package view;

import conntroller.GameContro;
import processing.core.PApplet;
import processing.core.PImage;

public class GameScreen {

	private PApplet app;
	private PImage mapa, espal1, espal2, espal3, frente1, frente2, frente3, lado1, lado2, lado3, otrola1, otrola2, otrola3;
	private PImage [] espal, frente, lado, otrola;
	private GameContro gameContro;

	public GameScreen(PApplet app) {
		gameContro = new GameContro(app);
		this.app = app;

	}

	public void cargaImagenesGS() {
		this.mapa = app.loadImage("Imagenes/mapaCuadricula.jpg");
		
		this.espal = new PImage[2];
		this.frente = new PImage[2];
		this.lado = new PImage[2];
		this.otrola = new PImage[2];

		for (int i = 1; i < espal.length; i++) {
			espal[i] = app.loadImage("Imagenes/Personaje/espalda"+i+".png");
		}
		for (int i = 1; i < frente.length; i++) {
			frente[i] = app.loadImage("Imagenes/Personaje/frente"+i+".png");
		}
		for (int i = 1; i < lado.length; i++) {
			lado[i] = app.loadImage("Imagenes/Personaje/lado"+i+".png");
		}
		for (int i = 1; i < otrola.length; i++) {
			otrola[i] = app.loadImage("Imagenes/Personaje/otrola"+i+".png");
		}
		
		
	}

	public void drawGame() {
		app.image(this.mapa,0,0);
		//app.image(this.espal[1],0,0);
	}
	public void moverPersonaje(char e) {
		gameContro.moverPersonaje(e);
	}

}
