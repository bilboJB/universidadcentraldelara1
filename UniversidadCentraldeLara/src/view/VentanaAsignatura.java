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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAsignatura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField txtSeccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAsignatura frame = new VentanaAsignatura();
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
	public VentanaAsignatura() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel asignatura = new JLabel("Asignatura");
		asignatura.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/asignatura.png")));
		asignatura.setFont(new Font("Segoe UI", Font.BOLD, 60));
		asignatura.setBounds(10, 60, 424, 89);
		contentPane.add(asignatura);
		
		JLabel codigo = new JLabel("Código");
		codigo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		codigo.setBounds(38, 160, 237, 32);
		contentPane.add(codigo);
		
		textCodigo = new JTextField();
		textCodigo.setBackground(new Color(224, 255, 255));
		textCodigo.setText("ingrese el código");
		textCodigo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCodigo.setBounds(48, 188, 227, 38);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(38, 237, 94, 24);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setText("ingrese el nombre");
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		textNombre.setBounds(48, 261, 299, 38);
		contentPane.add(textNombre);
		
		JLabel lblSeccion = new JLabel("Sección");
		lblSeccion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSeccion.setBounds(38, 310, 94, 24);
		contentPane.add(lblSeccion);
		
		txtSeccion = new JTextField();
		txtSeccion.setText("ingrese la seccion");
		txtSeccion.setFont(new Font("Segoe UI", Font.BOLD, 20));
		txtSeccion.setColumns(10);
		txtSeccion.setBackground(new Color(224, 255, 255));
		txtSeccion.setBounds(48, 336, 200, 38);
		contentPane.add(txtSeccion);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/asignaturas.png")));
		lblImagen.setBounds(494, 59, 498, 602);
		contentPane.add(lblImagen);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 8, 44, 28);
		contentPane.add(btnVolver);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 8, 44, 29);
		contentPane.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 8, 44, 29);
		contentPane.add(btnSalir);
		
		JButton btnBuscarAsignatura = new JButton("");
		btnBuscarAsignatura.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarAsignatura.setBounds(277, 188, 44, 38);
		contentPane.add(btnBuscarAsignatura);
		
		JButton btnBuscarSeccion = new JButton("");
		btnBuscarSeccion.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarSeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(214, 417, 107, 65);
		contentPane.add(btnModificar);
		btnBuscarSeccion.setBounds(249, 336, 44, 38);
		contentPane.add(btnBuscarSeccion);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(76, 493, 107, 65);
		contentPane.add(btnLimpiar);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(64, 8, 198, 28);
		contentPane.add(btnMenuPrincipal);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(214, 493, 107, 65);
		contentPane.add(btnEliminar);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(77, 417, 106, 65);
		contentPane.add(btnGuardar);
		
		JButton btnVerListaAsignaturas = new JButton("Ver Lista Asignaturas");
		btnVerListaAsignaturas.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/iconsLista50.png")));
		btnVerListaAsignaturas.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnVerListaAsignaturas.setBackground(Color.BLACK);
		btnVerListaAsignaturas.setBounds(38, 569, 369, 65);
		contentPane.add(btnVerListaAsignaturas);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaAsignatura.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		contentPane.add(fondo);
	}
}
