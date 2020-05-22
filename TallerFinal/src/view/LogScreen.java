package view;

import conntroller.MainContro;
import processing.core.PApplet;
import processing.core.PImage;

public class LogScreen {

	private PApplet app;
	private MainContro mainContro;
	private PImage log;
	
	public LogScreen(PApplet app) {
		mainContro = new MainContro(app);
		this.app = app;
	}
	
	public void cargaImagenesLS() {
		this.log = app.loadImage("Imagenes/Registro/Login.jpg");
	}
	public void drawLog() {
		app.image(this.log,0,0);
	}

}
