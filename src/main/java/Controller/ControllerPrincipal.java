package Controller;

import DAOs.DAOClientes;
import Recursos.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerPrincipal {

    private static ArrayList<Cliente> listaClientes;

    public static void cargarTabla(JTable tabla) throws SQLException {
        listaClientes = DAOClientes.getInstance().getClientes();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Identificador");
        modelo.addColumn("Nombre Completo");
        modelo.addColumn("Nº de Cuenta");

        Object[] registro = new Object[3];

        for (Cliente c : listaClientes) {

            registro[0] = c.getId();
            registro[1] = c.getnCompleto();
            registro[2] = c.getnCuenta();

            modelo.addRow(registro);
        }

        tabla.setModel(modelo);
    }


}
