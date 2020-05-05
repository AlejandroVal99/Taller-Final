package model;

import java.util.*;

import processing.core.PApplet;


public class Logic {
	private PApplet app; 
	private User usuario; 
	private LinkedList<User> usuariosList;
	private UserNicknameCompare userNick;
	
	
	


	public Logic(PApplet app) {
		this.app= app; 
		usuariosList = new LinkedList<User>();
		
		
		
		
		
		
	}
	
	public void creo() {
		usuario = new User(app, "daniel", "hola123"); 
	}
	
	
	public void test1() {
		usuario.pintar();
		
	}
	

	public void moverPersonaje(char k) {
		usuario.moverse(k);
		
		
	}
	
	

}
