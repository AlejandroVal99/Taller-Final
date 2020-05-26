package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Hierva extends Pokemon{

	public Hierva(String name, String tipo, PApplet app, int dano1, int dano2, int xp, int nivel, int posx, int posy, int vida,PImage salvaje, PImage combate, boolean capturado, int[][] mapa) {
		// TODO Auto-generated constructor stub
		super(name, tipo, app, dano1, dano2,xp, nivel, posx, posy, vida,salvaje,combate,capturado, mapa); 
	}

	
	

	@Override
	public void pintar() {
		app.fill(55,200,30);
		app.ellipse(posx, posy, 20, 20);
		
	}

	

}
