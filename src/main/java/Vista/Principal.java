package Vista;

import Controller.ControllerPrincipal;
import Recursos.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Principal extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private JButton btnCargar;
    private JButton btnEliminar;
    private JButton btnSalir;
    private JTable tabla;

    public Principal() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setBounds(100, 100, 628, 397);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(82, 32, 455, 244);
		panelPrincipal.setLayout(new BorderLayout());
        getContentPane().add(panelPrincipal);

        tabla = new JTable();
        JScrollPane js = new JScrollPane(tabla);
        panelPrincipal.add(js, BorderLayout.CENTER);

        panelBotones = new JPanel();
        panelBotones.setBounds(0, 333, 628, 36);
        getContentPane().add(panelBotones);

        btnCargar = new JButton("Cargar");
        btnCargar.addActionListener(new BtnButtonActionListener());
        panelBotones.add(btnCargar);

        btnEliminar = new JButton("Borrar");
        btnEliminar.addActionListener(new BtnButtonActionListener());
        panelBotones.add(btnEliminar);

        btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new BtnButtonActionListener());
        panelBotones.add(btnSalir);

        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }


    private class BtnButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCargar) {
                try {
                    ControllerPrincipal.cargarTabla(tabla);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            if (e.getSource() == btnEliminar) {
                if(tabla.getSelectedRow() == -1){
                    JOptionPane.showMessageDialog(null,"Tienes que tener seleccionada una fila","ERROR",JOptionPane.ERROR_MESSAGE);


                }
                else {
                    Cliente cliente = new Cliente((Integer) tabla.getValueAt(tabla.getSelectedRow(),0),tabla.getValueAt(tabla.getSelectedRow(),1).toString(),tabla.getValueAt(tabla.getSelectedRow(),2).toString());
                    System.out.println(cliente);
                    try {
                        ControllerPrincipal.eliminarCliente(cliente,tabla);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            if (e.getSource() == btnSalir) {
                System.exit(0);
            }
        }
    }
}
