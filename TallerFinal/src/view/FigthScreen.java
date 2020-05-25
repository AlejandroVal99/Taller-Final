package view;

import conntroller.MainContro;
import model.Pokemon;
import processing.core.PApplet;
import processing.core.PImage;

public class FigthScreen {

	private MainContro mainContro;
	private PApplet app;
	private PImage fight, fight2;
	private PImage [] aniFight;
	private int contador1;
	private boolean dos = false;

	
	public FigthScreen(PApplet app) {
	
		this.app = app;
		
		mainContro = new MainContro(app);
		this.contador1 = 1;
		mainContro.crearPokemones();
	
	}
	public void cargaFS() {
		this.aniFight = new PImage[44];

		this.fight = app.loadImage("Imagenes/fightScreen.jpg");
		this.fight2 = app.loadImage("Imagenes/fightScreen2.jpg");
		
		for (int i = 1; i < aniFight.length; i++) {
			aniFight[i] = app.loadImage("Imagenes/fight/fight" + " " + "(" + i + ").jpg");			
		}
	}
	public void drawFight(Pokemon p) {
		app.image(this.aniFight[this.contador1], 0, 0);
		if (app.frameCount % 5 == 0) {
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
		if(dos==true) {
			app.image(this.fight2,0,0);
		}
		app.text(p.getNivel(), 200, 100);
		//
		 if(p!=null) {
			 p.pintar();
			}
	}
	public void setDos(boolean dos) {
		this.dos = dos;
	}
	public void setContador1(int contador1) {
		this.contador1 = contador1;
	}
	public boolean testRun(Pokemon p) {
		
			System.out.println("matoooooooo");
			return mainContro.runPokemon(p); 
			
		
		
		
	}
	
	public boolean testCap(char k, Pokemon p) {
		if(k == 'r') {
			mainContro.capturar(p); 
		    return true; 
		}
		
		return false; 
	}
	
}
