package Model;

import java.util.Random;

public class Model {
	int numero;
	public String tentativi = "7";
	public Model() {
	}
	public int getNumero() {
		return numero;
	}
	public String getTentativi() {
		return tentativi;
	}
	public int NumeroDaIndovinare(){
		numero = (new Random()).nextInt(100);
		return numero;
	}
	public boolean IsGuessed(int numeroInserito) {
		boolean guess = false;
		if (numeroInserito == numero) guess = true;
		return guess;
	}
	public boolean altoBasso(int numeroInserito) {
		boolean piuAlto=false;
		if (numeroInserito<numero) piuAlto=true;
		return piuAlto;
	}
	
//	public static void main(String[] args) {0
//	}
}
