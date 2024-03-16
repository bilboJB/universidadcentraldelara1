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
import com.toedter.calendar.JDateChooser;

public class VentanaNotas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textNota1;
	private JTextField textNota2;
	private JTextField textNota3;
	private JTextField textPromedio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNotas frame = new VentanaNotas();
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
	public VentanaNotas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nota = new JLabel("Notas");
		nota.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/notas.png")));
		nota.setFont(new Font("Segoe UI", Font.BOLD, 60));
		nota.setBounds(49, 50, 258, 89);
		contentPane.add(nota);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 10, 44, 28);
		contentPane.add(btnVolver);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(61, 10, 198, 28);
		contentPane.add(btnMenuPrincipal);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 10, 44, 29);
		contentPane.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 10, 44, 29);
		contentPane.add(btnSalir);
		
		JLabel cedulaEstudiate = new JLabel("Cédula");
		cedulaEstudiate.setFont(new Font("Segoe UI", Font.BOLD, 16));
		cedulaEstudiate.setBounds(35, 156, 237, 32);
		contentPane.add(cedulaEstudiate);
		
		textCedula = new JTextField();
		textCedula.setText("ingrese la cédula del Estudiante");
		textCedula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		textCedula.setColumns(10);
		textCedula.setBackground(new Color(224, 255, 255));
		textCedula.setBounds(45, 184, 247, 32);
		contentPane.add(textCedula);
		
		JButton btnBuscarCedulaEstud = new JButton("");
		btnBuscarCedulaEstud.setBounds(293, 184, 44, 32);
		contentPane.add(btnBuscarCedulaEstud);
		
		JLabel lblNombreEstud = new JLabel("Nombre");
		lblNombreEstud.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombreEstud.setBounds(357, 160, 166, 24);
		contentPane.add(lblNombreEstud);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		textNombre.setBounds(357, 184, 186, 32);
		contentPane.add(textNombre);
		
		JLabel lblApellidoEstud = new JLabel("Apellido");
		lblApellidoEstud.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellidoEstud.setBounds(557, 160, 94, 24);
		contentPane.add(lblApellidoEstud);
		
		textApellido = new JTextField();
		textApellido.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textApellido.setColumns(10);
		textApellido.setBackground(new Color(224, 255, 255));
		textApellido.setBounds(553, 184, 174, 32);
		contentPane.add(textApellido);
		
		JLabel periodoAcademico = new JLabel("Periodo Académico");
		periodoAcademico.setFont(new Font("Segoe UI", Font.BOLD, 16));
		periodoAcademico.setBounds(751, 156, 186, 32);
		contentPane.add(periodoAcademico);
		
		JLabel lblNotaI = new JLabel("Nota 1:");
		lblNotaI.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNotaI.setBounds(197, 255, 63, 24);
		contentPane.add(lblNotaI);
		
		textNota1 = new JTextField();
		textNota1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNota1.setColumns(10);
		textNota1.setBackground(new Color(224, 255, 255));
		textNota1.setBounds(255, 249, 72, 42);
		contentPane.add(textNota1);
		
		JLabel lblNotaII = new JLabel("Nota 2:");
		lblNotaII.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNotaII.setBounds(352, 255, 72, 24);
		contentPane.add(lblNotaII);
		
		textNota2 = new JTextField();
		textNota2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNota2.setColumns(10);
		textNota2.setBackground(new Color(224, 255, 255));
		textNota2.setBounds(409, 249, 72, 42);
		contentPane.add(textNota2);
		
		JLabel lblNotaIII = new JLabel("Nota 3:");
		lblNotaIII.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNotaIII.setBounds(514, 255, 72, 24);
		contentPane.add(lblNotaIII);
		
		textNota3 = new JTextField();
		textNota3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNota3.setColumns(10);
		textNota3.setBackground(new Color(224, 255, 255));
		textNota3.setBounds(571, 249, 72, 42);
		contentPane.add(textNota3);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/calcular.png")));
		btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnCalcular.setBackground(Color.BLACK);
		btnCalcular.setBounds(311, 315, 237, 53);
		contentPane.add(btnCalcular);
		
		textPromedio = new JTextField();
		textPromedio.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textPromedio.setColumns(10);
		textPromedio.setBackground(new Color(224, 255, 255));
		textPromedio.setBounds(147, 400, 186, 32);
		contentPane.add(textPromedio);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPromedio.setBounds(63, 406, 87, 24);
		contentPane.add(lblPromedio);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(49, 477, 107, 65);
		contentPane.add(btnGuardar);
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(182, 477, 107, 65);
		contentPane.add(btnModificar);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(320, 477, 104, 65);
		contentPane.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(453, 477, 104, 65);
		contentPane.add(btnEliminar);
		
		JButton btnVerListado = new JButton("Ver Listado");
		btnVerListado.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/iconsLista50.png")));
		btnVerListado.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnVerListado.setBackground(Color.BLACK);
		btnVerListado.setBounds(167, 568, 282, 65);
		contentPane.add(btnVerListado);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/Notass.png")));
		lblImagen.setBounds(696, 249, 294, 380);
		contentPane.add(lblImagen);
		
		JDateChooser dateChooserPeriodoAcad = new JDateChooser();
		dateChooserPeriodoAcad.setBounds(761, 184, 171, 28);
		contentPane.add(dateChooserPeriodoAcad);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaNotas.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		contentPane.add(fondo);
	}
}
