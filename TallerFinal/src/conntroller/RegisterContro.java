package conntroller;

import java.util.LinkedList;

import model.Logic;
import model.User;
import processing.core.PApplet;

public class RegisterContro {
	
	Logic logic;
	PApplet app; 

	public RegisterContro( PApplet app) {
		this.app= app; 
		logic = new Logic(app); 
		
	}

	public void registrarmetodo(String name, String contrasena) {
		logic.registrarmetodo(name,  contrasena);
		
	}
	
	
	//---------
	public LinkedList<User> getUsuariosList() {
		return logic.getUsuariosList();
	}

	public void setUsuariosList(LinkedList<User> usuariosList) {
		logic.setUsuariosList(usuariosList);
	}
	
	public boolean areaSensible (int x, int y, int tamx, int tamy) {
		return logic.areaSensible(x, y, tamx, tamy);
	}
	
	
	

}
