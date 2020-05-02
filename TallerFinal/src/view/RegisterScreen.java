package view;

import controlP5.ControlP5;
import processing.core.PApplet;

public class RegisterScreen {
	private ControlP5 cp5; 
	private PApplet app; 

	public RegisterScreen(PApplet app) {
		this.app= app; 
		cp5= new ControlP5(app); 
		
	}
	
	public void inputs(){
		
		cp5.addTextfield("name")
		.setPosition(app.width/2 -100,20)
		.setSize(200,40)
		.setFocus(true)
		.setColor(app.color(255,255,0))
		.setColorActive(app.color(255,255,0))
		.setColorBackground(app.color(20,0,100))
		.setColorCaptionLabel(app.color(255,255,30))
		.setCaptionLabel(" "); 
		
		; 
		
	}

}
