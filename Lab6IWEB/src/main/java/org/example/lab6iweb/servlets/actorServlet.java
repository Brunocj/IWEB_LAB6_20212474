package org.example.lab6iweb.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab6iweb.beans.Actor;
import org.example.lab6iweb.daos.ActoresDao;


import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Lista de Actores", value = "/ListaActores")
public class actorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        ActoresDao actoresDao = new ActoresDao();

        int idPelicula = Integer.parseInt(request.getParameter("id"));
        ArrayList<Actor> listaActores = actoresDao.listarActores(idPelicula);
        String nombrePelicula = actoresDao.obtenerNombrePelicula(idPelicula);
        //Objeto que se enviara a la vista
        request.setAttribute("listaactores", listaActores);
        request.setAttribute("nombrePelicula", nombrePelicula);
        RequestDispatcher view = request.getRequestDispatcher("listaActores.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}