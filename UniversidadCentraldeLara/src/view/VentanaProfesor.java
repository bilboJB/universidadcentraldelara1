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
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VentanaProfesor extends JFrame {

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
					VentanaProfesor frame = new VentanaProfesor();
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
	public VentanaProfesor() {
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
		
		JLabel profesor = new JLabel("Profesor");
		profesor.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/profesor.png")));
		profesor.setFont(new Font("Segoe UI", Font.BOLD, 60));
		profesor.setBounds(38, 52, 325, 89);
		panel.add(profesor);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/profesor (2).png")));
		lblImagen.setBounds(480, 52, 512, 585);
		panel.add(lblImagen);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(64, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JLabel cedula = new JLabel("Cédula");
		cedula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		cedula.setBounds(49, 152, 237, 32);
		panel.add(cedula);
		
		textCedula = new JTextField();
		textCedula.setText("ingrese la cedula");
		textCedula.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCedula.setColumns(10);
		textCedula.setBackground(new Color(224, 255, 255));
		textCedula.setBounds(59, 180, 227, 38);
		panel.add(textCedula);
		
		JButton btnBuscarCedula = new JButton("");
		btnBuscarCedula.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarCedula.setBounds(286, 180, 44, 38);
		panel.add(btnBuscarCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(50, 229, 94, 24);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setText("ingrese el nombre");
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		textNombre.setBounds(60, 253, 299, 38);
		panel.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellido.setBounds(50, 302, 94, 24);
		panel.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setText("ingrese el apellido");
		textApellido.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textApellido.setColumns(10);
		textApellido.setBackground(new Color(224, 255, 255));
		textApellido.setBounds(60, 331, 299, 38);
		panel.add(textApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTelefono.setBounds(50, 380, 94, 24);
		panel.add(lblTelefono);
		
		textTelefono = new JTextField();
		textTelefono.setText("ingrese el telefono");
		textTelefono.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textTelefono.setColumns(10);
		textTelefono.setBackground(new Color(224, 255, 255));
		textTelefono.setBounds(60, 406, 299, 38);
		panel.add(textTelefono);
		
		JLabel lblSeccion = new JLabel("Sección");
		lblSeccion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSeccion.setBounds(49, 455, 94, 24);
		panel.add(lblSeccion);
		
		textSeccion = new JTextField();
		textSeccion.setText("ingrese la seccion");
		textSeccion.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textSeccion.setColumns(10);
		textSeccion.setBackground(new Color(224, 255, 255));
		textSeccion.setBounds(59, 479, 299, 38);
		panel.add(textSeccion);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(10, 561, 94, 65);
		panel.add(btnGuardar);
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(121, 561, 94, 65);
		panel.add(btnModificar);
		
		JButton btnActualizar = new JButton("");
		btnActualizar.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/iconsActualizar50.png")));
		btnActualizar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnActualizar.setBackground(Color.BLACK);
		btnActualizar.setBounds(237, 561, 94, 65);
		panel.add(btnActualizar);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(357, 561, 94, 65);
		panel.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(461, 561, 94, 65);
		panel.add(btnEliminar);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaProfesor.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}

}
