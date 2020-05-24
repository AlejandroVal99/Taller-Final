package view;

import conntroller.MainContro;
import processing.core.PApplet;
import processing.core.PImage;

public class HistorialScreen {

	private MainContro mainContro;
	private PApplet app;
	private PImage historial;

	public HistorialScreen(PApplet app) {
		this.app = app;
		mainContro = new MainContro(app);
	}

	public void cargaHS() {
		this.historial = app.loadImage("Imagenes/Historial.jpg");
	}

	public void drawHisto() {
		app.image(this.historial, 0, 0);
	}

	public void ordenFecha() {
		mainContro.ordenFecha();
	}

	public void ordenNick() {
		mainContro.ordenNick();
	}


}
