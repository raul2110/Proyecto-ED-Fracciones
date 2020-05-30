package clasesJPanelPersonales;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fracciones.Fraccion;
import objects.ObjectOutputStreamHeaderLess;

public class JPanelIntroducirSimplificar extends JPanel{

	File ejercicios = new File("EjerciciosSimplificar");
	
	public JPanelIntroducirSimplificar() {
		
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
		
		this.setBackground(new Color(123, 104, 238));
		this.setBounds(0, 0, 784, 561);
		this.setLayout(null);

		JLabel lblntroducirEjercicio = new JLabel("Introduzca el ejercicio", SwingConstants.CENTER);
		lblntroducirEjercicio.setBounds(204, 61, 375, 28);
		lblntroducirEjercicio.setFont(new Font("DejaVu Sans", Font.PLAIN, 23));
		this.add(lblntroducirEjercicio);
		
		JTextField numerador = new JTextField(SwingConstants.CENTER);
		numerador.setFont(new Font("Tahoma", Font.PLAIN, 25));
		numerador.setBounds(327, 146, 130, 50);
		this.add(numerador);
		numerador.setColumns(10);
		
		JTextField denominador = new JTextField(10);
		denominador.setFont(new Font("Tahoma", Font.PLAIN, 25));
		denominador.setBounds(327, 246, 130, 50);
		this.add(denominador);
		
		JButton btnCrearEjercicio = new JButton("Crear Ejercicio");
		btnCrearEjercicio.setBackground(new Color(173, 255, 47));
		btnCrearEjercicio.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnCrearEjercicio.setBounds(265, 384, 253, 53);
		this.add(btnCrearEjercicio);
		
		JLabel lblNewLabel = new JLabel("---------------",  SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(327, 216, 130, 14);
		this.add(lblNewLabel);
		
		btnCrearEjercicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int num = Integer.parseInt(numerador.getText());
				
				int den = Integer.parseInt(denominador.getText());
				
				Fraccion f1 = new Fraccion(num, den);
				
				try {
					ObjectOutputStreamHeaderLess write = 
							new ObjectOutputStreamHeaderLess(new FileOutputStream(ejercicios, true));
					
						write.writeObject(f1);
					
					write.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
	}
	
}






