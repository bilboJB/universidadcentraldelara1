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

import javax.swing.table.DefaultTableModel;

import view.Menu;
import view.VentanaListadoPorGenero;

public class ControladorVentanaPorGenero implements ActionListener {
	private VentanaListadoPorGenero ventanaListadoPorGenero;
	private DbCon db;
	private Menu menuPrincipal;
	
	public ControladorVentanaPorGenero() {
		ventanaListadoPorGenero = new VentanaListadoPorGenero();
		ventanaListadoPorGenero.setVisible(true);
		ventanaListadoPorGenero.agregarListener(this);
		db = new DbCon();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Menu Principal")) {
			ventanaListadoPorGenero.setVisible(false);
			menuPrincipal.setVisible(true);
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Generar Listado")) {
			ventanaListadoPorGenero.setModelo(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "Genero", "Carrera", "Decanato"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
			poblarTabla();
		}
	}
	
	public void setMenuPrincipal(Menu menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}
	
	private void poblarTabla() {
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT nombre_estudiante, genero_estudiante, nombre_carrera, nombre_decanato FROM public.\"Estudiante\" INNER JOIN \"Carrera\" ON \"Estudiante\".carrera = \"Carrera\".id_carrera INNER JOIN \"Decanato\" ON \"Carrera\".decanato = \"Decanato\".id_decanato ORDER BY genero_estudiante;");	
			//se ejecuta el query y se guarda el resultado
			result = pS.executeQuery();
			if(!result.isBeforeFirst()) {
				return;
			}
			while (result.next()) {
				ventanaListadoPorGenero.getModelo().addRow(new Object[] {result.getString(1), result.getString(2), result.getString(3), result.getString(4)});
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
		ventanaListadoPorGenero.getTable().setModel(ventanaListadoPorGenero.getModelo());
	}
}
