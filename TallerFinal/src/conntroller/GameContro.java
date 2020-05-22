package conntroller;

import java.util.LinkedList;

import model.Logic;
import model.User;
import processing.core.PApplet;

public class GameContro {
	
	private Logic logic;
	private PApplet app;
	private RegisterContro regiscontro;
	
	public GameContro(PApplet app) {
		this.app= app; 
		logic = new Logic(app);
		regiscontro = new RegisterContro(app);
	}

	public void moverPersonaje(char e) {
		logic.moverPersonaje(e);
	}
	
	public int[][] getMapaJuego() {
		return logic.getMapaJuego(); 
	}

	

	public void setMapaJuego(int[][] mapaJuego) {
		logic.setMapaJuego(mapaJuego);
	}
	
	
	
	

	


}


