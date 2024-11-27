package Vista;

import Controller.ControllerPrincipal;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Principal extends JFrame{

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnCargar;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTable tabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 628, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(82, 32, 455, 244);
		frame.getContentPane().add(panel);

		tabla = new JTable();

		JScrollPane js = new JScrollPane(tabla);
		panel.add(js);

		// Panel inferior para los botones
		panel_1 = new JPanel();
		panel_1.setBounds(0, 333, 628, 36);
		frame.getContentPane().add(panel_1);

		// Botones adicionales
		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new BtnButtonActionListener());
		panel_1.add(btnCargar);

		btnNewButton_1 = new JButton("Borrar");
		panel_1.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Salir");
		panel_1.add(btnNewButton_2);

		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	
	private class BtnButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnCargar) {
                try {
                    ControllerPrincipal.cargarTabla(tabla);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
		}
	}
}
