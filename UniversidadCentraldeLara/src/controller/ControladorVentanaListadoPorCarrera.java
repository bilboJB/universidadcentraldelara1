/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
Nairym González 28.206.840
Alexis Acuña 26.305.133
*/
package controller;

import view.VentanaListadoPorCarrera;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.table.DefaultTableModel;


public class ControladorVentanaListadoPorCarrera implements ActionListener{
	private VentanaListadoPorCarrera ventanaListadoPorCarrera;
	private DbCon db;
	
	public ControladorVentanaListadoPorCarrera() {
		db = new DbCon();
		ventanaListadoPorCarrera = new VentanaListadoPorCarrera();
		ventanaListadoPorCarrera.setVisible(true);
		ventanaListadoPorCarrera.agregarListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equalsIgnoreCase("Generar Listado")) {
			//refresca el modelo al default
			ventanaListadoPorCarrera.setModelo(new DefaultTableModel(new Object[][] {}, ventanaListadoPorCarrera.getColumnas()) {
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			//intentar conectar a la base de datos
			Connection con = null;
			PreparedStatement pS = null;
			ResultSet result = null;
			try{
				con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
				//crea el statement sql
				pS = con.prepareStatement("SELECT nombre_estudiante, nombre_carrera FROM \"Estudiante\" INNER JOIN \"Carrera\" ON \"Estudiante\".carrera = \"Carrera\".id_carrera WHERE nombre_carrera = ?;");
				pS.setString(1, ventanaListadoPorCarrera.getTxtCarrera().getText());
				//se ejecuta el query y se guarda el resultado
				result = pS.executeQuery();
				while(result.next()) {
					//mientras haya una fila en el resultado se adjunta a la tabla
					ventanaListadoPorCarrera.getModelo().addRow(new Object[] {result.getString(1), result.getString(2)});
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
			ventanaListadoPorCarrera.getTable().setModel(ventanaListadoPorCarrera.getModelo());
		}
	}

}
