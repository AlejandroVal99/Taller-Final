package model;

import processing.core.PApplet;

public abstract class Pokemon implements Runnable, Comparable<Pokemon>{
	protected PApplet app; 
	protected String name, tipo; 
	protected int dano1, dano2, xp, nivel, posx, posy; 

	public Pokemon(String name, String tipo, PApplet app, int dano1,
			int dano2, int xp, int nivel, int posx, int posy) {

		this.app= app; 
		this.name= name; 
		this.tipo = tipo;
		this.dano1 = dano1; 
		this.dano2= dano2; 
		this.xp= xp; 
		this.nivel= nivel; 
		this.posx= posx; 
		this.posy= posy; 	
		
	}
	
	//Metodo hecho para pintar la informacion del pokemon en la pokedex
	
	 public void drawPokemonOrden(int posy) {
	    	this.posx = 150;
	    	app.text(name, posx,posy);
	    	app.text(tipo, posx,posy+50);
	    	app.text(nivel, posx, posy+100);
	    	
	    }

	public int compareTo(Pokemon o) {
		// TODO Auto-generated method stub
		return o.getName().compareTo(this.getName());
	}
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public abstract void pintar(); 
    
    public int habilidades(int e) {
    	return e; 
	   
    }
    public void aumentarNivel() {
    	
    }

	public int getDano1() {
		return dano1;
	}

	public void setDano1(int dano1) {
		this.dano1 = dano1;
	}

	public int getDano2() {
		return dano2;
	}

	public void setDano2(int dano2) {
		this.dano2 = dano2;
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

	public String getTipo() {
	
		// TODO Auto-generated method stub
		return tipo;
	}
	
       
    //gets y sets 
    
	

}
