package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;

import fracciones.Fraccion;
import fracciones.SimplificarFracciones;
import main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones.Interfaz;

public class JPanelSimplificar extends JPanel{
	
	JTextField denominadorRes, numeradorRes;
	
	JLabel lblNumeroEjercicio, lblTitulo, numerador, denominador;
	
	File EjerciciosSimplificar = new File("EjerciciosSimplificar");
	
	ArrayList<Fraccion> ejercicios = new ArrayList<>();
	
	int ejerciciosIndex = 0;
	
	public JPanelSimplificar() {
		this.setBackground(new Color(123, 104, 238));
		this.setBounds(0, 0, 784, 561);
		this.setLayout(null);
		
		lblTitulo = new JLabel("", SwingConstants.CENTER);
		lblTitulo.setFont(new Font("DejaVu Sans", Font.BOLD, 23));
		lblTitulo.setBounds(147, 11, 490, 54);
		this.add(lblTitulo);
		
		lblNumeroEjercicio = new JLabel("1 de 5", SwingConstants.CENTER);
		lblNumeroEjercicio.setFont(new Font("DejaVu Sans", Font.PLAIN, 23));
		lblNumeroEjercicio.setBounds(252, 81, 279, 54);
		this.add(lblNumeroEjercicio);
		
		JPanel panelEjercicio = new JPanel();
		panelEjercicio.setBackground(Color.WHITE);
		panelEjercicio.setBounds(84, 155, 616, 300);
		this.add(panelEjercicio);
		panelEjercicio.setLayout(null);
		
		numerador = new JLabel("", SwingConstants.CENTER);
		numerador.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numerador.setBounds(150, 76, 130, 50);
		panelEjercicio.add(numerador);
		
		JLabel lblNewLabel = new JLabel("---------------",  SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(150, 146, 130, 14);
		panelEjercicio.add(lblNewLabel);
		
		denominador = new JLabel("", SwingConstants.CENTER);
		denominador.setFont(new Font("Tahoma", Font.PLAIN, 25));
		denominador.setBounds(150, 176, 130, 50);
		panelEjercicio.add(denominador);
		
		JLabel lblEquals = new JLabel("=", SwingConstants.CENTER);
		lblEquals.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblEquals.setBounds(278, 11, 59, 278);
		panelEjercicio.add(lblEquals);
		
		numeradorRes = new JTextField(SwingConstants.CENTER);
		numeradorRes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numeradorRes.setBounds(347, 76, 130, 50);
		panelEjercicio.add(numeradorRes);
		numeradorRes.setColumns(10);
		
		JLabel lblNewLabel1 = new JLabel("---------------",  SwingConstants.CENTER);
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel1.setBounds(347, 146, 130, 14);
		panelEjercicio.add(lblNewLabel1);
		
		denominadorRes = new JTextField(10);
		denominadorRes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		denominadorRes.setBounds(347, 176, 130, 50);
		panelEjercicio.add(denominadorRes);
		
		JButton btnCorregir = new JButton("Corregir");
		btnCorregir.setBackground(new Color(127, 255, 0));
		btnCorregir.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCorregir.setBounds(309, 490, 166, 34);
		this.add(btnCorregir);
		
		BasicArrowButton arrow_1 = new BasicArrowButton(3);
		arrow_1.setVisible(false);
		arrow_1.setBackground(new Color(100, 100, 255));
		arrow_1.setBounds(550, 490, 166, 34);
		this.add(arrow_1);
		
		JButton completar = new JButton("COMPLETAR");
		completar.setVisible(false);
		completar.setBackground(new Color(100, 100, 255));
		completar.setBounds(550, 490, 166, 34);
		this.add(completar);
		
		completar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz.panelUsuarios.setVisible(true);
				Interfaz.panelEjercicios.setVisible(false);
				Interfaz.panelMCD.setVisible(false);
			}
			
		});
		
		arrow_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				arrow_1.setVisible(false);
				
				ejerciciosIndex++;
				
				DisplayExercise(ejercicios.get(ejerciciosIndex));
			}
			
		});
		
		this.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				ejercicios.clear();
				ejerciciosIndex = 0;
				
				completar.setVisible(false);
				arrow_1.setVisible(false);
				
				lblTitulo.setText("Ejercicios: "+Interfaz.tipoDeEjercicio.name());
				SelectRandomExercises();
				DisplayExercise(ejercicios.get(ejerciciosIndex));
			}
		});
		
		btnCorregir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(numeradorRes.getText());
				int den = Integer.parseInt(denominadorRes.getText());
				
				Fraccion res = new Fraccion(num, den);
				
				Fraccion ejercicio = SimplificarFracciones.Simplificar(ejercicios.get(ejerciciosIndex));
				
				System.out.println(ejercicio.getNumerador());
				System.out.println(ejercicio.getDenominador());
				
				if(res.equals(ejercicio)) {
					if(ejerciciosIndex < 4) {
						arrow_1.setVisible(true);
					}
					else {
						completar.setVisible(true);
					}
				}
				
			}
		});
		
		
	}
	
	protected void DisplayExercise(Fraccion ejercicio) {
		denominadorRes.setText("");
		numeradorRes.setText("");
		
		lblNumeroEjercicio.setText((ejerciciosIndex + 1)+" de "+ejercicios.size());
		
		numerador.setText(ejercicio.getNumerador()+"");
		denominador.setText(ejercicio.getDenominador()+"");	
	}

	void SelectRandomExercises() {
		boolean seguir=true;
		try {
			ObjectInputStream read = new ObjectInputStream(new FileInputStream(EjerciciosSimplificar));
			
			while(seguir) {
				Fraccion ejercicio = (Fraccion)read.readObject();
				ejercicios.add(ejercicio);
			}
			
			read.close();
		}catch (EOFException e1) {
			
			if(ejercicios.size() > 5) {
				
				for(int i=ejercicios.size(); i > 5; i--) {
					int index = (int)(Math.random() * ejercicios.size());
					ejercicios.remove(index);
				}
				
			}
			
			seguir = false;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			  e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}