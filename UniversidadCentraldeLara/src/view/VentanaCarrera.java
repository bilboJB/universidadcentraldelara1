/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
*/
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class VentanaCarrera extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDecanato;
	private JTextField textNombre;
	private JTable table;
	private DefaultTableModel modelo;
	private JButton btnMenuPrincipal, btnBuscarDecanato, btnGuardar, btnModificar, btnLimpiar, btnVerListadoCarreras, btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCarrera frame = new VentanaCarrera();
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
	public VentanaCarrera() {
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
		
		JLabel carrera = new JLabel("Carrera");
		carrera.setIcon(new ImageIcon(VentanaCarrera.class.getResource("/iconos/carrera-profesional.png")));
		carrera.setFont(new Font("Segoe UI", Font.BOLD, 60));
		carrera.setBounds(31, 61, 424, 89);
		panel.add(carrera);
		
		JLabel codigo = new JLabel("Decanato");
		codigo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		codigo.setBounds(31, 161, 237, 32);
		panel.add(codigo);
		
		textDecanato = new JTextField();
		textDecanato.setToolTipText("ingrese el decanato");
		textDecanato.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textDecanato.setColumns(10);
		textDecanato.setBackground(new Color(224, 255, 255));
		textDecanato.setBounds(41, 189, 227, 38);
		panel.add(textDecanato);
		
		JLabel lblNombre = new JLabel("Nombre carrera");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(31, 238, 184, 24);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setToolTipText("ingrese el nombre");
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		textNombre.setBounds(41, 262, 299, 38);
		panel.add(textNombre);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaCarrera.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(11, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(VentanaCarrera.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(903, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaCarrera.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(949, 11, 44, 29);
		panel.add(btnSalir);
		
		btnBuscarDecanato = new JButton("");
		btnBuscarDecanato.setIcon(new ImageIcon(VentanaCarrera.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarDecanato.setBounds(269, 189, 44, 38);
		btnBuscarDecanato.setActionCommand("Buscar");
		panel.add(btnBuscarDecanato);
		
		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(VentanaCarrera.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnGuardar.setBounds(89, 419, 105, 65);
		btnGuardar.setActionCommand("Guardar");
		panel.add(btnGuardar);
		
		btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(VentanaCarrera.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnModificar.setBackground(Color.LIGHT_GRAY);
		btnModificar.setBounds(241, 419, 105, 65);
		btnModificar.setActionCommand("Modificar");
		panel.add(btnModificar);
		
		btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.LIGHT_GRAY);
		btnMenuPrincipal.setBounds(65, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(VentanaCarrera.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLimpiar.setBackground(Color.LIGHT_GRAY);
		btnLimpiar.setBounds(89, 495, 105, 65);
		btnLimpiar.setActionCommand("Limpiar");
		panel.add(btnLimpiar);
		
		btnVerListadoCarreras = new JButton("Ver Listado Carreras");
		btnVerListadoCarreras.setIcon(new ImageIcon(VentanaCarrera.class.getResource("/iconos/iconsLista50.png")));
		btnVerListadoCarreras.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnVerListadoCarreras.setBackground(Color.LIGHT_GRAY);
		btnVerListadoCarreras.setBounds(41, 571, 369, 65);
		panel.add(btnVerListadoCarreras);
		
		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(VentanaCarrera.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setBounds(241, 495, 105, 65);
		btnEliminar.setActionCommand("Eliminar");
		panel.add(btnEliminar);
		
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
					"Seleccion", "Carrera", "Decanato"
				}
			) {
				Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		scrollPane.setViewportView(table);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaCarrera.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
	
	public void agregarLister(ActionListener actionListener) {
		btnBuscarDecanato.addActionListener(actionListener);
		btnEliminar.addActionListener(actionListener);
		btnGuardar.addActionListener(actionListener);
		btnLimpiar.addActionListener(actionListener);
		btnMenuPrincipal.addActionListener(actionListener);
		btnModificar.addActionListener(actionListener);
		btnVerListadoCarreras.addActionListener(actionListener);
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

	public JTextField getTextDecanato() {
		return textDecanato;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}
}
