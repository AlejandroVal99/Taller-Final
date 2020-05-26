package model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class User implements Comparable<User>{

	 PApplet app; 
	 private PFont font;
	 boolean toco; 
	 String[] fechas ;
	 String password, nickname,fecha; 
	 Date fechadeRegistro; 
	 SimpleDateFormat dateFormat;
	 
	 LinkedList<Pokemon> pokedex; 
	 
	 int posx,posy; 
	 int conta;
	 
	 int d;
	 int m;
	 int a;
	 
	 //Variable del numero de pokebolas
	 int npokeballs;

	 //Booleans para animacion mov perso
	 boolean arriba = false;
	 boolean abajo = false;
	 boolean izquierda = false;
	 boolean derecha = false;
	 
	 //Variables de imgs animacion
	/*private PImage [] espal, frente, lado, otrola;
	private PImage espal1, espal2, espal3, frente1, frente2, frente3, lado1, lado2, lado3, otrola1, otrola2, otrola3;
*/

	public User(PApplet app, String nickname, String fecha, String password){
		
		fechas = fecha.split("-");
		a = Integer.parseInt(fechas[2]);
		this.app= app; 
		this.nickname = nickname; 
		this.password = password; 
		this.fecha = fecha;
		posx = 350; 
		posy = 400;
		pokedex = new  LinkedList<Pokemon>(); 
		npokeballs = 200;
		font = app.createFont("Fuentes/Pokemon" + " " + " X" + " " + " and" + " " + " Y.tff", 20);

		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		
	}

	
	public int getA() {
		return a;
	}


	public void setA(int a) {
		this.a = a;
	}


	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void pintar() {
		app.fill(255);
		app.ellipse(posx, posy, 20, 20);
		
	}
	//Metodo hecho para pintar la informacion del los usuarios en la pantLL de historial de usuarios
	public void pintarUserOrdenados(int posy) {
		
		app.textFont(font);
		//this.posx = 78;
    	app.text(nickname, 88,posy);
    	app.text(password, 483,posy);
    	app.text(fecha, 295, posy);
		
	}
	
	public void moverse(int k, int[][] matriz) {
		int fila= app.width/34; 
		int col = app.height/19; 
		if(k == app.CODED) { //ARRIBA
			if(app.keyCode == app.UP &&posy-10 >0) {
					if(matriz[(int)(posy-10)/col][(int)(posx)/fila]==1||
							matriz[(int)(posy-10)/col][(int)(posx)/fila]==2) {
						posy-=10; 
						derecha= false;
						izquierda = false;
						abajo = false;
						arriba = true;
						//System.out.println(derecha +" "+ izquierda +" "+abajo +" "+ arriba + "ARIBA");
					}
					}
		}
		if(k == app.CODED) { //ABAJO
			if(app.keyCode == app.DOWN && posy + 10 <app.height) {
				if(matriz[(int)(posy+10)/col][(int)(posx)/fila]==1||
						matriz[(int)(posy+10)/col][(int)(posx)/fila]==2) {
					posy+=10;
					arriba = false;
					derecha = false;
					izquierda = false;
					abajo = true;
					//System.out.println(derecha +" "+ izquierda +" "+abajo +" "+ arriba + "ABAJO");

				}
					
			}
		}
		if(k == app.CODED) { //IZQUIERDA
			if(app.keyCode == app.LEFT)  {
				if( matriz[(int)(posy)/col][(int)(posx-10)/fila]==1 || 
						matriz[(int)(posy)/col][(int)(posx-10)/fila]==2) {
					posx-=10;
					arriba= false;
					derecha = false;
					abajo = false;
					izquierda = true;
					//System.out.println(derecha +" "+ izquierda +" "+abajo +" "+ arriba + " IZQ");

				}
				 
					
			}
		}
		if(k == app.CODED) { //DERECHA
			if(app.keyCode == app.RIGHT ) {
				if( matriz[(int)(posy)/col][(int)(posx+10)/fila]==1||
						matriz[(int)(posy)/col][(int)(posx+10)/fila]==2) {
					posx+=10; 
					izquierda = false;
					arriba = false;
					abajo = false;
					derecha = true;
					//System.out.println(derecha +" "+ izquierda +" "+abajo +" "+ arriba + " DERE");

				}
			}	
		}
		
	
		
		


	
		
	}
	

	public int getConta() {
		return conta;
	}


	public void setConta(int conta) {
		this.conta = conta;
	}


	public int getNpokeballs() {
		return npokeballs;
	}


	public void setNpokeballs(int npokeballs) {
		this.npokeballs -= npokeballs;
	}


	private int keyIsDown(int left) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void atacar() {
		
	}

	public int compareTo(User o1) {
		return this.a - o1.getA();
	}
	
	// gets y sets	
	//-----------------------------------------------------	

	public boolean isToco() {
		return toco;
	}

	public void setToco(boolean toco) {
		this.toco = toco;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getFechadeRegistro() {
		return fechadeRegistro;
	}

	public void setFechadeRegistro(Date fechadeRegistro) {
		this.fechadeRegistro = fechadeRegistro;
	}

	public LinkedList<Pokemon> getPokedex() {
		return pokedex;
	}

	public void setPokedex(LinkedList<Pokemon> pokedex) {
		this.pokedex = pokedex;
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
	 public boolean isDerecha() {
		return derecha;
	}

	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}

	public boolean isArriba() {
		return arriba;
	}

	public void setArriba(boolean arriba) {
		this.arriba = arriba;
	}

	public boolean isAbajo() {
		return abajo;
	}

	public void setAbajo(boolean abajo) {
		this.abajo = abajo;
	}

	public boolean isIzquierda() {
		return izquierda;
	}

	public void setIzquierda(boolean izquierda) {
		this.izquierda = izquierda;
	}
	
	

}
