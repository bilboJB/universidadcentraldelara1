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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class VentanaSeccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textCedulaProfesor;
	private JTextField textCedulaEstudiante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSeccion frame = new VentanaSeccion();
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
	public VentanaSeccion() {
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
		
		JLabel seccion = new JLabel("Sección");
		seccion.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/seccion.png")));
		seccion.setFont(new Font("Segoe UI", Font.BOLD, 60));
		seccion.setBounds(39, 58, 325, 89);
		panel.add(seccion);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/secciones.png")));
		lblImagen.setBounds(438, 68, 553, 556);
		panel.add(lblImagen);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(62, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JLabel codigo = new JLabel("Código");
		codigo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		codigo.setBounds(39, 158, 237, 32);
		panel.add(codigo);
		
		textCodigo = new JTextField();
		textCodigo.setText("ingrese el código");
		textCodigo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCodigo.setColumns(10);
		textCodigo.setBackground(new Color(224, 255, 255));
		textCodigo.setBounds(49, 186, 227, 38);
		panel.add(textCodigo);
		
		JLabel profesor = new JLabel("Profesor");
		profesor.setFont(new Font("Segoe UI", Font.BOLD, 16));
		profesor.setBounds(39, 235, 237, 32);
		panel.add(profesor);
		
		textCedulaProfesor = new JTextField();
		textCedulaProfesor.setText("ingrese la cedula del profesor");
		textCedulaProfesor.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCedulaProfesor.setColumns(10);
		textCedulaProfesor.setBackground(new Color(224, 255, 255));
		textCedulaProfesor.setBounds(49, 262, 296, 38);
		panel.add(textCedulaProfesor);
		
		JButton btnBuscarCedulaProfesor = new JButton("");
		btnBuscarCedulaProfesor.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarCedulaProfesor.setBounds(347, 262, 44, 38);
		panel.add(btnBuscarCedulaProfesor);
		
		JLabel estudiante = new JLabel("Estudiante");
		estudiante.setFont(new Font("Segoe UI", Font.BOLD, 16));
		estudiante.setBounds(39, 311, 237, 32);
		panel.add(estudiante);
		
		textCedulaEstudiante = new JTextField();
		textCedulaEstudiante.setText("ingrese la cedula del estudiante");
		textCedulaEstudiante.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCedulaEstudiante.setColumns(10);
		textCedulaEstudiante.setBackground(new Color(224, 255, 255));
		textCedulaEstudiante.setBounds(49, 338, 325, 38);
		panel.add(textCedulaEstudiante);
		
		JButton btnBuscarCedulaEstudiante = new JButton("");
		btnBuscarCedulaEstudiante.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarCedulaEstudiante.setBounds(371, 338, 44, 38);
		panel.add(btnBuscarCedulaEstudiante);
		
		JLabel periodoAcademico = new JLabel("Periodo Académico");
		periodoAcademico.setFont(new Font("Segoe UI", Font.BOLD, 16));
		periodoAcademico.setBounds(37, 390, 237, 32);
		panel.add(periodoAcademico);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(97, 477, 94, 54);
		panel.add(btnGuardar);
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(251, 477, 94, 54);
		panel.add(btnModificar);
		
		JButton btnActualizar = new JButton("");
		btnActualizar.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/iconsActualizar50.png")));
		btnActualizar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnActualizar.setBackground(Color.BLACK);
		btnActualizar.setBounds(34, 538, 94, 54);
		panel.add(btnActualizar);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(182, 538, 94, 54);
		panel.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(319, 538, 94, 54);
		panel.add(btnEliminar);
		
		JButton btnVerListadoSeccion = new JButton("Ver Listado de las Secciones");
		btnVerListadoSeccion.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/iconsLista50.png")));
		btnVerListadoSeccion.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnVerListadoSeccion.setBackground(Color.BLACK);
		btnVerListadoSeccion.setBounds(24, 596, 389, 54);
		panel.add(btnVerListadoSeccion);
		
		JDateChooser dateChooserPeriodoAcad = new JDateChooser();
		dateChooserPeriodoAcad.setBounds(49, 418, 171, 28);
		panel.add(dateChooserPeriodoAcad);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaSeccion.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
}
