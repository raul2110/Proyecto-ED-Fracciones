package fracciones;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class CalculosMatematicos {
	public static boolean esPar(int numero) {
		return numero % 2 == 0;
	}

	public static ArrayList<Integer> divisoresTotales(int n1){
		
		ArrayList<Integer> divisores = new ArrayList<>();
		
		divisores.add(n1);
		
		for(int i=n1/2; i > 0; i--) {
		
			if(n1 % i == 0) {
				divisores.add(i);
			}
		}
		
		return divisores;
	}
	/*
	 * 
	 * Este m�todo se usa para descomponer un n�mero en sus factores primos Genera
	 * un mapa ordenado donde cada clave es un divisor primo del n�mero y cuyo valor
	 * es el n�mero de veces que incluye ese divisor primo.
	 * 
	 */
	public static SortedMap<Integer, Integer> divisores(int numero) {
		SortedMap<Integer, Integer> divisores = new TreeMap<Integer, Integer>();
		int numeroIntermedio = numero;
		Integer divisor = 2;
		while (numeroIntermedio >= divisor) {
			while (numeroIntermedio % divisor == 0) {
				Integer clave = divisor;
				divisores.putIfAbsent(divisor, 0);
				divisores.computeIfPresent(clave, (key, val) -> (val + 1));
				numeroIntermedio = numeroIntermedio / divisor;
			}

			divisor++;
		}
		return divisores;
	}

	public static ArrayList<Integer> listaDePrimosHasta(int numero) {
		ArrayList<Integer> listaDePrimos = new ArrayList<Integer>();
		listaDePrimos.add(1);
		listaDePrimos.add(2);
		listaDePrimos.add(3);
		for (int i = 5; i <= numero; i += 2) {
			if (esPrimo(i))
				listaDePrimos.add(i);
		}
		return listaDePrimos;
	}

	public static int potencia(int base, int exponente) {

		int resul = 1;
		if (exponente > 0)
			resul = base * potencia(base, exponente - 1);
		return resul;
	}

	public static boolean esPrimo(int numero) {

		boolean primo = true;
		int divisor = 3;
		if (numero != 2 && numero % 2 == 0)
			primo = false;
		while (primo && divisor <= Math.sqrt(numero)) {
			if (numero % divisor == 0)
				primo = false;
			divisor += 2;
		}
		return primo;
	}

	public static ArrayList<Integer> DescomposicionPrimos(int n1, ArrayList<Integer> res){
		
		res.add(n1);
		
		if(n1 == 1) {
			return res;
		}
		
		int i = 2;
		
		while(n1%i != 0) {
			i++;
		}
		
		DescomposicionPrimos(n1/=i, res);
		
		return res;
	}
	
}