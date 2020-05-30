package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import objects.Exercise_MCD_MCM;
import objects.ObjectOutputStreamHeaderLess;
import objects.TypeOfExercise;

public class JPanelIntroducirMCD extends JPanel{
	
	File ejerciciosMCD = new File("EjerciciosMCD_MCM");
	
	JTextField MCDn1, MCDn2;
	
	public JPanelIntroducirMCD(){
		
		if(ejerciciosMCD.length() == 0){	
			try {
				ejerciciosMCD.createNewFile();
				
				ObjectOutputStream write = 
						new ObjectOutputStream(new FileOutputStream(ejerciciosMCD, true));
				
				write.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		this.setBackground(new Color(255, 204, 255));
		this.setBounds(0, 0, 784, 561);
		this.setLayout(null);	
		
		JLabel lblntroducirEjercicio = new JLabel("Introduzca el ejercicio", SwingConstants.CENTER);
		lblntroducirEjercicio.setBounds(204, 61, 375, 28);
		lblntroducirEjercicio.setFont(new Font("DejaVu Sans", Font.PLAIN, 23));
		this.add(lblntroducirEjercicio);
		
		MCDn1 = new JTextField(SwingConstants.CENTER);
		MCDn1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MCDn1.setBounds(204, 146, 150, 100);
		this.add(MCDn1);
		MCDn1.setColumns(10);
		
		MCDn2 = new JTextField(SwingConstants.CENTER);
		MCDn2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MCDn2.setColumns(10);
		MCDn2.setBounds(429, 146, 150, 100);
		this.add(MCDn2);
		
		JButton btnCrearEjercicio = new JButton("Crear Ejercicio");
		btnCrearEjercicio.setBackground(new Color(173, 255, 47));
		btnCrearEjercicio.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnCrearEjercicio.setBounds(265, 325, 253, 53);
		this.add(btnCrearEjercicio);
		
		JLabel lblMCDn1 = new JLabel("num1", SwingConstants.CENTER);
		lblMCDn1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMCDn1.setBounds(230, 275, 100, 14);
		this.add(lblMCDn1);
		
		JLabel lblMCDn2 = new JLabel("num2", SwingConstants.CENTER);
		lblMCDn2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMCDn2.setBounds(461, 275, 100, 14);
		this.add(lblMCDn2);
		
		btnCrearEjercicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				CrearEjercicio();
			}
			
		});
	}
		
	boolean CrearEjercicio() {
		int n2 = Integer.parseInt(MCDn2.getText());
		int n1 = Integer.parseInt(MCDn1.getText());
		
		Exercise_MCD_MCM ejercicio = new Exercise_MCD_MCM(n1, n2);
		
		try {
			ObjectOutputStreamHeaderLess write = 
					new ObjectOutputStreamHeaderLess(new FileOutputStream(ejerciciosMCD, true));
			
				write.writeObject(ejercicio);
			
			write.close();
		} catch (FileNotFoundException e1) {
			return false;
		} catch (IOException e1) {
			return false;
		}
		
		return true;
	}
}


















