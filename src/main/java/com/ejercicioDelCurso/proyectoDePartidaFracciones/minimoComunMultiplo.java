package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.util.ArrayList;
import java.util.Collections;

public class minimoComunMultiplo {

	public static int MinimoComunMultiplo(ArrayList<Integer> nums){
		
		Collections.sort(nums, Collections.reverseOrder());
		
		return CheckMCM(nums, nums.get(0));
		
	}
	
	public static int MinimoComunMultiplo(int n1, int n2){
		
		ArrayList<Integer> nums = new ArrayList<>();
		
		if(n1 < n2) {
			nums.add(n2);
			nums.add(n1);
		}
		else {
			nums.add(n1);
			nums.add(n2);
		}
		
		return CheckMCM(nums, nums.get(0));
		
	}
	
	private static int CheckMCM(ArrayList<Integer> nums, int mcm){
		
		for(Integer n:nums) {
			if(mcm%n != 0) {
				mcm = CheckMCM(nums, mcm+nums.get(0));
			}
		}
		
		return mcm;
	}
	
}





