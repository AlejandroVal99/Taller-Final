package model;

import processing.core.PApplet;


public class Logic {
	PApplet app; 
	User usuario; 


	public Logic(PApplet app) {
		this.app= app; 
		
		
		
		
		
	}
	
	public void creo() {
		usuario = new User(app, "daniel", "hola123"); 
	}
	
	
	public void test1() {
		usuario.pintar();
		
	}
	

	public void moverPersonaje(char k) {
		usuario.moverse(k);
		
		
	}
	
	

}
