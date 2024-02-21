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

public class Decanato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Decanato frame = new Decanato();
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
	public Decanato() {
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
		
		JLabel decanato = new JLabel("Decanato");
		decanato.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/universidad.png")));
		decanato.setFont(new Font("Segoe UI", Font.BOLD, 60));
		decanato.setBounds(22, 66, 424, 89);
		panel.add(decanato);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(22, 188, 94, 24);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setText("ingrese el nombre");
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		textNombre.setBounds(32, 212, 299, 38);
		panel.add(textNombre);
		
		JLabel codigo = new JLabel("Código");
		codigo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		codigo.setBounds(22, 275, 237, 32);
		panel.add(codigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("ingrese el código de la carrera");
		txtCodigo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		txtCodigo.setColumns(10);
		txtCodigo.setBackground(new Color(224, 255, 255));
		txtCodigo.setBounds(32, 303, 304, 38);
		panel.add(txtCodigo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(22, 385, 210, 65);
		panel.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(256, 385, 200, 65);
		panel.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(257, 475, 210, 65);
		panel.add(btnEliminar);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/decanatos.png")));
		lblLogo.setBounds(495, 75, 488, 523);
		panel.add(lblLogo);
		
		JButton btnBuscarCarrera = new JButton("");
		btnBuscarCarrera.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarCarrera.setBounds(336, 303, 44, 38);
		panel.add(btnBuscarCarrera);
		
		JButton btnListado = new JButton("Ver Lista Decanato");
		btnListado.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/iconsLista50.png")));
		btnListado.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnListado.setBackground(Color.BLACK);
		btnListado.setBounds(60, 564, 369, 65);
		panel.add(btnListado);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(61, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/iconsEditar50.png")));
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setBounds(10, 475, 227, 65);
		panel.add(btnModificar);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(Decanato.class.getResource("/iconos/fondoMenu.jpg")));
		lblImagen.setBounds(0, 0, 1014, 661);
		panel.add(lblImagen);
	}

}
