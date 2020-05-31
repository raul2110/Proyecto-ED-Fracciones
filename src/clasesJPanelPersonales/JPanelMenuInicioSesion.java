package clasesJPanelPersonales;

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
import objects.Credentials;

public class JPanelMenuInicioSesion extends JPanel{
	JLabel lblMainMenuAdvice;
	JTextField textFieldCorreo;
	JPasswordField passwordField;
	
	public JPanelMenuInicioSesion(){
			this.setBackground(Color.ORANGE);
			this.setBounds(0, 0, 784, 561);
			this.setLayout(null);
			
			JLabel msgBienvenida = new JLabel("<html>Bienvenido/a</html>", SwingConstants.CENTER);
			msgBienvenida.setFont(new Font("Lato", Font.BOLD, 45));
			msgBienvenida.setBounds(250, 11, 283, 86);
			this.add(msgBienvenida);
			
			JLabel msgNombreAplicacion = new JLabel("<html>Fracciones</html>", SwingConstants.CENTER);
			msgNombreAplicacion.setFont(new Font("Lato", Font.PLAIN, 30));
			msgNombreAplicacion.setBounds(290, 108, 204, 49);
			this.add(msgNombreAplicacion);
			
			JPanel panelInicioSesion = new JPanel();
			panelInicioSesion.setBackground(Color.GREEN);
			panelInicioSesion.setBounds(164, 193, 456, 175);
			this.add(panelInicioSesion);
			panelInicioSesion.setLayout(null);
			
			JLabel msgIniciarSesion = new JLabel("Iniciar Sesi�n", SwingConstants.CENTER);
			msgIniciarSesion.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
			msgIniciarSesion.setBounds(0, 11, 456, 19);
			panelInicioSesion.add(msgIniciarSesion);
			
			JLabel msgIntroducirCorreo = new JLabel("Correo:", SwingConstants.RIGHT);
			msgIntroducirCorreo.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			msgIntroducirCorreo.setBounds(32, 56, 136, 19);
			panelInicioSesion.add(msgIntroducirCorreo);
			
			JLabel msgIntroducirContraseña = new JLabel("Contraseña:", SwingConstants.RIGHT);
			msgIntroducirContraseña.setFont(new Font("Bahnschrift", Font.BOLD, 15));
			msgIntroducirContraseña.setBounds(32, 86, 136, 19);
			panelInicioSesion.add(msgIntroducirContraseña);
			
			textFieldCorreo = new JTextField();
			textFieldCorreo.setBounds(178, 54, 183, 20);
			textFieldCorreo.setText("invitado");
			panelInicioSesion.add(textFieldCorreo);
			textFieldCorreo.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(178, 84, 183, 20);
			panelInicioSesion.add(passwordField);
			
			JButton submitBtn = new JButton("Entrar");
			submitBtn.setBounds(178, 130, 100, 20);
			submitBtn.setBackground(Color.ORANGE);
			
			lblMainMenuAdvice = new JLabel("<html>------- Datos erroneos -------<br/>verifique sus credenciales</html>\r\n", SwingConstants.CENTER);
			lblMainMenuAdvice.setFont(new Font("Impact", Font.PLAIN, 17));
			lblMainMenuAdvice.setForeground(new Color(255, 69, 0));
			lblMainMenuAdvice.setBounds(252, 379, 276, 58);
			lblMainMenuAdvice.setVisible(false);
			this.add(lblMainMenuAdvice);
			
			JLabel lblRegistro = new JLabel("�No tiene una cuenta?", SwingConstants.CENTER);
			lblRegistro.setBounds(324, 459, 136, 14);
			this.add(lblRegistro);
			
			JButton btnRegistro = new JButton("Registrese aqu�");
			btnRegistro.setBackground(Color.GREEN);
			btnRegistro.setBounds(321, 484, 142, 23);
			this.add(btnRegistro);
		
			panelInicioSesion.add(submitBtn);
			submitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Entry();
				}
			});
			
			btnRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChangeToMenuRegistro();
				}
			});
		}

	void Entry() {
		lblMainMenuAdvice.setVisible(false);
			
		String correo = textFieldCorreo.getText(), 
				password =  new String(passwordField.getPassword());
		
		try {
			Credentials credentials = Interfaz.database.Enter(correo, password);
			
			if(credentials != null) {
				Interfaz.user = credentials;
				Interfaz.panelInicio.setVisible(false);	
				Interfaz.panelUsuarios.setVisible(true);
			}
			else {
				lblMainMenuAdvice.setVisible(true);
			}
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}		
	}

	void ChangeToMenuRegistro() {
		Interfaz.panelMainMenu.setVisible(false);
		Interfaz.panelRegistro.setVisible(true);
	}
}
















