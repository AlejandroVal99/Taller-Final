package view;

import java.util.LinkedList;

import conntroller.MainContro;
import controlP5.ControlP5;
import controlP5.Textfield;
import model.User;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class RegisterScreen {
	private ControlP5 cp5;
	private PApplet app;
	private MainContro mainContro;
	private PImage[] regis1, regis2, regis3, regis4, regis5, regis6, regis7, regis8, regis9, regis10, regis11, regis12,
			regis13;
	private int conta1, conta2, conta3, conta4, conta5, conta6, conta7, conta8, conta9, conta10, conta11, conta12,
			conta13, clickRS;
	private PImage Registro;
	private PFont font;

	public RegisterScreen(PApplet app) {
		mainContro = new MainContro(app);
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
		this.regis13 = new PImage[62];
		this.Registro = app.loadImage("Imagenes/start.jpg");

		font = app.createFont("Fuentes/Pokemon" + " " + " X" + " " + " and" + " " + " Y.tff",20);
		carga2();

	}



	public void drawRegister() {
		//System.out.println(clickRS);
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
			app.image(this.regis13[this.conta13], 0, 0);
			if (app.frameCount % 2 == 0) {
				if (this.conta13< 58) {
					this.conta13++;
					regis4[conta13 - 1] = null;

				} else {
					conta13 = 58;
				}
			}
		}
		if(clickRS == 4 ) {
			app.image(Registro,0,0);
			clickRS = 4;
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

		cp5.addTextfield(name)
		.setPosition(299 , posy)
		.setSize(200, 40)
		.setFocus(true)
		//.setFont(font) //mirar bien por que no carga la fuente
		.setCaptionLabel(" ")
		.setColor(app.color(0))
		.setColorActive(app.color(248, 248, 248))
		.setColorForeground(app.color(248, 248, 248,1))
		.setColorBackground(app.color(248, 248, 248));

		;

	}

	// @esconde el input que concuerde con el nombre dado
	public void escondoInput(String name) {
	
			cp5.get(Textfield.class, name).hide();
		
	}

	// @esconde el input que concuerde con el nombre dado
	public void muestroInput(int screen, String name) {
		if (clickRS ==4) {
			cp5.get(Textfield.class, name).show();
		}
	}

	//@este metodo me trae la informacion de los input de registro
	public void getInfo() {
		String userName = cp5.get(Textfield.class, "name").getText();
		String name = cp5.get(Textfield.class, "correo").getText();
		String fecha = "11/02/2019";
		mainContro.registrarmetodo(userName,name, fecha);
	}	
	//@
	


	public void contadorRS() {
		clickRS++;
		if(clickRS >= 4) {
			clickRS = 4;
		}
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
		for (int i = 1; i < regis13.length; i++) {
			regis13[i] = app.loadImage("Imagenes/Regis/regis13/regis13" + " " + "(" + i + ").jpg");
		}
	}
	public int getClickRS() {
		return clickRS;
	}

	public void setClickRS(int clickRS) {
		this.clickRS += clickRS;
	}
	public LinkedList<User> getUsuariosList() {
		return mainContro.getUsuariosList();
	}
}
