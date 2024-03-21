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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaDecanato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JButton btnMenuPrincipal, btnGuardar, btnLimpiar, btnListado, btnEliminar, btnModificar;
	private JTable table;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDecanato frame = new VentanaDecanato();
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
	public VentanaDecanato() {
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
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(22, 166, 94, 24);
		panel.add(lblNombre);
		
		JLabel decanato = new JLabel("Decanato");
		decanato.setIcon(new ImageIcon(VentanaDecanato.class.getResource("/iconos/universidad.png")));
		decanato.setFont(new Font("Segoe UI", Font.BOLD, 60));
		decanato.setBounds(22, 66, 424, 89);
		panel.add(decanato);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblDireccion.setBounds(22, 239, 94, 24);
		panel.add(lblDireccion);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaDecanato.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTelefono.setBounds(22, 312, 94, 24);
		panel.add(lblTelefono);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(VentanaDecanato.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(VentanaDecanato.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnModificar.setBackground(Color.LIGHT_GRAY);
		btnModificar.setBounds(139, 496, 94, 59);
		btnModificar.setActionCommand("Modificar");
		panel.add(btnModificar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaDecanato.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		textDireccion = new JTextField();
		textDireccion.setToolTipText("ingrese la direccion");
		textDireccion.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textDireccion.setColumns(10);
		textDireccion.setBackground(new Color(224, 255, 255));
		textDireccion.setBounds(32, 263, 299, 38);
		panel.add(textDireccion);
		
		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(VentanaDecanato.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setBounds(375, 496, 94, 59);
		btnEliminar.setActionCommand("Eliminar");
		panel.add(btnEliminar);
		
		btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.LIGHT_GRAY);
		btnMenuPrincipal.setBounds(61, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(VentanaDecanato.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnGuardar.setBounds(22, 496, 94, 59);
		btnGuardar.setActionCommand("Guardar");
		panel.add(btnGuardar);
		
		btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(VentanaDecanato.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLimpiar.setBackground(Color.LIGHT_GRAY);
		btnLimpiar.setBounds(258, 496, 94, 59);
		btnLimpiar.setActionCommand("Limpiar");
		panel.add(btnLimpiar);
		
		textTelefono = new JTextField();
		textTelefono.setToolTipText("ingrese el telefono");
		textTelefono.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textTelefono.setColumns(10);
		textTelefono.setBackground(new Color(224, 255, 255));
		textTelefono.setBounds(32, 336, 299, 38);
		panel.add(textTelefono);
		
		btnListado = new JButton("Ver Lista Decanato");
		btnListado.setIcon(new ImageIcon(VentanaDecanato.class.getResource("/iconos/iconsLista50.png")));
		btnListado.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnListado.setBackground(Color.LIGHT_GRAY);
		btnListado.setBounds(61, 576, 369, 59);
		panel.add(btnListado);
		
		textNombre = new JTextField();
		textNombre.setToolTipText("ingrese el nombre");
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		textNombre.setBounds(32, 190, 299, 38);
		panel.add(textNombre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(500, 135, 465, 400);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		
		modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Seleccion", "Nombre", "Direccion", "Telefono"
				}
			) {
				Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		scrollPane.setViewportView(table);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaDecanato.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
	public void agregarListener(ActionListener actionListener) {
		btnEliminar.addActionListener(actionListener);
		btnGuardar.addActionListener(actionListener);
		btnLimpiar.addActionListener(actionListener);
		btnListado.addActionListener(actionListener);
		btnMenuPrincipal.addActionListener(actionListener);
		btnModificar.addActionListener(actionListener);
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public JTextField getTextDireccion() {
		return textDireccion;
	}

	public JTextField getTextTelefono() {
		return textTelefono;
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
