package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fracciones.Fraccion;
import objects.ExerciseSumResMultDiv;
import objects.ObjectOutputStreamHeaderLess;

public class JPanelIntroducirSumResMultDiv extends JPanel{

	File ejercicios = new File("EjerciciosSumResMultDiv");
	
	public JPanelIntroducirSumResMultDiv (){
		
		if(ejercicios.length() == 0){	
			try {
				ejercicios.createNewFile();
				
				ObjectOutputStream write = 
						new ObjectOutputStream(new FileOutputStream(ejercicios, true));
				
				write.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		this.setBounds(0, 0, 784, 561);
		this.setLayout(null);	
		this.setBackground(new Color(255, 204, 255));
		this.setBounds(0, 0, 784, 561);
		this.setLayout(null);	
		
		JLabel lblntroducirEjercicio = new JLabel("Introduzca el ejercicio", SwingConstants.CENTER);
		lblntroducirEjercicio.setBounds(204, 61, 375, 28);
		lblntroducirEjercicio.setFont(new Font("DejaVu Sans", Font.PLAIN, 23));
		this.add(lblntroducirEjercicio);
		
		JTextField numerador1 = new JTextField(SwingConstants.CENTER);
		numerador1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numerador1.setBounds(237, 146, 130, 50);
		this.add(numerador1);
		numerador1.setColumns(10);
		
		JTextField numerador2 = new JTextField(SwingConstants.CENTER);
		numerador2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numerador2.setColumns(10);
		numerador2.setBounds(429, 146, 130, 50);
		this.add(numerador2);
		
		JButton btnCrearEjercicio = new JButton("Crear Ejercicio");
		btnCrearEjercicio.setBackground(new Color(173, 255, 47));
		btnCrearEjercicio.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnCrearEjercicio.setBounds(265, 384, 253, 53);
		this.add(btnCrearEjercicio);
		
		JLabel lblFrac1 = new JLabel("Fracción1", SwingConstants.CENTER);
		lblFrac1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFrac1.setBounds(237, 326, 130, 14);
		this.add(lblFrac1);
		
		JLabel lblFrac2 = new JLabel("Fracción2", SwingConstants.CENTER);
		lblFrac2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFrac2.setBounds(429, 326, 130, 14);
		this.add(lblFrac2);
		
		JTextField denominador1 = new JTextField(10);
		denominador1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		denominador1.setBounds(237, 246, 130, 50);
		this.add(denominador1);
		
		JTextField denominador2 = new JTextField(10);
		denominador2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		denominador2.setBounds(429, 246, 130, 50);
		this.add(denominador2);
		
		JLabel lblNewLabel = new JLabel("---------------",  SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(237, 216, 130, 14);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("---------------", SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(429, 216, 130, 14);
		this.add(lblNewLabel_1);
		
		
		btnCrearEjercicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Fraccion f1, f2;
				
				int num1 = Integer.parseInt(numerador1.getText()), 
						num2 = Integer.parseInt(numerador2.getText());
				
				int den1 = Integer.parseInt(denominador1.getText()), 
						den2 = Integer.parseInt(denominador2.getText());
				
				f1 = new Fraccion(num1, den1);
				f2 = new Fraccion(num2, den2);
				
				ExerciseSumResMultDiv ejercicio = new ExerciseSumResMultDiv(f1, f2);
				
				try {
					ObjectOutputStreamHeaderLess write = 
							new ObjectOutputStreamHeaderLess(new FileOutputStream(ejercicios, true));
					
						write.writeObject(ejercicio);
					
					write.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
	}
	
}

















