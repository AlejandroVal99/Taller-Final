package view;

import conntroller.MainContro;
import controlP5.ControlP5;
import controlP5.Textfield;
import exceptions.PasswordException;
import exceptions.UserException;
import processing.core.PApplet;
import processing.core.PImage;

public class LogScreen {
	private ControlP5 cp5;
	private PApplet app;
	private MainContro mainContro;
	private PImage log;
	
	public LogScreen(PApplet app) {
		mainContro = new MainContro(app);
		this.app = app;
		cp5 = new ControlP5(app);
	}
	
	public void cargaImagenesLS() {
		this.log = app.loadImage("Imagenes/Registro/Login.jpg");
	}
	public void drawLog() {
		app.image(this.log,0,0);
	}
	
	//@ esto me crea inputs de tipo textfield, recibe el nombre y la posicion en y
		public void inputs(String name, int posy) {

			cp5.addTextfield(name).setPosition(app.width / 2 - 100, posy).setSize(200, 40).setFocus(true)
					.setColor(app.color(255, 255, 0)).setColorActive(app.color(255, 255, 0))
					.setColorBackground(app.color(20, 200, 100)).setColorCaptionLabel(app.color(255, 255, 30))
					.setCaptionLabel(" ");
		}

		// @esconde el input que concuerde con el nombre dado
		public void escondoInput(String name) {
				cp5.get(Textfield.class, name).hide();
		}
		// @esconde el input que concuerde con el nombre dado
		public void muestroInput(int screen, String name) {
			if (screen == 1) {
				cp5.get(Textfield.class, name).show();
			}
		}
		//@este metodo me trae la informacion de los input de logeo
		public void getInfo() throws UserException, PasswordException {
			String userName = cp5.get(Textfield.class, "name").getText();
			String userContra = cp5.get(Textfield.class, "correo").getText();
			mainContro.logInConfirma(userName, userContra);
		}	
}
