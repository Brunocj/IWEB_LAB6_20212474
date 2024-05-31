package org.example.lab6iweb.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab6iweb.beans.Pelicula;
import org.example.lab6iweb.daos.PeliculaDao;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Detalles de la película", value = "/DetallesPeli")
public class detallesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PeliculaDao peliculaDao = new PeliculaDao();

        int idPelicula = Integer.parseInt(request.getParameter("id"));
        Pelicula pelicula = peliculaDao.getPeliID(idPelicula);

        //Objeto que se enviara a la vista
        request.setAttribute("peliculamostrar",pelicula);
        RequestDispatcher view = request.getRequestDispatcher("viewPelicula.jsp");
        view.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}
