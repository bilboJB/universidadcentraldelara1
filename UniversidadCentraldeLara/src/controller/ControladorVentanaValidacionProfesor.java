/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
*/
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
import view.VentanaValidacionProfesor;

public class ControladorVentanaValidacionProfesor implements ActionListener {
	private VentanaValidacionProfesor ventanaValidacionProfesor;
	private Menu menu;
	private ControladorVentanaNotas cVentanaNotas;
	private DbCon db;
	private int idProfesor, idAsignatura, idSeccion;
	
	public ControladorVentanaValidacionProfesor() {
		ventanaValidacionProfesor = new VentanaValidacionProfesor();
		ventanaValidacionProfesor.setVisible(true);
		ventanaValidacionProfesor.agregarListener(this);
		db = new DbCon();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Validar Profesor")) {
			if (ventanaValidacionProfesor.getTextProfesor().getText().equalsIgnoreCase("") || ventanaValidacionProfesor.getTextAsignatura().getText().equalsIgnoreCase("") || !(ventanaValidacionProfesor.getTextSeccion().getText().matches("[1-9]"))) {
				JOptionPane.showMessageDialog(ventanaValidacionProfesor, "Por favor rellene los datos");
			}
			else if (validacionProfesor()) {
				cVentanaNotas = new ControladorVentanaNotas();
				menu.setVisible(false);
				ventanaValidacionProfesor.setVisible(false);
				cVentanaNotas.setMenuPrincipal(menu);
				cVentanaNotas.setId_seccion(idSeccion);
			}
			else {
				JOptionPane.showMessageDialog(ventanaValidacionProfesor, "Profesor no forma parte de esa seccion y/o de esa asignatura");
			}
		}
	}
	
	private boolean validacionProfesor() {
		boolean existe = false;
		int numeroSeccion = Integer.parseInt(ventanaValidacionProfesor.getTextSeccion().getText());
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		try{
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT id_asignatura, id_profesor, id_seccion FROM public.\"Seccion\" INNER JOIN \"Profesor\" ON \"Seccion\".profesor = \"Profesor\".id_profesor INNER JOIN \"Asignatura\" ON \"Seccion\".asignatura = \"Asignatura\".id_asignatura WHERE nombre_asignatura=? AND cedula_profesor=? AND numero_seccion=?;");	
			pS.setString(1, ventanaValidacionProfesor.getTextAsignatura().getText());
			pS.setString(2, ventanaValidacionProfesor.getTextProfesor().getText());
			pS.setInt(3, numeroSeccion);
			//se ejecuta el sql y se guarda el resultado
			result = pS.executeQuery();
			if(result.isBeforeFirst()) {
				existe = true;
			}
			while(result.next()) {
				idAsignatura = result.getInt(1);
				idProfesor = result.getInt(2);
				idSeccion = result.getInt(3);
			}
			
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			//cierra todo
			try { if (result != null) result.close(); } catch (Exception ex) {};
		    try { if (pS != null) pS.close(); } catch (Exception ex) {};
		    try { if (con != null) con.close(); } catch (Exception ex) {};
		}
		return existe;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
