package view;

import conntroller.PokedexContro;
import processing.core.PApplet;
import processing.core.PImage;

public class PokedexScreen {

	private PokedexContro pokedexContro;
	private PApplet app;
	private PImage pokedex;
	
	public PokedexScreen(PApplet app) {
		this.app = app;
		pokedexContro = new PokedexContro(app);
		
	}
	
	public void cargaPS() {
		this.pokedex = app.loadImage("Imagenes/PokedexFINAL.jpg");
	}

	public void drawPokedex() {
		app.image(this.pokedex,0,0);
	}
}
