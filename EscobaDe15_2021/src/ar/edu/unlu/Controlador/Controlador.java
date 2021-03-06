package ar.edu.unlu.Controlador;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlu.Modelo.Carta;
import ar.edu.unlu.Modelo.Estado;
//import ar.edu.unlu.Modelo.EventosEscoba;
import ar.edu.unlu.Modelo.Juego;
import ar.edu.unlu.Modelo.Jugador;
import ar.edu.unlu.Modelo.Observador;
import ar.edu.unlu.Vista.VistaConsola;

public class Controlador implements Observador {
	private Juego juego;
	private VistaConsola vista;
	
	
	public Controlador(VistaConsola vista, Juego Chinchon) {
		this.vista = vista;
		this.juego = Chinchon;
		juego.addObservador(this);
	}
	
	
	@Override
	public void notificarEvento(EventosEscoba evento) {
		switch(evento) {
		case JUEGOINICIADO:
			vista.juegoIniciado();
			break;			
		case MANOFINALIZADA:
			vista.repartir();
			break;
		case RONDAFINALIDAZA:
			vista.puntosActualizados();
			vista.repartir();
			break;
		case JUEGOFINALIZADO:
			vista.finJuego();
			break;
		
		case ESCOBA_DE_MANO:
			vista.notificarEscobaDeMano();
			break;
		}
	}
	@Override
	public void notificarMensaje(String mensaje) {
		vista.notificarMensaje(mensaje);
		
	}
	
	
	public void crearJugador(String nombre) {
		juego.agregarJugador(nombre);
	}
	public void iniciarJuego() {
		juego.iniciarJuego();
		
	}
	
	public Estado conocerEstado() {
		return juego.getEstadoJuego();
	}
	public List<Carta> mostrarCartasMesa() {
		return juego.mostrarCartasMesa();	
	}
	
	public void cambiaTurno() {
		juego.cambiarJugador();
	}
	public Integer getJugadorTurno() {
		return juego.getJugadorActual();
		
	}
	public void tirarCarta(Integer numero) {
		juego.tirarCarta(numero);
		
	}
	public List<Carta> cartasJugadorActual() {
		return juego.cartasJugadorActual();
		
	}
	public void levantarCartas(Integer numero, ArrayList<Integer> cartas) {
		juego.levantarCartas(numero, cartas);
	}
	
	public Integer cantidadCartasJugadorActual() {
		return juego.cantidadCartasJugadorActual();
	}


	public Integer cantidadCartasMesa() {
		return juego.cantidadCartasMesa();
	}

	public String nombreJugadorActual() {
		return juego.nombreJugadorActual();
	}


	public List<Jugador> getJugadores() {
		return juego.getJugadores();
	}


	public Jugador getGanador() {
		return juego.getGanador();
	}


	public void limpiarJuego() {
		juego.limpiarJuego();
	}
	
	public void cartasBazaJugador() {
		juego.cartasBazaJugador();
		
	}


	public String getNombreGanadorRonda() {
		return juego.getNombreGanadorRonda();
	}


	@Override
	public void notificarTurno(String nombre) {
		vista.turno(nombre);
	}


	@Override
	public void notificarCartasDeLaMesa(List<Carta> cartas) {
		vista.mostrarCartasMesa(cartas);
		
	}


	@Override
	public void notificarCartasJugador(List<Carta> cartas) {
		vista.mostrarCartasJugador(cartas);
		
	}


	@Override
	public void notificarGanador(Jugador jugador) {
		vista.mostrarGanador(jugador);
		
	}
	
}
