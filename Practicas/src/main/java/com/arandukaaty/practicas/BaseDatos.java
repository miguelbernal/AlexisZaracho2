package com.arandukaaty.practicas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
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
            System.out.println("Conectado con la Base de datos");
            Statement stmt = connection.createStatement();

            // Formulario
            formulario(stmt);

            stmt.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de Driver : " + ex);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void listar(Statement stmt) throws SQLException {
        String sql = "SELECT * FROM public.usuarios ORDER BY id;";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String usuario = rs.getString("usuario");
            String clave = rs.getString("clave");
            System.out.printf("Id = %s , Nombre = %s, Usuario = %s, Clave = %s ",
                    id, nombre, usuario, clave);
            System.out.println();
        }
    }

    public static void insertar(Statement stmt, String nombre, String usuario, String clave) 
            throws SQLException {
        String sql = "INSERT INTO usuarios(nombre, usuario, clave) "
                + "VALUES('"+nombre+"','"+usuario+"','"+clave+"')";
        int cantidadRegistros = stmt.executeUpdate(sql);
        System.out.println("Registros insertados: " + cantidadRegistros);

    }

    private static void actualizar(Statement stmt) throws SQLException {
        String sql = "UPDATE usuarios set nombre='Usuario 3', usuario='usuario3' "
                + "WHERE id = 3";
        int cantidadRegistros = stmt.executeUpdate(sql);
        System.out.println("Registros actualizados: " + cantidadRegistros);
    }

    private static void eliminar(Statement stmt) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = 4";
        int cantidadRegistros = stmt.executeUpdate(sql);
        System.out.println("Registros actualizados: " + cantidadRegistros);
    }

    private static void formulario(Statement stmt) throws SQLException {
        int opcion = 0;
        do {
            // Formulario
            System.out.println("*** CRUD ***");
            System.out.println("1. Listar");
            System.out.println("2. Agregar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("5. Salir");
            System.out.println("Opción: ");
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.nextInt();
            if (opcion == 1) {
                listar(stmt);
            } else if (opcion == 2) {
                formularioInsertar(stmt);
            } else if (opcion == 3) {
                actualizar(stmt);
            } else if (opcion == 4) {
                eliminar(stmt);
            } else {
                System.out.println("Opcion incorrecta");
            }

        } while (opcion != 5);
        System.out.println("Gracias por utilizar nuestro sistema :)");
    }

    private static void formularioInsertar(Statement stmt) 
            throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** INSERTAR USUARIO ***");
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.println("Clave: ");
        String clave = scanner.nextLine();
        insertar(stmt, nombre, usuario, clave);
    }
}
