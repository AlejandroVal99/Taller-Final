package conntroller;

import java.util.LinkedList;

import exceptions.FullPokes;
import exceptions.NoCapturadoException;
import exceptions.pokemonWinException;
import model.Logic;
import model.Pokemon;
import model.User;
import processing.core.PApplet;

public class MainContro {

	Logic logic;
	PApplet app;

	public MainContro(PApplet app) {
		this.app = app;
		logic = new Logic(app);

	}

	public void cargaImaPerso() {
		logic.cargaPersoUser();
	}

	public void registrarmetodo(String userName,String fecha, String name) {
		logic.registrarmetodo(userName,fecha,name);

	}
	public void pintarUserOrden() {
		logic.pintarUserOrden();
	}
	public boolean encuentroUserPoke() {
		return logic.encuentroUserPoke();
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

	public void ordenFecha() {
		logic.ordenFecha();
	}

	public void ordenNick() {
		logic.ordenNick();
	}

	public void ordenNombrePoke() {
		logic.ordenNombrePoke();
	}

	public void ordenTipo() {
		logic.ordenTipo();
	}
	public Pokemon cualpokemon() {
		return logic.cualpokemon(); 
	}
	
	public boolean runPokemon(Pokemon p) {
		return logic.runPokemon(p); 
	}
	
	public boolean capturar(Pokemon p) throws NoCapturadoException {
		return logic.capturar(p); 
	}
	
	public void primerPokemon(int r) {
		logic.primerPokemon(r);
	}
	public void crearPokesal() {
		logic.crearPokeSal();
	}
	
	public LinkedList<Pokemon> getPokemonList() {
		return logic.getPokemonList();
	}

	public void setPokemonList(LinkedList<Pokemon> pokemonList) {
		logic.setPokemonList(pokemonList);
	}

	public void fullPokes() throws FullPokes {
		
		logic.finalBeta();
		
		
	}
	public void pintarPokemonUser() {
		logic.pintarPokUser();
	}
	public void ataqueDelUser(int t,Pokemon p) {
		logic.ataqueUser(t,p);
	}
	
	public void ataquePokemon(int r,Pokemon p) {
		logic.ataquePokemon(r, p);
	}

	public void pintarPokeOrdenados() {
		logic.pintarPokemonOrden();
	}

	
	
	
	
	
	

	/*
	 * public void logInConfirma(String name, String contrasena) throws
	 * UserException, PasswordException { logic.logInConfirma(name, contrasena);
	 * System.out.println(name+"efeeeeee"+contrasena); }
	 */

}
