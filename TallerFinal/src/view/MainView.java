package view;

import processing.core.PApplet;
import controlP5.*; 
import view.*; 

public class MainView extends PApplet{
	
	
	int screen ; 
	private ControlP5 cp5; 
	RegisterScreen regisScreen; 
	IntroScreen introScreen;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.MainView");

	}
	
	public void settings() {
		size(816, 480);
		  smooth(4);
		
	}
	public void setup() {
		cp5= new ControlP5(this); 
		regisScreen = new RegisterScreen(this); 
		introScreen = new IntroScreen(this);
		register.creo();
		regisScreen.creo();
		regisScreen.inputs("name",20);
		regisScreen.inputs("correo",20+20*3);
		
		//cargar imagenes de las clases
		introScreen.cargaImagenesIS();
		
	}
	public void draw() {
		
		switch (screen) {
		
		case 0:
			introScreen.drawIntro();
			background(0, 20, 0);
		
			break;
		case 1:
			background(255, 20, 0); 
			regisScreen.escondoInput(1,"name");
			regisScreen.escondoInput(1,"correo");
			break;
		case 2:
			background(0, 200, 30); 
			break;
		case 3:
			background(200, 20, 50); 
			regisScreen.test();
			break;
		case 4:
			background(30, 20, 0); 
			break;
		case 5:
			background(40, 203, 0); 
			break;
		case 6:
			background(20, 20,200); 
			break;
		case 7:
			background(100, 20, 0); 
			break;
		case 8:
			background(190, 20, 200); 
			break;
		case 9:
			background(255, 255, 0); 
			break;
		default:
			background(255, 255, 0); 
			
			break;
		}
		if(screen==3) {
			
		}
		
	}
	public void keyPressed() {
       
	switch (screen) {
		
		case 0:			
			if(key == ENTER) {
				regisScreen.getInfo();
				System.out.println("enter");
			}
		
			break;
		case 1:
		
			break;
		case 2:
		
			break;
		case 3:
			regisScreen.moverPersonaje(key);
		
			break;
		case 4:
		
			break;
		case 5:
		
			break;
		case 6:
		
			break;
		case 7:
		
			break;
		case 8:
		
			break;
		case 9:
		
			break;
			

		default:
			
			break;
	}
		
		
	
	}
	public void mousePressed() {
		
switch (screen) {
		
		case 0:
		
			break;
		case 1:
		
			break;
		case 2:
		
			break;
		case 3:
		
			break;
		case 4:
		
			break;
		case 5:
		
			break;
		case 6:
		
			break;
		case 7:
		
			break;
		case 8:
		
			break;
		case 9:
		
			break;
			

		default:
			
			break;
	}
		
		System.out.println(screen);
		screen++; 
		if(screen >= 10) {
			screen = 10; 
			
		}
		
	}
	


}
