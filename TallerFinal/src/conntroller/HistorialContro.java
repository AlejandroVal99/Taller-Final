package conntroller;

import model.Logic;
import processing.core.PApplet;

public class HistorialContro {
	
	private Logic logic;
	private PApplet app;

	public HistorialContro(PApplet app) {
		this.app= app; 
		logic = new Logic(app);
	}

}
