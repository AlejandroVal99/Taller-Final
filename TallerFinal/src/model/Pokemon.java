package model;

import processing.core.PApplet;

public abstract class Pokemon implements Comparable<Pokemon>{
	protected PApplet app; 
	protected String name; 
	protected int daño1, daño2, xp, nivel; 

	public Pokemon(String name, PApplet app, int daño1, int daño2, int xp, int nivel) {

		this.app= app; 
		this.name= name; 
		this.daño1 = daño1; 
		this.daño2= daño2; 
		this.xp= xp; 
		this.nivel= nivel; 
		
		
		
	}
	
    public abstract void pintar(); 
    
    public int habilidades(int e) {
    	return e; 
	   
    }
    public void aumentarNivel() {
    	
    }
	

}
