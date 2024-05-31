package org.example.lab6iweb.daos;

import org.example.lab6iweb.beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class PeliculaDao {

    public ArrayList<Pelicula> listarPeliculas() {
        ArrayList<Pelicula> listaPelis = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "123456";

        // QUERY
        String query = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre as genero "
                + "FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero "
                + "ORDER BY p.rating DESC, p.boxOffice DESC";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {


            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setIdPelicula(rs.getInt("idPelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
                pelicula.setRating(rs.getDouble("rating"));
                pelicula.setBoxOffice(rs.getDouble("boxOffice"));
                pelicula.setGenero(rs.getString("genero"));

                listaPelis.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPelis;
    }

    public ArrayList<Pelicula> buscarPeliculasPorTitulo(String titulo) {
        ArrayList<Pelicula> listaPelis = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "123456";


        String query = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre as genero "
                + "FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero "
                + "WHERE p.titulo LIKE ? ORDER BY p.rating DESC, p.boxOffice DESC";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + titulo + "%");
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setIdPelicula(rs.getInt("idPelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
                pelicula.setRating(rs.getDouble("rating"));
                pelicula.setBoxOffice(rs.getDouble("boxOffice"));
                pelicula.setGenero(rs.getString("genero"));

                listaPelis.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPelis;
    }

    public Pelicula getPeliID(int id) {
        Pelicula pelicula = new Pelicula();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "123456";

        //query
        String query = "SELECT p.idPelicula, p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre as genero "
                + "FROM Pelicula p JOIN Genero g ON p.idGenero = g.idGenero "
                + "WHERE p.idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                pelicula.setIdPelicula(rs.getInt("idPelicula"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setAnoPublicacion(rs.getInt("anoPublicacion"));
                pelicula.setRating(rs.getDouble("rating"));
                pelicula.setBoxOffice(rs.getDouble("boxOffice"));
                pelicula.setGenero(rs.getString("genero"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pelicula;
    }
}
