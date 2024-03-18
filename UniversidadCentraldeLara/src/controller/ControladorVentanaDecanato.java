package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Decanato;
import view.Menu;
import view.VentanaDecanato;

public class ControladorVentanaDecanato implements ActionListener {
	private VentanaDecanato ventanaDecanato;
	private Menu menu;
	private DbCon db;
	private HashMap<Integer, Decanato> decanatos;
	private ArrayList<Decanato> decanatosEliminar;
	
	public ControladorVentanaDecanato() {
		ventanaDecanato = new VentanaDecanato();
		ventanaDecanato.setVisible(true);
		ventanaDecanato.agregarListener(this);
		menu = null;
		db = new DbCon();
		decanatos = new HashMap<Integer, Decanato>();
		decanatosEliminar = new ArrayList<Decanato>();
		limpiar();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Menu Principal")) {
			//para el boton menu principal
			ventanaDecanato.setVisible(false);
			menu.setVisible(true);
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Guardar")) {
			//para el boton guardar
			if (ventanaDecanato.getTextNombre().getText().equalsIgnoreCase("") || ventanaDecanato.getTextDireccion().getText().equalsIgnoreCase("") || ventanaDecanato.getTextTelefono().getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(ventanaDecanato, "Por favor rellene los datos");
			}
			else {
				insertarDecanato();
				JOptionPane.showMessageDialog(ventanaDecanato, "Decanato Guardado");
				limpiar();
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Limpiar")) {
			//para el boton limpiar
			limpiar();
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Ver Lista Decanato")) {
			//para el boton listado de decanatos
			ventanaDecanato.setModelo(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Seleccion", "Nombre", "Direccion", "Telefono"
				}
			) {
				Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			poblarTablaDecanatos();
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Modificar")) {
			//para el boton modificar
			int contador = 0;
			int rows = ventanaDecanato.getTable().getRowCount();
			int coordenada = 0;
			for(int i=0; i < rows; i++) {
				if((Boolean)(ventanaDecanato.getModelo().getValueAt(i, 0)) == true) {
					coordenada = i;
					contador++;
				}
			}
			if (contador == 0) {
				JOptionPane.showMessageDialog(ventanaDecanato, "Escoja un decanato para modificar");
			}
			else if (contador > 1) {
				JOptionPane.showMessageDialog(ventanaDecanato, "Escoja solo un decanato para modificar");
			}
			else {
				int id_decanato = 0;
				Decanato decanato = new Decanato(null, ventanaDecanato.getModelo().getValueAt(coordenada, 2).toString(), ventanaDecanato.getModelo().getValueAt(coordenada, 1).toString(), ventanaDecanato.getModelo().getValueAt(coordenada, 3).toString());
				for(Entry<Integer, Decanato> dec : decanatos.entrySet()) {
					if(dec.getValue().getNombreDecanato().equalsIgnoreCase(decanato.getNombreDecanato()) && dec.getValue().getDireccionDecanato().equalsIgnoreCase(decanato.getDireccionDecanato()) && dec.getValue().getTlfDecanato().equalsIgnoreCase(decanato.getTlfDecanato())) {
						id_decanato = dec.getKey();
					}
				}
				if(ventanaDecanato.getTextNombre().getText().equalsIgnoreCase("") && ventanaDecanato.getTextDireccion().getText().equalsIgnoreCase("") && ventanaDecanato.getTextTelefono().getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(ventanaDecanato, "Escoja datos para modificar");
				}
				else {
					modificarDecanato(id_decanato);
					JOptionPane.showMessageDialog(ventanaDecanato, "Decanato modificado");
					limpiar();
				}
			}
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Eliminar")) {
			//para el boton eliminar
			int rows = ventanaDecanato.getTable().getRowCount();
			for(int i=0; i < rows; i++) {
				if((Boolean)(ventanaDecanato.getModelo().getValueAt(i, 0)) == true) {
					decanatosEliminar.add(new Decanato(null, ventanaDecanato.getModelo().getValueAt(i, 2).toString(), ventanaDecanato.getModelo().getValueAt(i, 1).toString(), ventanaDecanato.getModelo().getValueAt(i, 3).toString()));
				}
			}
			if (decanatosEliminar.isEmpty() || decanatos.isEmpty()) {
				JOptionPane.showMessageDialog(ventanaDecanato, "Escoja decanatos a eliminar");
				return;
			}
			int respuesta = JOptionPane.showConfirmDialog(ventanaDecanato, "Esta seguro que quiere eliminar, no podra deshacer esta acción", "Confirmación eliminación" ,JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				int id_decanato = 0;
				for(Entry<Integer, Decanato> dec : decanatos.entrySet()) {
					for(Decanato decAElim : decanatosEliminar) {
						if (dec.getValue().getNombreDecanato().equalsIgnoreCase(decAElim.getNombreDecanato()) && dec.getValue().getDireccionDecanato().equalsIgnoreCase(decAElim.getDireccionDecanato()) && dec.getValue().getTlfDecanato().equalsIgnoreCase(decAElim.getTlfDecanato())) {
							id_decanato = dec.getKey();
							eliminarDecanato(id_decanato);
							break;
						}
					}
				}
				JOptionPane.showMessageDialog(ventanaDecanato, "Se ha eliminado el decanato");
				limpiar();
			}
		}
	}
	
	public void setMenuPrincipal(Menu menuPrincipal) {
		menu = menuPrincipal;
	}
	
	private void limpiar() {
		ventanaDecanato.getTextDireccion().setText("");
		ventanaDecanato.getTextNombre().setText("");
		ventanaDecanato.getTextTelefono().setText("");
		ventanaDecanato.setModelo(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Seleccion", "Nombre", "Direccion", "Telefono"
				}
			) {
				Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		ventanaDecanato.getTable().setModel(ventanaDecanato.getModelo());
		decanatos.clear();
		decanatosEliminar.clear();
	}
	
	private void insertarDecanato() {
		Connection con = null;
		PreparedStatement pS = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("INSERT INTO public.\"Decanato\" (nombre_decanato, direccion_decanato, tlf_decanato) VALUES (?, ?, ?);");
			pS.setString(1, ventanaDecanato.getTextNombre().getText());
			pS.setString(2, ventanaDecanato.getTextDireccion().getText());
			pS.setString(3, ventanaDecanato.getTextTelefono().getText());
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
	
	private void poblarTablaDecanatos() {
		Connection con = null;
		PreparedStatement pS = null;
		ResultSet result = null;
		decanatos.clear();
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql
			pS = con.prepareStatement("SELECT nombre_decanato, direccion_decanato, tlf_decanato, id_decanato FROM public.\"Decanato\";");	
			//se ejecuta el query y se guarda el resultado
			result = pS.executeQuery();
			while(result.next()) {
				//se insertan los datos en la tabla y en el hashmap
				ventanaDecanato.getModelo().addRow(new Object[] {false, result.getString(1), result.getString(2), result.getString(3)});
				decanatos.put(result.getInt(4), new Decanato(null, result.getString(2), result.getString(1), result.getString(3)));
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
		ventanaDecanato.getTable().setModel(ventanaDecanato.getModelo());
	}
	
	private void modificarDecanato(int id) {
		if (id == 0) {
			return;
		}
		Connection con = null;
		PreparedStatement pS = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql para cada caso y lo ejecuta
			if (!ventanaDecanato.getTextNombre().getText().equalsIgnoreCase("")) {
				pS = con.prepareStatement("UPDATE public.\"Decanato\" SET nombre_decanato=? WHERE id_decanato=?;");
				pS.setString(1, ventanaDecanato.getTextNombre().getText());
				pS.setInt(2, id);
				pS.executeUpdate();
				pS.close();
			}
			if (!ventanaDecanato.getTextDireccion().getText().equalsIgnoreCase("")) {
				pS = con.prepareStatement("UPDATE public.\"Decanato\" SET direccion_decanato=? WHERE id_decanato=?;");
				pS.setString(1, ventanaDecanato.getTextDireccion().getText());
				pS.setInt(2, id);
				pS.executeUpdate();
				pS.close();
			}
			if(!ventanaDecanato.getTextTelefono().getText().equalsIgnoreCase("")) {
				pS = con.prepareStatement("UPDATE public.\"Decanato\" SET tlf_decanato=? WHERE id_decanato=?;");
				pS.setString(1, ventanaDecanato.getTextTelefono().getText());
				pS.setInt(2, id);
				pS.executeUpdate();
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
	
	private void eliminarDecanato(int id) {
		if (id == 0) {
			return;
		}
		Connection con = null;
		PreparedStatement pS = null;
		try {
			con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPassword());
			//crea el statement sql y lo ejecuta
			pS = con.prepareStatement("DELETE FROM public.\"Decanato\" WHERE id_decanato=?;");
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
}
