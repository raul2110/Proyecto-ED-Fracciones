package clasesJPanelPersonales;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import objects.Exercise_MCD_MCM;
import objects.ObjectOutputStreamHeaderLess;

public class JPanelIntroducirDescomponer extends JPanel{
	JTextField num;
	
	File ejercicios = new File("EjerciciosDescomposicion");
	
	public JPanelIntroducirDescomponer(){
		
		this.setBackground(new Color(255, 160, 122));
		this.setBounds(0, 0, 784, 561);
		this.setLayout(null);
		
		JLabel lblntroducirEjercicio = new JLabel("Introduzca el ejercicio", SwingConstants.CENTER);
		lblntroducirEjercicio.setBounds(204, 61, 375, 28);
		lblntroducirEjercicio.setFont(new Font("DejaVu Sans", Font.PLAIN, 23));
		this.add(lblntroducirEjercicio);
		
		num = new JTextField(SwingConstants.CENTER);
		num.setFont(new Font("Tahoma", Font.PLAIN, 25));
		num.setBounds(317, 142, 150, 100);
		this.add(num);
		num.setColumns(10);
		
		JButton btnCrearEjercicio = new JButton("Crear Ejercicio");
		btnCrearEjercicio.setBackground(new Color(173, 255, 47));
		btnCrearEjercicio.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnCrearEjercicio.setBounds(265, 325, 253, 53);
		this.add(btnCrearEjercicio);
		
		btnCrearEjercicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CrearEjercicio();
			}
			
		});
	}
	
	boolean CrearEjercicio() {
		int n1 = Integer.parseInt(num.getText());
		
		try {
			DataOutputStream write = new DataOutputStream(new FileOutputStream(ejercicios, true));
			
				write.writeInt(n1);
			
			write.close();
		} catch (FileNotFoundException e1) {
			return false;
		} catch (IOException e1) {
			return false;
		}
		
		return true;
	}
}

















