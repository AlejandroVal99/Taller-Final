package view;

import conntroller.LogContro;
import processing.core.PApplet;
import processing.core.PImage;

public class LogScreen {

	private PApplet app;
	private LogContro logContro;
	private PImage log;
	
	public LogScreen(PApplet app) {
		logContro = new LogContro(app);
		this.app = app;
	}
	
	public void cargaImagenesLS() {
		this.log = app.loadImage("Imagenes/Registro/Login.jpg");
	}
	public void drawLog() {
		app.image(this.log,0,0);
	}

}
