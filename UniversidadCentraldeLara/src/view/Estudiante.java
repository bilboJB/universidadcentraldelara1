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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class Estudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textSemestre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estudiante frame = new Estudiante();
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
	public Estudiante() {
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
		estudiante.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/graduado.png")));
		estudiante.setFont(new Font("Segoe UI", Font.BOLD, 60));
		estudiante.setBounds(37, 50, 424, 89);
		panel.add(estudiante);
		
		JLabel cedula = new JLabel("Cédula");
		cedula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		cedula.setBounds(37, 150, 237, 32);
		panel.add(cedula);
		
		textCedula = new JTextField();
		textCedula.setText("ingrese la cedula");
		textCedula.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCedula.setColumns(10);
		textCedula.setBackground(new Color(224, 255, 255));
		textCedula.setBounds(47, 178, 227, 38);
		panel.add(textCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(37, 227, 94, 24);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setText("ingrese el nombre");
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		textNombre.setBounds(47, 251, 299, 38);
		panel.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellido.setBounds(37, 300, 94, 24);
		panel.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setText("ingrese el apellido");
		textApellido.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textApellido.setColumns(10);
		textApellido.setBackground(new Color(224, 255, 255));
		textApellido.setBounds(47, 324, 299, 38);
		panel.add(textApellido);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(23, 449, 185, 59);
		panel.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(23, 515, 187, 65);
		panel.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(220, 515, 185, 65);
		panel.add(btnEliminar);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/estudiante.png")));
		lblImagen.setBounds(507, 66, 484, 566);
		panel.add(lblImagen);
		
		JButton btnBuscarCedula = new JButton("");
		btnBuscarCedula.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarCedula.setBounds(275, 178, 54, 38);
		panel.add(btnBuscarCedula);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(64, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(218, 449, 221, 59);
		panel.add(btnModificar);
		
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSemestre.setBounds(37, 373, 94, 24);
		panel.add(lblSemestre);
		
		textSemestre = new JTextField();
		textSemestre.setText("ingrese el semestre");
		textSemestre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textSemestre.setColumns(10);
		textSemestre.setBackground(new Color(224, 255, 255));
		textSemestre.setBounds(47, 397, 299, 38);
		panel.add(textSemestre);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/iconsActualizar50.png")));
		btnActualizar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnActualizar.setBackground(Color.BLACK);
		btnActualizar.setBounds(110, 591, 227, 59);
		panel.add(btnActualizar);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Estudiante.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
}
