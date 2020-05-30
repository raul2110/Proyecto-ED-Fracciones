package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamHeaderLess extends ObjectOutputStream{

	public ObjectOutputStreamHeaderLess(OutputStream out) throws IOException {
		super(out);
	}
		
	public void writeStreamHeader() {
			
	}
		
}
