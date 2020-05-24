package model;

import java.util.*;

import exceptions.PasswordException;
import exceptions.UserException;
import processing.core.PApplet;
import processing.core.PImage;

public class Logic {
	private PApplet app;
	// private User usuario;
	private String infoPokemons[];
	private static LinkedList<User> usuariosList;
	private LinkedList<Pokemon> pokemonList;
	private UserNicknameCompare userNick;
	private PokemonTipoCompare pokemonTipo;
	private UserNicknameCompare userNickname;
	private int conta;

	// Variables de imgs animacion
	private PImage[] espal, frente, lado, otrola;

	// Variable que almacena el usuario que está activo para pedirle la
	// informaciona
	// este
	private User userActivo;
	// Variable de tamaño de cada reacudro tamaño del liezno divido columnas
	private int tamSquad;
	// Variable del juego nunca va a cambiar
	private int mapaJuego[][] = // 34x /19y

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
		cargaPersoUser();
	}

	public void cargaPersoUser() {
		System.out.println("entraaa");
		this.espal = new PImage[3];
		this.frente = new PImage[3];
		this.lado = new PImage[3];
		this.otrola = new PImage[3];

		lado [0] = app.loadImage("Imagenes/Personaje/lado1.png");
		lado [1] = app.loadImage("Imagenes/Personaje/lado2.png");
		lado [2] = app.loadImage("Imagenes/Personaje/lado3.png");		
		
		espal [0] = app.loadImage("Imagenes/Personaje/espalda1.png");
		espal [1]= app.loadImage("Imagenes/Personaje/espalda2.png");
		espal [2] = app.loadImage("Imagenes/Personaje/espalda3.png");
		
		frente [0] = app.loadImage("Imagenes/Personaje/frente1.png");
		frente [1] = app.loadImage("Imagenes/Personaje/frente2.png");
		frente [2] = app.loadImage("Imagenes/Personaje/frente3.png");
		
		otrola[0] = app.loadImage("Imagenes/Personaje/otrola1.png");
		otrola[1] = app.loadImage("Imagenes/Personaje/otrola2.png");
		otrola[2] = app.loadImage("Imagenes/Personaje/otrola3.png");
		//System.out.println(otrola[2] + "sh");

		/*for (int i = 1; i < 2; i++) {
			espal[i] = app.loadImage("Imagenes/Personaje/espalda" + i + ".png");
		}
		for (int i = 1; i < frente.length; i++) {
			frente[i] = app.loadImage("Imagenes/Personaje/frente" + i + ".png");
		}
		for (int i = 1; i < 3; i++) {
			lado[i] = app.loadImage("Imagenes/Personaje/lado" + i + ".png");
			System.out.println(lado[0]);

		}
		for (int i = 1; i < otrola.length; i++) {
			otrola[i] = app.loadImage("Imagenes/Personaje/otrola" + i + ".png");
			//System.out.println(otrola[2]);
		}*/
	}

	// Metodo que recorre el TXT con los pokemones y crea los respectivos pokemones

	public void crearPokemones() {
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

			if (datosPokemons[1].equals("Agua")) {
				pokemonList.add(new Agua(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy));
			} else if (datosPokemons[1].equals("Fuego")) {
				pokemonList.add(new Fuego(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy));
			} else {
				pokemonList.add(new Hierva(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy));
			}

		}
		System.out.println(pokemonList.size() + "infopokemoooooooooooooooooooooooooooooon");

	}

	public void pintoprueba() {
		for (Pokemon p : pokemonList) {
			p.pintar();
			p.moverPokemon(mapaJuego);

		}
	}

	// @ añade usuarios a la lista
	public void registrarmetodo(String userName, String name) {
		System.out.println("SISAS MANO");
		usuariosList.add(new User(app, userName, name));

		for (int i = 0; i < usuariosList.size(); i++) {
			System.out.println(usuariosList.get(i).getNickname() + "  " + usuariosList.size());
			System.out.println(usuariosList.get(i).getPassword() + "  " + usuariosList.size());
			System.out.println("----------------------------------------------------------");

		}

	}

	// Metodo que recorre todos los usuarios para ver si existe ese usaurio y con
	// esa contraseña y lo iguala a usaurioActivo, para seguir trabajando mediante
	// ese

	/*
	 * public boolean logInConfirma(String name, String contrasena) throws
	 * UserException, PasswordException {
	 * 
	 * for (int i = 0; i < usuariosList.size(); i++) {
	 * 
	 * if (name.equals(usuariosList.get(i).getNickname()) &&
	 * contrasena.equals(usuariosList.get(i).getPassword())) {
	 * 
	 * System.out.println("SI EXISTE"); return true;
	 * 
	 * } else {
	 * 
	 * if (!name.equals(usuariosList.get(i).getNickname()) && i >=
	 * usuariosList.size()) {
	 * 
	 * throw new UserException("Usuario equivocado");
	 * 
	 * } else if (!contrasena.equals(usuariosList.get(i).getPassword())) { throw new
	 * UserException("Contraseña equivocado");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } return false;
	 * 
	 * }
	 */ // ESTE YA NO SE VA A USARRR

	// @ Metodo que de ser necesaria un area sensible, retorna falso o verdadero
	public boolean areaSensible(int x, int y, int tamx, int tamy) {
		int mouseX = app.mouseX;
		int mouseY = app.mouseY;
		if (mouseX > x && mouseX < x + tamx && mouseY > y && mouseY < y + tamy) {
			return true;
		}

		return false;

	}
	// Metodo para ordenar la lista de Pokemones, va a recibir un entero para saber
	// si
	// será ordenamiento parcial o natural, serán botones en pantalla entonces
	// pondre que reciba 0 y 1

	public void sortPokemon(int i) {
		System.out.println("entre");
		switch (i) {

		case 1:// Nombre

			Collections.sort(pokemonList);

			break;

		case 2:// Tipo
			Collections.sort(pokemonList, pokemonTipo);

			break;
		}
	}
	//-----Orden Pokemones-------
	public void ordenNombrePoke() {
		Collections.sort(pokemonList);
	}
	public void ordenTipo() {
		Collections.sort(pokemonList, pokemonTipo);		
	}

	//-------Orden Usuarios---------
	public void ordenNick() {
		Collections.sort(usuariosList, userNick);
	}
	public void ordenFecha() {
		Collections.sort(usuariosList);

	}

	// Metodo para ordenar la lista de usuarios va a recibir un entero para saber si
	// será ordenamiento parcial o natural, serán botones en pantalla entonces
	// pondre que reicba 0 y 1
	public void sortUsers(int r) { //cambiar por mousePressed
		System.out.println("entre");
		switch (r) {

		case 1:// De acuerdoFecha de inscripcion aún por definirse

			Collections.sort(usuariosList);

			break;

		case 2:// Nickname
			Collections.sort(usuariosList, userNick);

			break;
		}
	}

	// Metodo usado para pinatr la informacion de los pokemones cuando lo pidamos en
	// la pokedex o en general que llama al metodo usado para esto en pokemones
	// VALORES A SUJETOS A CAMBIO
	public void pintarPokemonOrden() {

		for (int j = 0; j < pokemonList.size(); j++) {

			pokemonList.get(j).drawPokemonOrden(j * 50);
			;
		}
	}

	// Metodo usado para pinatr la informacion de los usuarios ordenados, en la
	// pantalla del historial de usaurios que llama al metodo usado para esto en
	// usuarios VALORES A SUJETOS A CAMBIO
	public void pintarUserOrden() {
		for (int r = 0; r < usuariosList.size(); r++) {

			usuariosList.get(r).pintarUserOrdenados(r * 50);
		}
	}

	// Metodo usado para mover los pokemones de forma aleatoria, cada segundo para
	// que no sea muy rapido

	public void moverPokemones() {
		if (app.frameCount % 30 == 0) {
			// Falta definir si tendremos una lista de los pokemones que estan dentro del
			// juego
			// REVISARRRRRRR
			pokemonList.get(0).moverPokemon(mapaJuego);
		}

	}

//-------------------------------------------------------------------------------------------

	public LinkedList<User> getUsuariosList() {
		return usuariosList;
	}

	public void setUsuariosList(LinkedList<User> usuariosList) {
		this.usuariosList = usuariosList;
	}

	public int[][] getMapaJuego() {
		return mapaJuego;
	}

	public int getPosx() {
		return getPosx();
	}

	public void setMapaJuego(int[][] mapaJuego) {
		this.mapaJuego = mapaJuego;
	}

	public void moverPerso(char key) {
		if (usuariosList.size() != 0) {
			usuariosList.get(0).moverse(key, mapaJuego);
		}

	}

	public void pintarUsuarios() {
		// System.out.println(usuariosList.get(0).getNickname());

		// aqui pinto el usuario en cuestion
		for (int i = 0; i < usuariosList.size(); i++) {
			if (usuariosList.get(i) != null) {
				
				//falta validacion de que le undio tal flecha
				app.image(lado[conta],usuariosList.get(i).getPosx(),usuariosList.get(i).getPosy() );
				if(app.frameCount % 6 == 0) {
				    
				    conta++; 
				    if(conta > 2){
				        
				        conta = 0;
				       
				    } 
				}
				usuariosList.get(i).pintar();
				app.fill(0);
				app.text(usuariosList.get(i).getNickname(), usuariosList.get(i).getPosx(),
						usuariosList.get(i).getPosy());

			}

		}
	}

	

	
}
