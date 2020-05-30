package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class FileDatabase {

	File database = new File("database");
	
	public FileDatabase() throws IOException {
		if(database.length() == 0) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(database, true));
			oos.close();
		}
	}
	
	public boolean Add(String email, String password, TypeOfUser tipoDeUsuario) 
			throws FileNotFoundException, IOException, ClassNotFoundException {
		
		Credentials uc = new Credentials(email, password, tipoDeUsuario);
		
		MyObjectWriter mow = new MyObjectWriter(new FileOutputStream(database, true));
		
		if(EmailRepeated(uc)) {
			mow.close();
			return false;
		}
		
		mow.writeObject(uc);
		
		mow.close();
		
		return true;
	}
	
	public Credentials Enter(String email, String password) 
			throws FileNotFoundException, ClassNotFoundException, IOException {
		
		Credentials userCredentials = new Credentials(email, password, null);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(database));
		
		boolean seguir = true;
		while(seguir) {
			try {
				Credentials credentials = (Credentials)ois.readObject();
				
				if(credentials.equals(userCredentials)) {
					ois.close();
					return credentials;
				}
				
			}catch(EOFException e) {
				seguir = false;
			}
		}
		
		ois.close();
		return null;
	}
	
	boolean EmailRepeated(Credentials userCredentials) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		if(database.length() <= 4) {
			return false;
		}
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(database));
		
		boolean seguir = true;
		while(seguir) {
			try{
				Credentials credentials = (Credentials)ois.readObject();
			
				if(userCredentials.getEmail().equals(credentials.getEmail())) {
					ois.close();
					return true;
				}
			}catch(EOFException e) {
				seguir = false;
			}
		}
		
		ois.close();
		return false;
	}
	
}

class MyObjectWriter extends ObjectOutputStream{

	public MyObjectWriter(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void writeStreamHeader() throws IOException{
		
	}
	
}






























