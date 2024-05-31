package org.example.lab6iweb.daos;

import org.example.lab6iweb.beans.Actor;



import java.sql.*;
import java.util.ArrayList;

public class ActoresDao {
    public ArrayList<Actor> listarActores(int idPeli) {
        ArrayList<Actor> listaActores = new ArrayList<>();
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
        String query = "SELECT a.idActor, a.nombre, a.apellido, a.anoNacimiento, a.premioOscar " +
                "FROM Actor a " +
                "JOIN Protagonistas p ON a.idActor = p.idActor " +
                "WHERE p.idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idPeli);
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                Actor actor = new Actor();
                actor.setIdActor(rs.getInt("idActor"));
                actor.setNombre(rs.getString("nombre"));
                actor.setApellido(rs.getString("apellido"));
                actor.setAnoNacimiento(rs.getInt("anoNacimiento"));
                actor.setPremioOscar(rs.getBoolean("premioOscar"));


                listaActores.add(actor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaActores;
    }

    public String obtenerNombrePelicula(int idPeli) {
        String nombrePelicula = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Parámetros de conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "123456";

        // QUERY para obtener el nombre de la película
        String query = "SELECT titulo FROM Pelicula WHERE idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idPeli);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                nombrePelicula = rs.getString("titulo");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombrePelicula;
    }
}
