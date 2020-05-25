package model;

import java.util.*;

import exceptions.NoCapturadoException;
import exceptions.pokemonWinException;
import processing.core.PApplet;
import processing.core.PImage;

public class Logic {
	private PApplet app;
	// private User usuario;
	private String infoPokemons[];
	private String infoPokemonSal[];
	private String infoUsuarios[];
	private static LinkedList<User> usuariosList;
	private static LinkedList<Pokemon> pokemonList;
	private static LinkedList<Pokemon> pokemonSalList;
	private UserNicknameCompare userNick;
	private PokemonTipoCompare pokemonTipo;
	private UserNicknameCompare userNickname;
	private int conta;
	private int contacap;
	private Pokemon tocado;

	// Variables de imgs animacion
	private PImage[] espal, frente, lado, otrola;

	// Variable que almacena el usuario que está activo para pedirle la
	// informaciona
	// este
	private static User userActivo;
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
		infoPokemonSal = app.loadStrings("../TallerFinal/Informacion/PokemoneSal.txt");
		infoUsuarios = app.loadStrings("../TallerFinal/Informacion/usuarios.txt");
		usuariosList = new LinkedList<User>();
		pokemonList = new LinkedList<Pokemon>();
		pokemonSalList = new LinkedList<Pokemon>();
		userNick = new UserNicknameCompare();
		pokemonTipo = new PokemonTipoCompare();

		tamSquad = app.height / 20;
		cargaPersoUser();

		contacap = 0;
	}

	public void cargaPersoUser() {
		// System.out.println("entraaa");
		this.espal = new PImage[3];
		this.frente = new PImage[3];
		this.lado = new PImage[3];
		this.otrola = new PImage[3];

		lado[0] = app.loadImage("Imagenes/Personaje/lado1.png");
		lado[1] = app.loadImage("Imagenes/Personaje/lado2.png");
		lado[2] = app.loadImage("Imagenes/Personaje/lado3.png");

		espal[0] = app.loadImage("Imagenes/Personaje/espalda1.png");
		espal[1] = app.loadImage("Imagenes/Personaje/espalda2.png");
		espal[2] = app.loadImage("Imagenes/Personaje/espalda3.png");

		frente[0] = app.loadImage("Imagenes/Personaje/frente1.png");
		frente[1] = app.loadImage("Imagenes/Personaje/frente2.png");
		frente[2] = app.loadImage("Imagenes/Personaje/frente3.png");

		otrola[0] = app.loadImage("Imagenes/Personaje/otrola1.png");
		otrola[1] = app.loadImage("Imagenes/Personaje/otrola2.png");
		otrola[2] = app.loadImage("Imagenes/Personaje/otrola3.png");

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
			int vida = Integer.parseInt(datosPokemons[8]);
			System.out.println(nombre);
			PImage salvaje = app.loadImage("Imagenes/Personaje/otrola1.png");
			//PImage combate = app.loadImage("Imagenes/pokemonsitos/"+ nombre+ "b0.png");

			/*if (datosPokemons[1].equals("Agua")) {
				pokemonList.add(new Agua(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy, vida, salvaje, combate,true));
			} else if (datosPokemons[1].equals("Fuego")) {
				pokemonList.add(new Fuego(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy, vida, salvaje, combate,true));
			} else {
				pokemonList.add(new Hierva(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy, vida, salvaje, combate,true));
			}*/

		}
		// System.out.println(pokemonList.size() +
		// "infopokemoooooooooooooooooooooooooooooon");

		// RecorrerTxt de pokemones Salvajes

		for (int i = 0; i < infoPokemonSal.length; i++) {

			String[] datosPokemons = infoPokemonSal[i].split(",");
			String nombre = datosPokemons[0];
			String tipo = datosPokemons[1];
			int nivel = Integer.parseInt(datosPokemons[2]);
			int dano1 = Integer.parseInt(datosPokemons[3]);
			int dano2 = Integer.parseInt(datosPokemons[4]);
			int xP = Integer.parseInt(datosPokemons[5]);
			int posx = Integer.parseInt(datosPokemons[6]);
			int posy = Integer.parseInt(datosPokemons[7]);
			int vida = Integer.parseInt(datosPokemons[8]);
			//PImage salvaje = app.loadImage("Imagenes/pokemonsitos/"+nombre+"0.png");
			//PImage combate = app.loadImage("Imagenes/pokemonsitos/"+nombre+"b0.png");
			System.out.println(nombre);

			/*if (datosPokemons[1].equals("Agua")) {
				pokemonSalList.add(new Agua(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy, vida, salvaje, combate,false));
			} else if (datosPokemons[1].equals("Fuego")) {
				pokemonSalList.add(new Fuego(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy, vida, salvaje, combate,false));
			} else {
				pokemonSalList.add(new Hierva(nombre, tipo, this.app, dano1, dano2, xP, nivel, posx, posy, vida, salvaje, combate,false));
			}*/

		}

		// Metodo para registrar la info de los usuarios

		for (int i = 0; i < infoUsuarios.length; i++) {
			String[] datosUsu = infoUsuarios[i].split(",");
			String nick = datosUsu[0];
			String fecha = datosUsu[1];
			String nombre = datosUsu[2];
			usuariosList.add(new User(this.app, nick, fecha, nombre));
		}

	}

	public void pintoprueba() {
		for (Pokemon p : pokemonSalList) {
			p.pintar();
			p.moverPokemon(mapaJuego);

		}

		encuentroUserPoke();

		// System.out.println(encuentroUserPoke() + " Me estrelle");
	}

	// @ añade usuarios a la lista
	public void registrarmetodo(String userName, String name) {
		// System.out.println("SISAS MANO");
		usuariosList.addFirst(new User(app, userName, name, name));// ojo con la fecha
		userActivo = usuariosList.get(0);

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

	// -----Orden Pokemones-------
	public void ordenNombrePoke() {
		Collections.sort(pokemonList);
	}

	public void ordenTipo() {
		Collections.sort(pokemonList, pokemonTipo);
	}

	// -------Orden Usuarios---------
	public void ordenNick() {
		Collections.sort(usuariosList, userNick);
	}

	public void ordenFecha() {
		Collections.sort(usuariosList);

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
		if (app.frameCount % 200 == 0) {
			// Falta definir si tendremos una lista de los pokemones que estan dentro del
			// juego
			// REVISARRRRRRR
			pokemonList.get(0).moverPokemon(mapaJuego);
		}

	}

	// Metodo de validacion de la posicion de pokemones con el usuarios, devuelve un
	// boolean

	public boolean encuentroUserPoke() {

		for (Pokemon p : pokemonSalList) {

			if (PApplet.dist(userActivo.getPosx(), userActivo.getPosy(), p.getPosx(), p.getPosy()) <= 15) {
				// System.out.println(p.getTipo() + "el pokemooooonaleta");
				tocado = p;
				return true;

			}

		}
		return false;

	}

	// este metodo conoce que pokemon ha tocado
	public Pokemon cualpokemon() {

		return tocado;

	}

	// elimino al pokemon porque se escapo
	public boolean runPokemon(Pokemon p) {

		pokemonSalList.remove(p);
		System.out.println(pokemonSalList.size() + "hablamos Social");

		return true;

	}

	public boolean capturar(Pokemon p) throws NoCapturadoException {

		// System.out.println(userActivo.getPokedex().size() + "aloo");
		// System.out.println(contacap + "contadorrrrrpapiiiiii");

		if (userActivo.getNpokeballs() > 0) {
			int pCap = (int) app.random(0, 101);
			userActivo.setNpokeballs(1);

			if (pCap > 40) {
				pokemonSalList.remove(p);
				System.out.println("Fallaste cahmaco");
				throw new NoCapturadoException("Fallaste cahmaco");

			} else {
				System.out.println("Probalidad: " + pCap);
				System.out.println("capturado el pokemon");
				contacap++;
				userActivo.getPokedex().add(p);
				System.out.println("Pokemones del usuario: " + userActivo.getPokedex().size());
				pokemonSalList.remove(p);
				return true;
				// System.out.println(userActivo.getPokedex().size() + "aloo");
				// System.out.println(contacap + "contadorrrrrpapiiiiii");

			}

		}
		return false;
	}

	public void ataqueUser(int p, Pokemon j) {

		if (p == 1) {

			if (j.getVida() > 0) {
				j.setVida(userActivo.getPokedex().get(0).getDano1());
			}

		} else if (p == 0) {

			if (j.getVida() > 0) {
				j.setVida(userActivo.getPokedex().get(0).getDano2());
			}
		}

	}

	public void primerPokemon(int r) {

		if (r == 0) {//El del medio
			
			userActivo.getPokedex().add(pokemonList.get(0));

		} else if (r == 1){//EL de la izq
			userActivo.getPokedex().add(pokemonList.get(1));
			

		}else if (r == 2){// El de la der
			
			userActivo.getPokedex().add(pokemonList.get(2));

		}
	}
//-------------------------------------------------------------------------------------------

	public static User getUserActivo() {
		return userActivo;
	}

	public static void setUserActivo(User userActivo) {
		Logic.userActivo = userActivo;
	}

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
			userActivo.moverse(key, mapaJuego);
		}

	}

	public void pintarUsuarios() { 
		// System.out.println(usuariosList.get(0).getNickname());

		// aqui pinto el usuario en cuestion

		if (userActivo != null) {

			// ANIMACION DERECHA
			if (userActivo.isDerecha() == true) {
				app.image(lado[conta], userActivo.getPosx(), userActivo.getPosy());
				if (app.frameCount % 6 == 0) {
					conta++;
					if (conta > 2) {
						conta = 0;
					}
				}
			} /*
				 * else { app.image(frente[0], usuariosList.get(i).getPosx(),
				 * usuariosList.get(i).getPosy()); }
				 */
			// ANIMACION IZQUIERDA
			if (userActivo.isIzquierda() == true) {
				app.image(otrola[conta], userActivo.getPosx(), userActivo.getPosy());
				if (app.frameCount % 6 == 0) {
					conta++;
					if (conta > 2) {
						conta = 0;
					}
				}
			} /*
				 * else { app.image(frente[0], usuariosList.get(i).getPosx(),
				 * usuariosList.get(i).getPosy()); }
				 */
			// ANIMACION ARRIBA
			if (userActivo.isArriba() == true) {
				app.image(espal[conta], userActivo.getPosx(), userActivo.getPosy());
				if (app.frameCount % 6 == 0) {
					conta++;
					if (conta > 2) {
						conta = 0;
					}
				}
			} /*
				 * else{ app.image(frente[0], usuariosList.get(i).getPosx(),
				 * usuariosList.get(i).getPosy()); }
				 */
			// ANIMACION ABAJO
			if (userActivo.isAbajo() == true) {
				app.image(frente[conta], userActivo.getPosx(), userActivo.getPosy());
				if (app.frameCount % 6 == 0) {
					conta++;
					if (conta > 2) {
						conta = 0;
					}
				}
			} /*
				 * else { app.image(frente[0], usuariosList.get(i).getPosx(),
				 * usuariosList.get(i).getPosy()); }
				 */
		}
		// usuariosList.get(i).pintar();
		app.fill(0);
		app.text(userActivo.getNickname(), userActivo.getPosx(), userActivo.getPosy());

	}
}
