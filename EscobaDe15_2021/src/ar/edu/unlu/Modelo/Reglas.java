package ar.edu.unlu.Modelo;

import java.util.List;

public class Reglas {
	//private EventosEscoba eventos;
	private Ronda ronda;
	
	public Reglas (Ronda ronda) {
		this.ronda = ronda;
	}
	
	public boolean verificarSuma15(List<Carta> cartas) {
		Integer acumulador = 0; 
		for (Carta carta : cartas) {
			acumulador += carta.getNumero();
		}		
		return (acumulador == 15);
		
	}
	
	// funcion para validar si la carta es el 7 de oro
	public boolean validacion7DeOro(Carta carta) {
		return (carta.getNumero() == 7) && (carta.getPalo() == Palo.ORO);
		}
	
	
	public boolean esFinDeMano(List<Jugador> jugadores) {
		boolean finDeMano = true;
		Integer i = 0;
		while ((i < jugadores.size()) && finDeMano) {
			if (!(jugadores.get(i).cantidadDeCartas() == 0)) 
				finDeMano = false;
			i++;
		}
		return finDeMano;
	}
	
	
	
	public boolean levanto7DeOro(List<Carta> cartasLevantadas) {
		boolean resultado = false;
		Integer i = 0;
		while ((i < cartasLevantadas.size()) && !(resultado)) {
			if (validacion7DeOro(cartasLevantadas.get(i))){
				resultado = true;
			}
			i++;
		}
		return resultado;
	}
	
	



	
	
	
	//Funcion privada para sumar los puntos de la setenta, que va a ser invocada en el metodo ActualizarPuntos()
		public void sumarPuntoPorSetenta(List<Jugador> jugadores) {
			//Integer[] arrayDe7 = { 0, 0, 0, 0 };
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
						ronda.sumarPuntoJugador(jugadores.get(indice));
						ronda.sumarPuntoJugador(jugadores.get(indice)); 
					} else
						ronda.sumarPuntoJugador(jugadores.get(indice));
					
				} /*else
					arrayDe7[indice] = cantidadDe7; */
				indice++;

			}

		/*	if (bandera) {
				if (arrayDe7[0] == 2 && !(arrayDe7[1] == 2 || arrayDe7[2] == 2 || arrayDe7[3] == 2)) {
					ronda.sumarPuntoJugador(jugadores.get(0));
				} else if (arrayDe7[1] == 2 && !(arrayDe7[0] == 2 || arrayDe7[2] == 2 || arrayDe7[3] == 2)) {
					ronda.sumarPuntoJugador(jugadores.get(1));
				} else if (arrayDe7[2] == 2 && !(arrayDe7[0] == 2 || arrayDe7[1] == 2 || arrayDe7[3] == 2)) {
					ronda.sumarPuntoJugador(jugadores.get(2));
				}else if (arrayDe7[3] == 2 && !(arrayDe7[0] == 2 || arrayDe7[1] == 2 || arrayDe7[2] == 2)) {
					ronda.sumarPuntoJugador(jugadores.get(3));
				}
			} */
		}



	
}
