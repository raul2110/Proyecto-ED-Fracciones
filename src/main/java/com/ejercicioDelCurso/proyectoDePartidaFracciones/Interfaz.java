package main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import java.awt.Component;
import java.io.IOException;
import java.util.LinkedList;

import objects.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz extends JFrame {

	private static final long serialVersionUID = -2617942729382080271L;

	public static FileDatabase database;
	
	public static LinkedList<JPanel> panelHistory = new LinkedList<>();
	
	public static JPanel contentPane, panelInicio, panelUsuarios, panelProfesor, panelEjercicios, panelMCD, 
		panelRegistro, panelMainMenu, panelIntroducir, panelIntroducirMCD;
	
	public static Credentials user;
	public static TypeOfExercise tipoDeEjercicio;
	private JComboBox<String> comboBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Interfaz() throws IOException {
		database = new FileDatabase();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BasicArrowButton back = new BasicArrowButton(3);
		back.setDirection(7);
		back.setBackground(new Color(255, 50, 100));
		back.setBounds(30, 30, 40, 34);
		contentPane.add(back);
		
		panelEjercicios = new JPanel();
		panelEjercicios.setBounds(0, 0, 784, 561);
		contentPane.add(panelEjercicios);
		panelEjercicios.setLayout(null);	
		
			JPanel panelDescomponer = new JPanelDescomponer();
			panelEjercicios.add(panelDescomponer);
					
			JPanel panelSimplificar = new JPanelSimplificar();
			panelEjercicios.add(panelSimplificar);
			
			JPanel panelSumResMultDiv = new JPanelSumResMultDiv();
			panelEjercicios.add(panelSumResMultDiv);
		
			panelMCD = new JPanelMCD();
			panelEjercicios.add(panelMCD);
			
			
		
		panelIntroducir = new JPanel();
		panelIntroducir.setBounds(0, 0, 784, 561);
		contentPane.add(panelIntroducir);
		panelIntroducir.setLayout(null);
		
			JPanel panelIntroducirDescomponer = new JPanelIntroducirDescomponer();
			panelIntroducir.add(panelIntroducirDescomponer);	
			
			JPanel panelIntroducirSimplificar = new JPanelIntroducirSimplificar();
			panelIntroducir.add(panelIntroducirSimplificar);	
			
			JPanel panelIntroducirSumResMultDiv = new JPanelIntroducirSumResMultDiv();
			panelIntroducir.add(panelIntroducirSumResMultDiv);
		
			panelIntroducirMCD = new JPanelIntroducirMCD();
			panelIntroducir.add(panelIntroducirMCD);
		
		
		panelUsuarios = new JPanel();		
		panelUsuarios.setBounds(0, 0, 784, 561);
		contentPane.add(panelUsuarios);
		panelUsuarios.setLayout(null);
		
			panelProfesor = new JPanelProfesor();
			panelUsuarios.add(panelProfesor);
		
			JPanel panelAlumno = new JPanelAlumno();
			panelUsuarios.add(panelAlumno);
			
		
		panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 784, 561);
		contentPane.add(panelInicio);
		panelInicio.setLayout(null);
		
			panelRegistro = new JPanelRegistro();
			panelInicio.add(panelRegistro);
		
			panelMainMenu = new JPanelMenuInicioSesion();
			panelInicio.add(panelMainMenu);
		
		
			
		panelHistory.add(panelInicio);
		/*------------------------------------------------------------*/
		/*------------------------------------------------------------*/
		/*-------------------visibilidad paneles----------------------*/
		panelInicio.setVisible(true);
		panelUsuarios.setVisible(false);
		panelAlumno.setVisible(true);
		panelProfesor.setVisible(false);
		
		panelEjercicios.setVisible(false);
		panelMCD.setVisible(false);
		panelSimplificar.setVisible(false);
		panelIntroducirSumResMultDiv.setVisible(false);
		panelDescomponer.setVisible(true);
		
		panelIntroducir.setVisible(false);
		panelIntroducirMCD.setVisible(false);
		panelSumResMultDiv.setVisible(false);
		panelIntroducirSimplificar.setVisible(false);
		panelIntroducirDescomponer.setVisible(false);
		/*------------------------------------------------------------*/
		/*------------------------------------------------------------*/
		/*-------------------------metodos----------------------------*/
			
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(panelHistory.size() == 1) {
					dispose();
				}else {
					
					panelInicio.setVisible(true);
					panelUsuarios.setVisible(false);
					panelAlumno.setVisible(true);
					panelProfesor.setVisible(false);
					
					panelEjercicios.setVisible(false);
					panelMCD.setVisible(false);
					panelSimplificar.setVisible(false);
					panelIntroducirSumResMultDiv.setVisible(false);
					panelDescomponer.setVisible(true);
					
					panelIntroducir.setVisible(false);
					panelIntroducirMCD.setVisible(false);
					panelSumResMultDiv.setVisible(false);
					panelIntroducirSimplificar.setVisible(false);
					panelIntroducirDescomponer.setVisible(false);
					
				}
			}
		});
		
		panelEjercicios.addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				
				panelHistory.add(panelEjercicios);
				
				panelMCD.setVisible(false);
				panelSumResMultDiv.setVisible(false);
				panelSimplificar.setVisible(false);
				panelDescomponer.setVisible(false);
				
				switch(tipoDeEjercicio) {
				case MCD:
				case MCM:
					panelMCD.setVisible(true);
					break;
				case SUMA:
				case RESTA:
				case MULTIPLICACION:
				case DIVISION:
					panelSumResMultDiv.setVisible(true);
					break;
				case SIMPLIFICACION:
					panelSimplificar.setVisible(true);
					break;
				case DESCOMPOSICION:
					panelDescomponer.setVisible(true);
					break;
				default:
					break;
				}
			}
		});
		
		panelUsuarios.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				panelHistory.add(panelEjercicios);
				
				if(user.getTipoDeUsuario() == TypeOfUser.PROFESOR) {
					Component[] components = panelUsuarios.getComponents();
					
					if(((JPanel)components[0]) instanceof JPanelAlumno) {
						((JPanel)components[0]).setVisible(false);
						((JPanel)components[1]).setVisible(true);
					}else {
						((JPanel)components[0]).setVisible(true);
						((JPanel)components[1]).setVisible(false);
					}
					
				}
			}
		});
	
		panelIntroducir.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				panelHistory.add(panelEjercicios);
				
				panelIntroducirMCD.setVisible(false);
				panelIntroducirSumResMultDiv.setVisible(false);
				panelIntroducirSimplificar.setVisible(false);
				panelIntroducirDescomponer.setVisible(false);
				
				switch(tipoDeEjercicio) {
				case MCD:
				case MCM:
					panelIntroducirMCD.setVisible(true);
					break;
				case SUMA:
				case RESTA:
				case MULTIPLICACION:
				case DIVISION:
					panelIntroducirSumResMultDiv.setVisible(true);
					break;
				case SIMPLIFICACION:
					panelIntroducirSimplificar.setVisible(true);
					break;
				case DESCOMPOSICION:
					panelIntroducirDescomponer.setVisible(true);
					break;
				default:
					break;
				}
			}
		});
		
	}
}







































