package view;

import conntroller.RegisterContro;
import processing.core.PApplet;

public class MainView extends PApplet{
	
	RegisterContro register; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.MainView");

	}
	
	public void settings() {
		size(400,400); 
		
	}
	public void setup() {
		register = new RegisterContro(this); 
		register.test();
		
	}
	public void draw() {
		
		background(0, 20, 0); 

		
	}

}
