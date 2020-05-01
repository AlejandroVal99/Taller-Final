package model;

import processing.core.PApplet;

public abstract class Pokemon implements Runnable, Comparable<Pokemon>{
	protected PApplet app; 
	protected String name; 
	protected int daño1, daño2, xp, nivel, posx, posy; 

	public Pokemon(String name, PApplet app, int daño1,
			int daño2, int xp, int nivel, int posx, int posy) {

		this.app= app; 
		this.name= name; 
		this.daño1 = daño1; 
		this.daño2= daño2; 
		this.xp= xp; 
		this.nivel= nivel; 
		this.posx= posx; 
		this.posy= posy; 
		
		
		
	}
	
    public abstract void pintar(); 
    
    public int habilidades(int e) {
    	return e; 
	   
    }
    public void aumentarNivel() {
    	
    }

	public int getDaño1() {
		return daño1;
	}

	public void setDaño1(int daño1) {
		this.daño1 = daño1;
	}

	public int getDaño2() {
		return daño2;
	}

	public void setDaño2(int daño2) {
		this.daño2 = daño2;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}
    
    
    //gets y sets 
    
	

}
