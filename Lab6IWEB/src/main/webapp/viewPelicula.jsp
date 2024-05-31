<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 30/05/2024
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.example.lab6iweb.beans.Pelicula" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%
    Pelicula pelicula = (Pelicula) request.getAttribute("peliculamostrar");
    NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
    String boxOfficeFormatted = formatter.format(pelicula.getBoxOffice());
%>
<!DOCTYPE html>
<html>
<head>
    <title><%=pelicula.getTitulo()%></title>
</head>
<body>
<h1><%=pelicula.getTitulo()%></h1>
<table border="1">
    <tr>
        <th>idPelicula</th>
        <td><%=pelicula.getIdPelicula()%></td>
    </tr>
    <tr>
        <th>Director</th>
        <td><%=pelicula.getDirector()%></td>
    </tr>
    <tr>
        <th>Año</th>
        <td><%=pelicula.getAnoPublicacion()%></td>
    </tr>
    <tr>
        <th>Rating</th>
        <td><%=pelicula.getRating()%>/10</td>
    </tr>
    <tr>
        <th>Box Office</th>
        <td>$<%=boxOfficeFormatted%></td>
    </tr>
    <tr>
        <th>Género</th>
        <td><%=pelicula.getGenero()%></td>
    </tr>
    <tr>
        <th>Actores</th>
        <td><a href="ListaActores?id=<%=pelicula.getIdPelicula()%>">Ver Actores</a></td>
    </tr>
</table>

</body>
</html>
