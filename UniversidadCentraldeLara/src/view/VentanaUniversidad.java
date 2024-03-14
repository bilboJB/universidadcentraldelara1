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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaUniversidad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUniversidad frame = new VentanaUniversidad();
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
	public VentanaUniversidad() {
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
		
		JLabel universidad = new JLabel("Universidad");
		universidad.setIcon(new ImageIcon(VentanaUniversidad.class.getResource("/iconos/universidad.png")));
		universidad.setFont(new Font("Segoe UI", Font.BOLD, 60));
		universidad.setBounds(43, 48, 424, 89);
		panel.add(universidad);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(60, 165, 94, 24);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setText("ingrese el nombre");
		textNombre.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textNombre.setColumns(10);
		textNombre.setBackground(new Color(224, 255, 255));
		textNombre.setBounds(70, 189, 299, 38);
		panel.add(textNombre);
		
		JLabel codigo = new JLabel("Código");
		codigo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		codigo.setBounds(60, 252, 237, 32);
		panel.add(codigo);
		
		textCodigo = new JTextField();
		textCodigo.setText("ingrese el código del decanato");
		textCodigo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textCodigo.setColumns(10);
		textCodigo.setBackground(new Color(224, 255, 255));
		textCodigo.setBounds(70, 280, 304, 38);
		panel.add(textCodigo);
		
		JButton btnBuscarDecanato = new JButton("");
		btnBuscarDecanato.setIcon(new ImageIcon(VentanaUniversidad.class.getResource("/iconos/iconsLupa30.png")));
		btnBuscarDecanato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarDecanato.setBounds(374, 280, 44, 38);
		panel.add(btnBuscarDecanato);
		
		JButton btnMenuPrincipal = new JButton("Menu Principal");
		btnMenuPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnMenuPrincipal.setBackground(Color.BLACK);
		btnMenuPrincipal.setBounds(61, 11, 198, 28);
		panel.add(btnMenuPrincipal);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaUniversidad.class.getResource("/iconos/iconsVolver30.png")));
		btnVolver.setBounds(10, 11, 44, 28);
		panel.add(btnVolver);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setIcon(new ImageIcon(VentanaUniversidad.class.getResource("/iconos/btn-minimizar.png")));
		btnMinimizar.setBackground(Color.BLACK);
		btnMinimizar.setBounds(902, 11, 44, 29);
		panel.add(btnMinimizar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VentanaUniversidad.class.getResource("/iconos/btn-cerrar.png")));
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setBounds(948, 11, 44, 29);
		panel.add(btnSalir);
		
		JButton btnLimpiar = new JButton("");
		btnLimpiar.setIcon(new ImageIcon(VentanaUniversidad.class.getResource("/iconos/iconsLimpiar50.png")));
		btnLimpiar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setBounds(275, 396, 94, 54);
		panel.add(btnLimpiar);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(VentanaUniversidad.class.getResource("/iconos/iconGuardar.png")));
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(90, 396, 94, 54);
		panel.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(VentanaUniversidad.class.getResource("/iconos/iconsEliminar50.png")));
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(181, 510, 94, 54);
		panel.add(btnEliminar);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(VentanaUniversidad.class.getResource("/iconos/universidadd.png")));
		lblImagen.setBounds(477, 69, 515, 570);
		panel.add(lblImagen);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(VentanaUniversidad.class.getResource("/iconos/fondoMenu.jpg")));
		fondo.setBounds(0, 0, 1014, 661);
		panel.add(fondo);
	}
}
