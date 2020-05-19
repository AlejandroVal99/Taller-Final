package view;

import processing.core.PApplet;
import controlP5.*;

public class MainView extends PApplet {

	int screen;
	private ControlP5 cp5;
	RegisterScreen regisScreen;
	IntroScreen introScreen;

	public static void main(String[] args) {
		PApplet.main("view.MainView");

	}

	public void settings() {
		size(816, 480);
		smooth(4);

	}

	public void setup() {
		screen = 0; 
		cp5 = new ControlP5(this);
		regisScreen = new RegisterScreen(this);
		introScreen = new IntroScreen(this);
		
	
		regisScreen.creo();
		regisScreen.inputs("name", 20);
		regisScreen.inputs("correo", 20 + 20 * 3);
		regisScreen.escondoInput(1, "name");
		regisScreen.escondoInput(1, "correo");

		// cargar imagenes de las clases
		introScreen.cargaImagenesIS();
		regisScreen.cargaImagenesRS();
	}

	public void draw() {

		switch (screen) {

		case 0: // pantalla intro
			
			background(0, 20, 0);
			introScreen.drawIntro();
			fill(255);
			textSize(50);
			text("X: " + mouseX + " Y: " + mouseY, mouseX, mouseY);
			break;
		case 1:// pantalla loggeo
			background(0, 0, 255);
			
			break;
		case 2: // pantalla registro
			background(0, 200, 30);
			
			regisScreen.drawRegister();
			break;
		case 3:
			background(200, 20, 50);
			regisScreen.muestroInput(1, "name");
			regisScreen.muestroInput(1, "correo");
			regisScreen.test();
			break;
		case 4:
			background(30, 20, 0);
			regisScreen.escondoInput(1, "name");
			regisScreen.escondoInput(1, "correo");
			break;
		case 5:
			background(40, 203, 0);
			break;
		case 6:
			background(20, 20, 200);
			break;
		case 7:
			
			background(100, 20, 0);
			break;
		case 8:
			
			background(190, 20, 200);
			break;
		case 9:
			background(255, 255, 0);
			break;
		default:
			background(255, 255, 0);

			break;
		}
		if (screen == 3) {

		}

	}

	public void keyPressed() {

		switch (screen) {

		case 0:
		

			break;
		case 1:

			break;
		case 2:
			
			break;
		case 3:
			if (key == ENTER) {
				regisScreen.getInfo();
				System.out.println("enter");
			}
			regisScreen.moverPersonaje(key);

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		case 7:

			break;
		case 8:

			break;
		case 9:

			break;

		default:

			break;
		}

	}

	public void mousePressed() {

		switch (screen) {

		case 0:
			if (mouseX > 305 && mouseX < 508 && mouseY > 292 && mouseY < 348) {
				screen = 1;// pasa a pantalla loggeo
			}
			if (mouseX > 305 && mouseX < 508 && mouseY > 368 && mouseY < 420) {
				screen = 2;// pasa a pantalla-video de registro
			}
			break;
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		case 7:

			break;
		case 8:

			break;
		case 9:

			break;

		default:

			break;
		}

		System.out.println(screen);
		//screen++;
		if (screen >= 10) {
			screen = 10;

		}

	}

	public void mouseMoved() {
		switch (screen) {

		case 0:
			if (mouseX > 305 && mouseX < 508 && mouseY > 292 && mouseY < 348) {
				introScreen.setPaso(true);
			} else {
				introScreen.setPaso(false);
			}
			if (mouseX > 305 && mouseX < 508 && mouseY > 368 && mouseY < 420) {
				introScreen.setPaso2(true);
			} else {
				introScreen.setPaso2(false);
			}
			break;
		case 1:

			break;
		}

	}
}