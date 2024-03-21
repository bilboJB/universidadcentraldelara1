/*
Javier Bravo 27.736.325
Dehucarlys Azuaje 25.149.300
Isivet Montero 28.020.215
*/
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.Menu;
import view.VentanaCarrera;

public class ControladorVentanaCarrera implements ActionListener {
	private VentanaCarrera ventanaCarrera;
	private DbCon db;
	private Menu menuPrincipal;
	private int decanato;
	private HashMap<Integer, String[]> carreras;
	private ArrayList<String[]> carrerasEliminar;
	
	public ControladorVentanaCarrera() {
		ventanaCarrera = new VentanaCarrera();
		ventanaCarrera.setVisible(true);
		ventanaCarrera.agregarLister(this);
		db = new DbCon();
		carreras = new HashMap<Integer, String[]>();
		carrerasEliminar = new ArrayList<String[]>();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Menu Principal")) {
			//para el boton menu principal
			ventanaCarrera.setVisible(false);
			menuPrincipal.setVisible(true);
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Buscar")) {
			if (ventanaCarrera.getTextDecanato().getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(ventanaCarrera, "Por favor coloque un decanato");
			}
			else if (buscarDecanato()) {
				JOptionPane.showMessageDialog(ventanaCarrera, "Se encontro el decanato");
			}
			else {
				JOptionPane.showMessageDialog(ventanaCarrera, "No se ha encontrado el decanato");
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Guardar")) {
			//para el boton guardar
			if (ventanaCarrera.getTextNombre().getText().equalsIgnoreCase("") || decanato == 0) {
				JOptionPane.showMessageDialog(ventanaCarrera, "Rellene los datos por favor");
			}
			else {
				insertarCarrera();
				JOptionPane.showMessageDialog(ventanaCarrera, "Se ha insertado la carrera");
				limpiar();
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Limpiar")) {
			limpiar();
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Ver Listado Carreras")) {
			//para el boton listado carreras
			ventanaCarrera.setModelo(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Seleccion", "Carrera", "Decanato"
				}
			) {
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
			poblarTablaCarrera();
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Modificar")) {
			//para el boton modificar
			int contador = 0;
			int rows = ventanaCarrera.getModelo().getRowCount();
			int coordenada = 0;
			for (int i=0; i<rows; i++) {
				if ((Boolean)ventanaCarrera.getModelo().getValueAt(i, 0) == true) {
					coordenada = i;
					contador++;
				}
			}
			if (contador == 0) {
				JOptionPane.showMessageDialog(ventanaCarrera, "Escoja una carrera para modificar");
			}
			else if (contador > 1) {
				JOptionPane.showMessageDialog(ventanaCarrera, "Escoja solo una carrera para modificar");
			}
			else {
				int id_carrera = 0;
				String[] carrera = new String[] {ventanaCarrera.getModelo().getValueAt(coordenada, 1).toString(), ventanaCarrera.getModelo().getValueAt(coordenada, 2).toString()};
				for (Entry<Integer, String[]> car : carreras.entrySet()) {
					if (car.getValue()[0].equalsIgnoreCase(carrera[0]) && car.getValue()[1].equalsIgnoreCase(carrera[1])) {
						id_carrera = car.getKey();
					}
				}
				if (ventanaCarrera.getTextNombre().getText().equalsIgnoreCase("") && decanato == 0) {
					JOptionPane.showMessageDialog(ventanaCarrera, "Escoja datos para modificar");
				}
				else {
					modificarCarrera(id_carrera);
					limpiar();
				}
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
			//para el oton eliminar
			int rows = ventanaCarrera.getModelo().getRowCount();
			for (int i=0; i <rows; i++) {
				if ((Boolean)ventanaCarrera.getModelo().getValueAt(i, 0) == true) {
					carrerasEliminar.add(new String[] {ventanaCarrera.getModelo().getValueAt(i, 1).toString(), ventanaCarrera.getModelo().getValueAt(i, 2).toString()});
				}
			}
			if (carreras.isEmpty() || carrerasEliminar.isEmpty()) {
				JOptionPane.showMessageDialog(ventanaCarrera, "Por favor escoja carreras para eliminar");
				return;
			}
			int respuesta = JOptionPane.showConfirmDialog(ventanaCarrera, "Esta seguro que quiere eliminar, no se podra deshacer esta accion", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				int id_carrera = 0;
				for (Entry<Integer,String[]> car : carreras.entrySet()) {
					for(String[] carElim : carrerasEliminar) {
						if (car.getValue()[0].equalsIgnoreCase(carElim[0]) && car.getValue()[1].equalsIgnoreCase(carElim[1])) {
							id_carrera = car.getKey();
							eliminarCarrera(id_carrera);
							break;
						}
					}
				}
				JOptionPane.showMessageDialog(ventanaCarrera, "Se ha eliminado la carrera");
				limpiar();
			}
		}
	}
	
	private boolean buscarDecanato() {
		boolean encontro = false;
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT id_decanato FROM public.\"Decanato\" WHERE nombre_decanato=?;");	
			pS.setString(1, ventanaCarrera.getTextDecanato().getText());
			result = pS.executeQuery();
			if (result.isBeforeFirst()) {
				encontro = true;
			}
			while (result.next()) {
				decanato = result.getInt(1);
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
	
	private void insertarCarrera() {
		Connection con = null;
		PreparedStatement pS = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("INSERT INTO public.\"Carrera\"(nombre_carrera, decanato) VALUES (?, ?);");
			pS.setString(1, ventanaCarrera.getTextNombre().getText());
			pS.setInt(2, decanato);
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
	
	private void poblarTablaCarrera() {
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		carreras.clear();
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT nombre_carrera, nombre_decanato, id_carrera FROM public.\"Carrera\" INNER JOIN \"Decanato\" ON \"Carrera\".decanato = \"Decanato\".id_decanato;");	
			//se ejecuta el query y se guarda el resultado
			result = pS.executeQuery();
			while(result.next()) {
				//se insertan los datos en la tabla y en el hashmap
				ventanaCarrera.getModelo().addRow(new Object[] {false, result.getString(1), result.getString(2)});
				carreras.put(result.getInt(3), new String[] {result.getString(1),result.getString(2)});
			}
		}
		catch (SQLException ex) {
			// TODO: handle exception
		}
		finally {
			try { if (result != null) result.close(); } catch (Exception ex) {};
		    try { if (pS != null) pS.close(); } catch (Exception ex) {};
		    try { if (con != null) con.close(); } catch (Exception ex) {};
		}
		ventanaCarrera.getTable().setModel(ventanaCarrera.getModelo());
	}
	
	private void modificarCarrera(int id) {
		if (id==0) {
			return;
		}
		Connection con = null;
		PreparedStatement pS = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql para cada caso y lo ejecuta
			if (decanato != 0) {
				pS = con.prepareStatement("UPDATE public.\"Carrera\" SET decanato=? WHERE id_carrera=?;");
				pS.setInt(1, decanato);
				pS.setInt(2, id);
				pS.executeUpdate();
				pS.close();
			}
			if (!ventanaCarrera.getTextNombre().getText().equalsIgnoreCase("")) {
				pS = con.prepareStatement("UPDATE public.\"Carrera\" SET nombre_carrera=? WHERE id_carrera=?;");
				pS.setString(1, ventanaCarrera.getTextNombre().getText());
				pS.setInt(2, id);
			}
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
	
	private void eliminarCarrera(int id) {
		if (id == 0) {
			return;
		}
		Connection con = null;
		PreparedStatement pS = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql y lo ejecuta
			pS = con.prepareStatement("DELETE FROM public.\"Carrera\" WHERE id_carrera=?;");
			pS.setInt(1, id);
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
	
	private void limpiar() {
		ventanaCarrera.getTextDecanato().setText("");
		ventanaCarrera.getTextNombre().setText("");
		carreras.clear();
		carrerasEliminar.clear();
		decanato = 0;
		ventanaCarrera.setModelo(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Seleccion", "Carrera", "Decanato"
				}
			) {
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
		ventanaCarrera.getTable().setModel(ventanaCarrera.getModelo());
	}
	
	public void setMenuPrincipal(Menu menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}
	
}
