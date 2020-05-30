package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.io.Serializable;

import fracciones.MaximoComunDivisor;
import fracciones.minimoComunMultiplo;

public class Exercise_MCD_MCM implements Serializable{

	private TypeOfExercise typeOfExercise;
	private int n1, n2, resultado;
	
	
	public Exercise_MCD_MCM(int n1, int n2){
		this.n1 = n1;
		this.n2 = n2;
	}
	
	
	public TypeOfExercise getTypeOfExercise() {
		return typeOfExercise;
	}
	public void setTypeOfExercise(TypeOfExercise typeOfExercise) {
		this.typeOfExercise = typeOfExercise;
		
		if(typeOfExercise == TypeOfExercise.MCD) {
			resultado = MaximoComunDivisor.GetMaximoComunDivisor(n1, n2);
		}
		else {
			resultado = minimoComunMultiplo.MinimoComunMultiplo(n1, n2);
		}
	}
	public int getN1() {
		return n1;
	}
	public void setN1(int n1) {
		this.n1 = n1;
	}
	public int getN2() {
		return n2;
	}
	public void setN2(int n2) {
		this.n2 = n2;
	}
	public int getResultado() {
		return resultado;
	}
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
}















