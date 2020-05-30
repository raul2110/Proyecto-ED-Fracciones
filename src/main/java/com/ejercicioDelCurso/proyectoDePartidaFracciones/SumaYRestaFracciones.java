package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SumaYRestaFracciones {

	static ArrayList<Integer> denominadores = new ArrayList<>();
	static int mcm;
	static int numerador = 0;
	
	public static Fraccion Suma(ArrayList<Fraccion> fracciones) { 
		
		SetUp(fracciones);
		
		numerador = 0;
		
		for(Fraccion f:fracciones) {
			int multiplicador = mcm/f.getDenominador();
			numerador += f.getNumerador()*multiplicador;
		}
		
		Fraccion resultado = new Fraccion(numerador, mcm);
		
		return resultado ;
	}
	
	public static Fraccion Suma(Fraccion f1, Fraccion f2) {
		
		ArrayList<Fraccion> fracciones = new ArrayList<>();
		
		fracciones.add(f1);
		fracciones.add(f2);
		
		return Suma(fracciones);
		
	}
	
	public static Fraccion Resta(ArrayList<Fraccion> fracciones) { 
		
		SetUp(fracciones);
		
		for(int i=0; i<fracciones.size(); i++) {
			int multiplicador = mcm/fracciones.get(i).getDenominador();
			
			int numRes = fracciones.get(i).getNumerador()*multiplicador;
			
			if(i == 0) {
				numerador = numRes;
			}
			else {
				numerador -= numRes;
			}
		}
		
		Fraccion resultado = new Fraccion(numerador, mcm);
		
		return resultado ;
	}
	
	public static Fraccion Resta(Fraccion f1, Fraccion f2) {
		
		ArrayList<Fraccion> fracciones = new ArrayList<>();
		
		fracciones.add(f1);
		fracciones.add(f2);
		
		return Resta(fracciones);
		
	}
	
	static void SetUp(ArrayList<Fraccion> fracciones) {
		denominadores.clear();
		
		for(Fraccion d:fracciones) {
			denominadores.add(d.getDenominador());
		}	
		
		mcm = minimoComunMultiplo.MinimoComunMultiplo(denominadores);
	}
	
	
}



























