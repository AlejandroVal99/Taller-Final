package view;

import processing.core.PApplet;
import processing.core.PFont;
import controlP5.*;
import exceptions.NoCapturadoException;
import exceptions.pokemonWinException;



public class MainView extends PApplet {

	int screen;
	private ControlP5 cp5;
	private PFont font;
	RegisterScreen regisScreen;
	IntroScreen introScreen;
	GameScreen gameScreen;
	FigthScreen fightScreen;
	PokedexScreen pokedexScreen;
	SelPokemonScreen selPokemonScreen;
	HistorialScreen historialScreen;

	public static void main(String[] args) {
		PApplet.main("view.MainView");

	}

	public void settings() {
		size(816, 480);
		smooth(4);

	}

	public void setup() {
		
		screen = 2;
		font = createFont("Fuentes/Pokemon X and Y.tff",20);
		cp5 = new ControlP5(this);
		regisScreen = new RegisterScreen(this);
		introScreen = new IntroScreen(this);
		gameScreen = new GameScreen(this);
		fightScreen = new FigthScreen(this);
		pokedexScreen = new PokedexScreen(this);
		selPokemonScreen = new SelPokemonScreen(this);
		historialScreen = new HistorialScreen(this);

		// --------Espacio Para Cargar Imagenes De Cada Clase--------------
		fightScreen.cargaFS();
		pokedexScreen.cargaPS();
		regisScreen.cargaImagenesRS();
		gameScreen.cargaImagenesGS();
		selPokemonScreen.cargaImagenesSPS();
		historialScreen.cargaHS();

		regisScreen.inputs("name", 107);
		regisScreen.inputs("correo", 283);
		regisScreen.escondoInput("name");
		regisScreen.escondoInput("correo");

		// cargar imagenes de las clases
		introScreen.cargaImagenesIS();

		// regisScreen.carga3();

	}

	public void draw() {
		textFont(font);
		textSize(20);
		switch (screen) {

		case 0: // pantalla intro

			background(0, 20, 0);
			introScreen.drawIntro();
			break;
		case 1:// pantalla seleccion
			background(0, 0, 255);
			regisScreen.escondoInput("name");
			regisScreen.escondoInput("correo");
			selPokemonScreen.drawSeleccion();
			break;
		case 2: // pantalla registro
			background(0);

			regisScreen.drawRegister();
			regisScreen.muestroInput(1, "name");
			regisScreen.muestroInput(1, "correo");
			fill(0);
			textSize(30);
			text("X: " + mouseX + " Y: " + mouseY, mouseX, mouseY);
			break;
		case 3: // pantalla juego
			background(200, 20, 50);

			gameScreen.drawGame();
			gameScreen.finaltest();
			regisScreen.escondoInput("name");
			regisScreen.escondoInput("correo");
			screen = gameScreen.cambioPantallaChoque();
			
			if(fightScreen.isFalloCap()) {
				//Pa el front
				text("NO LO CAPTURASTE MANCO",150,100);
				
				
			}

			break;
		case 4: // pantalla pelea
			background(30, 20, 0);
			fightScreen.drawFight(gameScreen.cualpokemon());
			
			
			
			
			

			break;
		case 5: // pantalla pokedex
			background(40, 203, 0);
			pokedexScreen.drawPokedex();
			
			break;
		case 6:// pantalla historial
			background(20, 20, 200);
			historialScreen.drawHisto();
			fill(0);
			textSize(30);
			text("X: " + mouseX + " Y: " + mouseY, mouseX, mouseY);
			break;
		case 7:

			background(100, 20, 0);
			break;
		case 8:

			background(190, 20, 200);
			break;
		case 9:
			background(255, 255, 0);
			break;
		default:
			background(255, 255, 0);

			break;
		}
		if (screen == 3) {

		}

	}

	public void keyPressed() {

		switch (screen) {

		case 0:

			break;
		case 1: // pantalla seleccion

			break;
		case 2: // pantalla registro
			/*
			 * if (key == ENTER) { regisScreen.getInfo();
			 * 
			 * }
			 */
			if (key == CODED) {
				if (keyCode == UP) {

				}
			}
			break;
		case 3:// pantalla juego
			gameScreen.mover();
			fightScreen.setFalloCap(false);
			
			if(key == 'p') {
				screen=5;
			}
			if(key == 'h') {
				screen = 6;
			}

			break;
		case 4:

			break;
		case 5://Pantalla pokedex

			break;
		case 6://Pantalla historial

			break;
		case 7:

			break;
		case 8:

			break;
		case 9:

			break;

		default:

			break;
		}

	}

	public void mousePressed() {

		switch (screen) {

		case 0:
			if (mouseX > 285 && mouseX < 529 && mouseY > 312 && mouseY < 387) {
				screen = 2;// pasa a pantalla loggeo
			}
			break;
		case 1:// pantalla loggeo
		
			//El del medio
			if (mouseX > 335 && mouseX < 480 && mouseY > 25 && mouseY < 214) {
				selPokemonScreen.primerPokemon(2);
				screen = 3;// pasa a pantalla de juego -FUEGO
			}
			//El de la izq
			if (mouseX > 146 && mouseX < 260 && mouseY > 9 && mouseY < 158) {
				selPokemonScreen.primerPokemon(1);
				screen = 3;// pasa a pantalla de juego - AGUA
			}
			//El de la derecha
			if (mouseX > 555 && mouseX < 670 && mouseY > 9 && mouseY < 158) {
				selPokemonScreen.primerPokemon(0);
				screen = 3;// pasa a pantalla de juego - HIERBA
			}
			break;
		case 2:// pantalla registro
			regisScreen.contadorRS();
			if ((mouseX > 678 && mouseX < 803 && mouseY > 431 && mouseY < 484)) {
				regisScreen.getInfo();
				screen = 1;// pasa a pantalla loggeo
			}
			break;
		case 3:// pantalla juego
			
			break;
		case 4:// pantalla pelea
			
			
			//Habilidad Uno
			if (mouseX > 59  && mouseX < 179 && mouseY > 368 && mouseY < 404) {
				fightScreen.ataqueUser(1,gameScreen.cualpokemon() );
				
				
			}
			
			//Habilidad Dos
			if (mouseX > 305 && mouseX < 431 && mouseY > 368 && mouseY < 404) {
				fightScreen.ataqueUser(2,gameScreen.cualpokemon() );
			}
			
			
			
			
			if (mouseX > 536 && mouseX < 587 && mouseY > 413 && mouseY < 455) {
				fightScreen.testRun(gameScreen.cualpokemon());
				screen = 3;
				fightScreen.setContador1(1);
				System.out.println("RUN");
			}
			if (mouseX > 661 && mouseX < 777 && mouseY > 362 && mouseY < 405) {
				//fightScreen.testCap('r', gameScreen.cualpokemon());
				if (fightScreen.testCap('r',gameScreen.cualpokemon()) ) {
					screen = 3;
					fightScreen.setContador1(1);
				System.out.println("CAPTUREE");
			}
			}
			if(mouseX > 537 && mouseX < 608 && mouseY > 363 && mouseY < 405) {
				fightScreen.setDos(true);
			}else if((mouseX > 536 && mouseX < 587 && mouseY > 413 && mouseY < 455) || (mouseX > 661 && mouseX < 777 && mouseY > 362 && mouseY < 405)) {
				fightScreen.setDos(false);

			}

			break;
		case 5:// pantalla pokedex
			if (mouseX > 216 && mouseX < 316 && mouseY > 426 && mouseY < 459) {
				pokedexScreen.ordenNombrePoke();
			}
			if (mouseX > 329 && mouseX < 429 && mouseY > 426 && mouseY < 459) {
				pokedexScreen.ordenTipo();
			}
			if (mouseX > 5 && mouseX < 103 && mouseY > 376 && mouseY < 410) {
			screen = 3; //boton back
			}
			break;
		case 6:// pantalla historial
			if (mouseX > 668 && mouseX < 760 && mouseY > 140 && mouseY < 202) {
				historialScreen.ordenFecha();
			}
			if (mouseX > 668 && mouseX < 760 && mouseY > 252 && mouseY < 314) {
				historialScreen.ordenNick();
			}
			if (mouseX > 677 && mouseX < 767 && mouseY > 394 && mouseY < 424) {
				
				screen = 3; //boton back
			}
			break;
		case 7:

			break;
		case 8:

			break;
		case 9:

			break;

		default:

			break;
		}

		System.out.println(screen);

		if (screen >= 10) {
			screen = 10;

		}

	}

	public void mouseMoved() {
		switch (screen) {

		case 0:
			if (mouseX > 305 && mouseX < 508 && mouseY > 292 && mouseY < 348) {
				introScreen.setPaso(true);
			} else {
				introScreen.setPaso(false);
			}
			break;
		case 1:// pantalla seleccion
				// Torchic
			if (mouseX > 335 && mouseX < 480 && mouseY > 25 && mouseY < 214) {
				selPokemonScreen.setTorchi(true);
			} else {
				selPokemonScreen.setTorchi(false);
			}
			// Mudkip
			if (mouseX > 146 && mouseX < 260 && mouseY > 9 && mouseY < 158) {
				selPokemonScreen.setMud(true);
			} else {
				selPokemonScreen.setMud(false);
			}
			// Treecko
			if (mouseX > 555 && mouseX < 670 && mouseY > 9 && mouseY < 158) {
				selPokemonScreen.setTree(true);
			} else {
				selPokemonScreen.setTree(false);
			}
			break;
			
		case 4:
			if (mouseX > 59 && mouseX < 179 && mouseY > 368 && mouseY < 404) {
				fightScreen.setH1(true);
			} else {
				fightScreen.setH1(false);			
			}
			if (mouseX > 305 && mouseX < 431 && mouseY > 368 && mouseY < 404) {
				fightScreen.setH2(true);
			} else {
				fightScreen.setH2(false);			
			}
		break;
		}

	}

}