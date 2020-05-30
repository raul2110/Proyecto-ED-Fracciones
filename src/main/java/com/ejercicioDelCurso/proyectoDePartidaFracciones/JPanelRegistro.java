package jframePersonalClases;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.com.ejercicioDelCurso.proyectoDePartidaFracciones.Interfaz;
import objects.TypeOfUser;

public class JPanelRegistro extends JPanel{
		JTextField textFieldCorreo;
		JPasswordField passwordFieldContraseña;
		JLabel lblRegistroAdvice;
		
		TypeOfUser tipoDeUsuario = TypeOfUser.ALUMNO;
		
		public JPanelRegistro(){
			this.setBackground(Color.GREEN);
			this.setVisible(false);
			this.setBounds(0, 0, 784, 561);
			this.setLayout(null);
			
			JLabel lblRegistro = new JLabel("¿Ya tiene una cuenta?", SwingConstants.CENTER);
			lblRegistro.setBounds(324, 459, 136, 14);
			this.add(lblRegistro);
			
			JButton btnRegistro = new JButton("Entrar");
			btnRegistro.setBackground(Color.ORANGE);
			btnRegistro.setBounds(352, 484, 80, 23);
			this.add(btnRegistro);
			
			JPanel panelDatos = new JPanel();
			panelDatos.setBackground(Color.ORANGE);
			panelDatos .setBounds(164, 193, 456, 175);
			this.add(panelDatos);
			panelDatos.setLayout(null);
			
			JButton btnProfesor = new JButton("Soy Profesor");
			btnProfesor.setBounds(105, 115, 110, 20);
			btnProfesor.setBackground(Color.WHITE);
			btnProfesor.setForeground(Color.MAGENTA);
			panelDatos.add(btnProfesor);
			
			JButton btnAlumno = new JButton("Soy Alumno");
			btnAlumno.setBounds(245, 115, 110, 20);
			btnAlumno.setBackground(Color.GRAY);
			btnAlumno.setForeground(Color.BLUE);
			panelDatos.add(btnAlumno);
			
			JLabel msgDatosRegistro = new JLabel("Introduzca los datos de la cuenta", SwingConstants.CENTER);
			msgDatosRegistro.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
			msgDatosRegistro.setBounds(0, 11, 456, 19);
			panelDatos.add(msgDatosRegistro);
			
			JLabel msgIntroducirCorreo = new JLabel("Correo:", SwingConstants.RIGHT);
			msgIntroducirCorreo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			msgIntroducirCorreo.setBounds(32, 56, 136, 19);
			panelDatos.add(msgIntroducirCorreo);
			
			JLabel msgIntroducirContraseña = new JLabel("Contraseña:", SwingConstants.RIGHT);
			msgIntroducirContraseña.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			msgIntroducirContraseña.setBounds(32, 86, 136, 19);
			panelDatos.add(msgIntroducirContraseña);
			
			textFieldCorreo = new JTextField();
			textFieldCorreo.setBounds(178, 54, 183, 20);
			panelDatos.add(textFieldCorreo);
			textFieldCorreo.setColumns(10);
			
			passwordFieldContraseña = new JPasswordField();
			passwordFieldContraseña.setBounds(178, 84, 183, 20);
			panelDatos.add(passwordFieldContraseña);
			
			JButton submitBtn = new JButton("Registrar");
			submitBtn.setBounds(178, 150, 100, 20);
			submitBtn.setBackground(Color.GREEN);
			panelDatos.add(submitBtn);
			
			JLabel lblMsgRegistro = new JLabel("Registrese en menos de un minuto", SwingConstants.CENTER);
			lblMsgRegistro.setForeground(new Color(199, 21, 133));
			lblMsgRegistro.setFont(new Font("Nirmala UI", Font.BOLD, 21));
			lblMsgRegistro.setBounds(193, 68, 406, 50);
			this.add(lblMsgRegistro);
			
			JLabel lblTotalmenteGratis = new JLabel("TOTALMENTE GRATIS", SwingConstants.CENTER);
			lblTotalmenteGratis.setForeground(new Color(199, 21, 133));
			lblTotalmenteGratis.setFont(new Font("Nirmala UI", Font.BOLD, 21));
			lblTotalmenteGratis.setBounds(193, 112, 406, 50);
			this.add(lblTotalmenteGratis);
			
			lblRegistroAdvice = new JLabel("Cuenta creada correctamente", SwingConstants.CENTER);
			lblRegistroAdvice.setFont(new Font("Impact", Font.PLAIN, 17));
			lblRegistroAdvice.setForeground(Color.BLUE);
			lblRegistroAdvice.setBounds(217, 379, 350, 58);
			lblRegistroAdvice.setVisible(false);
			this.add(lblRegistroAdvice);
			
			btnRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChangeToMainMenu();
				}
			});
			
			submitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CreateAccount();
				}
			});
			
			btnProfesor.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ChangeToSelected(btnProfesor, btnAlumno);
				}
			});
			
			btnAlumno.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ChangeToSelected(btnAlumno, btnProfesor);
				}
			});
		}
		
		protected void ChangeToSelected(JButton selected, JButton lastSelected) {
			selected.setBackground(Color.GRAY);
			lastSelected.setBackground(Color.WHITE);
			
			if(selected.getText().contains("Alumno")) {
				tipoDeUsuario = TypeOfUser.ALUMNO;
			}
			else {
				tipoDeUsuario = TypeOfUser.PROFESOR;
			}
		}

		void CreateAccount() {
			try {
				String correo = textFieldCorreo.getText(), 
					contraseña = new String(passwordFieldContraseña.getPassword()),
					advice = "Cuenta creada correctamente";
				
				Color adviceColor = Color.BLUE;
				
				if(correo.isEmpty() || contraseña.isEmpty()) {	
					advice = "Debe introducir valores en ambos campos";
					adviceColor = Color.RED;
					
				}else if(!Interfaz.database.Add(correo, contraseña, tipoDeUsuario)) {
					advice = "El correo ya está asociado a otra cuenta";
					adviceColor = Color.RED;
				}
				
				lblRegistroAdvice.setText(advice);
				lblRegistroAdvice.setForeground(adviceColor);
				lblRegistroAdvice.setVisible(true);
			
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		}
		
		void ChangeToMainMenu() {
			Interfaz.panelMainMenu.setVisible(true);
			Interfaz.panelRegistro.setVisible(false);
		}
	}


























