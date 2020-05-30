package objects;

import java.io.Serializable;

import fracciones.Fraccion;
import fracciones.MultiplicacionYDivisionFracciones;
import fracciones.SumaYRestaFracciones;

public class ExerciseSumResMultDiv implements Serializable{

	Fraccion f1, f2, resultado;
	
	TypeOfExercise tipoDeEjercicio;
	
	public ExerciseSumResMultDiv(Fraccion f1, Fraccion f2) {
		this.f1 = f1;
		this.f2 = f2;
	}

	public Fraccion getF1() {
		return f1;
	}
	public void setF1(Fraccion f1) {
		this.f1 = f1;
	}
	public Fraccion getF2() {
		return f2;
	}
	public void setF2(Fraccion f2) {
		this.f2 = f2;
	}
	public Fraccion getResultado() {
		return resultado;
	}
	public void setResultado(Fraccion resultado) {
		this.resultado = resultado;
	}
	public TypeOfExercise getTipoDeEjercicio() {
		return tipoDeEjercicio;
	}
	public void setTipoDeEjercicio(TypeOfExercise tipoDeEjercicio) {
		this.tipoDeEjercicio = tipoDeEjercicio;
		
		Fraccion res = SumaYRestaFracciones.Suma(f1, f2);
		 
		if(tipoDeEjercicio.equals(TypeOfExercise.RESTA)){
			res = SumaYRestaFracciones.Resta(f1, f2);
		}else if(tipoDeEjercicio.equals(TypeOfExercise.MULTIPLICACION)) {
			res = MultiplicacionYDivisionFracciones.Multiplicacion(f1, f2);
		}else if(tipoDeEjercicio.equals(TypeOfExercise.DIVISION)) {
			res = MultiplicacionYDivisionFracciones.Division(f1, f2);
		}
	
		resultado = res;
	}
	
}



























