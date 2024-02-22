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

public class Notas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCedula;
	private JTextField textNombreProf;
	private JTextField textApellidoProf;
	private JTextField txtIngreseLaCdula;
	private JTextField textNombreEstud;
	private JTextField textApellidoEstud;
	private JTextField textNotaI;
	private JTextField textNotaII;
	private JTextField textNotaIII;
	private JTextField textPromedio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notas frame = new Notas();
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
	public Notas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nota = new JLabel("Notas");
		nota.setIcon(new ImageIcon(Notas.class.getResource("/iconos/notas.png")));
		nota.setFont(new Font("Segoe UI", Font.BOLD, 60));
		nota.setBounds(49, 50, 258, 89);
		contentPane.add(nota);
		
		JLabel cedulaProfesor = new JLabel("Cédula");
		cedulaProfesor.setFont(new Font("Segoe UI", Font.BOLD, 16));
		cedulaProfesor.setBounds(38, 136, 237, 32);
		contentPane.add(cedulaProfesor);
		
		textCedula = new JTextField();
		textCedula.setText("ingrese la cédula del Profesor");
		textCedula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		textCedula.setColumns(10);
		textCedula.setBackground(new Color(224, 255, 255));
		textCedula.setBounds(48, 164, 247, 32);
		contentPane.add(textCedula);
		
		JButton btnBuscarCedulaProfe = new JButton("");
		btnBuscarCedulaProfe.setIcon(new ImageIcon(Notas.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarCedulaProfe.setBounds(296, 164, 44, 32);
		contentPane.add(btnBuscarCedulaProfe);
		
		JLabel lblNombrePrf = new JLabel("Nombre");
		lblNombrePrf.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombrePrf.setBounds(366, 140, 196, 24);
		contentPane.add(lblNombrePrf);
		
		textNombreProf = new JTextField();
		textNombreProf.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombreProf.setColumns(10);
		textNombreProf.setBackground(new Color(224, 255, 255));
		textNombreProf.setBounds(376, 164, 186, 32);
		contentPane.add(textNombreProf);
		
		JLabel lblApellidoProfe = new JLabel("Apellido");
		lblApellidoProfe.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellidoProfe.setBounds(596, 136, 94, 24);
		contentPane.add(lblApellidoProfe);
		
		textApellidoProf = new JTextField();
		textApellidoProf.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textApellidoProf.setColumns(10);
		textApellidoProf.setBackground(new Color(224, 255, 255));
		textApellidoProf.setBounds(606, 164, 196, 32);
		contentPane.add(textApellidoProf);
		
		JLabel cedulaEstudiate = new JLabel("Cédula");
		cedulaEstudiate.setFont(new Font("Segoe UI", Font.BOLD, 16));
		cedulaEstudiate.setBounds(38, 207, 237, 32);
		contentPane.add(cedulaEstudiate);
		
		txtIngreseLaCdula = new JTextField();
		txtIngreseLaCdula.setText("ingrese la cédula del Estudiante");
		txtIngreseLaCdula.setFont(new Font("Segoe UI", Font.BOLD, 16));
		txtIngreseLaCdula.setColumns(10);
		txtIngreseLaCdula.setBackground(new Color(224, 255, 255));
		txtIngreseLaCdula.setBounds(48, 235, 247, 32);
		contentPane.add(txtIngreseLaCdula);
		
		JButton btnBuscarCedulaEstud = new JButton("");
		btnBuscarCedulaEstud.setIcon(new ImageIcon(Notas.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarCedulaEstud.setBounds(296, 235, 44, 32);
		contentPane.add(btnBuscarCedulaEstud);
		
		JLabel lblNombreEstud = new JLabel("Nombre");
		lblNombreEstud.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombreEstud.setBounds(366, 211, 196, 24);
		contentPane.add(lblNombreEstud);
		
		textNombreEstud = new JTextField();
		textNombreEstud.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombreEstud.setColumns(10);
		textNombreEstud.setBackground(new Color(224, 255, 255));
		textNombreEstud.setBounds(376, 235, 186, 32);
		contentPane.add(textNombreEstud);
		
		JLabel lblApellidoEstud = new JLabel("Apellido");
		lblApellidoEstud.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApellidoEstud.setBounds(596, 207, 94, 24);
		contentPane.add(lblApellidoEstud);
		
		textApellidoEstud = new JTextField();
		textApellidoEstud.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textApellidoEstud.setColumns(10);
		textApellidoEstud.setBackground(new Color(224, 255, 255));
		textApellidoEstud.setBounds(606, 235, 196, 32);
		contentPane.add(textApellidoEstud);
		
		JLabel lblNotaI = new JLabel("Nota 1:");
		lblNotaI.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNotaI.setBounds(179, 296, 63, 24);
		contentPane.add(lblNotaI);
		
		textNotaI = new JTextField();
		textNotaI.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNotaI.setColumns(10);
		textNotaI.setBackground(new Color(224, 255, 255));
		textNotaI.setBounds(237, 290, 72, 42);
		contentPane.add(textNotaI);
		
		JLabel lblNotaII = new JLabel("Nota 2:");
		lblNotaII.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNotaII.setBounds(334, 296, 72, 24);
		contentPane.add(lblNotaII);
		
		textNotaII = new JTextField();
		textNotaII.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNotaII.setColumns(10);
		textNotaII.setBackground(new Color(224, 255, 255));
		textNotaII.setBounds(391, 290, 72, 42);
		contentPane.add(textNotaII);
		
		JLabel lblNotaIII = new JLabel("Nota 3:");
		lblNotaIII.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNotaIII.setBounds(496, 296, 72, 24);
		contentPane.add(lblNotaIII);
		
		textNotaIII = new JTextField();
		textNotaIII.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNotaIII.setColumns(10);
		textNotaIII.setBackground(new Color(224, 255, 255));
		textNotaIII.setBounds(553, 290, 72, 42);
		contentPane.add(textNotaIII);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnCalcular.setBackground(Color.BLACK);
		btnCalcular.setBounds(297, 353, 237, 53);
		contentPane.add(btnCalcular);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblPromedio.setBounds(49, 434, 87, 24);
		contentPane.add(lblPromedio);
		
		textPromedio = new JTextField();
		textPromedio.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textPromedio.setColumns(10);
		textPromedio.setBackground(new Color(224, 255, 255));
		textPromedio.setBounds(133, 428, 186, 32);
		contentPane.add(textPromedio);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(Notas.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(49, 481, 186, 65);
		contentPane.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(Notas.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(511, 481, 186, 65);
		contentPane.add(btnLimpiar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(Notas.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(271, 481, 207, 65);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Notas.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 26));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(168, 570, 186, 65);
		contentPane.add(btnEliminar);
		
		JButton btnVerListado = new JButton("Ver Listado");
		btnVerListado.setIcon(new ImageIcon(Notas.class.getResource("/iconos/iconsLista50.png")));
		btnVerListado.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnVerListado.setBackground(Color.BLACK);
		btnVerListado.setBounds(382, 570, 258, 65);
		contentPane.add(btnVerListado);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(Notas.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 10, 44, 28);
		contentPane.add(btnVolver);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(61, 10, 198, 28);
		contentPane.add(btnMenuPrincipal);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(Notas.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 10, 44, 29);
		contentPane.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Notas.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 10, 44, 29);
		contentPane.add(btnSalir);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Notas.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		contentPane.add(fondo);
	}
}
