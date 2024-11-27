package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAOs.DAOClientes;
import Recursos.Cliente;

public class ControllerPrincipal{

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
/*
    public static boolean insertarVehiculo(Vehiculo vehiculo, JTable tablaVehiculos) throws SQLException {
        boolean insertado = false;
        if (vehiculo.getDniCliente().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null,"No puedes asignar un coche sin propietario","ERROR",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int resultado = DAOVehiculosSQL.getInstance().insertarVehiculo(vehiculo);
        if (resultado == 1) {
            insertado = true;
            cargarTabla(tablaVehiculos);
        }
        System.out.println(insertado);
        return insertado;
    }
*/
    public static boolean eliminarCliente(Cliente c, JTable tabla) throws SQLException {
        boolean eliminado = false;

        int resultado = DAOClientes.getInstance().eliminarCliente(c);
        if (resultado == 1) {
            eliminado = true;
            cargarTabla(tabla);
        }
        System.out.println(eliminado);

        return eliminado;
    }

    public static void leerVehiculo(JTable tabla) {
        int filaSelec = tabla.getSelectedRow();

        String modelo = "";

        if (tabla.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona un *ALGO* para obtener su información", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        } else {

            for (int i = 0; i < tabla.getColumnCount(); i++) {
                modelo += tabla.getValueAt(filaSelec, i).toString() + " ";
            }
            String[] partes = modelo.split(" ");
            Cliente cliente = new Cliente(Integer.parseInt(partes[0]),partes[1],partes[2]);

            int id = -1;
            for (Cliente c : listaClientes) {
                if(c.equals(cliente))
                    id = c.getId();

            }

            JOptionPane.showMessageDialog(null, modelo+id, "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
/*
    public static boolean actualizarVehiculo(PanelCRUD thisPanel, JTable tablaVehiculos) throws Exception {
        boolean valido = false;
        int filaSelec = tablaVehiculos.getSelectedRow();
        String modelo = thisPanel.getTxtMarca().getText() + " " + thisPanel.getTxtModelo().getText() + " "
                + thisPanel.getTxtMatricula().getText();
        String[] partes = modelo.toString().split(" ");

        Vehiculo vAntiguo = new Vehiculo(tablaVehiculos.getValueAt(filaSelec, 0).toString(),
                tablaVehiculos.getValueAt(filaSelec, 1).toString(), tablaVehiculos.getValueAt(filaSelec, 2).toString());
        Vehiculo vNuevo = new Vehiculo(partes[0], partes[1], partes[2]);
        if (vAntiguo.equals(vNuevo)) {
            JOptionPane.showMessageDialog(null, "No puedes actualizar un vehiculo sin cambiarle algún dato", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return valido;
        }
        int valor = DAOVehiculosSQL.getInstance().actualizarVehiculo(vNuevo, filaSelec);
        if (valor == 1) {
            cargarTabla(tablaVehiculos);
            valido = true;
        }
        return valido;
    }
*/
}
