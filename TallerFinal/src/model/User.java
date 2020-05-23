package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import processing.core.PApplet;

public class User implements Comparable<User>{

	 PApplet app; 
	 boolean toco; 
	 String password, nickname; 
	 Date fechadeRegistro; 
	 SimpleDateFormat dateFormat;
	 LinkedList<Pokemon> pokedex; 
	 int posx
	 ,posy; 
	
	public User(PApplet app, String nickname, String password){
		
		this.app= app; 
		this.nickname = nickname; 
		this.password = password; 
		posx = 350; 
		posy = 400;
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		
	}
	
	public void pintar() {
		app.fill(255);
		app.ellipse(posx, posy, 20, 20);
		
	}
	//Metodo hecho para pintar la informacion del los usuarios en la pantLL de historial de usuarios
	public void pintarUserOrdenados(int posy) {
		
		this.posx = 150;
    	app.text(nickname, posx,posy);
    	app.text(pokedex.size(), posx,posy+50);
    	app.text("Fecha: " + fechadeRegistro, posx, posy+100);
		
	}
	public void capturarPokemon() {
		
	}
	public void moverse(int k, int[][] matriz) {
		int fila= app.width/34; 
		int col = app.height/19; 
		if(k == app.CODED) {
			if(app.keyCode == app.UP &&posy-10 >0) {
					if(matriz[(int)(posy-10)/col][(int)(posx)/fila]==1||
							matriz[(int)(posy-10)/col][(int)(posx)/fila]==2) {
						posy-=10; 
					}
			}
		}
		if(k == app.CODED) {
			if(app.keyCode == app.DOWN && posy + 10 <app.height) {
				if(matriz[(int)(posy+10)/col][(int)(posx)/fila]==1||
						matriz[(int)(posy+10)/col][(int)(posx)/fila]==2) {
					posy+=10;
				}
					
			}
		}
		if(k == app.CODED) {
			if(app.keyCode == app.LEFT ) {
				if( matriz[(int)(posy)/col][(int)(posx-10)/fila]==1 || 
						matriz[(int)(posy)/col][(int)(posx-10)/fila]==2) {
					posx-=10;
				}
				 
					
			}
		}
		if(k == app.CODED) {
			if(app.keyCode == app.RIGHT ) {
				if( matriz[(int)(posy)/col][(int)(posx+10)/fila]==1||
						matriz[(int)(posy)/col][(int)(posx+10)/fila]==2) {
					posx+=10; 
				}
					
			}
		}
		
	
		
		


	
		
	}
	public void atacar() {
		
	}

	public int compareTo(User o) {
		return 0;
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
	
	
	
	

}
