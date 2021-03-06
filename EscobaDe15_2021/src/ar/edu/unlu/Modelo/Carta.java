package ar.edu.unlu.Modelo;

public class Carta {
	private Integer numero;
	private Palo palo;
	
	
	//Constructor
	public Carta(Integer numero, Palo palo) {
		this.setNumero(numero);
		this.setPalo(palo);
	}
	
	//getters & setters
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Palo getPalo() {
		return palo;
	}
	public void setPalo(Palo palo) {
		this.palo = palo;
	}

	
	//metodo para mostrar una carta
	
	public String mostrarCarta() {
		return "[" + numero + " de " + palo + "]";		//retorna un String con la informacion de la carta
	}
	
	
	
	

}
