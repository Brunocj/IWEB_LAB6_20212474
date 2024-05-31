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

@WebServlet(name = "Lista de peliculas", value = "/ListaPelis")
public class PeliculaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PeliculaDao peliculaDao = new PeliculaDao();
        ArrayList<Pelicula> listaPeliculas = peliculaDao.listarPeliculas();
        //Busqueda
        String searchQuery = request.getParameter("search");

        //Cuando no se realizan busquedas, se muestran todas las peliculas
        if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            listaPeliculas = peliculaDao.buscarPeliculasPorTitulo(searchQuery);
        } else {
            listaPeliculas = peliculaDao.listarPeliculas();
        }


        //Objeto que se enviara a la vista
        request.setAttribute("listapelis",listaPeliculas);
        RequestDispatcher view = request.getRequestDispatcher("listaPeliculas.jsp");
        view.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}