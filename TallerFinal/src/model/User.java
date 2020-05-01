package model;

import java.sql.Date;
import java.util.LinkedList;

import processing.core.PApplet;

public class User implements Comparable<User>{

	 PApplet app; 
	 boolean toco; 
	 String password, nickname; 
	 Date fechadeRegistro; 
	 LinkedList<Pokemon> pokedex; 
	 int posx = 200
	 ,posy = 200; 
	
	public User(PApplet app, String nickname, String password){
		this.app= app; 
		this.nickname = nickname; 
		this.password = password; 
		
		
	}
	
	public void pintar() {
		app.ellipse(posx, posy, 20, 20);
		
	}
	public void capturarPokemon() {
		
	}
	public void moverse(char k) {
		
		switch (k) {
		case 'a':
			posx-=10; 
			break;
		case 's':
			posy+=10; 
			break;
			
		case 'd':
			posx+=10; 
			break;
			
		case 'w':
			posy-=10; 
			break;
			
			
			

		default:
			break;
		}
		
	}
	public void atacar() {
		
	}

	public int compareTo(User o) {
		return 0;
	}
	
	// gets y sets

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
