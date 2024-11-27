package Recursos;

import DAOs.IDAOClientes;

import java.sql.SQLException;
import java.util.ArrayList;

public class MockDAOClientes implements IDAOClientes {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private static MockDAOClientes dao = null;

    @Override
    public ArrayList<Cliente> obtenerClientes() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Cliente> getClientes() {
        clientes.add(new Cliente(98234, "Juan Pérez", "juan.perez@example.com"));
        clientes.add(new Cliente(58392, "María González", "maria.g@example.com"));
        clientes.add(new Cliente(14756, "Carlos Ramírez", "carlos.ram@example.com"));
        clientes.add(new Cliente(73618, "Laura Rodríguez", "laura.rod@example.com"));
        clientes.add(new Cliente(49502, "Ana Martínez", "ana.mart@example.com"));
        return clientes;
    }

    @Override
    public int eliminarCliente(Cliente c) {
        return 0;
    }

    public static MockDAOClientes getInstance(){
        if(dao == null) dao = new MockDAOClientes();
        return dao;
    }
}
