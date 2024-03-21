/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
*/
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.ComponentOrientation;

public class VentanaListadoPorGenero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private JButton btnMenuPrincipal, btnGenerarListado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListadoPorGenero frame = new VentanaListadoPorGenero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaListadoPorGenero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1014, 661);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.LIGHT_GRAY);
		btnMenuPrincipal.setBounds(48, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JLabel lblListadoPorGenero = new JLabel("Listado por Genero");
		lblListadoPorGenero.setIcon(new ImageIcon(VentanaListadoPorGenero.class.getResource("/iconos/listado de estudiante por semestre.png")));
		lblListadoPorGenero.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblListadoPorGenero.setBounds(239, 66, 564, 81);
		panel.add(lblListadoPorGenero);
		
		btnGenerarListado = new JButton("Generar Listado");
		btnGenerarListado.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGenerarListado.setBackground(Color.LIGHT_GRAY);
		btnGenerarListado.setIcon(new ImageIcon(VentanaListadoSeccion.class.getResource("/iconos/iconsLista50.png")));
		btnGenerarListado.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGenerarListado.setBounds(356, 560, 355, 65);
		panel.add(btnGenerarListado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 225, 903, 301);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Genero", "Carrera", "Decanato"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		};
		table.setModel(modelo);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaListadoSeccion.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
	
	public void agregarListener(ActionListener actionListener) {
		btnGenerarListado.addActionListener(actionListener);
		btnMenuPrincipal.addActionListener(actionListener);
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public JTable getTable() {
		return table;
	}
}
