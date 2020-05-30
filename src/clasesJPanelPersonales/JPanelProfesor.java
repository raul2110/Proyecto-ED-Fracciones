package clasesJPanelPersonales;

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

public class JPanelProfesor extends JPanel{

	public JPanelProfesor(){
		this.setBackground(new Color(152, 251, 152));
		this.setBounds(0, 0, 784, 561);
		this.setLayout(null);
		
		JLabel lblIntroduzcaUnEjercicio = new JLabel("Elija un tipo de ejercicios a Introducir", SwingConstants.CENTER);
		lblIntroduzcaUnEjercicio.setBounds(174, 33, 437, 31);
		lblIntroduzcaUnEjercicio.setFont(new Font("Nirmala UI", Font.BOLD, 23));
		this.add(lblIntroduzcaUnEjercicio);
		
		JButton btnDescomposicion = new JButton("Descomposicion\r\n");
		btnDescomposicion.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnDescomposicion.setBackground(new Color(255, 204, 255));
		btnDescomposicion.setBounds(306, 412, 172, 50);
		this.add(btnDescomposicion);
		
		JButton btnCrearMCD = new JButton("MCD y MCM\r\n");
		btnCrearMCD.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnCrearMCD.setBackground(new Color(255, 204, 255));
		btnCrearMCD.setBounds(317, 118, 150, 50);
		this.add(btnCrearMCD);
		
		JButton btnSimplificacion = new JButton("Simplificacion\r\n");
		btnSimplificacion.setFont(new Font("Dialog", Font.PLAIN, 16));
		btnSimplificacion.setBackground(new Color(255, 204, 255));
		btnSimplificacion.setBounds(317, 203, 150, 50);
		this.add(btnSimplificacion);
		
		JButton btnCrearSumResMultDiv = new JButton("<html>-------Suma, Resta-------<br/>Multiplicacion y Division</html>\r\n");
		btnCrearSumResMultDiv.setFont(btnCrearMCD.getFont());
		btnCrearSumResMultDiv.setBackground(new Color(255, 204, 255));
		btnCrearSumResMultDiv.setBounds(293, 308, 203, 50);
		this.add(btnCrearSumResMultDiv);
		
		btnCrearMCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetTypeOfExercise(TypeOfExercise.MCD);
			}
		});
		
		btnCrearSumResMultDiv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SetTypeOfExercise(TypeOfExercise.SUMA);
			}
			
		});
	
		btnSimplificacion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SetTypeOfExercise(TypeOfExercise.SIMPLIFICACION);
			}
			
		});
	
		btnDescomposicion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SetTypeOfExercise(TypeOfExercise.DESCOMPOSICION);
			}
			
		});
	}
	
	private void SetTypeOfExercise(TypeOfExercise tipoDeEjercicio) {
		Interfaz.tipoDeEjercicio = tipoDeEjercicio;
		Interfaz.panelProfesor.setVisible(false);
		Interfaz.panelIntroducir.setVisible(true);	
	}
}

























