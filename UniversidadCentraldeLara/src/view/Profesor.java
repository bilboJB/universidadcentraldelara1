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
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Profesor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textSeccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profesor frame = new Profesor();
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
	public Profesor() {
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
		profesor.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/profesor.png")));
		profesor.setFont(new Font("Segoe UI", Font.BOLD, 60));
		profesor.setBounds(38, 52, 325, 89);
		panel.add(profesor);
		
		JLabel cedula = new JLabel("Cédula");
		cedula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		cedula.setBounds(37, 152, 237, 32);
		panel.add(cedula);
		
		textCedula = new JTextField();
		textCedula.setText("ingrese la cedula");
		textCedula.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCedula.setColumns(10);
		textCedula.setBackground(new Color(224, 255, 255));
		textCedula.setBounds(47, 180, 227, 38);
		panel.add(textCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(38, 229, 94, 24);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setText("ingrese el nombre");
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		textNombre.setBounds(48, 253, 299, 38);
		panel.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellido.setBounds(38, 302, 94, 24);
		panel.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setText("ingrese el apellido");
		textApellido.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textApellido.setColumns(10);
		textApellido.setBackground(new Color(224, 255, 255));
		textApellido.setBounds(48, 331, 299, 38);
		panel.add(textApellido);
		
		JLabel lblSeccion = new JLabel("Sección");
		lblSeccion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSeccion.setBounds(38, 380, 94, 24);
		panel.add(lblSeccion);
		
		textSeccion = new JTextField();
		textSeccion.setText("ingrese la sección");
		textSeccion.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textSeccion.setColumns(10);
		textSeccion.setBackground(new Color(224, 255, 255));
		textSeccion.setBounds(48, 406, 200, 38);
		panel.add(textSeccion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(23, 475, 210, 65);
		panel.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(261, 475, 200, 65);
		panel.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(275, 572, 209, 65);
		panel.add(btnEliminar);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/profesor (2).png")));
		lblImagen.setBounds(480, 52, 512, 585);
		panel.add(lblImagen);
		
		JButton btnBuscarCedula = new JButton("");
		btnBuscarCedula.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarCedula.setBounds(274, 180, 44, 38);
		panel.add(btnBuscarCedula);
		
		JButton btnBuscarSeccion = new JButton("");
		btnBuscarSeccion.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarSeccion.setBounds(248, 406, 44, 38);
		panel.add(btnBuscarSeccion);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(64, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(21, 572, 227, 65);
		panel.add(btnModificar);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Profesor.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}

}
