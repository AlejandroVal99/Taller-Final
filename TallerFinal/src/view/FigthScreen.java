package view;

import conntroller.FigthContro;
import processing.core.PApplet;
import processing.core.PImage;

public class FigthScreen {

	private FigthContro fightContro;
	private PApplet app;
	private PImage fight;
	
	public FigthScreen(PApplet app) {
		this.app = app;
		fightContro = new FigthContro(app);
	}
	
	public void cargaFS() {
		this.fight = app.loadImage("Imagenes/fightScreen.jpg");
	}
	public void drawFight() {
		app.image(this.fight,0,0);
	}
}
