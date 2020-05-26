package view;

import conntroller.MainContro;
import exceptions.NoCapturadoException;
import exceptions.pokemonWinException;
import model.Pokemon;
import processing.core.PApplet;
import processing.core.PImage;

public class FigthScreen {

	private MainContro mainContro;
	private PApplet app;
	private PImage fight, fight2, ha1, ha2, mori;
	private PImage[] aniFight;
	private int contador1;
	private boolean dos = false;
	private boolean turno;
	private boolean falloCap;
	private boolean h1;
	private boolean h2;
	private boolean paso;
	private boolean excep;

	private float ultimo;
	private float maximo;
	private float velx;
	private float enx;
	private boolean reinicio;

	public FigthScreen(PApplet app) {

		this.app = app;
		turno = true;
		mainContro = new MainContro(app);
		this.contador1 = 1;
		mainContro.crearPokemones();
		mainContro.crearPokesal();
		falloCap = false;
		excep = false;
		h1 = false;
		h2 = false;

		maximo = 5000;
		ultimo = app.millis();
		velx = 10;
		enx += velx;
		reinicio = false;
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

		mainContro.ganePelea(p);
		paso = mainContro.ganePelea(p);

		if (mainContro.ganePelea(p)) {
			System.out.println("saquenmeee");
		}
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
		
		if (p != null) {
			p.pintarPokemon();
			p.pintarBarra();
		}

		mainContro.pintarPokemonUser();
		float pasado = app.millis() - ultimo;
		float restante = (int) (maximo - pasado) / 1000;

		if (!turno) {

			int r = (int) app.random(1, 3);
			if (restante < 0) {

				mainContro.ataquePokemon(r, p);
				turno = !turno;
				restante = 10;

			}

		}

		// PRUEBO
		// MILLLISSSSS-----------------------------------<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		// app. text(""+restante,50,50);
	}

	public boolean testRun(Pokemon p) {

		if (turno) {

			System.out.println("Me cague");
			turno = true;
			return mainContro.runPokemon(p);

		}

		return false;

	}

	public void teclas(char k) {

		if (k == 'l') {
			ultimo = app.millis();
		}

	}

	public void winPoke() throws pokemonWinException  {
		mainContro.winPoke();
	}
	public boolean isExcep() {
		return excep;
	}

	public void setExcep(boolean excep) {
		this.excep = excep;
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
					turno = true;
					// return true;

				}
				// turno = !turno;
				return true;
			}
		}

		return false;
	}

	public void ataqueUser(int r, Pokemon p) {

		if (turno) {
			mainContro.ataqueDelUser(r, p);
			turno = !turno;
		}

	}

	public void ataquePok(int r, Pokemon n) {

		mainContro.ataquePokemon(r, n);

	}

	// -------------------------------------

	public boolean isTurno() {
		return turno;
	}

	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	public boolean isFalloCap() {
		return falloCap;
	}

	public void setFalloCap(boolean falloCap) {
		this.falloCap = falloCap;
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

	public float getUltimo() {
		return ultimo;
	}

	public void setUltimo(float ultimo) {
		this.ultimo = ultimo;
	}

	public boolean isPaso() {
		return paso;
	}

	public void setPaso(boolean paso) {
		this.paso = paso;
	}

}
