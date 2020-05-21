package conntroller;

import model.Logic;
import processing.core.PApplet;

public class GameContro {
	
	private Logic logic;
	private PApplet app;
	
	public GameContro(PApplet app) {
		this.app= app; 
		logic = new Logic(app);
	}

	public void moverPersonaje(char e) {
		logic.moverPersonaje(e);
	}
}


