package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Menu;

public class ControladorVentanaMenu implements ActionListener{
	private Menu menu;
	
	public ControladorVentanaMenu() {
		menu = new Menu();
		menu.setVisible(true);
		menu.agregarListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
