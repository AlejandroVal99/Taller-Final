package model;

import processing.core.PApplet;


public class Logic {
	PApplet app; 
	User usuario; 


	public Logic(PApplet app) {
		this.app= app; 
		
		
		
		
		
	}
	
	public void test1() {
		usuario = new User(app, "daniel", "hola123"); 
		usuario.pintar();
		System.out.println("fuck");
		
		
	}
	
	

}
