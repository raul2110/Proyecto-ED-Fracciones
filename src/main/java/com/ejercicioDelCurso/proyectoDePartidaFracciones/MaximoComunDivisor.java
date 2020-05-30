package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class MaximoComunDivisor {

	public static int GetMaximoComunDivisor(int n1, int n2) {
		
		ArrayList<Integer> divisoresN1 = CalculosMatematicos.divisoresTotales(n1);
		ArrayList<Integer> divisoresN2 = CalculosMatematicos.divisoresTotales(n2);
			
		for(int i=0; i<divisoresN1.size(); i++) {
			if(divisoresN2.contains(divisoresN1.get(i))) {
				return divisoresN1.get(i);
			}
		}
		
		return 1;
	}
	
	public static int GetMaximoComunDivisor(ArrayList<Integer> nums) {
		
		ArrayList<Integer> divisores = new ArrayList<>();
		
		Collections.sort(nums);
		
		divisores.addAll(CalculosMatematicos.divisoresTotales(nums.get(0)));
		
		int valid = 0;
		
		for(Integer d:divisores) {
			for(Integer n:nums) {
				if(n%d == 0) {
					valid++;
				}
			}
			
			if(valid == nums.size()) {
				return d;
			}
			valid = 0;
		}
		
		return 1;
	}
	
}

