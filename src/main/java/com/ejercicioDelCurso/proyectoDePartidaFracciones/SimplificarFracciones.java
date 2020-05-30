package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.util.ArrayList;

public class SimplificarFracciones {

	public static Fraccion Simplificar(Fraccion f) {
		MaximoComunDivisor getMcd = new MaximoComunDivisor();
		
		int mcd = getMcd.GetMaximoComunDivisor(f.getDenominador(), f.getNumerador());
		
		f.setDenominador(f.getDenominador() / mcd);
		f.setNumerador(f.getNumerador() / mcd);
		
		return f;
	}
	
	public static ArrayList<Fraccion> Simplificar(ArrayList<Fraccion> fracciones) {
		MaximoComunDivisor getMcd = new MaximoComunDivisor();
		
		ArrayList<Fraccion> simplificadas = new ArrayList<>(); 
		
		for(Fraccion f:fracciones) {
			simplificadas.add(Simplificar(f));
		}		
		
		return simplificadas;
	}
	
}


















