package view;

import java.util.LinkedList;

import conntroller.MainContro;
import exceptions.FullPokes;
import model.Pokemon;
import model.User;
import processing.core.PApplet;
import processing.core.PImage;

public class GameScreen {

	private PApplet app;
	private PImage mapa, espal1, espal2, espal3, frente1, frente2, frente3, lado1, lado2, lado3, otrola1, otrola2, otrola3;
	private PImage [] espal, frente, lado, otrola;
	private MainContro mainContro;
	private boolean finalBeta;
	
	//esta parte de codigo es muy muy muy muy importante, este metodo
		//recibe por parametro la lista de usuarios
		// esa lista solo es modificada en el flujo de register
		// entonces, lo que hago es hacer toda operacion que necesite con los usuarios
		//en este metodo, pues en el main, recibira en el parametro el metodo de register screen
		//que retorna la lista de usuarios ya modificada
	public GameScreen(PApplet app) {
		mainContro = new MainContro(app);
		this.app = app;
		finalBeta = false;
 
	}
	

	public void cargaImagenesGS() {
		mainContro.crearPokemones();
		mainContro.crearPokesal();
		
		mainContro.cargaImaPerso();
		this.mapa = app.loadImage("Imagenes/mapaCuadricula.jpg");
		
	
		System.out.println(mainContro.getMapaJuego()[0][15]+"------------");
			
	}
	public void ani() {
		/*app.image(espal[conta],posx, posy);
		if(app.frameCount % 6 == 0) {
		    
		    conta++; 
		    if(conta > 2){
		        
		        conta = 0;
		       
		    } 
		}*/
	}
	public int cambioPantallaChoque() {
		if(mainContro.encuentroUserPoke() ==true) {
			return 4;
	}else {
		return 3;
	}
	}
	
	
	
	public void finaltest() {
		mainContro.pintarUsu();
		mainContro.pintoprueba();
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
		app.text(app.mouseX+" "+app.mouseY, app.mouseX, app.mouseY+50);
		
		if(finalBeta) {
			
			app.text("Final del juego, nos vemos en prodigos",150,200);
		}
		
		
      
		
		
	}
	
	
	public void mover() {
		try {
			mainContro.fullPokes();
		} catch (FullPokes e) {
			// TODO Auto-generated catch block
			
			finalBeta = true;
		}
		mainContro.moverPerso(app.key);
		
	
	}
	
	public Pokemon cualpokemon() {
		return mainContro.cualpokemon(); 
	}
	
	
	



}
