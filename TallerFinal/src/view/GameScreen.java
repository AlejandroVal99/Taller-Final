package view;

import java.util.LinkedList;

import conntroller.GameContro;
import model.User;
import processing.core.PApplet;
import processing.core.PImage;

public class GameScreen {

	private PApplet app;
	private PImage mapa, espal1, espal2, espal3, frente1, frente2, frente3, lado1, lado2, lado3, otrola1, otrola2, otrola3;
	private PImage [] espal, frente, lado, otrola;
	private GameContro gameContro;
	private LinkedList<User> usuariosList; 
	
	//esta parte de codigo es muy muy muy muy importante, este metodo
		//recibe por parametro la lista de usuarios
		// esa lista solo es modificada en el flujo de register
		// entonces, lo que hago es hacer toda operacion que necesite con los usuarios
		//en este metodo, pues en el main, recibira en el parametro el metodo de register screen
		//que retorna la lista de usuarios ya modificada
	public GameScreen(PApplet app, LinkedList<User> usuariosList) {
		gameContro = new GameContro(app);
		this.app = app;
		this.usuariosList= usuariosList; 

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
	
	
	public void finaltest() {
		System.out.println(usuariosList.get(0).getNickname());

		//aqui pinto el usuario en cuestion
		for (int i = 0; i < usuariosList.size(); i++) {
			usuariosList.get(i).pintar();
		
			app.fill(0);
			app.text(usuariosList.get(i).getNickname(), 
					usuariosList.get(i).getPosx(),
					usuariosList.get(i).getPosy());
		}
	}
	public void drawGame() {
		app.image(mapa,0,0);
		//app.image(this.espal[1],0,0);
	}
	
	
	/*public void moverPersonaje(char e) {
		gameContro.moverPersonaje(e);
	}
	*/
	
	public void mover() {
	
		usuariosList.get(0).moverse(app.key);
		
	}
	



}
