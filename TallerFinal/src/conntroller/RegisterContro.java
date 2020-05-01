package conntroller;

import model.Logic;
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
	
	public void moverPersonaje(char k) {
		logic.moverPersonaje(k);
		
	}
	
	public void creo() {
		logic.creo();
	}

}
