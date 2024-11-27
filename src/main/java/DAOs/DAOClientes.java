package DAOs;

import Recursos.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOClientes implements IDAOClientes {

    private ArrayList<Cliente> clienteBD = new ArrayList<>();
    private static DAOClientes dao = null;

    public DAOClientes() throws SQLException {
        this.clienteBD = obtenerClientes();
    }

    public ArrayList<Cliente> obtenerClientes() throws SQLException {
        Statement statement = getStatementClientes();

        String selectSql = "SELECT DISTINCT ID, NombreCompleto, NumeroCuenta FROM Clientes; ";
        ResultSet resultSet = statement.executeQuery(selectSql);

        while (resultSet.next()) {
            clienteBD.add(new Cliente(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
        }

        return getClientes();
    }

    public static DAOClientes getInstance() throws SQLException {
        if (dao == null) dao = new DAOClientes();
        return dao;
    }

    public ArrayList<Cliente> getClientes() {
        return clienteBD;
    }

    public Statement getStatementClientes() throws SQLException {
        return ConexionSQL.getInstance().conectar().createStatement();
    }

    public int eliminarCliente(Cliente c) {
        boolean realizado = false;
        for (Cliente cliente : clienteBD) {
            if (cliente.getId() == c.getId()) {
                System.out.println("Adiós " + cliente);
                clienteBD.remove(cliente);
                ConexionSQL.getInstance().eliminarDatos("DELETE FROM CLIENTES WHERE ID = " + cliente.getId());
                return 1;
            }
        }
        return -1;
    }
}
