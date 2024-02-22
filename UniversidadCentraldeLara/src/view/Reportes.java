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
import javax.swing.JButton;
import java.awt.Color;

public class Reportes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes frame = new Reportes();
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
	public Reportes() {
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
		
		JLabel reportes = new JLabel("Reportes");
		reportes.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/informe.png")));
		reportes.setFont(new Font("Segoe UI", Font.BOLD, 60));
		reportes.setBounds(30, 40, 390, 81);
		panel.add(reportes);
		
		JButton btnEstudianteXCarr = new JButton("Listado de Estudiante por Carrera");
		btnEstudianteXCarr.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/listados.png")));
		btnEstudianteXCarr.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnEstudianteXCarr.setBounds(67, 152, 353, 68);
		panel.add(btnEstudianteXCarr);
		
		JButton btnEstudianteXSemestre = new JButton("Listado de Estudiante por Semestre");
		btnEstudianteXSemestre.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/listados.png")));
		btnEstudianteXSemestre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnEstudianteXSemestre.setBounds(486, 152, 376, 68);
		panel.add(btnEstudianteXSemestre);
		
		JButton btnListadoSeccionPromdSecc = new JButton("Listado de las Secciones con Promedio de la Sección");
		btnListadoSeccionPromdSecc.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/listados.png")));
		btnListadoSeccionPromdSecc.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnListadoSeccionPromdSecc.setBounds(67, 242, 506, 68);
		panel.add(btnListadoSeccionPromdSecc);
		
		JButton btnRetiroAsig = new JButton("Listado de Retiro de Asignaturas");
		btnRetiroAsig.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/listados.png")));
		btnRetiroAsig.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnRetiroAsig.setBounds(603, 242, 353, 68);
		panel.add(btnRetiroAsig);
		
		JButton btnListadoPromedioPuntos = new JButton("Listado de Estudiantes con Promedio por encima de 16 puntos");
		btnListadoPromedioPuntos.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/listados.png")));
		btnListadoPromedioPuntos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnListadoPromedioPuntos.setBounds(67, 565, 575, 68);
		panel.add(btnListadoPromedioPuntos);
		
		JButton btnMejorPromedioCarrera = new JButton("Listado de Estudiantes con Mejor Promedio por Carrera");
		btnMejorPromedioCarrera.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/listados.png")));
		btnMejorPromedioCarrera.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMejorPromedioCarrera.setBounds(67, 407, 551, 68);
		panel.add(btnMejorPromedioCarrera);
		
		JButton btnMejorPromedioDecan = new JButton("Listado de Estudiantes con Mejor Promedio por Decanato");
		btnMejorPromedioDecan.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/listados.png")));
		btnMejorPromedioDecan.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMejorPromedioDecan.setBounds(67, 486, 551, 68);
		panel.add(btnMejorPromedioDecan);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setBackground(new Color(0, 0, 0));
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBounds(67, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JButton btnListadoSeccion = new JButton("Listado por Sección");
		btnListadoSeccion.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/listados.png")));
		btnListadoSeccion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnListadoSeccion.setBounds(67, 321, 264, 68);
		panel.add(btnListadoSeccion);
		
		JButton btnListadoXSeccionProm = new JButton("Listado por Sección con Promedio");
		btnListadoXSeccionProm.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/listados.png")));
		btnListadoXSeccionProm.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnListadoXSeccionProm.setBounds(397, 321, 359, 68);
		panel.add(btnListadoXSeccionProm);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Reportes.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
}
