package conntroller;

import java.util.LinkedList;

import model.Logic;
import model.User;
import processing.core.PApplet;

public class MainContro {

	Logic logic;
	PApplet app;

	public MainContro(PApplet app) {
		this.app = app;
		logic = new Logic(app);

	}

	public void registrarmetodo(String name, String contrasena) {
		logic.registrarmetodo(name, contrasena);

	}

	// ---------
	public LinkedList<User> getUsuariosList() {
		return logic.getUsuariosList();
	}

	public void setUsuariosList(LinkedList<User> usuariosList) {
		logic.setUsuariosList(usuariosList);
	}

	public boolean areaSensible(int x, int y, int tamx, int tamy) {
		return logic.areaSensible(x, y, tamx, tamy);
	}

	// METODOS DE GAME CONTROLLER
	// ------------------------------------------------------------
	/*
	 * public void moverPersonaje(char e) { logic.moverPersonaje(e); }
	 */

	public int[][] getMapaJuego() {
		return logic.getMapaJuego();
	}

	public void setMapaJuego(int[][] mapaJuego) {
		logic.setMapaJuego(mapaJuego);
	}

	public void moverPerso(char key) {
		logic.moverPerso(key);
	}

	public void pintarUsu() {
		logic.pintarUsuarios();
	}
	public void crearPokemones() {
		logic.crearPokemones();
	}
	public void pintoprueba() {
		logic.pintoprueba();
	}



}
