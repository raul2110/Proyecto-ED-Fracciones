package fracciones;

import java.util.ArrayList;

public class MultiplicacionYDivisionFracciones {

	public static Fraccion Multiplicacion(ArrayList<Fraccion> fracciones) {
		
		int num = 1, den = 1;
		
		for(Fraccion f:fracciones) {
			num *= f.getNumerador();
			den *= f.getDenominador();
		}
		
		Fraccion fraccion = new Fraccion(num, den);
		
		//fraccion = SimplificarFracciones.Simplificar(fraccion);
		return fraccion;
	}
	
	public static Fraccion Multiplicacion(Fraccion f1, Fraccion f2) {
		
		ArrayList<Fraccion> fracciones = new ArrayList<>();
		
		fracciones.add(f1);
		fracciones.add(f2);
		
		return Multiplicacion(fracciones);
	}
	
	public static Fraccion Division(ArrayList<Fraccion> fracciones) {
		
		int num = 1, den = 1;
		
		for(int i=0; i<fracciones.size(); i++) {
			if(i == 0) {
				num = fracciones.get(i).getNumerador();
				den = fracciones.get(i).getDenominador();
			}
			else if(i%2 != 0){
				num *= fracciones.get(i).getDenominador();
				den *= fracciones.get(i).getNumerador();
			}
			else {
				num *= fracciones.get(i).getNumerador();
				den *= fracciones.get(i).getDenominador();
			}
		}
		
		Fraccion fraccion = new Fraccion(num, den);
		
		return fraccion;
	}
	
	public static Fraccion Division(Fraccion f1, Fraccion f2) {
		
		ArrayList<Fraccion> fracciones = new ArrayList<>();
		
		fracciones.add(f1);
		fracciones.add(f2);
		
		return Division(fracciones);
	}
	
}

















