package model;

import java.util.*;

import exceptions.PasswordException;
import exceptions.UserException;
import processing.core.PApplet;

public class Logic {
	private PApplet app;
	// private User usuario;
	private String infoPokemons[];
	private LinkedList<User> usuariosList;
	private LinkedList<Pokemon> pokemonList;
	private UserNicknameCompare userNick;
	private PokemonTipoCompare pokemonTipo;
	private User userActivo;
	// Variable de tamaño de cada reacudro tamaño del liezno divido columnas
	private int tamSquad;
	// Variable del juego nunca va a cambiar
	private int mapaJuego[][] =

			{ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1, 1, 3, 3, 3, 3, 3, 0, 0, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 1, 1, 1, 1, 1, 0, 0, 2, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 1, 1, 1, 1, 3, 3, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 0, 0, 2, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0 }

			};

	public Logic(PApplet app) {

		this.app = app;
		infoPokemons = app.loadStrings("../TallerFinal/Informacion/pokemones.txt");
		usuariosList = new LinkedList<User>();
		pokemonList = new LinkedList<Pokemon>();
		userNick = new UserNicknameCompare();
		pokemonTipo = new PokemonTipoCompare();

		tamSquad = app.height / 20;

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
			} else if (infoPokemons[1].equals("Fuego")) {
				pokemonList.add(new Fuego(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy));
			} else {
				pokemonList.add(new Hierva(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy));
			}

		}
	}

	public void registrarmetodo(String name, String contrasena) {
		usuariosList.add(new User(app, name, contrasena));

		for (int i = 0; i < usuariosList.size(); i++) {
			System.out.println(usuariosList.get(i).getNickname() + "  " + usuariosList.size());
			System.out.println(usuariosList.get(i).getPassword() + "  " + usuariosList.size());
			System.out.println("----------------------------------------------------------");

		}

	}

	// Metodo que recorre todos los usuarios para ver si existe ese usaurio y con
	// esa contraseña y lo iguala a usaurioActivo, para seguir trabajando mediante
	// ese

	public boolean logInConfirma(String name, String contrasena) throws UserException, PasswordException {
		usuariosList.add(new User(app, name, contrasena));

		for (int i = 0; i < usuariosList.size(); i++) {

			if (name.equals(usuariosList.get(i).getNickname())
					&& contrasena.equals(usuariosList.get(i).getPassword())) {
				return true;
			} else {
				
				if (!name.equals(usuariosList.get(i).getNickname())) {

					throw new UserException("Usuario equivocado");
					

				} else if (!contrasena.equals(usuariosList.get(i).getPassword())) {
					throw new UserException("Contraseña equivocado");
					
				}

			}

		}
		return false;

	}

	// Metodo que valida la posicion del personaje dentro de la matriz
	// para ver si se puede mover y despues enviarle al metodo de
	// usar mover, si undieron
	public void moverPersonaje(char e) {
		/*
		 * if (e == 'd') {
		 * 
		 * if (( + tamSquad < width) && (arr[py][px + 1] == 0) || (yo.posx + tamSquad <
		 * width) && (arr[py][px + 1] >=3)) { yo.posx += tamSquad; px++; }
		 * 
		 * } if (e == 'a') { if ((yo.posx - col >= 0) && (arr[py][px - 1] == 0) ||
		 * (yo.posx - col >= 0) && (arr[py][px - 1] >= 3)) { yo.posx -= col; px--; } }
		 * if (e == 'w') { if ((yo.posy - col >= 0) && (arr[py - 1][px] == 0) ||
		 * (yo.posy - col >= 0) && (arr[py - 1][px] >=3)) { yo.posy -= col; py--; } } if
		 * (e == 's') { if ((yo.posy + col <= height) && (arr[py + 1][px] == 0) ||
		 * (yo.posy + col <= height) && (arr[py + 1][px] >=3)) { yo.posy += col; py++; }
		 * }
		 */
	}

	public void creo() {
		// usuario = new User(app, "daniel", "hola123");
	}

	public void test1() {
		// usuario.pintar();

	}

	public boolean areaSensible(int x, int y, int tamx, int tamy) {
		int mouseX = app.mouseX;
		int mouseY = app.mouseY;
		if (mouseX > x && mouseX < x + tamx && mouseY > y && mouseY < y + tamy) {
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
