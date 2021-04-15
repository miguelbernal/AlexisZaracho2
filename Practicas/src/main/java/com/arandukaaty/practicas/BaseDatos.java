package com.arandukaaty.practicas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDatos {

    private static Connection connection = null;
    private static final String SERVERDB = "localhost";
    private static final int PORT = 5432;
    private static final String DATABASE = "alexis";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";

    public static void baseDatos() /*throws SQLException*/ {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Conextado con el Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://" + SERVERDB + ":"
                    + PORT + "/" + DATABASE,
                    USER, PASSWORD);
            System.out.println("Conextado con la Base de datos");
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from public.usuarios ;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String usuario = rs.getString("usuario");
                String clave = rs.getString("clave");
                System.out.printf("Id = %s , Nombre = %s, Usuario = %s, Clave = %s ", 
                        id, nombre, usuario, clave); 
                System.out.println();
            }
            rs.close(); 
            stmt.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de Driver : " + ex);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
