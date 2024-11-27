package Vista;

import DAOs.DAOClientes;
import Recursos.Cliente;

import java.sql.SQLException;

public class Codigo {

    public static void main(String[] args) throws SQLException {
        for (Cliente c : DAOClientes.getInstance().obtenerClientes()) {
            System.out.println(c);
        }
    }
}
