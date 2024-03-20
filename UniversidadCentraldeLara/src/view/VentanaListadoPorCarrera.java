/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Alexis Acuña 26.305.133
*/
package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;

public class VentanaListadoPorCarrera extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCarrera;
	private JTable table;
	private JButton btnListado;
	private DefaultTableModel modelo;
	private String[] columnas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListadoPorCarrera frame = new VentanaListadoPorCarrera();
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
	public VentanaListadoPorCarrera() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Listado de Estudiante por Carrera");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel lblCarrera = new JLabel("Carrera");
		panel_2.add(lblCarrera);
		
		txtCarrera = new JTextField();
		txtCarrera.setPreferredSize(new Dimension(450,25));
		panel_2.add(txtCarrera);
		txtCarrera.setColumns(30);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		table = new JTable();
		columnas = new String[] {"Estudiante", "Carrera"};
		modelo = new DefaultTableModel(new Object[][] {}, columnas) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 932482014137999698L;
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		table.setModel(modelo);
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		btnListado = new JButton("Generar Listado");
		btnListado.setIcon(new ImageIcon(VentanaListadoPorCarrera.class.getResource("/iconos/iconsLista50.png")));
		panel_3.add(btnListado);
	}
	public void agregarListener(ActionListener actionListener) {
		btnListado.addActionListener(actionListener);
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}

	public String[] getColumnas() {
		return columnas;
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getTxtCarrera() {
		return txtCarrera;
	}
	
}
