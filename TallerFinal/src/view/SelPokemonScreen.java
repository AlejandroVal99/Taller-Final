package view;

import conntroller.MainContro;
import processing.core.PApplet;
import processing.core.PImage;

public class SelPokemonScreen {

	private PApplet app;
	private MainContro mainContro;
	private PImage seleOri, sele1, sele2, sele3;
	private boolean tree = false;
	private boolean torchi = false;
	private boolean mud = false;
	
	public SelPokemonScreen(PApplet app) {
		this.app = app;
		mainContro = new MainContro(app);
	}
	
	public void cargaImagenesSPS() {
		this.seleOri = app.loadImage("Imagenes/SelePokemon.jpg");
		this.sele1 = app.loadImage("Imagenes/selePoke1.jpg");
		this.sele2 = app.loadImage("Imagenes/selePoke2.jpg");
		this.sele3 = app.loadImage("Imagenes/selePoke3.jpg");

	}
	
	public void drawSeleccion() {
		app.image(this.seleOri,0,0);
		
		if(this.torchi == true) {
			app.image(this.sele1,0,0);
		}
		if(this.mud == true) {
			app.image(this.sele2,0,0);
		}
		if(this.tree == true) {
			app.image(this.sele3,0,0);
		}
	}

	public boolean isTree() {
		return tree;
	}

	public void setTree(boolean tree) {
		this.tree = tree;
	}

	public boolean isTorchi() {
		return torchi;
	}

	public void setTorchi(boolean torchi) {
		this.torchi = torchi;
	}

	public boolean isMud() {
		return mud;
	}

	public void setMud(boolean mud) {
		this.mud = mud;
	}

}
