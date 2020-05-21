package view;

import conntroller.HistorialContro;
import processing.core.PApplet;
import processing.core.PImage;

public class HistorialScreen {
	
	private HistorialContro historialContro;
	private PApplet app;
	private PImage historial;

	public HistorialScreen(PApplet app) {
		this.app = app;
		historialContro = new HistorialContro(app);
	}
	
	public void cargaHS() {
		this.historial = app.loadImage("Imagenes/Historial.jpg");
	}
	
	public void drawHisto() {
		app.image(this.historial,0,0);
	}

}
