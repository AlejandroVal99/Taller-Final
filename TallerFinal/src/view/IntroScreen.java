package view;

import processing.core.PApplet;
import processing.core.PImage;

public class IntroScreen {
	private PImage[] intro;
	private PImage ini1, ini2, ini3;
	private int contador1;
	private PApplet app;
	private boolean paso = false;
	private boolean paso2 = false;


	public IntroScreen(PApplet app) {
		this.contador1 = 1;
		this.app = app;
	}

	public void cargaImagenesIS() {
		this.intro = new PImage[859];
		this.ini1 = app.loadImage("Imagenes/Intro/ini1.jpg");
		this.ini2 = app.loadImage("Imagenes/Intro/ini2.jpg");
		this.ini3 = app.loadImage("Imagenes/Intro/ini3.jpg");

		for (int i = 1; i < 857; i++) {
			intro[i] = app.loadImage("Imagenes/Intro/intro/intro" + " " + "(" + i + ").jpg");
		}
	}

	public void drawIntro() {
		app.image(this.ini1, 0, 0);
		if(this.paso==true) {//falta aca poner el si la animacion ya acabo
			app.image(this.ini2,0,0);
		}if(this.paso2==true) {
			app.image(this.ini3,0,0);
		}
		/*app.image(this.intro[contador1], 0, 0);
		if (app.frameCount % 2 == 0) {
			contador1++;
			if (contador1 > 857) {
				app.image(this.ini1, 0, 0);

			}
		}*/

	}

	public boolean isPaso() {
		return paso;
	}
	
	public void setPaso(boolean paso) {
		this.paso = paso;
	}
	public boolean isPaso2() {
		return paso2;
	}
	
	public void setPaso2(boolean paso2) {
		this.paso2 = paso2;
	}
}
