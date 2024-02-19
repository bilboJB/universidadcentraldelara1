package controller;

import view.VentanaListadoPorCarrera;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorVentanaListadoPorCarrera implements ActionListener{
	private VentanaListadoPorCarrera ventanaListadoPorCarrera;
	
	public ControladorVentanaListadoPorCarrera() {
		ventanaListadoPorCarrera = new VentanaListadoPorCarrera();
		ventanaListadoPorCarrera.setVisible(true);
		ventanaListadoPorCarrera.agregarListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Generar Listado")) {
			System.out.println(ventanaListadoPorCarrera.getTxtCarrera().getText());
			
		}
	}

}
