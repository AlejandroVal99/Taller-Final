package view;

import conntroller.MainContro;
import processing.core.PApplet;
import processing.core.PImage;

public class FigthScreen {

	private MainContro mainContro;
	private PApplet app;
	private PImage fight;
	private PImage [] aniFight;
	private int contador1;
	
	public FigthScreen(PApplet app) {
		this.app = app;
		mainContro = new MainContro(app);
		this.contador1 = 1;
	}
	
	public void cargaFS() {
		this.aniFight = new PImage[44];

		this.fight = app.loadImage("Imagenes/fightScreen.jpg");
		
		for (int i = 1; i < aniFight.length; i++) {
			aniFight[i] = app.loadImage("Imagenes/fight/fight" + " " + "(" + i + ").jpg");			
		}
	}
	
	public void drawFight() {
		
		app.image(this.aniFight[this.contador1], 0, 0);
		if (app.frameCount % 2 == 0) {
			if (this.contador1 < 43) {
				this.contador1++;
				aniFight[contador1 - 1] = null;

			} else {
				contador1 = 43;
			}
		}
		if(contador1 == 43) {
			app.image(this.fight,0,0);
		}
	}
}
