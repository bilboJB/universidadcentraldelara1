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
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDecanato, btnEstudiante, btnProfesor, btnCarrera, btnAsignatura, btnSeccion, btnNotas, btnReporte;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
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
		
		JLabel menuPrincipal = new JLabel("MENÚ PRINCIPAL");
		menuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 60));
		menuPrincipal.setBounds(277, 35, 515, 75);
		panel.add(menuPrincipal);
		
		btnDecanato = new JButton("Decanato");
		btnDecanato.setBackground(Color.LIGHT_GRAY);
		btnDecanato.setIcon(new ImageIcon(Menu.class.getResource("/iconos/universidad.png")));
		btnDecanato.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnDecanato.setBounds(234, 147, 222, 92);
		panel.add(btnDecanato);
		
		btnEstudiante = new JButton("Estudiante");
		btnEstudiante.setBackground(Color.LIGHT_GRAY);
		btnEstudiante.setIcon(new ImageIcon(Menu.class.getResource("/iconos/graduado.png")));
		btnEstudiante.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnEstudiante.setBounds(234, 279, 222, 92);
		panel.add(btnEstudiante);
		
		btnProfesor = new JButton("Profesor");
		btnProfesor.setBackground(Color.LIGHT_GRAY);
		btnProfesor.setIcon(new ImageIcon(Menu.class.getResource("/iconos/profesor.png")));
		btnProfesor.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnProfesor.setBounds(234, 408, 222, 92);
		panel.add(btnProfesor);
		
		btnCarrera = new JButton("Carrera");
		btnCarrera.setBackground(Color.LIGHT_GRAY);
		btnCarrera.setIcon(new ImageIcon(Menu.class.getResource("/iconos/carrera-profesional.png")));
		btnCarrera.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnCarrera.setBounds(234, 538, 222, 92);
		panel.add(btnCarrera);
		
		btnAsignatura = new JButton("Asignatura");
		btnAsignatura.setBackground(Color.LIGHT_GRAY);
		btnAsignatura.setIcon(new ImageIcon(Menu.class.getResource("/iconos/asignatura.png")));
		btnAsignatura.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnAsignatura.setBounds(566, 147, 237, 92);
		panel.add(btnAsignatura);
		
		btnSeccion = new JButton("Sección");
		btnSeccion.setBackground(Color.LIGHT_GRAY);
		btnSeccion.setIcon(new ImageIcon(Menu.class.getResource("/iconos/seccion.png")));
		btnSeccion.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnSeccion.setBounds(566, 279, 237, 92);
		panel.add(btnSeccion);
		
		btnNotas = new JButton("Notas");
		btnNotas.setBackground(Color.LIGHT_GRAY);
		btnNotas.setIcon(new ImageIcon(Menu.class.getResource("/iconos/notas.png")));
		btnNotas.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnNotas.setBounds(566, 408, 237, 92);
		panel.add(btnNotas);
		
		btnReporte = new JButton("Reportes");
		btnReporte.setBackground(Color.LIGHT_GRAY);
		btnReporte.setIcon(new ImageIcon(Menu.class.getResource("/iconos/informe.png")));
		btnReporte.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnReporte.setBounds(566, 538, 237, 92);
		panel.add(btnReporte);
		
		JButton btnSalir = new JButton("");
		btnSalir.setBackground(new Color(0, 0, 0));
		btnSalir.setIcon(new ImageIcon(Menu.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(Menu.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(new Color(0, 0, 0));
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(Menu.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon(Menu.class.getResource("/iconos/fondoMenu.jpg")));
		Fondo.setBounds(10, 1, 1004, 661);
		panel.add(Fondo);
	}
	
	public void agregarListener(ActionListener actionListener) {
		btnAsignatura.addActionListener(actionListener);
		btnCarrera.addActionListener(actionListener);
		btnDecanato.addActionListener(actionListener);
		btnEstudiante.addActionListener(actionListener);
		btnNotas.addActionListener(actionListener);
		btnProfesor.addActionListener(actionListener);
		btnReporte.addActionListener(actionListener);
		btnSeccion.addActionListener(actionListener);
	}

}
