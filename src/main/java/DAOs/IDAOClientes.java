package DAOs;

import Recursos.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDAOClientes {
    public ArrayList<Cliente> obtenerClientes() throws SQLException;
    public ArrayList<Cliente> getClientes();
    public int eliminarCliente(Cliente c);
    }
