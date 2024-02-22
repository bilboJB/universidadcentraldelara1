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

public class Carrera extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField txtAsignatura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carrera frame = new Carrera();
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
	public Carrera() {
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
		carrera.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/carrera-profesional.png")));
		carrera.setFont(new Font("Segoe UI", Font.BOLD, 60));
		carrera.setBounds(31, 61, 424, 89);
		panel.add(carrera);
		
		JLabel codigo = new JLabel("Código");
		codigo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		codigo.setBounds(31, 161, 237, 32);
		panel.add(codigo);
		
		textCodigo = new JTextField();
		textCodigo.setText("ingrese el código");
		textCodigo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCodigo.setColumns(10);
		textCodigo.setBackground(new Color(224, 255, 255));
		textCodigo.setBounds(41, 189, 227, 38);
		panel.add(textCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(31, 238, 94, 24);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setText("ingrese el nombre");
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		textNombre.setBounds(41, 262, 299, 38);
		panel.add(textNombre);
		
		JLabel lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblAsignatura.setBounds(31, 321, 94, 24);
		panel.add(lblAsignatura);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setText("ingrese el codigo de la asignatura");
		txtAsignatura.setFont(new Font("Segoe UI", Font.BOLD, 20));
		txtAsignatura.setColumns(10);
		txtAsignatura.setBackground(new Color(224, 255, 255));
		txtAsignatura.setBounds(41, 347, 338, 38);
		panel.add(txtAsignatura);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(17, 407, 210, 65);
		panel.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(255, 407, 200, 65);
		panel.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(255, 492, 210, 65);
		panel.add(btnEliminar);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/carrera-profesional (1).png")));
		lblImagen.setBounds(478, 61, 515, 575);
		panel.add(lblImagen);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(11, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(903, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(949, 11, 44, 29);
		panel.add(btnSalir);
		
		JButton btnBuscarCarrera = new JButton("");
		btnBuscarCarrera.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarCarrera.setBounds(269, 189, 44, 38);
		panel.add(btnBuscarCarrera);
		
		JButton btnBuscarAsignatura = new JButton("");
		btnBuscarAsignatura.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarAsignatura.setBounds(381, 347, 44, 38);
		panel.add(btnBuscarAsignatura);
		
		JButton btnVerListadoCarreras = new JButton("Ver Listado Carreras");
		btnVerListadoCarreras.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/iconsLista50.png")));
		btnVerListadoCarreras.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnVerListadoCarreras.setBackground(Color.BLACK);
		btnVerListadoCarreras.setBounds(54, 579, 369, 65);
		panel.add(btnVerListadoCarreras);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(65, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(11, 492, 227, 65);
		panel.add(btnModificar);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Carrera.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}

}
