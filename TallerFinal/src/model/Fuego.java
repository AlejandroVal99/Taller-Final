package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Fuego extends Pokemon{

	public Fuego(String name, String tipo, PApplet app, int dano1, int dano2, int xp, int nivel, int posx, int posy,int vida,PImage salvaje, PImage combate, boolean capturado, int[][] mapa) {
		// TODO Auto-generated constructor stub
		super(name, tipo, app, dano1, dano2,xp, nivel, posx, posy, vida,salvaje,combate,capturado, mapa);
	}



	@Override
	public void pintar() {
		// TODO Auto-generated method stub
		app.fill(255,0,0);
		app.ellipse(posx, posy, 20, 20);
		
	}

	

}
