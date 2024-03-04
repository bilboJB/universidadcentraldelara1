/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Nairym González 28.206.840
Alexis Acuña 26.305.133
*/
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class VentanaInscripcion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCarrera;
	private JTextField textPeriodoAcad;
	private JTable tablaInscrpcion;
	
	private DefaultTableModel modeloTabla;
	private JButton btnGuardar, btnBuscarCedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInscripcion frame = new VentanaInscripcion();
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
	public VentanaInscripcion() {
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
		
		JLabel inscripcion = new JLabel("Inscripción");
		inscripcion.setBounds(39, 46, 390, 81);
		inscripcion.setIcon(new ImageIcon(VentanaInscripcion.class.getResource("/iconos/inscripcion.png")));
		inscripcion.setFont(new Font("Segoe UI", Font.BOLD, 60));
		panel.add(inscripcion);
		
		JLabel cedula = new JLabel("Cédula");
		cedula.setBounds(10, 184, 237, 32);
		cedula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		panel.add(cedula);
		
		textCedula = new JTextField();
		textCedula.setToolTipText("ingrese la cedula");
		textCedula.setBounds(20, 212, 158, 32);
		textCedula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		textCedula.setColumns(10);
		textCedula.setBackground(new Color(224, 255, 255));
		panel.add(textCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(245, 188, 196, 24);
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(255, 212, 186, 32);
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		panel.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(475, 184, 94, 24);
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 16));
		panel.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setEditable(false);
		textApellido.setBounds(485, 212, 196, 32);
		textApellido.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textApellido.setColumns(10);
		textApellido.setBackground(new Color(224, 255, 255));
		panel.add(textApellido);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(703, 188, 94, 24);
		lblCarrera.setFont(new Font("Segoe UI", Font.BOLD, 16));
		panel.add(lblCarrera);
		
		textCarrera = new JTextField();
		textCarrera.setEditable(false);
		textCarrera.setBounds(713, 212, 291, 32);
		textCarrera.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCarrera.setColumns(10);
		textCarrera.setBackground(new Color(224, 255, 255));
		panel.add(textCarrera);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(413, 559, 210, 65);
		btnGuardar.setIcon(new ImageIcon(VentanaInscripcion.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGuardar.setBackground(Color.BLACK);
		panel.add(btnGuardar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 304, 944, 237);
		panel.add(scrollPane);
		
		tablaInscrpcion = new JTable();
		tablaInscrpcion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		tablaInscrpcion.setShowVerticalLines(false);
		tablaInscrpcion.setShowHorizontalLines(false);
		tablaInscrpcion.setShowGrid(false);
		modeloTabla = new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"", "Asignaturas", "Secci\u00F3n"
				}
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -5866929548135962087L;
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
		tablaInscrpcion.setModel(modeloTabla);
		tablaInscrpcion.getColumnModel().getColumn(0).setPreferredWidth(35);
		scrollPane.setViewportView(tablaInscrpcion);
		
		JLabel lblPeriodoAcad = new JLabel("Periodo Académico");
		lblPeriodoAcad.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblPeriodoAcad.setBounds(214, 152, 196, 30);
		panel.add(lblPeriodoAcad);
		
		textPeriodoAcad = new JTextField();
		textPeriodoAcad.setEditable(false);
		textPeriodoAcad.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textPeriodoAcad.setColumns(10);
		textPeriodoAcad.setBackground(new Color(224, 255, 255));
		textPeriodoAcad.setBounds(406, 149, 186, 32);
		panel.add(textPeriodoAcad);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaInscripcion.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(VentanaInscripcion.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaInscripcion.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(64, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		btnBuscarCedula = new JButton("");
		btnBuscarCedula.setIcon(new ImageIcon(VentanaInscripcion.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarCedula.setBounds(181, 212, 44, 38);
		panel.add(btnBuscarCedula);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaInscripcion.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
	
	public JTable getTablaInscrpcion() {
		return tablaInscrpcion;
	}

	public void setTablaInscrpcion(JTable tablaInscrpcion) {
		this.tablaInscrpcion = tablaInscrpcion;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public JTextField getTextCedula() {
		return textCedula;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public JTextField getTextApellido() {
		return textApellido;
	}

	public JTextField getTextCarrera() {
		return textCarrera;
	}

	public JTextField getTextPeriodoAcad() {
		return textPeriodoAcad;
	}
	public void agregarListener(ActionListener actionListener) {
		btnGuardar.addActionListener(actionListener); 
		btnBuscarCedula.addActionListener(actionListener);
	}
}


