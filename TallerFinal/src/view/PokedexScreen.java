package view;

import conntroller.MainContro;
import processing.core.PApplet;
import processing.core.PImage;

public class PokedexScreen {

	private MainContro mainContro;
	private PApplet app;
	private PImage pokedex;
	
	public PokedexScreen(PApplet app) {
		this.app = app;
		mainContro = new MainContro(app);
		
	}
	
	public void cargaPS() {
		this.pokedex = app.loadImage("Imagenes/PokedexFINAL.jpg");
	}

	public void drawPokedex() {
		app.image(this.pokedex,0,0);
	}

	public void ordenNombrePoke() {
		mainContro.ordenNombrePoke();
	}

	public void ordenTipo() {
		mainContro.ordenTipo();
	}
}
