package clasesJPanelPersonales;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.DataInputStream;
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

import fracciones.CalculosMatematicos;
import main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones.Interfaz;

public class JPanelDescomponer extends JPanel{

	JLabel lblNewLabel, lblNumeroEjercicio ;
	JTextField textField;
	
	File ejerciciosDescomposicion = new File("EjerciciosDescomposicion");
	
	ArrayList<Integer> ejercicios = new ArrayList<>();
	
	int ejerciciosIndex = 0;
	
	public JPanelDescomponer(){
		this.setBackground(new Color(233, 150, 122));
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
		panelEjercicio.setBounds(84, 146, 616, 279);
		this.add(panelEjercicio);
		panelEjercicio.setLayout(null);
		
		lblNewLabel = new JLabel("", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(180, 54, 255, 45);
		panelEjercicio.add(lblNewLabel);
		
		textField = new JTextField(SwingConstants.LEFT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setBounds(175, 187, 265, 45);
		panelEjercicio.add(textField);
		textField.setColumns(10);
		
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
				int num = Integer.parseInt(lblNewLabel.getText());
				
				ArrayList<Integer> res = new ArrayList<>();
				
				res = CalculosMatematicos.DescomposicionPrimos(num, res);
				
				String[] numbers = textField.getText().split(" ");
				
				int matches = 0;
				for(int i=0; i<res.size(); i++) {
					
					int n1 = Integer.parseInt(numbers[i]);
					
					if(n1 == res.get(i)) {
						matches++;
					}
					
				}
				
				if(matches == res.size()) {
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
	
	protected void DisplayExercise(Integer ejercicio) {
		textField.setText("");
		lblNumeroEjercicio.setText((ejerciciosIndex + 1)+" de "+ejercicios.size());
		lblNewLabel.setText(ejercicio+"");
	}

	void SelectRandomExercises() {
			boolean seguir = true;
			try {
				DataInputStream read = new DataInputStream(new FileInputStream(ejerciciosDescomposicion));
				
				Integer ejercicio;
				
					ejercicio = read.readInt();
			
				while(seguir) {
					ejercicios.add(ejercicio);
					ejercicio = read.readInt();
				}
				
				read.close();
			}catch(EOFException e) {
				System.out.println(ejercicios.size());
				if(ejercicios.size() > 5) {
					
					for(int i=ejercicios.size(); i > 5; i--) {
						int index = (int)(Math.random() * ejercicios.size());
						ejercicios.remove(index);
					}
					
				}
				
				seguir = false;
			}catch (IOException e) {
				e.printStackTrace();
			}		
	}
}



























