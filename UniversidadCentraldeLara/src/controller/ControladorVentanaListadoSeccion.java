/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Alexis Acuña 26.305.133
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
import javax.swing.table.DefaultTableModel;

import view.VentanaListadoSeccion;
import view.Menu;
import view.VentanaInscripcion;

public class ControladorVentanaListadoSeccion implements ActionListener {
	private DbCon db;
	private VentanaListadoSeccion listadoSeccion;
	private String seccion;
	private Menu menu;
	
	public ControladorVentanaListadoSeccion() {
		db = new DbCon();
		listadoSeccion = new VentanaListadoSeccion();
		listadoSeccion.setVisible(true);
		listadoSeccion.agregarListener(this);
		seccion = "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Menu Principal")) {
			listadoSeccion.setVisible(false);
			menu.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("")) {
			//para el boton buscar seccion
			if(buscarSeccion()) {
				JOptionPane.showMessageDialog(listadoSeccion, "Se ha encontrado la sección");
			}
			else {
				JOptionPane.showMessageDialog(listadoSeccion, "No se ha encontrado la sección");
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Generar Listado")) {
			//para el boton general listado
			if (seccion != "" || buscarSeccion()) {
				listadoSeccion.setModelo(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Decanato", "Carrera", "Asignatura", "Docente", "Seccion"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
				poblarTabla();
			}
		}
	}
	
	public boolean buscarSeccion() {
		boolean encontro = false;
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT id_seccion FROM public.\"Seccion\" WHERE id_seccion = ?;");
			pS.setString(1, "");
			//se ejecuta el sql y se guarda el resultado
			result = pS.executeQuery();
			if(result.isBeforeFirst()) {
				encontro = true;
			}
			while(result.next()) {
				seccion = result.getString(1);
			}
		} catch (SQLException ex) {
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
	public void poblarTabla() {
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT nombre_decanato, nombre_carrera, nombre_asignatura, nombre_profesor, id_seccion FROM \"Seccion\" INNER JOIN \"Asignatura\" ON \"Seccion\".asignatura = \"Asignatura\".id_asignatura INNER JOIN \"Profesor\" ON \"Seccion\".profesor = \"Profesor\".id_profesor INNER JOIN \"Carrera\" ON \"Carrera\".id_carrera = \"Asignatura\".carrera INNER JOIN \"Decanato\" ON \"Decanato\".id_decanato = \"Carrera\".decanato WHERE id_seccion = ?;");	
			pS.setString(1, seccion);
			//se ejecuta el query y se guarda el resultado
			result = pS.executeQuery();
			if(!result.isBeforeFirst()) {
				return;
			}
			while(result.next()) {
				//se agregan los resultados a la tabla
				listadoSeccion.getModelo().addRow(new Object[] {result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)});
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
}
