package conntroller;

import model.Logic;
import processing.core.PApplet;

public class PokedexContro {

	private Logic logic;
	private PApplet app;
	
	public PokedexContro(PApplet app) {
		this.app= app; 
		logic = new Logic(app);
	}

}
