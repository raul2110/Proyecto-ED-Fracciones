package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones.Interfaz;
import objects.ExerciseSumResMultDiv;

public class JPanelSumResMultDiv extends JPanel{

	JLabel lblNewLabel, lblNumeroEjercicio, numerador1, numerador2, 
		denominador1, denominador2;
	
	JTextField textFieldResDen, textFieldResNum;
	
	File ejerciciosSumResMultDiv = new File("EjerciciosSumResMultDiv");
	
	ArrayList<ExerciseSumResMultDiv> ejercicios = new ArrayList<>();
	
	int ejerciciosIndex = 0;
	
	public JPanelSumResMultDiv() throws IOException {
		
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
		panelEjercicio.setBounds(84, 155, 616, 300);
		this.add(panelEjercicio);
		panelEjercicio.setLayout(null);
		
		numerador1 = new JLabel("", SwingConstants.CENTER);
		numerador1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numerador1.setBounds(25, 60, 130, 50);
		panelEjercicio.add(numerador1);
	
		
		numerador2 = new JLabel("", SwingConstants.CENTER);
		numerador2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numerador2.setBounds(237, 60, 130, 50);
		panelEjercicio.add(numerador2);
		
		denominador1 = new JLabel("", SwingConstants.CENTER);
		denominador1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		denominador1.setBounds(25, 186, 130, 50);
		panelEjercicio.add(denominador1);
		
		denominador2 = new JLabel("", SwingConstants.CENTER);
		denominador2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		denominador2.setBounds(237, 186, 130, 50);
		panelEjercicio.add(denominador2);
		
		JLabel lblNewLabel = new JLabel("---------------",  SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 143, 130, 14);
		panelEjercicio.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("---------------", SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(237, 143, 130, 14);
		panelEjercicio.add(lblNewLabel_1);
		
		JLabel lblOperation = new JLabel("", SwingConstants.CENTER);
		lblOperation.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblOperation.setBounds(165, 11, 59, 278);
		panelEjercicio.add(lblOperation);
		
		textFieldResNum = new JTextField(10);
		textFieldResNum.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textFieldResNum.setBounds(460, 60, 130, 50);
		panelEjercicio.add(textFieldResNum);
		
		textFieldResDen = new JTextField(10);
		textFieldResDen.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textFieldResDen.setBounds(460, 186, 130, 50);
		panelEjercicio.add(textFieldResDen);
		
		JLabel lblNewLabel_2 = new JLabel("---------------", SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(460, 143, 130, 14);
		panelEjercicio.add(lblNewLabel_2);
		
		JLabel lblEquals = new JLabel("=", SwingConstants.CENTER);
		lblEquals.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblEquals.setBounds(384, 11, 59, 278);
		panelEjercicio.add(lblEquals);
		
		
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
				String signo = "+";
				
				switch(Interfaz.tipoDeEjercicio) {
				case SUMA:
					signo = "+";
					break;
				case RESTA:
					signo = "-";
					break;
				case MULTIPLICACION:
					signo = "*";
					break;
				case DIVISION:
					signo = "/";
					break;
				default:
					break;
				}
				lblOperation.setText(signo);
				
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
				int num = Integer.parseInt(textFieldResNum.getText());
				int den = Integer.parseInt(textFieldResDen.getText());
				
				Fraccion res = new Fraccion(num, den);
				
				ExerciseSumResMultDiv ejercicio = ejercicios.get(ejerciciosIndex);
				
				if(ejercicio.getTipoDeEjercicio() == null) {
					ejercicio.setTipoDeEjercicio(Interfaz.tipoDeEjercicio);
				}
				
				if(res.equals(ejercicio.getResultado())) {
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
	
	protected void DisplayExercise(ExerciseSumResMultDiv ejercicio) {
		textFieldResDen.setText("");
		textFieldResNum.setText("");
		
		lblNumeroEjercicio.setText((ejerciciosIndex + 1)+" de "+ejercicios.size());
		
		numerador1.setText(ejercicio.getF1().getNumerador()+"");
		denominador1.setText(ejercicio.getF1().getDenominador()+"");
		numerador2.setText(ejercicio.getF2().getNumerador()+"");
		denominador2.setText(ejercicio.getF2().getDenominador()+"");
		
	}

	void SelectRandomExercises() {
		boolean seguir=true;
		try {
			ObjectInputStream read = new ObjectInputStream(new FileInputStream(ejerciciosSumResMultDiv));
			
			while(seguir) {
				ExerciseSumResMultDiv ejercicio = (ExerciseSumResMultDiv)read.readObject();
				ejercicios.add(ejercicio);
			}
			
			read.close();
		} catch (EOFException e1) {
			
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













