package ar.edu.unlu.Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
	private List<Carta> cartas = new ArrayList<>();
	
	//constructor
	
	public Mazo() {
		llenarMazo();
		mezclarMazo();
	}

	
	

	public List<Carta> getCartas() {
		return cartas;
	}
	
	
	//Crea las cartas y llena el mazo
	public void llenarMazo() {
		int i;
		for (i = 1;i <= 10; i++) {
				this.cartas.add(new Carta(i,Palo.BASTO));
				this.cartas.add(new Carta(i,Palo.ESPADA));
				this.cartas.add(new Carta(i,Palo.ORO));
				this.cartas.add(new Carta(i,Palo.COPA));
			}
	}
	
	
	//retorna la cantidad de cartas del mazo
	public int cantidadDeCartas() {
		return this.cartas.size();
	}
	
	
	//Mezcla las cartas del mazo
	public void mezclarMazo() {
		Collections.shuffle(this.cartas);
	}

	
	//Retorna una carta del mazo
	public Carta darCarta() {
			Carta carta = cartas.get(cartas.size() - 1);
			cartas.remove(cartas.size() - 1);
			return carta;
		
	}




	public void limpiar() {
		this.cartas.clear();
		
	}
	
	
	
	
	
	
	
}



