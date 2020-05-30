package jframePersonalClases;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones.Interfaz;
import objects.TypeOfExercise;

public class JPanelAlumno extends JPanel{

	public JPanelAlumno(){
		this.setVisible(true);
		this.setBackground(new Color(204, 255, 204));
		this.setBounds(0, 0, 784, 561);
		this.setLayout(null);
		
		JLabel lblElejirTipoEjercicio = new JLabel("Elija un tipo de ejercicios a realizar", SwingConstants.CENTER);
		lblElejirTipoEjercicio.setFont(new Font("Nirmala UI", Font.BOLD, 23));
		lblElejirTipoEjercicio.setBounds(168, 68, 447, 54);
		this.add(lblElejirTipoEjercicio);
		
		JButton btnMCD = new JButton("Máximo común Divisor");
		btnMCD.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnMCD.setBackground(new Color(255, 204, 255));
		btnMCD.setBounds(49, 170, 200, 50);
		this.add(btnMCD);
		
		JButton btnMCM = new JButton("Mínimo común Multiplo");
		btnMCM.setFont(btnMCD.getFont());
		btnMCM.setBackground(new Color(255, 204, 255));
		btnMCM.setBounds(286, 170, btnMCD.getBounds().width, btnMCD.getBounds().height);
		this.add(btnMCM);
		
		JButton btnSimplificacion = new JButton("Simplificacion");
		btnSimplificacion.setFont(btnMCD.getFont());
		btnSimplificacion.setBackground(new Color(255, 204, 255));
		btnSimplificacion.setBounds(518, 170, btnMCD.getBounds().width, btnMCD.getBounds().height);
		this.add(btnSimplificacion);
		
		JButton btnSuma = new JButton("Suma");
		btnSuma.setFont(btnMCD.getFont());
		btnSuma.setBackground(new Color(255, 204, 255));
		btnSuma.setBounds(168, 255, btnMCD.getBounds().width, btnMCD.getBounds().height);
		this.add(btnSuma);
		
		JButton btnResta = new JButton("Resta");
		btnResta.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnResta.setBackground(new Color(255, 204, 255));
		btnResta.setBounds(415, 255, btnMCD.getBounds().width, btnMCD.getBounds().height);
		this.add(btnResta);
		
		JButton btnMultiplicacion = new JButton("Multiplicacion");
		btnMultiplicacion.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnMultiplicacion.setBackground(new Color(255, 204, 255));
		btnMultiplicacion.setBounds(168, 337, btnMCD.getBounds().width, btnMCD.getBounds().height);
		this.add(btnMultiplicacion);
		
		JButton btnDivision = new JButton("Division");
		btnDivision.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnDivision.setBackground(new Color(255, 204, 255));
		btnDivision.setBounds(415, 337, btnMCD.getBounds().width, btnMCD.getBounds().height);
		this.add(btnDivision);
		
		JButton btnDescomposicion = new JButton("Descomposicion");
		btnDescomposicion.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnDescomposicion.setBackground(new Color(255, 204, 255));
		btnDescomposicion.setBounds(292, 415, 200, 50);
		this.add(btnDescomposicion);
		
		btnMCD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz.tipoDeEjercicio = TypeOfExercise.MCD;
				Interfaz.panelUsuarios.setVisible(false);
				Interfaz.panelEjercicios.setVisible(true);
			}
		});
		
		btnMCM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz.tipoDeEjercicio = TypeOfExercise.MCM;
				Interfaz.panelUsuarios.setVisible(false);
				Interfaz.panelEjercicios.setVisible(true);
			}
		});
		
		btnSimplificacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz.tipoDeEjercicio = TypeOfExercise.SIMPLIFICACION;
				Interfaz.panelUsuarios.setVisible(false);
				Interfaz.panelEjercicios.setVisible(true);
			}
		});
		
		btnSuma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz.tipoDeEjercicio = TypeOfExercise.SUMA;
				Interfaz.panelUsuarios.setVisible(false);
				Interfaz.panelEjercicios.setVisible(true);
			}
		});
		
		btnResta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz.tipoDeEjercicio = TypeOfExercise.RESTA;
				Interfaz.panelUsuarios.setVisible(false);
				Interfaz.panelEjercicios.setVisible(true);
			}
		});

		btnMultiplicacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz.tipoDeEjercicio = TypeOfExercise.MULTIPLICACION;
				Interfaz.panelUsuarios.setVisible(false);
				Interfaz.panelEjercicios.setVisible(true);
			}
		});
		
		btnDivision.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz.tipoDeEjercicio = TypeOfExercise.DIVISION;
				Interfaz.panelUsuarios.setVisible(false);
				Interfaz.panelEjercicios.setVisible(true);
			}
		});

		btnDescomposicion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz.tipoDeEjercicio = TypeOfExercise.DESCOMPOSICION;
				Interfaz.panelUsuarios.setVisible(false);
				Interfaz.panelEjercicios.setVisible(true);
			}
		});
	}
	
}


















