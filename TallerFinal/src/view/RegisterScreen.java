package view;

import java.util.LinkedList;

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
	private PImage[] regis1, regis2, regis3, regis4, regis5, regis6, regis7, regis8, regis9, regis10, regis11, regis12,
			regis13;
	private int conta1, conta2, conta3, conta4, conta5, conta6, conta7, conta8, conta9, conta10, conta11, conta12,
			conta13, clickRS;
	private PImage Registro;
	// private boolean ;

	public RegisterScreen(PApplet app) {
		regiscontro = new RegisterContro(app);
		this.app = app;
		cp5 = new ControlP5(app);
		this.conta1 = 1;
		this.conta2 = 1;
		this.conta3 = 1;
		this.conta4 = 1;
		this.conta5 = 1;
		this.conta6 = 1;
		this.conta7 = 1;
		this.conta8 = 1;
		this.conta9 = 1;
		this.conta10 = 1;
		this.conta11 = 1;
		this.conta12 = 1;
		this.conta13 = 1;

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
		this.regis11 = new PImage[93];
		this.regis12 = new PImage[82];
		this.regis13 = new PImage[62];
		this.Registro = app.loadImage("Imagenes/Registro/Register.jpg");

		carga2();

	}

	public void drawRegister() {
		if (clickRS == 0) {
			app.image(this.regis1[this.conta1], 0, 0);
			if (app.frameCount % 2 == 0) {
				if (this.conta1 < 158) {
					this.conta1++;
					regis1[conta1 - 1] = null;
					
					//System.out.println(regis1[12]);

				} else {
					conta1 = 158;
				}

			}
		}

		if (clickRS == 1) {
			app.image(this.regis2[this.conta2], 0, 0);
			if (app.frameCount % 2 == 0) {
				if (this.conta2 < 65) {
					this.conta2++;
					regis2[conta2 - 1] = null;

				} else {
					conta1 = 65;
				}
			}
		}
		if (clickRS == 2) {
			app.image(this.regis3[this.conta3], 0, 0);
			if (app.frameCount % 2 == 0) {
				if (this.conta3 < 57) {
					this.conta3++;
					regis3[conta3 - 1] = null;

				} else {
					conta3 = 57;
				}
			}
		}
		if (clickRS == 3) {
			app.image(this.regis4[this.conta4], 0, 0);
			if (app.frameCount % 2 == 0) {
				if (this.conta4< 54) {
					this.conta4++;
					regis4[conta4 - 1] = null;

				} else {
					conta4 = 54;
				}
			}
		}
		if(clickRS == 4 ) {
			app.image(Registro,0,0);
		}
		
		/*if (clickRS == 4) {
			app.image(this.regis5[this.conta5], 0, 0);
			if (app.frameCount % 2 == 0) {
				if (this.conta5< 93) {
					this.conta5++;
					regis5[conta5 - 1] = null;

				} else {
					conta5 = 93;
				}
			}
		}
		if (clickRS == 5) {
			app.image(this.regis6[this.conta6], 0, 0);
			if (app.frameCount % 2 == 0) {
				if (this.conta6< 61) {
					this.conta6++;
					regis6[conta6 - 1] = null;

				} else {
					conta6 = 61;
				}
			}
		}*/
	}

	//@ esto me crea inputs de tipo textfield, recibe el nombre y la posicion en y
	public void inputs(String name, int posy) {

		cp5.addTextfield(name).setPosition(app.width / 2 - 100, posy).setSize(200, 40).setFocus(true)
				.setColor(app.color(255, 255, 0)).setColorActive(app.color(255, 255, 0))
				.setColorBackground(app.color(20, 0, 100)).setColorCaptionLabel(app.color(255, 255, 30))
				.setCaptionLabel(" ");

		;

	}

	// @esconde el input que concuerde con el nombre dado
	public void escondoInput(String name) {
	
			cp5.get(Textfield.class, name).hide();
		
	}

	// @esconde el input que concuerde con el nombre dado
	public void muestroInput(int screen, String name) {
		if (screen == 1) {
			cp5.get(Textfield.class, name).show();
		}
	}

	//@este metodo me trae la informacion de los input de registro
	public void getInfo() {
		String userName = cp5.get(Textfield.class, "name").getText();
		String userContra = cp5.get(Textfield.class, "correo").getText();
		regiscontro.registrarmetodo(userName, userContra);
	}	
	//@
	

<<<<<<< HEAD
=======
	}

	public void creo() {
		regiscontro.creo();
	}

	public void test() {
		regiscontro.test();
		for (int i = 0; i < regiscontro.getUsuariosList().size(); i++) {
			regiscontro.getUsuariosList().get(i).pintar();
			app.fill(0);
			app.text(regiscontro.getUsuariosList().get(i).getNickname(), regiscontro.getUsuariosList().get(i).getPosx(),
					regiscontro.getUsuariosList().get(i).getPosy());
		}

		if (regiscontro.areaSensible(0, 0, 100, 100)) {
			System.out.println("funciona");
		}
	}

	public void moverPersonaje(char k) {
		for (User u : regiscontro.getUsuariosList()) {
			u.moverse(k);

		}
	}
>>>>>>> parent of 8efb2c1... debugpapa

	public void contadorRS() {
		clickRS++;
	}

	//@cargo las imagenes necesarias
	public void carga2() {
		for (int i = 1; i < regis1.length; i++) {
			regis1[i] = app.loadImage("Imagenes/Regis/regis1/regis1" + " " + "(" + i + ").jpg");
		}

		for (int i = 1; i < regis2.length; i++) {
			regis2[i] = app.loadImage("Imagenes/Regis/regis2/regis2" + " " + "(" + i + ").jpg");
		}

		for (int i = 1; i < regis3.length; i++) {
			regis3[i] = app.loadImage("Imagenes/Regis/regis3/regis3" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < regis4.length; i++) {
			regis4[i] = app.loadImage("Imagenes/Regis/regis4/regis4" + " " + "(" + i + ").jpg");
		}
	}
	/*public void carga3() {
		System.out.println("HOLAA");
		for (int i = 1; i < regis5.length; i++) {
			regis5[i] = app.loadImage("Imagenes/Regis/regis5/regis5" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < regis6.length; i++) {
			regis6[i] = app.loadImage("Imagenes/Regis/regis6/regis6" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < regis7.length; i++) {
			regis7[i] = app.loadImage("Imagenes/Regis/regis7/regis7" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < regis8.length; i++) {
			regis8[i] = app.loadImage("Imagenes/Regis/regis8/regis8" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < regis9.length; i++) {
			regis9[i] = app.loadImage("Imagenes/Regis/regis9/regis9" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < regis10.length; i++) {
			regis10[i] = app.loadImage("Imagenes/Regis/regis10/regis10" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < regis11.length; i++) {
			regis11[i] = app.loadImage("Imagenes/Regis/regis11/regis11" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < regis12.length; i++) {
			regis12[i] = app.loadImage("Imagenes/Regis/regis12/regis12" + " " + "(" + i + ").jpg");
		}
		for (int i = 1; i < regis13.length; i++) {
			regis13[i] = app.loadImage("Imagenes/Regis/regis13/regis13" + " " + "(" + i + ").jpg");
		}

	}*/

	public int getClickRS() {
		return clickRS;
	}

	public void setClickRS(int clickRS) {
		this.clickRS += clickRS;
	}
	public LinkedList<User> getUsuariosList() {
		return regiscontro.getUsuariosList();
	}
}
