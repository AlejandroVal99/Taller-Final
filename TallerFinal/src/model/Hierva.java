package model;

import processing.core.PApplet;

public class Hierva extends Pokemon{

	public Hierva(String name, String tipo, PApplet app, int dano1, int dano2, int xp, int nivel, int posx, int posy, int vida) {
		// TODO Auto-generated constructor stub
		super(name, tipo, app, dano1, dano2,xp, nivel, posx, posy, vida); 
	}

	
	

	@Override
	public void pintar() {
		app.fill(55,200,30);
		app.ellipse(posx, posy, 20, 20);
		
	}

	

}
