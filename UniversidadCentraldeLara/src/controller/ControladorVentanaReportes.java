package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Menu;
import view.VentanaReportes;

public class ControladorVentanaReportes implements ActionListener {
	private VentanaReportes ventanaReportes;
	private Menu menuPrincipal;
	private ControladorVentanaListadoSeccion cListadoSeccion;
	private ControladorVentanaListadoPorCarrera cListadoPorCarrera;
	
	public ControladorVentanaReportes() {
		ventanaReportes = new VentanaReportes();
		ventanaReportes.setVisible(true);
		ventanaReportes.agregarListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Menu Principal")) {
			//para el boton menu principal
			ventanaReportes.setVisible(false);
			menuPrincipal.setVisible(true);
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Listado por Sección")) {
			//para el boton listado por seccion
			cListadoSeccion = new ControladorVentanaListadoSeccion();
			cListadoSeccion.setMenu(menuPrincipal);
			ventanaReportes.setVisible(false);
		}
		
		if (e.getActionCommand().equalsIgnoreCase("Listado de Estudiante por Carrera")) {
			//para el boton listado de estudiantes por carrera
			cListadoPorCarrera = new ControladorVentanaListadoPorCarrera();
		}
	}

	public void setMenuPrincipal(Menu menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}
	
}
