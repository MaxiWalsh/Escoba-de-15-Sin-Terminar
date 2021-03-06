package ar.edu.unlu.Modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
	private List<Carta> cartas = new ArrayList<>();
	//private int cantidadDeCartas;
	
	public Mesa() {
		
	}

	
	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public List<Carta> getCartas(){
		return this.cartas;
	}
	
	
	public void mostrarCartas() {
		for (Carta carta : cartas) {
			System.out.println(carta.mostrarCarta());
		}			
	}
	
	
	
	public List<Carta> juntarCartas(ArrayList<Integer> cartas){
		List<Carta> resultado = new ArrayList<>();
		for (Integer i=0; i<cartas.size(); i++) {
			resultado.add(this.cartas.get(cartas.get(i)));
		}
		
		return resultado;
		
	}
	
	public void sacarCartas(List<Carta> cartas) {
		//this.cartas.removeAll(cartas);
		
		for (Carta carta : cartas) {
			this.cartas.remove(carta);
		}
		
	}
	
	
	public void limpiarMesa(){
		this.cartas.clear();
	}
	
	//funcion para agregar cartas a la mesa
	public void agregarCarta(Carta carta) {
		this.cartas.add(carta);							//agrega la carta a la mesa
	}


	public Integer cantidadDeCartas() {
		return this.cartas.size();
	}
	
	
}
