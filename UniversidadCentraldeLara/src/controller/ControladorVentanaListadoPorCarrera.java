package controller;

import view.VentanaListadoPorCarrera;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.table.DefaultTableModel;


public class ControladorVentanaListadoPorCarrera implements ActionListener{
	private VentanaListadoPorCarrera ventanaListadoPorCarrera;
	private final String url = "jdbc:postgresql://localhost/UniversidadCentraldeLara";
	private final String user = "postgres";
	private final String password = "1234";
	
	public ControladorVentanaListadoPorCarrera() {
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
			try(Connection con = DriverManager.getConnection(url,user,password);){
				//crea el statement sql
				PreparedStatement pS = con.prepareStatement("SELECT nombre_estudiante, nombre_carrera FROM \"Estudiante\" INNER JOIN \"Carrera\" ON \"Estudiante\".carrera = \"Carrera\".id_carrera WHERE nombre_carrera = ?;");
				pS.setString(1, ventanaListadoPorCarrera.getTxtCarrera().getText());
				//se ejecuta el sql y se guarda el resultado
				ResultSet result = pS.executeQuery();
				while(result.next()) {
					//mientras haya una fila en el resultado se adjunta a la tabla
					ventanaListadoPorCarrera.getModelo().addRow(new Object[] {result.getString(1), result.getString(2)});
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			ventanaListadoPorCarrera.getTable().setModel(ventanaListadoPorCarrera.getModelo());
		}
	}

}
