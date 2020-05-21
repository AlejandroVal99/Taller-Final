package view;

import java.awt.List;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class IntroScreen {
	private PImage[] intro;
	private PImage ini1, ini2, ini3;
	private int contador1;
	private PApplet app;
	private boolean paso = false;
	private boolean paso2 = false;
	final ArrayList<PImage> images = new ArrayList<PImage>();



	public IntroScreen(PApplet app) {
		this.contador1 = 1;
		this.app = app;
		
	}

	public void cargaImagenesIS() {
		this.intro = new PImage[523];
		this.ini1 = app.loadImage("Imagenes/Intro/ini1.jpg");
		this.ini2 = app.loadImage("Imagenes/Intro/ini2.jpg");
		this.ini3 = app.loadImage("Imagenes/Intro/ini3.jpg");

		for (int i = 1; i < intro.length; i++) {
			intro[i] = app.loadImage("Imagenes/Intro/intro/intro" + " " + "(" + i + ").jpg");
			
			
		}
		for (int i = 0; i < images.size(); i++) {
		}
	}
	public void drawIntro() {
		app.image(this.ini1, 0, 0);
		if(this.paso==true) {//falta aca poner el si la animacion ya acabo
			app.image(this.ini2,0,0);
		}if(this.paso2==true) {
			app.image(this.ini3,0,0);
		}
		if(contador1!=522) {
			animation(); 
		}
		
	}
	
	public void animation () {
		if(contador1!=522) {
			app.image(this.intro[contador1], 0, 0);
		}
		if (app.frameCount %3 == 0) {
			
			
			if (contador1 < 522) {
				contador1++;
				if(contador1-1!=522) {
					intro[contador1-1]= null; 
				}
			}else {
				
				contador1 = 522; 
				app.image(this.ini1, 0, 0);
			}
		}
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
