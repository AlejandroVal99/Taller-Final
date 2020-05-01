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
	
	public User(PApplet app, String nickname, String password){
		this.app= app; 
		this.nickname = nickname; 
		this.password = password; 
		
	}
	
	public void pintar() {
		System.out.println("cree un usuario");
		
	}
	public void capturarPokemon() {
		
	}
	public void moverse(char k) {
		
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
	
	

}
