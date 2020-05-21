package conntroller;

import model.Logic;
import processing.core.PApplet;

public class FigthContro {

	private Logic logic;
	private PApplet app;
	
	public FigthContro(PApplet app) {
		this.app= app; 
		logic = new Logic(app);
	}

}
