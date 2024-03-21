/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
*/
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import model.Estudiante;
import view.Menu;
import view.VentanaNotas;

public class ControladorVentanaNotas implements ActionListener {
	private VentanaNotas ventanaNotas;
	private DbCon db;
	private Menu menuPrincipal;
	private int id_estudiante, id_seccion;
	private Estudiante estudiante;
	private double promedio;
	private Double[] notas;
	
	public ControladorVentanaNotas() {
		ventanaNotas = new VentanaNotas();
		ventanaNotas.setVisible(true);
		ventanaNotas.agregarListener(this);
		db = new DbCon();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Menu Principal")) {
			//para el boton menu principal
			ventanaNotas.setVisible(false);
			menuPrincipal.setVisible(true);
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Cedula")) {
			//para el boton buscar cedula estudiante
			if (ventanaNotas.getTextCedula().getText().isBlank()) {
				JOptionPane.showMessageDialog(ventanaNotas, "Por favor ingrese la cédula del estudiante");
			}
			else if (encontroEstudiante()) {
				String[] nombreApellido = estudiante.getNombreCompleto().split("\\s+");
				ventanaNotas.getTextNombre().setText(nombreApellido[0]);
				ventanaNotas.getTextApellido().setText(nombreApellido[1]);
			}
			else {
				JOptionPane.showMessageDialog(ventanaNotas, "Estudiante no forma parte de la sección");
				limpiar();
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Calcular")) {
			//para el boton calcular
			if (ventanaNotas.getTextNota1().getText().matches("[0-9.]+") && ventanaNotas.getTextNota2().getText().matches("[0-9.]+") && ventanaNotas.getTextNota3().getText().matches("[0-9.]+")) {
				double nota1 = Double.parseDouble(ventanaNotas.getTextNota1().getText());
				double nota2 = Double.parseDouble(ventanaNotas.getTextNota2().getText());
				double nota3 = Double.parseDouble(ventanaNotas.getTextNota3().getText());
				notas = new Double[] {nota1,nota2,nota3};
				promedio = (nota1 + nota2 + nota3) / 3;
				ventanaNotas.getTextPromedio().setText(DecimalFormat.getNumberInstance().format(promedio));
			}
			else {
				JOptionPane.showMessageDialog(ventanaNotas, "Por favor rellene las notas (asi sea con 0)");
				limpiar();
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Guardar")) {
			//para el boton guardar
			if (estudiante == null || notas == null) {
				JOptionPane.showMessageDialog(ventanaNotas, "Por favor ingrese el estudiante, las notas y el promedio");
			}
			else {
				insertarNotas();
				JOptionPane.showMessageDialog(ventanaNotas, "Se han insertado las notas");
				limpiar();
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Limpiar")) {
			//para el boton limpiar
			limpiar();
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Modificar")) {
			//para el boton modificar
			if (estudiante == null || notas == null) {
				JOptionPane.showMessageDialog(ventanaNotas, "Por favor ingrese el estudiante, las notas y el promedio");
			}
			else {
				modificarNotas();
				JOptionPane.showMessageDialog(ventanaNotas, "Se han modificado las notas");
				limpiar();
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
			if (estudiante == null) {
				JOptionPane.showMessageDialog(ventanaNotas, "Por favor ingrese el estudiante");
			}
			else {
				int resultado = JOptionPane.showConfirmDialog(ventanaNotas, "Esta seguro que quiere eliminar la nota? Esta acción no se podra deshacer","",JOptionPane.YES_NO_OPTION);
				if (resultado == JOptionPane.YES_OPTION) {
					eliminarNotas();
					JOptionPane.showMessageDialog(ventanaNotas, "Se ha eliminado la nota");
					estudiante = null;
					limpiar();
				}
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Ver Notas")) {
			if (estudiante == null) {
				JOptionPane.showMessageDialog(ventanaNotas, "Por favor ingrese el estudiante");
			}
			else if (consultarNotas()) {
				ventanaNotas.getTextPromedio().setText(DecimalFormat.getNumberInstance().format(promedio));
				ventanaNotas.getTextNota1().setText(DecimalFormat.getNumberInstance().format(notas[0]));
				ventanaNotas.getTextNota2().setText(DecimalFormat.getNumberInstance().format(notas[1]));
				ventanaNotas.getTextNota3().setText(DecimalFormat.getNumberInstance().format(notas[2]));
			}
			else {
				JOptionPane.showMessageDialog(ventanaNotas, "El estudiante no posee notas");
			}
		}
	}

	public void setMenuPrincipal(Menu menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}
	
	private boolean encontroEstudiante() {
		boolean encontro = false;
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		try{
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT nombre_estudiante, cedula_estudiante, tlf_estudiante, fecha_nacimiento, genero_estudiante, id_estudiante FROM public.\"EstudiantePorSeccion\" INNER JOIN \"Estudiante\" ON \"EstudiantePorSeccion\".estudiante = \"Estudiante\".id_estudiante WHERE cedula_estudiante=? AND seccion=?;");	
			pS.setString(1, ventanaNotas.getTextCedula().getText());
			pS.setInt(2, id_seccion);
			//se ejecuta el sql y se guarda el resultado
			result = pS.executeQuery();
			if(result.isBeforeFirst()){
				encontro = true;
			}
			while(result.next()) {
				estudiante = new Estudiante(result.getString(1),result.getString(2),result.getString(3),result.getDate(4).toLocalDate(),result.getString(5).charAt(0),null);
				id_estudiante = result.getInt(6);
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
		return encontro;
	}

	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}
	
	private void insertarNotas() {
		Connection con = null;
		PreparedStatement pS = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql y lo ejecuta
			pS = con.prepareStatement("INSERT INTO public.\"Calificacion\"(promedio, nota, estudiante, seccion) VALUES (?, ?, ?, ?);");
			pS.setDouble(1, promedio);
			pS.setArray(2, con.createArrayOf("DOUBLE", notas));
			pS.setInt(3, id_estudiante);
			pS.setInt(4, id_seccion);
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
	
	private void modificarNotas() {
		if(id_estudiante == 0 || id_seccion == 0) {
			return;
		}
		Connection con = null;
		PreparedStatement pS = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql y lo ejecuta
			pS = con.prepareStatement("UPDATE public.\"Calificacion\" SET promedio=?, nota=? WHERE estudiante=? AND seccion=?;");
			pS.setDouble(1, promedio);
			pS.setArray(2, con.createArrayOf("DOUBLE", notas));
			pS.setInt(3, id_estudiante);
			pS.setInt(4, id_seccion);
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
	
	private void eliminarNotas() {
		if(id_estudiante == 0 || id_seccion == 0) {
			return;
		}
		Connection con = null;
		PreparedStatement pS = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql y lo ejecuta
			pS = con.prepareStatement("DELETE FROM public.\"Calificacion\" WHERE estudiante=? AND seccion=?;");
			pS.setInt(1, id_estudiante);
			pS.setInt(2, id_seccion);
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
	
	private boolean consultarNotas() {
		boolean encontro = false;
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		try{
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT promedio, nota FROM public.\"Calificacion\" WHERE estudiante=? AND seccion=?;");	
			pS.setInt(1, id_estudiante);
			pS.setInt(2, id_seccion);
			//se ejecuta el sql y se guarda el resultado
			result = pS.executeQuery();
			if(result.isBeforeFirst()){
				encontro = true;
			}
			while(result.next()) {
				promedio = result.getDouble(1);
				Array notasEncontradas = result.getArray(2);
				notas = (Double[])notasEncontradas.getArray();
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
		return encontro;
	}
	
	private void limpiar() {
		ventanaNotas.getTextNombre().setText("");
		ventanaNotas.getTextCedula().setText("");
		ventanaNotas.getTextApellido().setText("");
		ventanaNotas.getTextNota1().setText("");
		ventanaNotas.getTextNota2().setText("");
		ventanaNotas.getTextNota3().setText("");
		ventanaNotas.getTextPromedio().setText("");
		notas = null;
		promedio = 0;
	}
}
