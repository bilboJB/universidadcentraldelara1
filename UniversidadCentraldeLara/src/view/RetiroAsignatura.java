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

public class RetiroAsignatura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAsignatura;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetiroAsignatura frame = new RetiroAsignatura();
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
	public RetiroAsignatura() {
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
		
		JLabel retiroAsignatura = new JLabel("Listado de Retiro de Asignatura");
		retiroAsignatura.setIcon(new ImageIcon(RetiroAsignatura.class.getResource("/iconos/listado de estudiante por semestre.png")));
		retiroAsignatura.setFont(new Font("Segoe UI", Font.BOLD, 50));
		retiroAsignatura.setBounds(110, 62, 838, 81);
		panel.add(retiroAsignatura);
		
		JLabel asignatura = new JLabel("Asignatura:");
		asignatura.setFont(new Font("Segoe UI", Font.BOLD, 16));
		asignatura.setBounds(295, 169, 93, 32);
		panel.add(asignatura);
		
		textAsignatura = new JTextField();
		textAsignatura.setFont(new Font("Segoe UI", Font.BOLD, 16));
		textAsignatura.setColumns(10);
		textAsignatura.setBackground(new Color(224, 255, 255));
		textAsignatura.setBounds(385, 169, 238, 32);
		panel.add(textAsignatura);
		
		JButton btnBuscarAsignatura = new JButton("");
		btnBuscarAsignatura.setIcon(new ImageIcon(RetiroAsignatura.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarAsignatura.setBounds(622, 169, 36, 32);
		panel.add(btnBuscarAsignatura);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 236, 882, 302);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
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
				{null, null},
			},
			new String[] {
				"Estudiante", "Asignatura"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnGenerarListado = new JButton("Generar Listado");
		btnGenerarListado.setIcon(new ImageIcon(RetiroAsignatura.class.getResource("/iconos/iconsLista50.png")));
		btnGenerarListado.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGenerarListado.setBackground(Color.BLACK);
		btnGenerarListado.setBounds(342, 560, 355, 65);
		panel.add(btnGenerarListado);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(RetiroAsignatura.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(67, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(RetiroAsignatura.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(RetiroAsignatura.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(RetiroAsignatura.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}

}
