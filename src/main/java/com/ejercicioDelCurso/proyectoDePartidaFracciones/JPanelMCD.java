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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;

import main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones.Interfaz;
import objects.Exercise_MCD_MCM;
import objects.TypeOfExercise;

public class JPanelMCD extends JPanel{	
	
	JLabel lblNewLabel, lblNumeroEjercicio ;
	JTextField textField;
	
	File ejerciciosMCD = new File("EjerciciosMCD_MCM");
	
	ArrayList<Exercise_MCD_MCM> ejercicios = new ArrayList<>();
	
	int ejerciciosIndex = 0;
	
	public JPanelMCD () throws IOException {
		
		this.setBackground(new Color(255, 204, 255));
		this.setBounds(0, 0, 784, 561);
		this.setLayout(null);
		
		JLabel lblTitulo = new JLabel("", SwingConstants.CENTER);
		lblTitulo.setFont(new Font("DejaVu Sans", Font.BOLD, 23));
		lblTitulo.setBounds(147, 11, 490, 54);
		this.add(lblTitulo);
		
		lblNumeroEjercicio = new JLabel("1 de 5", SwingConstants.CENTER);
		lblNumeroEjercicio.setFont(new Font("DejaVu Sans", Font.PLAIN, 23));
		lblNumeroEjercicio.setBounds(252, 81, 279, 54);
		this.add(lblNumeroEjercicio);
		
		JPanel panelEjercicio = new JPanel();
		panelEjercicio.setBackground(Color.WHITE);
		panelEjercicio.setBounds(84, 194, 616, 196);
		this.add(panelEjercicio);
		panelEjercicio.setLayout(null);
		
		lblNewLabel = new JLabel("", SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 74, 255, 45);
		panelEjercicio.add(lblNewLabel);
		
		textField = new JTextField(SwingConstants.LEFT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(341, 74, 265, 45);
		panelEjercicio.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("=", SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(285, 74, 46, 45);
		panelEjercicio.add(lblNewLabel_1);
		
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
				int res = Integer.parseInt(textField.getText());
				
				Exercise_MCD_MCM ejercicio = ejercicios.get(ejerciciosIndex);
				
				if(ejercicio.getTypeOfExercise() == null) {
					ejercicio.setTypeOfExercise(Interfaz.tipoDeEjercicio);
				}
				
				System.out.println(ejercicio.getResultado());
				
				if(res == ejercicio.getResultado()) {
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
	
	protected void DisplayExercise(Exercise_MCD_MCM ejercicio) {
		textField.setText("");
		lblNumeroEjercicio.setText((ejerciciosIndex + 1)+" de "+ejercicios.size());
		lblNewLabel.setText("("+ejercicio.getN1()+", "+ejercicio.getN2()+")");
	}

	void SelectRandomExercises() {
		boolean seguir=true;
		try {
			ObjectInputStream read = new ObjectInputStream(new FileInputStream(ejerciciosMCD));
			
			while(seguir) {
				Exercise_MCD_MCM ejercicio = (Exercise_MCD_MCM)read.readObject();
				ejercicios.add(ejercicio);
			}
			
			read.close();
		} catch (EOFException e1) {
			
			System.out.println(ejercicios.size());
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

	





















