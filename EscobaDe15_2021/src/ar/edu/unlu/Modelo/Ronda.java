package ar.edu.unlu.Modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ronda {
	//private List<Jugador> jugadores = new ArrayList<>();
	private Jugador ultimoJugadorEnLevantar;
	private Reglas reglas = new Reglas(this);

	public Ronda() {
	}

	public Jugador getUltimoJugadorEnLevantar() {
		return this.ultimoJugadorEnLevantar;
	}

	public void setUltimoJugadorEnLevantar(Jugador ultimoJugadorEnLevantar) {
		this.ultimoJugadorEnLevantar = ultimoJugadorEnLevantar;
	}


	// fin getters & setters

	// inicio metodos de la clase

	public void actualizarPuntos(List<Jugador> jugadores) {
		sumaPuntoPorCarta(jugadores);
		sumarPuntoPorSetenta(jugadores);
		sumaPuntoPorOro(jugadores);
	}

	
	public boolean comprobarFinDeRonda(Mazo mazo, List<Jugador> jugadores) {
		boolean finDeRonda = true;
		Integer i = 0;
		while ((i < jugadores.size()) && finDeRonda) {
			if (!(jugadores.get(i).cantidadDeCartas() == 0)) 
				finDeRonda = false;
			i++;
		}
		return finDeRonda && mazo.getCartas().size() == 0;
		
	}
	
	public void sumaPuntoPorOro(List<Jugador> jugadores) {
		Integer indice = 0;
		boolean bandera = true;

		while (indice < jugadores.size() && bandera) {
			List<Carta> cartasBaza = jugadores.get(indice).getBaza();
			Integer cantidadDeOro = 0;
			for (Carta carta : cartasBaza) {
				if (carta.getPalo() == Palo.ORO)
					cantidadDeOro++;
			}
			if (cantidadDeOro >= 6) {
				bandera = false;
				if (cantidadDeOro == 10) {
					sumarPuntoJugador(jugadores.get(indice));
					sumarPuntoJugador(jugadores.get(indice)); 
				} else
					sumarPuntoJugador(jugadores.get(indice));
				
			}
			indice++;
		}
	}
	
	
	public void sumaPuntoPorCarta(List<Jugador> jugadores) {
		Integer indice = 0;
		boolean bandera = true;

		while (indice < jugadores.size() && bandera) {
			List<Carta> cartasBaza = jugadores.get(indice).getBaza();
			Integer cantidadDeOro = 0;
			for (Carta carta : cartasBaza) {
				if (carta.getPalo() == Palo.ORO)
					cantidadDeOro++;
			}
			if (cantidadDeOro >= 21) {
				bandera = false;
				sumarPuntoJugador(jugadores.get(indice));
			}
			indice++;
		}
	}
	
	
	
	
	// funcion privada para validar si la carta es el 7 de oro
	private boolean validacion7DeOro(Carta carta) {
		boolean resultado = false;
		if (validacion7(carta) && (carta.getPalo() == Palo.ORO))
			resultado = true;
		return resultado;

	}

	// Funcion privada para ver si la carta es un 7
	private boolean validacion7(Carta carta) {
		boolean resultado = false;
		if (carta.getNumero() == 7)
			resultado = true;
		return resultado;

	}

	
	public void sumarPuntoPorSetenta(List<Jugador> jugadores) {
		Integer indice = 0;
		boolean bandera = true;

		while (indice < jugadores.size() && bandera) {
			List<Carta> cartasBaza = jugadores.get(indice).getBaza();
			Integer cantidadDe7 = 0;
			for (Carta carta : cartasBaza) {
				if (carta.getNumero() == 7)
					cantidadDe7++;
			}
			if (cantidadDe7 >= 3) {
				bandera = false;
				if (cantidadDe7 == 4) {
					sumarPuntoJugador(jugadores.get(indice));
					sumarPuntoJugador(jugadores.get(indice)); 
				} else
					sumarPuntoJugador(jugadores.get(indice));
				
			} 
			indice++;

			}
		}
	
	
	
	
	/*private void sumarPuntoPorSetenta(List<Jugador> jugadores) {
		Integer[] arrayDe7 = { 0, 0, 0, 0 };
		Integer indice = 0;
		boolean bandera = true;

		while (jugadores.get(indice) != null && bandera) {
			List<Carta> cartasBaza = jugadores.get(indice).getBaza();
			Integer cantidadDe7 = 0;
			for (Carta carta : cartasBaza) {
				if (validacion7(carta) == true)
					cantidadDe7++;
			}
			if (cantidadDe7 >= 3) {
				bandera = false;
				if (cantidadDe7 == 4) {
					jugadores.get(indice).incrementarPuntos();
					jugadores.get(indice).incrementarPuntos();
				} else
					jugadores.get(indice).incrementarPuntos();
			} else
				arrayDe7[indice] = cantidadDe7;
			indice++;

		}

		if (bandera) {
			if (arrayDe7[0] == 2 && !(arrayDe7[1] == 2 || arrayDe7[2] == 2 || arrayDe7[3] == 2)) {
				jugadores.get(0).incrementarPuntos();
			} else if (arrayDe7[1] == 2 && !(arrayDe7[0] == 2 || arrayDe7[2] == 2 || arrayDe7[3] == 2)) {
				jugadores.get(1).incrementarPuntos();
			} else if (arrayDe7[2] == 2 && !(arrayDe7[0] == 2 || arrayDe7[1] == 2 || arrayDe7[3] == 2)) {
				jugadores.get(2).incrementarPuntos();
			}else if (arrayDe7[3] == 2 && !(arrayDe7[0] == 2 || arrayDe7[1] == 2 || arrayDe7[2] == 2)) {
				jugadores.get(3).incrementarPuntos();
			}
		}
	}
	*/
	/*public void repartirCartas(Mazo mazo, List<Jugador> jugadores) {
		for(Jugador jugador : jugadores) {
			Integer contador = 1;
			while (contador <= 3) {
				jugador.agregarCartas(mazo.darCarta());
				contador++;
			}
		}
	}
	
	public void darCartasALaMesa(Mazo mazo, Mesa mesa) {
		Integer contador = 1;
		while (contador <= 4) {
			mesa.agregarCarta(mazo.darCarta());
			contador++;
		}
	}
	*/
	
	public void sumarPuntoJugador(Jugador jugador) {
		jugador.incrementarPuntos();
	}

}
