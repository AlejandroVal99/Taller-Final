package conntroller;

import model.Logic;
import processing.core.PApplet;

public class LogContro {

	private Logic logic;
	private PApplet app;

	public LogContro(PApplet app) {
		this.app= app; 
		logic = new Logic(app);
	}

}
