package model;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Pokemon implements Runnable, Comparable<Pokemon> {
	protected PApplet app;
	protected String name, tipo;
	protected int dano1, dano2, xp, nivel, posx, posy,vida,vidaTotal;
	protected PImage salvaje, combate;
	protected boolean capturado;
	protected int[][] mapa;

	public Pokemon(String name, String tipo, PApplet app, int dano1, int dano2, int xp, int nivel, int posx, int posy,int vida,PImage salvaje, PImage combate, boolean capturado, int[][] mapa) {

		this.app = app;
		this.name = name;
		this.tipo = tipo;
		this.dano1 = dano1;
		this.dano2 = dano2;
		this.xp = xp;
		this.nivel = nivel;
		this.posx = posx;
		this.posy = posy;
		this.vida = vida;
		vidaTotal=vida;
		this.combate = combate;
		this.salvaje = salvaje;
		this.capturado = capturado;
		this.mapa = mapa;

	}

	// Run aqu� debido a que todos hacen lo mismo por lo tanto la podemos declarar
	// en la padre para qeu todos lo hagan
	public void run() {
	moverPokemon();

	}
	
	//Metodo para pintar los pokemones
	
	public void pintarPokemon() {
		if(capturado) {
			app.image(combate,141 , 177);
		}else {
			app.image(salvaje,525 , 37);
		}
		
	}
	
	public void pintarBarra() {
		
		if(capturado) {
			app.fill(105,217,160);
			app.rect(590,271,(float)((vida*158)/vidaTotal),7);
			app.fill(0);
			app.text(name, 498, 236+20);
			app.text(nivel, 722, 236+20);
			
			
			
			//System.out.println("valor barra: "+(vida*158)/vidaTotal);
		}else {
			app.image(salvaje,525 , 37);
			app.fill(105,217,160);
			app.rect(180,101,(float)((vida*158)/vidaTotal),7);
			app.fill(0);
			app.text(name, 78, 63+20);
			app.text(nivel, 306, 63+20);
			
		}
	}

	// Metodo hecho para pintar la informacion del pokemon en la pokedex

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida -= vida;
	}

	public void drawPokemonOrden(int posy) {
	
		app.text(name, 517, posy);
		app.text(tipo, 731, posy);
		//app.text(nivel, posx, posy);

	}

	// Metodo hecho para mvoer el pokemon, recibe un int y el mapa para hacer las
	// validaciones del movimeinto. ESTE ES EL METO
	public void moverPokemon() {

		int y = (int) app.random(0, 5);

		// 1 arriba
		// 2 abajo
		// 3 derecha
		// 4 izquierda

		int fila = app.width / 34;
		int col = app.height / 19;

		if (y == 2 && posy - 10 > 0) {
			if (mapa[(int) (posy - 10) / col][(int) (posx) / fila] == 2) {
				posy -= 10;
			}
		}

		if (y == 1 && posy + 10 < app.height) {
			if (mapa[(int) (posy + 10) / col][(int) (posx) / fila] == 2) {
				posy += 10;
			}

		}

		if (y == 4) {
			if (mapa[(int) (posy) / col][(int) (posx - 10) / fila] == 2) {
				posx -= 10;
			}

		}

		if (y == 3) {
			if (mapa[(int) (posy) / col][(int) (posx + 10) / fila] == 2) {
				posx += 10;
			}

		}
		//System.out.println("posx: " + posx + " posy: " + posy);

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
		return dano1 * nivel;
	}

	public void setDano1(int dano1) {
		this.dano1 = dano1;
	}

	public int getDano2() {
		return dano2 * nivel;
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

	// gets y sets

}
