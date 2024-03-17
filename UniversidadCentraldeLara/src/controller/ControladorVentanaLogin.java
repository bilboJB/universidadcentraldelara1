package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import view.Login;

public class ControladorVentanaLogin implements ActionListener{
	private Login login;
	private String usuario;
	private String password;
	private ControladorVentanaMenu controladorVentanaMenu;
	
	public ControladorVentanaLogin() {
		login = new Login();
		login.setVisible(true);
		login.agregarListener(this);
		usuario = "admin";
		password = "admin";
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Ingresar")) {
			String contra = new String(login.getTxtClave().getPassword());
			//para el boton ingresar
			if(login.getTextUsuario().getText().equals(usuario) && password.equals(contra)) {
				crearMenu();
				login.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(login, "Por favor coloque el usuario y contraseña");
			}
		}
	}
	private void crearMenu() {
		controladorVentanaMenu = new ControladorVentanaMenu();
	}
}
