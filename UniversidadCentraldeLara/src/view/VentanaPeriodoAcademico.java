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
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
//import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JDateChooser;

public class VentanaPeriodoAcademico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPeriodoAcademico frame = new VentanaPeriodoAcademico();
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
	public VentanaPeriodoAcademico() {
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
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaPeriodoAcademico.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(61, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(VentanaPeriodoAcademico.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaPeriodoAcademico.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JLabel periodoAcademico = new JLabel("Periodo Académico");
		periodoAcademico.setIcon(new ImageIcon(VentanaPeriodoAcademico.class.getResource("/iconos/periodo academicoo.png")));
		periodoAcademico.setFont(new Font("Segoe UI", Font.BOLD, 60));
		periodoAcademico.setBounds(37, 67, 643, 89);
		panel.add(periodoAcademico);
		
		JLabel codigo = new JLabel("Código");
		codigo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		codigo.setBounds(61, 185, 237, 32);
		panel.add(codigo);
		
		textCodigo = new JTextField();
		textCodigo.setText("ingrese el código");
		textCodigo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCodigo.setColumns(10);
		textCodigo.setBackground(new Color(224, 255, 255));
		textCodigo.setBounds(71, 213, 227, 38);
		panel.add(textCodigo);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(VentanaPeriodoAcademico.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscar.setBounds(303, 213, 44, 38);
		panel.add(btnBuscar);
		
		JLabel fechaInicio = new JLabel("Fecha Inicio");
		fechaInicio.setFont(new Font("Segoe UI", Font.BOLD, 16));
		fechaInicio.setBounds(61, 271, 114, 24);
		panel.add(fechaInicio);
		
		JLabel lblFechaFinal = new JLabel("Fecha Final");
		lblFechaFinal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFechaFinal.setBounds(61, 345, 114, 24);
		panel.add(lblFechaFinal);
		
		JLabel lblFechaLimiteRetiro = new JLabel("Fecha Limite de Retiro");
		lblFechaLimiteRetiro.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblFechaLimiteRetiro.setBounds(61, 419, 198, 24);
		panel.add(lblFechaLimiteRetiro);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(VentanaPeriodoAcademico.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(71, 509, 94, 59);
		panel.add(btnGuardar);
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(VentanaPeriodoAcademico.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(192, 509, 94, 59);
		panel.add(btnModificar);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(VentanaPeriodoAcademico.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(37, 591, 94, 59);
		panel.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(VentanaPeriodoAcademico.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(204, 591, 94, 59);
		panel.add(btnEliminar);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VentanaPeriodoAcademico.class.getResource("/iconos/periodo academico.png")));
		lblImagen.setBounds(468, 151, 536, 483);
		panel.add(lblImagen);
		
		//JDateChooser dateChooserInicio = new JDateChooser();
		//dateChooserInicio.setBounds(71, 306, 171, 28);
		//panel.add(dateChooserInicio);
		
		//JDateChooser dateChooserFinal = new JDateChooser();
		//dateChooserFinal.setBounds(71, 380, 171, 28);
		//panel.add(dateChooserFinal);
		
		//JDateChooser dateChooserRetiro = new JDateChooser();
		//dateChooserRetiro.setBounds(71, 454, 171, 28);
		//panel.add(dateChooserRetiro);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaPeriodoAcademico.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
}
