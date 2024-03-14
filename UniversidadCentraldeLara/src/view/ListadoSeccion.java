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
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListadoSeccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSeccion;
	private JTable table;
	private DefaultTableModel modelo;
	private JButton btnBuscarSeccion, btnGenerarListado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoSeccion frame = new ListadoSeccion();
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
	public ListadoSeccion() {
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
		
		JLabel listadoSeccion = new JLabel("Listado por Sección");
		listadoSeccion.setIcon(new ImageIcon(ListadoSeccion.class.getResource("/iconos/listado de estudiante por semestre.png")));
		listadoSeccion.setFont(new Font("Segoe UI", Font.BOLD, 50));
		listadoSeccion.setBounds(239, 66, 564, 81);
		panel.add(listadoSeccion);
		
		JLabel seccion = new JLabel("Sección:");
		seccion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		seccion.setBounds(344, 165, 81, 32);
		panel.add(seccion);
		
		textSeccion = new JTextField();
		textSeccion.setFont(new Font("Segoe UI", Font.BOLD, 16));
		textSeccion.setColumns(10);
		textSeccion.setBackground(new Color(224, 255, 255));
		textSeccion.setBounds(407, 165, 258, 32);
		panel.add(textSeccion);
		
		btnBuscarSeccion = new JButton("");
		btnBuscarSeccion.setIcon(new ImageIcon(ListadoSeccion.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarSeccion.setBounds(675, 165, 36, 32);
		panel.add(btnBuscarSeccion);
		
		btnGenerarListado = new JButton("Generar Listado");
		btnGenerarListado.setIcon(new ImageIcon(ListadoSeccion.class.getResource("/iconos/iconsLista50.png")));
		btnGenerarListado.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGenerarListado.setBackground(Color.BLACK);
		btnGenerarListado.setBounds(356, 560, 355, 65);
		panel.add(btnGenerarListado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 225, 903, 301);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Decanato", "Carrera", "Asignatura", "Docente", "Seccion"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(ListadoSeccion.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(67, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(ListadoSeccion.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(ListadoSeccion.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(ListadoSeccion.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public JTextField getTextSeccion() {
		return textSeccion;
	}

	public JTable getTable() {
		return table;
	}
	
	public void agregarListener(ActionListener actionListener) {
		btnBuscarSeccion.addActionListener(actionListener);
		btnGenerarListado.addActionListener(actionListener);
	}
}
