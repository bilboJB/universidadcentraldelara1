/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Alexis Acuña 26.305.133
*/

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaEstudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textSeccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEstudiante frame = new VentanaEstudiante();
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
	public VentanaEstudiante() {
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
		
		JLabel estudiante = new JLabel("Estudiante");
		estudiante.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/graduado.png")));
		estudiante.setFont(new Font("Segoe UI", Font.BOLD, 60));
		estudiante.setBounds(37, 50, 424, 89);
		panel.add(estudiante);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/estudiante.png")));
		lblImagen.setBounds(507, 66, 484, 566);
		panel.add(lblImagen);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(64, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		textCedula = new JTextField();
		textCedula.setText("ingrese la cedula");
		textCedula.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCedula.setColumns(10);
		textCedula.setBackground(new Color(224, 255, 255));
		textCedula.setBounds(47, 174, 227, 38);
		panel.add(textCedula);
		
		JLabel cedula = new JLabel("Cédula");
		cedula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		cedula.setBounds(37, 146, 237, 32);
		panel.add(cedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(37, 223, 94, 24);
		panel.add(lblNombre);
		
		JButton btnBuscarCedula = new JButton("");
		btnBuscarCedula.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarCedula.setBounds(275, 174, 54, 38);
		panel.add(btnBuscarCedula);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellido.setBounds(37, 296, 94, 24);
		panel.add(lblApellido);
		
		textNombre = new JTextField();
		textNombre.setText("ingrese el nombre");
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		textNombre.setBounds(47, 247, 299, 38);
		panel.add(textNombre);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTelefono.setBounds(37, 369, 94, 24);
		panel.add(lblTelefono);
		
		textApellido = new JTextField();
		textApellido.setText("ingrese el apellido");
		textApellido.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textApellido.setColumns(10);
		textApellido.setBackground(new Color(224, 255, 255));
		textApellido.setBounds(47, 320, 299, 38);
		panel.add(textApellido);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaNacimiento.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFechaNacimiento.setBounds(37, 442, 189, 24);
		panel.add(lblFechaNacimiento);
		
		textTelefono = new JTextField();
		textTelefono.setText("ingrese el telefono");
		textTelefono.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textTelefono.setColumns(10);
		textTelefono.setBackground(new Color(224, 255, 255));
		textTelefono.setBounds(47, 393, 299, 38);
		panel.add(textTelefono);
		
		JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setModel(new DefaultComboBoxModel(new String[] {"Seleccione el genero:", "Femenino", "Masculino"}));
		comboBoxGenero.setFont(new Font("Segoe UI", Font.BOLD, 16));
		comboBoxGenero.setBackground(new Color(224, 255, 255));
		comboBoxGenero.setBounds(47, 539, 227, 38);
		panel.add(comboBoxGenero);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblGenero.setBounds(37, 505, 189, 24);
		panel.add(lblGenero);
		
		textSeccion = new JTextField();
		textSeccion.setText("ingrese la seccion");
		textSeccion.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textSeccion.setColumns(10);
		textSeccion.setBackground(new Color(224, 255, 255));
		textSeccion.setBounds(47, 612, 299, 38);
		panel.add(textSeccion);
		
		JLabel lblSeccion = new JLabel("Sección");
		lblSeccion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSeccion.setBounds(37, 588, 94, 24);
		panel.add(lblSeccion);
		
		JButton btnActualizar = new JButton("");
		btnActualizar.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/iconsActualizar50.png")));
		btnActualizar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnActualizar.setBackground(Color.BLACK);
		btnActualizar.setBounds(397, 344, 100, 53);
		panel.add(btnActualizar);
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(397, 266, 100, 53);
		panel.add(btnModificar);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(397, 185, 100, 53);
		panel.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(397, 505, 100, 53);
		panel.add(btnEliminar);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(397, 424, 100, 53);
		panel.add(btnLimpiar);
		
		//JDateChooser dateChooserFechaNac = new JDateChooser();
		//dateChooserFechaNac.setBounds(47, 466, 203, 28);
		//panel.add(dateChooserFechaNac);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaEstudiante.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
}
