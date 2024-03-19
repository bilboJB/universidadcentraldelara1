package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaValidacionProfesor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textProfesor;
	private JTextField textAsignatura;
	private JTextField textSeccion;
	private JButton btnValidar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaValidacionProfesor frame = new VentanaValidacionProfesor();
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
	public VentanaValidacionProfesor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setBounds(10, 11, 434, 48);
		contentPane.add(panel);
		
		JLabel lblProfesor = new JLabel("Cedula Profesor");
		panel.add(lblProfesor);
		
		textProfesor = new JTextField();
		panel.add(textProfesor);
		textProfesor.setColumns(20);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		panel_1.setBounds(10, 70, 434, 46);
		contentPane.add(panel_1);
		
		JLabel lblAsignatura = new JLabel("Nombre Asignatura");
		panel_1.add(lblAsignatura);
		
		textAsignatura = new JTextField();
		textAsignatura.setColumns(20);
		panel_1.add(textAsignatura);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		panel_2.setBounds(10, 127, 434, 46);
		contentPane.add(panel_2);
		
		JLabel lblNumeroSeccion = new JLabel("Numero Seccion");
		panel_2.add(lblNumeroSeccion);
		
		textSeccion = new JTextField();
		textSeccion.setColumns(20);
		panel_2.add(textSeccion);
		
		btnValidar = new JButton("Validar Profesor");
		btnValidar.setBounds(147, 186, 153, 36);
		contentPane.add(btnValidar);
	}

	public JTextField getTextProfesor() {
		return textProfesor;
	}

	public JTextField getTextAsignatura() {
		return textAsignatura;
	}

	public JTextField getTextSeccion() {
		return textSeccion;
	}
	
	public void agregarListener(ActionListener actionListener) {
		btnValidar.addActionListener(actionListener);
	}
}
