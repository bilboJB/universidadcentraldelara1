package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Menu;

public class ControladorVentanaMenu implements ActionListener{
	private Menu menu;
	private ControladorVentanaDecanato cVentanaDecanato;
	private ControladorVentanaEstudiante cVentanaEstudiante;
	private ControladorVentanaProfesor cVentanaProfesor;
	private ControladorVentanaCarrera cVentanaCarrera;
	private ControladorVentanaAsignatura cVentanaAsignatura;
	private ControladorVentanaSeccion cVentanaSeccion;
	private ControladorVentanaNotas cVentanaNotas;
	private ControladorVentanaReportes cVentanaReportes;
	
	public ControladorVentanaMenu() {
		menu = new Menu();
		menu.setVisible(true);
		menu.agregarListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Decanato")) {
			//para el boton decanato
			cVentanaDecanato = new ControladorVentanaDecanato();
			cVentanaDecanato.setMenuPrincipal(menu);
			menu.setVisible(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Estudiante")) {
			//para el boton estudiante
			cVentanaEstudiante = new ControladorVentanaEstudiante();
			menu.setVisible(false);
		}

		if(e.getActionCommand().equalsIgnoreCase("Profesor")) {
			//para el boton profesor
			cVentanaProfesor = new ControladorVentanaProfesor();
			menu.setVisible(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Carrera")) {
			//para el boton carrera
			cVentanaCarrera = new ControladorVentanaCarrera();
			menu.setVisible(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Asignatura")) {
			//para el boton asignatura
			cVentanaAsignatura = new ControladorVentanaAsignatura();
			menu.setVisible(false);
		}

		if(e.getActionCommand().equalsIgnoreCase("Sección")) {
			//para el boton seccion
			cVentanaSeccion = new ControladorVentanaSeccion();
			menu.setVisible(false);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Notas")) {
			//para el boton notas
			cVentanaNotas = new ControladorVentanaNotas();
			menu.setVisible(false);
		}

		if(e.getActionCommand().equalsIgnoreCase("Reportes")) {
			//para el boton reportes
			cVentanaReportes = new ControladorVentanaReportes();
			menu.setVisible(false);
		}
	}

}
