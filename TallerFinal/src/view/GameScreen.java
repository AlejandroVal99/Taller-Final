package view;

import java.util.LinkedList;

import conntroller.MainContro;
import model.User;
import processing.core.PApplet;
import processing.core.PImage;

public class GameScreen {

	private PApplet app;
	private PImage mapa, espal1, espal2, espal3, frente1, frente2, frente3, lado1, lado2, lado3, otrola1, otrola2, otrola3;
	private PImage [] espal, frente, lado, otrola;
	private MainContro mainContro;
	private LinkedList<User> usuariosList; 
	
	//esta parte de codigo es muy muy muy muy importante, este metodo
		//recibe por parametro la lista de usuarios
		// esa lista solo es modificada en el flujo de register
		// entonces, lo que hago es hacer toda operacion que necesite con los usuarios
		//en este metodo, pues en el main, recibira en el parametro el metodo de register screen
		//que retorna la lista de usuarios ya modificada
	public GameScreen(PApplet app, LinkedList<User> usuariosList) {
		mainContro = new MainContro(app);
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
	
		System.out.println(mainContro.getMapaJuego()[0][15]+"------------");
		
		
		
	}
	
	
	public void finaltest() {
		//System.out.println(usuariosList.get(0).getNickname());

		//aqui pinto el usuario en cuestion
		for (int i = 0; i < usuariosList.size(); i++) {
			if(usuariosList.get(i)!=null) {
				usuariosList.get(i).pintar();		
				app.fill(0);
				app.text(usuariosList.get(i).getNickname(), 
						usuariosList.get(i).getPosx(),
						usuariosList.get(i).getPosy());
				
			}
		
		}
	}
	public void drawGame() {
	
		app.image(mapa,0,0);
		//app.image(this.espal[1],0,0);
		
		//intento pintar la matriz real
		for (int i = 0; i < 34; i++) {
			for (int j = 0; j < 19; j++) {
				
				switch (mainContro.getMapaJuego()[j][i]) {
				case 0:
					app.fill(255,0,0,80);
					app.stroke(255,255,0);
					
					break;
				case 1:
					app.fill(255,255,255,80);
					app.stroke(0,255,0);
					
					break;
				case 2:
					app.fill(255,0,255,90);
					app.stroke(0,255,255);
					
					break;
				case 3:
					app.fill(0,0,0,80);
					app.stroke(0,0,0);
					
					break;

				default:
					break;
				}
				
				app.rect(i*app.width/34, j*app.height/19, app.width/34, app.height/19);
				
			}
			
		}
		//esto es para conocer la exactaposicion del personaje en la matriz
		int fila= app.width/34; 
		app.text((int)app.mouseX/fila, app.mouseX, app.mouseY+50);
		
		
	}
	
	
	public void mover() {
		if(usuariosList.size()!=0) {
			
			usuariosList.get(0).moverse(app.key,mainContro.getMapaJuego());
		}
		
		
	}
	
	
	



}
