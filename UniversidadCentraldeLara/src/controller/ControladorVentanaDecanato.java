package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import view.Menu;
import view.VentanaDecanato;

public class ControladorVentanaDecanato implements ActionListener {
	private VentanaDecanato ventanaDecanato;
	private Menu menu;
	private DbCon db;
	
	public ControladorVentanaDecanato() {
		ventanaDecanato = new VentanaDecanato();
		ventanaDecanato.setVisible(true);
		ventanaDecanato.agregarListener(this);
		menu = null;
		db = new DbCon();
		limpiar();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Menu Principal")) {
			//para el boton menu principal
			ventanaDecanato.setVisible(false);
			menu.setVisible(true);
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Guardar")) {
			//para el boton guardar
			if (ventanaDecanato.getTextNombre().getText().equalsIgnoreCase("") || ventanaDecanato.getTextDireccion().getText().equalsIgnoreCase("") || ventanaDecanato.getTextTelefono().getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(ventanaDecanato, "Por favor rellene los datos");
			}
			else {
				insertarDecanato();
				JOptionPane.showMessageDialog(ventanaDecanato, "Decanato Guardado");
				limpiar();
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Limpiar")) {
			//para el boton limpiar
			limpiar();
		}
		
		
	}
	
	public void setMenuPrincipal(Menu menuPrincipal) {
		menu = menuPrincipal;
	}
	
	private void limpiar() {
		ventanaDecanato.getTextDireccion().setText("");
		ventanaDecanato.getTextNombre().setText("");
		ventanaDecanato.getTextTelefono().setText("");
	}
	
	private void insertarDecanato() {
		Connection con = null;
		PreparedStatement pS = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("INSERT INTO public.\"Decanato\" (nombre_decanato, direccion_decanato, tlf_decanato) VALUES (?, ?, ?);");
			pS.setString(1, ventanaDecanato.getTextNombre().getText());
			pS.setString(2, ventanaDecanato.getTextDireccion().getText());
			pS.setString(3, ventanaDecanato.getTextTelefono().getText());
			pS.executeUpdate();
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			//cierra todo
			try { if (pS != null) pS.close(); } catch (Exception ex) {};
		    try { if (con != null) con.close(); } catch (Exception ex) {};
		}
	}
}
