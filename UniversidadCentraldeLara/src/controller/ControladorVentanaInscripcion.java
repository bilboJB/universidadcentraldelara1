package controller;

import view.VentanaInscripcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import model.*;

public class ControladorVentanaInscripcion implements ActionListener{
	private VentanaInscripcion ventanaInscripcion;
	private DbCon db;
	private Inscripcion inscripcion;
	private PeriodoAcademico periodo;
	private Estudiante estudiante;
	private String codigoCarrera;
	private Carrera carrera;
	
	public ControladorVentanaInscripcion() {
		db = new DbCon();
		ventanaInscripcion = new VentanaInscripcion();
		ventanaInscripcion.setVisible(true);
		ventanaInscripcion.agregarListener(this);
		obtenerPeriodo();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Guardar")) {
			//para el boton guardar
			
		}
		if(e.getActionCommand().equalsIgnoreCase("")) {
			//para el boton buscar cedula
			obtenerDatosEstudiante();
			obtenerCarrera();
		}
	}
	private void obtenerPeriodo() {
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		try{
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT * FROM public.\"PeriodoAcademico\" WHERE fecha_inicio='2024-05-20';");	
			//se ejecuta el sql y se guarda el resultado
			result = pS.executeQuery();
			while(result.next()) {
				periodo = new PeriodoAcademico(result.getString(1),result.getDate(2).toLocalDate(),result.getDate(3).toLocalDate());
			}
			ventanaInscripcion.getTextPeriodoAcad().setText(periodo.getCodigoPeriodo());
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
	}
	private void obtenerDatosEstudiante() {
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		try{
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT nombre_estudiante, cedula_estudiante, tlf_estudiante, fecha_nacimiento, genero_estudiante, carrera FROM public.\"Estudiante\" WHERE cedula_estudiante = ?;");	
			pS.setString(1, ventanaInscripcion.getTextCedula().getText());
			//se ejecuta el sql y se guarda el resultado
			result = pS.executeQuery();
			while(result.next()) {
				estudiante = new Estudiante(result.getString(1),result.getString(2),result.getString(3),result.getDate(4).toLocalDate(),result.getString(5).charAt(0),null);
				codigoCarrera = result.getString(6);
			}
			String[] nombreApellido = estudiante.getNombreCompleto().split("\\s+");
			ventanaInscripcion.getTextNombre().setText(nombreApellido[0]);
			ventanaInscripcion.getTextApellido().setText(nombreApellido[1]);
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
	}
	private void obtenerCarrera() {
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		try{
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT nombre_carrera FROM public.\"Carrera\" WHERE id_carrera = ?;");	
			pS.setString(1, codigoCarrera);
			//se ejecuta el sql y se guarda el resultado
			result = pS.executeQuery();
			while(result.next()) {
				carrera = new Carrera(null,result.getString(1));
			}
			ventanaInscripcion.getTextCarrera().setText(carrera.getNombreCarrera());
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
	}
}
