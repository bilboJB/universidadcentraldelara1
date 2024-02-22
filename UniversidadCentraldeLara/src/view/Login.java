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
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsario;
	private JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
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
		
		JLabel iniciarSesion = new JLabel("INICIAR SESIÓN");
		iniciarSesion.setForeground(new Color(0, 0, 0));
		iniciarSesion.setBackground(new Color(47, 79, 79));
		iniciarSesion.setFont(new Font("Segoe UI", Font.BOLD, 60));
		iniciarSesion.setBounds(513, 99, 456, 93);
		panel.add(iniciarSesion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/iconos/iniciar sesion.png")));
		lblNewLabel.setBounds(46, 22, 474, 617);
		panel.add(lblNewLabel);
		
		JButton btnIniciarSesion = new JButton("Ingresar");
		btnIniciarSesion.setBackground(new Color(0, 0, 0));
		btnIniciarSesion.setForeground(new Color(0, 0, 0));
		btnIniciarSesion.setFont(new Font("Segoe UI", Font.BOLD, 36));
		btnIniciarSesion.setBounds(663, 503, 208, 57);
		panel.add(btnIniciarSesion);
		
		textUsario = new JTextField();
		textUsario.setBackground(new Color(224, 255, 255));
		textUsario.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textUsario.setText("Ingrese el nombre de usuario");
		textUsario.setBounds(644, 267, 275, 37);
		panel.add(textUsario);
		textUsario.setColumns(10);
		
		JLabel iconoUsuario = new JLabel("");
		iconoUsuario.setIcon(new ImageIcon(Login.class.getResource("/iconos/iconsUsuario50.png")));
		iconoUsuario.setBounds(589, 254, 55, 57);
		panel.add(iconoUsuario);
		
		txtClave = new JPasswordField();
		txtClave.setBackground(new Color(224, 255, 255));
		txtClave.setToolTipText("");
		txtClave.setBounds(644, 341, 275, 31);
		panel.add(txtClave);
		
		JLabel iconoClave = new JLabel("");
		iconoClave.setIcon(new ImageIcon(Login.class.getResource("/iconos/iconCandado50.png")));
		iconoClave.setBounds(594, 322, 50, 50);
		panel.add(iconoClave);
		
		JButton btnMinimizar = new JButton("-");
		btnMinimizar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnMinimizar.setBackground(new Color(0, 0, 139));
		btnMinimizar.setBounds(891, 0, 50, 31);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("X");
		btnSalir.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSalir.setBounds(951, 0, 50, 31);
		panel.add(btnSalir);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Login.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
}
