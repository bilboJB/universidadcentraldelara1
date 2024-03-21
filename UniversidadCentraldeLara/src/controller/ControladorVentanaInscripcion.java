/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
*/
package controller;

import view.VentanaInscripcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;

public class ControladorVentanaInscripcion implements ActionListener{
	private VentanaInscripcion ventanaInscripcion;
	private DbCon db;
	private Inscripcion inscripcion;
	private PeriodoAcademico periodo;
	private Estudiante estudiante;
	private int codigoCarrera, codigoEstudiante;
	private Carrera carrera;
	private ArrayList<Seccion> secciones;
	private ArrayList<String> asignaturas;
	
	public ControladorVentanaInscripcion() {
		db = new DbCon();
		ventanaInscripcion = new VentanaInscripcion();
		ventanaInscripcion.setVisible(true);
		ventanaInscripcion.agregarListener(this);
		obtenerPeriodo();
		secciones = new ArrayList<Seccion>();
		asignaturas = new ArrayList<String>();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Guardar")) {
			//para el boton guardar
			int rows = ventanaInscripcion.getTablaInscrpcion().getRowCount();
			for (int i = 0; i < rows; i++) {
				if ((Boolean)(ventanaInscripcion.getModeloTabla().getValueAt(i, 0)) == true) {
					asignaturas.add(ventanaInscripcion.getModeloTabla().getValueAt(i, 1).toString());
					secciones.add(new Seccion(null, new Estudiante[] {estudiante}, (int)ventanaInscripcion.getModeloTabla().getValueAt(i, 2), periodo));
				}
			}
			//revisando si hay duplicados entre las asignaturas
			if (distintasAsignaturas(asignaturas)) {
				inscripcion = new Inscripcion(carrera, estudiante, periodo, secciones.toArray(new Seccion[0]));
				inscribirEstudiante();
				JOptionPane.showMessageDialog(ventanaInscripcion, "Inscripción realizada con exito!");
				limpiar();
			}
			else {
				JOptionPane.showMessageDialog(ventanaInscripcion, "Por favor escoja una sección por asignatura");
			}
			asignaturas.clear();
			secciones.clear();
		}
		
		if(e.getActionCommand().equalsIgnoreCase("")) {
			//para el boton buscar cedula
			obtenerDatosEstudiante();
			obtenerCarrera();
			ventanaInscripcion.setModeloTabla(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"", "Asignaturas", "Secci\u00F3n"
				}
			) {
				/**
				 * 
				 */
				Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			poblarTablaConAsignaturas();
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
			pS = con.prepareStatement("SELECT nombre_estudiante, cedula_estudiante, tlf_estudiante, fecha_nacimiento, genero_estudiante, carrera, id_estudiante FROM public.\"Estudiante\" WHERE cedula_estudiante = ?;");	
			pS.setString(1, ventanaInscripcion.getTextCedula().getText());
			//se ejecuta el sql y se guarda el resultado
			result = pS.executeQuery();
			if(!result.isBeforeFirst()){
				//si no encuentra ningun estudiante
				estudiante = null;
				codigoCarrera = 0;
				codigoEstudiante = 0;
				JOptionPane.showMessageDialog(ventanaInscripcion, "Estudiante no encontrado");
				limpiar();
				return;
			}
			while(result.next()) {
				estudiante = new Estudiante(result.getString(1),result.getString(2),result.getString(3),result.getDate(4).toLocalDate(),result.getString(5).charAt(0),null);
				codigoCarrera = result.getInt(6);
				codigoEstudiante = result.getInt(7);
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
			pS.setInt(1, codigoCarrera);
			//se ejecuta el sql y se guarda el resultado
			result = pS.executeQuery();
			if(!result.isBeforeFirst()) {
				return;
			}
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
	private void poblarTablaConAsignaturas() {
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		try{
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT nombre_asignatura, numero_seccion FROM \"Seccion\" INNER JOIN \"Asignatura\" ON \"Seccion\".asignatura = \"Asignatura\".id_asignatura WHERE carrera = ?;");	
			pS.setInt(1, codigoCarrera);
			//se ejecuta el query y se guarda el resultado
			result = pS.executeQuery();
			if(!result.isBeforeFirst()) {
				return;
			}
			while(result.next()) {
				//se agregan los resultados a la tabla
				ventanaInscripcion.getModeloTabla().addRow(new Object[] {false, result.getString(1), result.getInt(2)});
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
		ventanaInscripcion.getTablaInscrpcion().setModel(ventanaInscripcion.getModeloTabla());
	}
	private boolean distintasAsignaturas(ArrayList<String> lista) {
		if (lista.isEmpty()) {
			return false;
		}
		return lista.stream().distinct().count() == lista.size();
	}
	private void inscribirEstudiante() {
		Connection con = null;
		PreparedStatement pS = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("INSERT INTO public.\"EstudiantePorSeccion\" (estudiante, seccion) VALUES (?, ?);");
			for (Seccion seccion : inscripcion.getSecciones()) {
				//inserta en estudiantes por seccion
				pS.setInt(1, codigoEstudiante);
				pS.setInt(2, seccion.getCodigoSeccion());
				pS.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			//cierra todo
			try { if (pS != null) pS.close(); } catch (Exception ex) {};
		    try { if (con != null) con.close(); } catch (Exception ex) {};
		}
	}
	private void limpiar() {
		ventanaInscripcion.setModeloTabla(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"", "Asignaturas", "Secci\u00F3n"
				}
			) {
				/**
				 * 
				 */
				Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		ventanaInscripcion.getTextNombre().setText("");
		ventanaInscripcion.getTextApellido().setText("");
		ventanaInscripcion.getTextCarrera().setText("");
		ventanaInscripcion.getTextCedula().setText("");
		ventanaInscripcion.getTablaInscrpcion().setModel(ventanaInscripcion.getModeloTabla());
	}
}
