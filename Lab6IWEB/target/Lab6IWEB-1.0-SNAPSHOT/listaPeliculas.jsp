<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="org.example.lab6iweb.beans.Pelicula" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%
    ArrayList<Pelicula> listaPeliculas = (ArrayList<Pelicula>) request.getAttribute("listapelis");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lista de peliculas</title>
</head>
<body>
<h1>Lista de peliculas</h1>

<form method="get" action="ListaPelis">
    <input type="text" name="search" placeholder="Buscar por título">
    <input type="submit" value="Buscar">
</form>

<%
    if (listaPeliculas == null || listaPeliculas.isEmpty()) {
%>
<p>No se encontraron películas;</p>
<%
} else {
%>
<table border="1">
    <thead>
    <tr>
        <th>Título</th>
        <th>Director</th>
        <th>Año de Publicación</th>
        <th>Rating</th>
        <th>Box Office</th>
        <th>Género</th>
        <th>Actores</th>
    </tr>
    </thead>
    <tbody>
    <%
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        for (Pelicula pelicula : listaPeliculas) {
            String boxOfficeFormatted = formatter.format(pelicula.getBoxOffice());
    %>
    <tr>
        <td><a href="DetallesPeli?id=<%=pelicula.getIdPelicula()%>"><%=pelicula.getTitulo()%></a></td>
        <td><%=pelicula.getDirector()%></td>
        <td><%=pelicula.getAnoPublicacion()%></td>
        <td><%=pelicula.getRating()%>/10</td>
        <td>$<%=boxOfficeFormatted%></td>
        <td><%=pelicula.getGenero()%></td>
        <td><a href="ListaActores?id=<%=pelicula.getIdPelicula()%>">Ver Actores</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
    }
%>
</body>
</html>
