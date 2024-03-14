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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaListadoSemestre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSemestre;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListadoSemestre frame = new VentanaListadoSemestre();
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
	public VentanaListadoSemestre() {
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
		
		JLabel estudianteXSemestre = new JLabel("Listado de Estudiantes por Semestres");
		estudianteXSemestre.setIcon(new ImageIcon(VentanaListadoSemestre.class.getResource("/iconos/listado de estudiante por semestre.png")));
		estudianteXSemestre.setFont(new Font("Segoe UI", Font.BOLD, 50));
		estudianteXSemestre.setBounds(24, 56, 969, 81);
		panel.add(estudianteXSemestre);
		
		JLabel semestre = new JLabel("Semestre:");
		semestre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		semestre.setBounds(328, 148, 81, 32);
		panel.add(semestre);
		
		textSemestre = new JTextField();
		textSemestre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		textSemestre.setColumns(10);
		textSemestre.setBackground(new Color(224, 255, 255));
		textSemestre.setBounds(403, 148, 158, 32);
		panel.add(textSemestre);
		
		JButton btnBuscarSemestre = new JButton("");
		btnBuscarSemestre.setIcon(new ImageIcon(VentanaListadoSemestre.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarSemestre.setBounds(564, 148, 36, 32);
		panel.add(btnBuscarSemestre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 214, 918, 283);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Estudiantes", "Semestre"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnGenerarListado = new JButton("Generar Listado");
		btnGenerarListado.setIcon(new ImageIcon(VentanaListadoSemestre.class.getResource("/iconos/iconsLista50.png")));
		btnGenerarListado.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGenerarListado.setBackground(Color.BLACK);
		btnGenerarListado.setBounds(382, 537, 355, 65);
		panel.add(btnGenerarListado);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaListadoSemestre.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(11, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(68, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(VentanaListadoSemestre.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(903, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaListadoSemestre.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(949, 11, 44, 29);
		panel.add(btnSalir);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaListadoSemestre.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
}
