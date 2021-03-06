package ar.edu.unlu.Modelo;

import java.util.List;

import ar.edu.unlu.Controlador.EventosEscoba;

public interface Observador {
	void notificarEvento(EventosEscoba evento);
	void notificarMensaje(String mensaje);
	void notificarTurno(String nombre);
	void notificarCartasDeLaMesa(List<Carta> cartas);
	void notificarCartasJugador(List<Carta> cartas);
	void notificarGanador(Jugador jugador);
}
