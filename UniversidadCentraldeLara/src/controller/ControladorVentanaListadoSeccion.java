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
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Profesor;
import view.VentanaListadoSeccion;
import view.Menu;
import view.VentanaInscripcion;

public class ControladorVentanaListadoSeccion implements ActionListener {
	private DbCon db;
	private VentanaListadoSeccion listadoSeccion;
	private String decanato, carrera, asignatura, docente;
	private int numeroSeccion, idSeccion, aprobados, reprobados;
	private Menu menu;
	private ArrayList<String> encimaPromedio, debajoPromedio;
	
	public ControladorVentanaListadoSeccion() {
		db = new DbCon();
		listadoSeccion = new VentanaListadoSeccion();
		listadoSeccion.setVisible(true);
		listadoSeccion.agregarListener(this);
		encimaPromedio = new ArrayList<String>();
		debajoPromedio = new ArrayList<String>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Menu Principal")) {
			listadoSeccion.setVisible(false);
			menu.setVisible(true);
		}
		
		
		if (e.getActionCommand().equalsIgnoreCase("Generar Listado")) {
			//para el boton general listado
			listadoSeccion.setModelo(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Decanato", "Carrera", "Asignatura", "Docente", "Seccion", "#Aprobados", "#Aplazados", "Encima promedio", "Debajo promedio"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				poblarTabla();
		}
	}
	
	public void poblarTabla() {
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		String cedulasEncima = "";
		String cedulasDebajo = "";
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT nombre_decanato, nombre_carrera, nombre_asignatura, nombre_profesor, numero_seccion, id_seccion FROM \"Seccion\" INNER JOIN \"Asignatura\" ON \"Seccion\".asignatura = \"Asignatura\".id_asignatura INNER JOIN \"Profesor\" ON \"Seccion\".profesor = \"Profesor\".id_profesor INNER JOIN \"Carrera\" ON \"Carrera\".id_carrera = \"Asignatura\".carrera INNER JOIN \"Decanato\" ON \"Decanato\".id_decanato = \"Carrera\".decanato;");	
			//se ejecuta el query y se guarda el resultado
			result = pS.executeQuery();
			if(!result.isBeforeFirst()) {
				return;
			}
			while(result.next()) {
				//se agregan los resultados a la tabla
				decanato = result.getString(1);
				carrera = result.getString(2);
				asignatura = result.getString(3);
				docente = result.getString(4);
				numeroSeccion = result.getInt(5);
				idSeccion = result.getInt(6);
				datosSeccion(idSeccion);
				for (String ced : encimaPromedio) {
					cedulasEncima = cedulasEncima.concat(ced + " ");
				}
				for (String ced : debajoPromedio) {
					cedulasDebajo = cedulasDebajo.concat(ced + " ");
				}
				listadoSeccion.getModelo().addRow(new Object[] {decanato, carrera, asignatura, docente, numeroSeccion, aprobados, reprobados, cedulasEncima, cedulasDebajo});
				encimaPromedio.clear();
				debajoPromedio.clear();
				cedulasEncima = "";
				cedulasDebajo = "";
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
		listadoSeccion.getTable().setModel(listadoSeccion.getModelo());
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	private void datosSeccion(int id) {
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea y ejecuta cada statement sql
			pS = con.prepareStatement("SELECT COUNT(promedio) FROM public.\"Calificacion\" WHERE promedio>=10 AND seccion=?;");
			pS.setInt(1, id);
			result = pS.executeQuery();
			while (result.next()) {
				aprobados = result.getInt(1);
			}
			result.close();
			pS.close();
			
			pS = con.prepareStatement("SELECT COUNT(promedio) FROM public.\"Calificacion\" WHERE promedio<10 AND seccion=?;");
			pS.setInt(1, id);
			result = pS.executeQuery();
			while (result.next()) {
				reprobados = result.getInt(1);
			}
			result.close();
			pS.close();
			
			pS = con.prepareStatement("SELECT cedula_estudiante FROM public.\"Calificacion\" INNER JOIN \"Estudiante\" ON \"Estudiante\".id_estudiante = \"Calificacion\".estudiante WHERE promedio>=(SELECT AVG(promedio) FROM public.\"Calificacion\") AND seccion=?;");
			pS.setInt(1, id);
			result = pS.executeQuery();
			while (result.next()) {
				String cedula = result.getString(1);
				encimaPromedio.add(cedula);
			}
			result.close();
			pS.close();
			
			pS = con.prepareStatement("SELECT cedula_estudiante FROM public.\"Calificacion\" INNER JOIN \"Estudiante\" ON \"Estudiante\".id_estudiante = \"Calificacion\".estudiante WHERE promedio<(SELECT AVG(promedio) FROM public.\"Calificacion\") AND seccion=?;");
			pS.setInt(1, id);
			result = pS.executeQuery();
			while (result.next()) {
				String cedula = result.getString(1);
				debajoPromedio.add(cedula);
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
	}
}
