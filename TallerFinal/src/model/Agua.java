package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Agua extends Pokemon{

	public Agua(String name, String tipo, PApplet app, int dano1, int dano2, int xp, int nivel, int posx, int posy, int vida,PImage salvaje, PImage combate, boolean capturado) {
		super(name, tipo, app, dano1, dano2,xp, nivel, posx, posy, vida,salvaje,combate,capturado); 
		// TODO Auto-generated constructor stub
	}

	public int compareTo(Pokemon o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void pintar() {
		// TODO Auto-generated method stub
		app.fill(0,0,200);
		app.ellipse(posx, posy, 20, 20);
		
	}




}
