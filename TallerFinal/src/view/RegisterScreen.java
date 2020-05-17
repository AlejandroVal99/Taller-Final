package view;

import conntroller.RegisterContro;
import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;

public class RegisterScreen {
	private ControlP5 cp5; 
	private PApplet app; 
	private RegisterContro regiscontro; 


	public RegisterScreen(PApplet app) {
		regiscontro = new RegisterContro(app); 
		this.app= app; 
		cp5= new ControlP5(app); 
	
		
	}
	
	public void inputs(String name, int posy){
	
		
		cp5.addTextfield(name)
		.setPosition(app.width/2 -100,posy)
		.setSize(200,40)
		.setFocus(false)
		.setColor(app.color(255,255,0))
		.setColorActive(app.color(255,255,0))
		.setColorBackground(app.color(20,0,100))
		.setColorCaptionLabel(app.color(255,255,30))
		.setCaptionLabel(" "); 
		
		; 

	}
	
	public void escondoInput(int screen,String name) {
	if(screen==1 ) {	
			cp5.get(Textfield.class, name).hide(); 
		}
	}
	
	public void getInfo() {
		String userName = cp5.get(Textfield.class, "name").getText(); 
		String userContra = cp5.get(Textfield.class, "correo").getText(); ;
		regiscontro.registrarmetodo(userName, userContra);
		//System.out.println(userName);
		
		
	}
	public void creo() {
		regiscontro.creo();
	}
	public void test() {
		regiscontro.test();
		
	}
	
	public void moverPersonaje(char k) {
		regiscontro.moverPersonaje(k);
		
	}

}
