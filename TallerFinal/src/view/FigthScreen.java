package view;

import conntroller.MainContro;
import processing.core.PApplet;
import processing.core.PImage;

public class FigthScreen {

	private MainContro mainContro;
	private PApplet app;
	private PImage fight;
	
	public FigthScreen(PApplet app) {
		this.app = app;
		mainContro = new MainContro(app);
	}
	
	public void cargaFS() {
		this.fight = app.loadImage("Imagenes/fightScreen.jpg");
	}
	public void drawFight() {
		app.image(this.fight,0,0);
	}
}
