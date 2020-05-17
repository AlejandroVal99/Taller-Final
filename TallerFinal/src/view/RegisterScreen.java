package view;

import conntroller.RegisterContro;
import controlP5.ControlP5;
import controlP5.Textfield;
import model.User;
import processing.core.PApplet;
import processing.core.PImage;

public class RegisterScreen {
	private ControlP5 cp5; 
	private PApplet app; 
	private RegisterContro regiscontro; 
	private PImage[] regis1, regis2, regis3, regis4, regis5, regis6, regis7, regis8, regis9, regis10, regis11, regis12, regis13;
	private int conta1, conta2, conta3, conta4, conta5, conta6, conta7, conta8, conta9, conta10, conta11, conta12, conta13;

	public RegisterScreen(PApplet app) {
		regiscontro = new RegisterContro(app); 
		this.app= app; 
		cp5= new ControlP5(app); 
		this.conta1 = 1; this.conta2 = 2; this.conta3 = 1; this.conta4 = 1; this.conta5 = 1; this.conta6 = 1; this.conta7 = 1; this.conta8 = 1; this.conta9 = 1; this.conta10 =1; this.conta11 = 1; this.conta12 = 1; this.conta13 = 1;
		
	}
	
	public void cargaImagenesRS() {
		this.regis1 = new PImage[162];
		this.regis2 = new PImage[69];
		this.regis3 = new PImage[61];
		this.regis4 = new PImage[58];
		this.regis5 = new PImage[97];
		this.regis6 = new PImage[65];
		this.regis7 = new PImage[87];
		this.regis8 = new PImage[49];
		this.regis9 = new PImage[57];
		this.regis10 = new PImage[92];
		this.regis11= new PImage[93];
		this.regis12 = new PImage[82];
		this.regis13 = new PImage[62];

		carga2();
	}
	
	public void drawRegister() {
		
		app.image(this.regis1[this.conta1], 0, 0);
		if (app.frameCount % 2 == 0) {
			this.conta1++;
			/*if (this.conta1 > 857) {
				app.image(this.ini1, 0, 0);

		}*/
			}
	}
	
	public void inputs(String name, int posy){
	
		
		cp5.addTextfield(name)
		.setPosition(app.width/2 -100,posy)
		.setSize(200,40)
		.setFocus(true)
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
		for (int i = 0; i < regiscontro.getUsuariosList().size(); i++) {
			regiscontro.getUsuariosList().get(i).pintar();
			app.fill(0);
			app.text(regiscontro.getUsuariosList().get(i).getNickname(),
					regiscontro.getUsuariosList().get(i).getPosx(),
					regiscontro.getUsuariosList().get(i).getPosy());
		}	
		
		
		if(regiscontro.areaSensible(0, 0, 100, 100)) {
			System.out.println("funciona");
		}
	}
	public void moverPersonaje(char k) {
		//usuario.moverse(k);
		for (User u : regiscontro.getUsuariosList()) {
			u.moverse(k);
			
		}
	}
	public void carga2() {
		for (int i = 1; i < 160; i++) {
			regis1[i] = app.loadImage("Imagenes/Regis/regis1/regis1" + " " + "(" + i + ").jpg");
		}
		/*for (int i = 1; i < 67; i++) {
			regis2[i] = app.loadImage("Imagenes/Regis/regis2/regis2" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < 59; i++) {
			regis3[i] = app.loadImage("Imagenes/Regis/regis3/regis3" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < 56; i++) {
			regis4[i] = app.loadImage("Imagenes/Regis/regis4/regis4" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < 95; i++) {
			regis5[i] = app.loadImage("Imagenes/Regis/regis5/regis5" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < 63; i++) {
			regis6[i] = app.loadImage("Imagenes/Regis/regis6/regis6" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < 85; i++) {
			regis7[i] = app.loadImage("Imagenes/Regis/regis7/regis7" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < 47; i++) {
			regis8[i] = app.loadImage("Imagenes/Regis/regis8/regis8" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < 55; i++) {
			regis9[i] = app.loadImage("Imagenes/Regis/regis9/regis9" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < 90; i++) {
			regis10[i] = app.loadImage("Imagenes/Regis/regis10/regis10" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < 91; i++) {
			regis11[i] = app.loadImage("Imagenes/Regis/regis11/regis11" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < 80; i++) {
			regis12[i] = app.loadImage("Imagenes/Regis/regis12/regis12" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < 60 ; i++) {
			regis13[i] = app.loadImage("Imagenes/Regis/regis13/regis13" + " " + "(" + i + ").jpg");
		}*/
	}

}
