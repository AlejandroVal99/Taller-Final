package view;

import conntroller.MainContro;
import exceptions.NoCapturadoException;
import model.Pokemon;
import processing.core.PApplet;
import processing.core.PImage;

public class FigthScreen {

	private MainContro mainContro;
	private PApplet app;
	private PImage fight, fight2, ha1, ha2;
	private PImage[] aniFight;
	private int contador1;
	private boolean dos = false;
	private boolean turno;
	private boolean falloCap;
	private boolean h1;
	private boolean h2;

	public FigthScreen(PApplet app) {

		this.app = app;
		turno = true;
		mainContro = new MainContro(app);
		this.contador1 = 1;
		mainContro.crearPokemones();
		mainContro.crearPokesal();
		falloCap = false;
		h1 = false;
		h2 = false;
	}

	public void cargaFS() {
		this.aniFight = new PImage[44];

		this.fight = app.loadImage("Imagenes/fightScreen.jpg");
		this.fight2 = app.loadImage("Imagenes/fightScreen2.jpg");
		this.ha1 = app.loadImage("Imagenes/fightScreen3.jpg");
		this.ha2 = app.loadImage("Imagenes/fightScreen4.jpg");

		for (int i = 1; i < aniFight.length; i++) {
			aniFight[i] = app.loadImage("Imagenes/fight/fight" + " " + "(" + i + ").jpg");
		}
	}

	public void drawFight(Pokemon p) {
		app.image(this.aniFight[this.contador1], 0, 0);
		
		
		
		if (app.frameCount % 5 == 0) {
			if (this.contador1 < 43) {
				this.contador1++;
			} else {
				contador1 = 43;
			}
		}
		if (contador1 == 43) {
			app.image(this.fight, 0, 0);
		}
		if (dos == true) {
			app.image(this.fight2, 0, 0);
			if (h1 == true) {
				app.image(this.ha1, 0, 0);
			}
			if (h2 == true) {
				app.image(this.ha2, 0, 0);
			}
		}
		app.text(p.getNivel(), 200, 100);
		
		if (p != null) {
			p.pintarPokemon();
			p.pintarBarra();
		}
		
		mainContro.pintarPokemonUser();
	}

	public void setH1(boolean h1) {
		this.h1 = h1;
	}

	public void setH2(boolean h2) {
		this.h2 = h2;
	}

	public void setDos(boolean dos) {
		this.dos = dos;
	}

	public void setContador1(int contador1) {
		this.contador1 = contador1;
	}

	public boolean testRun(Pokemon p) {

		if (turno) {

			System.out.println("Me cague");
			// turno = !turno;
			return mainContro.runPokemon(p);

		}

		return false;

	}

	public boolean testCap(char k, Pokemon p) {

		if (turno) {

			if (k == 'r') {
				try {

					mainContro.capturar(p);
					falloCap = false;

				} catch (NoCapturadoException e) {

					System.out.println("No capture");
					falloCap = true;
					// turno = !turno;
					// return true;

				}
				// turno = !turno;
				return true;
			}
		}

		return false;
	}
	
	public void ataqueUser(int r, Pokemon p) {
		
		if(turno) {
			mainContro.ataqueDelUser(r, p);
			turno = !turno;
		}
		
		
	}

	public boolean isFalloCap() {
		return falloCap;
	}

	public void setFalloCap(boolean falloCap) {
		this.falloCap = falloCap;
	}

}
