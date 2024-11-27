package DAOs;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {

    private static final String USER = "Hugo";
    private static final String PASSWORD = "h1234";
    private static final String CONEX = "jdbc:sqlserver://localhost:1433;databaseName=Repaso;user=" + USER + ";password=" + PASSWORD + ";encrypt=true;trustServerCertificate=true;";
    private static  ConexionSQL conexion = null;



    public static Connection conectar() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONEX);
            System.out.println("Conexión realizada con éxito");
            return connection;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La conexión fallo", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error en la conexión");
        }
        return connection;
    }

    public static ConexionSQL getInstance() throws SQLException {
        if (conexion == null) conexion = new ConexionSQL();
        return conexion;
    }
}
