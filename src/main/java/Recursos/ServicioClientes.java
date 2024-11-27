package Recursos;

import DAOs.DAOClientes;
import DAOs.IDAOClientes;

import java.sql.SQLException;
import java.util.ArrayList;

public class ServicioClientes {

    private IDAOClientes dao = null;

    public ServicioClientes() {
        this.dao = getDao();
    }

    public ServicioClientes(IDAOClientes mockDAOVehiculo) {
        this.dao = mockDAOVehiculo;
    }

    public IDAOClientes getDao() {
        try {
            return DAOClientes.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente getMaxId(){
        ArrayList<Cliente> clientes = dao.getClientes();
        Cliente maxId = clientes.get(0);
        for (Cliente cliente : clientes) {
            if (cliente.getId() > maxId.getId()) {
                maxId = cliente;
            }
        }
        return maxId;
    }

    public int nCaracteresNCompleto(){
        ArrayList<Cliente> clientes = dao.getClientes();
        int nombreMax = clientes.getFirst().getnCompleto().trim().length();
        for (Cliente c : clientes) {
            if (c.getnCompleto().trim().length() > nombreMax)
                nombreMax = c.getnCompleto().trim().length();
        }
        return nombreMax;
    }
}
