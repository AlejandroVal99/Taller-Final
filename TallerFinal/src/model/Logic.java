package model;

import java.util.*;

import processing.core.PApplet;

public class Logic {
	private PApplet app;
	//private User usuario;
	private String infoPokemons[];
	private LinkedList<User> usuariosList;
	private LinkedList<Pokemon> pokemonList;
	private UserNicknameCompare userNick;
	private PokemonTipoCompare pokemonTipo;
	private int mapaJuego[][] =
		{
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,2,2,2,1,1,1,1,1,1,1,1,2,2,2,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,2,2,2,2,1,1,1,1,1,1,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,2,2,2,2,2,2,1,1,1,1,1,1,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,2,2,2,2,2,1,1,1,1,1,1,1,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,2,2,1,1,3,3,3,3,3,0,0,2,2,2,2,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,3,3,3,3,3,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,1,3,1,1,1,1,1,0,0,2,2,1,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,2,2,2,2,2,1,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,2,2,2,2,2,2,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,2,2,2,2,2,2,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,2,2,1,1,1,1,3,3,3,3,2,2,2,2,2,1,1,1,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,2,2,2,2,2,1,1,1,1,1,1,1,0,0,2,2,1,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,2,2,2,2,2,2,1,1,1,1,1,1,0,0,2,2,1,1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,2,2,2,2,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,2,2,2,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			
			};

	public Logic(PApplet app) {
		this.app = app;
		infoPokemons = app.loadStrings("../TallerFinal/Informacion/pokemones.txt");
		usuariosList = new LinkedList<User>();
		pokemonList = new LinkedList<Pokemon>();
		userNick = new UserNicknameCompare();
		pokemonTipo = new PokemonTipoCompare();
		System.out.println("Tamaño"+mapaJuego[0].length);
	
		

	}
	

	public void crearPokemones() {
		// TODO Auto-generated method stub
		for (int i = 0; i < infoPokemons.length; i++) {

			String[] datosPokemons = infoPokemons[i].split(",");

			String nombre = datosPokemons[0];
			String tipo = datosPokemons[1];
			int nivel = Integer.parseInt(datosPokemons[2]);
			int dano1 = Integer.parseInt(datosPokemons[3]);
			int dano2 = Integer.parseInt(datosPokemons[4]);
			int xP = Integer.parseInt(datosPokemons[5]);
			int posx = Integer.parseInt(datosPokemons[6]);
			int posy = Integer.parseInt(datosPokemons[7]);


			if (infoPokemons[1].equals("Agua")) {
				pokemonList.add(new Agua(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy));
			}else if (infoPokemons[1].equals("Fuego")) {
				pokemonList.add(new Fuego(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy));
			} else {
				pokemonList.add(new Hierva(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy));
			}

		}
	}
	
	public void registrarmetodo(String name, String contrasena) {
		usuariosList.add(new User(app, name, contrasena)); 
		
		for (int i = 0; i < usuariosList.size(); i++) {
			System.out.println(usuariosList.get(i).getNickname()+"  "+ usuariosList.size());
			System.out.println(usuariosList.get(i).getPassword()+"  "+ usuariosList.size());
			System.out.println("----------------------------------------------------------");
			
			
		}
		
	}
	

	
	public void creo() {
		//usuario = new User(app, "daniel", "hola123");
	}

	public void test1() {
		//usuario.pintar();

	}
	
	public boolean areaSensible (int x, int y, int tamx, int tamy) {
		int mouseX = app.mouseX; 
		int mouseY = app.mouseY; 
		if(mouseX>x && mouseX < x+ tamx
				&& mouseY>y&& mouseY<y+tamy) {
			return true; 
		}
		
		return false; 
		
	}

	
//-------------------------------------------------------------------------------------------
	
	public LinkedList<User> getUsuariosList() {
		return usuariosList;
	}

	public void setUsuariosList(LinkedList<User> usuariosList) {
		this.usuariosList = usuariosList;
	}
	
	

}
