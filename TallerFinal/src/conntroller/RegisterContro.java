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
	
	public void test() {
		logic.test1();
		
	}
	
	
	
	public void creo() {
		logic.creo();
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

}
