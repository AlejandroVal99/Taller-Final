package view;

import processing.core.PApplet;
import processing.core.PImage;

public class IntroScreen {
	private PImage [] intro;
	private PImage ini1, ini2, ini3;
	private int contador1;
	private PApplet app; 
	
	public IntroScreen(PApplet app) {
		this.contador1 = 1;
		this.app= app; 
	}
	public void cargaImagenesIS() {
		this.intro = new PImage [859];
		this.ini1 = app.loadImage("Imagenes/Intro/ini1.jpg");
		this.ini2 = app.loadImage("Imagenes/Intro/ini2.jpg");
		this.ini3 = app.loadImage("Imagenes/Intro/ini3.jpg");
		
		for(int i=1;i<857;i++) {
			intro[i]=app.loadImage("Imagenes/Intro/intro/intro"+" "+"("+i+").jpg");
		}
	}
	public void drawIntro() {
		app.image(intro[contador1], 0, 0);
		if(app.frameCount %2==0) {
			contador1++;
			if(contador1>857) {
				app.image(ini1,0,0);
				
			}
		}
	}

}
