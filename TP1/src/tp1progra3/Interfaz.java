package tp1progra3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Interfaz extends juego {
	static juego listado;
	private JFrame frame;
	private JTextField campo_para_ingresar_letra;
	static String palabra;
	static String caracter;
	String auxiliar="";
	String guardado="_".repeat(palabra.length());
	private JButton boton_para_ingresar_letra;
	

	
	
	/*public static boolean validarCaracter(String caracter) {
		return !caracter.matches("[a-zA-Z]*");
	}*/
	public static void main(String[] args) {
		listado = new juego ();
		palabra = listado.dame_palabra();
		 // esto se podria hacer cuando das click en iniciar
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(144, 238, 144));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//mensaje perdedor
		JLabel mensaje_perder = new JLabel("");
		mensaje_perder.setBounds(115, 193, 189, 14);
		frame.getContentPane().add(mensaje_perder);
		
	    //mensaje ganador 
		JLabel mensaje_ganar = new JLabel("");
		mensaje_ganar.setBounds(115, 193, 189, 14);
		frame.getContentPane().add(mensaje_ganar);
		
		JButton boton_iniciar = new JButton("CLICK PARA INICIAR!");
		boton_iniciar.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));
		boton_iniciar.setBackground(new Color(135, 206, 250));
		boton_iniciar.setForeground(Color.BLACK);
		boton_iniciar.setBounds(217, 165, 198, 53);
		frame.getContentPane().add(boton_iniciar);
		
		JLabel msjintentos_restantes = new JLabel("Intentos Restantes:");
		msjintentos_restantes.setFont(new Font("Bauhaus 93", Font.PLAIN, 12));
		msjintentos_restantes.setBounds(10, 231, 114, 14);
		frame.getContentPane().add(msjintentos_restantes);
		msjintentos_restantes.setVisible(false);
		
		JLabel msjnumdeintentos = new JLabel(listado.getContador_intentos().toString());
		msjnumdeintentos.setFont(new Font("Bauhaus 93", Font.PLAIN, 12));
		msjnumdeintentos.setBounds(125, 231, 46, 14);
		frame.getContentPane().add(msjnumdeintentos);
		msjnumdeintentos.setVisible(false);
		
		JLabel palabra_a_encontrar = new JLabel("");
		palabra_a_encontrar.setBounds(54, 47, 320, 14);
		frame.getContentPane().add(palabra_a_encontrar);
		
		campo_para_ingresar_letra = new JTextField();
		campo_para_ingresar_letra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char validar = e.getKeyChar();
				if (Character.isDigit(validar)) {
				 JOptionPane.showMessageDialog(campo_para_ingresar_letra, "debe ingresar una letra");
		
				}
				
			}
		});
		campo_para_ingresar_letra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					ingresoLetra(mensaje_perder, mensaje_ganar, msjnumdeintentos, palabra_a_encontrar);
					
					
			}

			
		});
		campo_para_ingresar_letra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		campo_para_ingresar_letra.setBounds(96, 72, 217, 20);
		frame.getContentPane().add(campo_para_ingresar_letra);
		campo_para_ingresar_letra.setColumns(10);
		campo_para_ingresar_letra.setVisible(false);
		
		boton_para_ingresar_letra = new JButton("ingresar letra o palabra");
		boton_para_ingresar_letra.setFont(new Font("Bauhaus 93", Font.PLAIN, 12));
		boton_para_ingresar_letra.setBackground(new Color(238, 130, 238));
		boton_para_ingresar_letra.setVisible(false);
		boton_iniciar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				mensaje_perder.setText("");
				boton_para_ingresar_letra.setEnabled(true);
				listado = new juego ();
				palabra = listado.dame_palabra();
				auxiliar="";
				guardado="_".repeat(palabra.length());
				msjintentos_restantes.setVisible(true);
				msjnumdeintentos.setVisible(true);
				campo_para_ingresar_letra.setVisible(true);
				campo_para_ingresar_letra.setEnabled(true);
				boton_para_ingresar_letra.setVisible(true);
				palabra_a_encontrar.setText(" _ ".repeat(palabra.length()));
				boton_iniciar.setText("Reiniciar");
				listado.reiniciar_intentos();
				msjnumdeintentos.setText(listado.getContador_intentos().toString());
				mensaje_perder.setText("");
				mensaje_ganar.setText("");
				
			}
		});
		
		boton_para_ingresar_letra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresoLetra(mensaje_perder, mensaje_ganar, msjnumdeintentos, palabra_a_encontrar);
				
				
			
			}

			
			
		});
		
		
		boton_para_ingresar_letra.setBounds(96, 103, 217, 40);
		frame.getContentPane().add(boton_para_ingresar_letra);
		
		
		
		
		
		
	}

	public void ingresoLetra(JLabel mensaje_perder, JLabel mensaje_ganar, JLabel msjnumdeintentos,
			JLabel palabra_a_encontrar) {
		caracter=campo_para_ingresar_letra.getText();
		campo_para_ingresar_letra.setText(null);
		 
		 

		try {
			if(son_iguales(palabra,caracter)) { // arriesga y pone palabra de una
				palabra_a_encontrar.setText(caracter);
				mensaje_ganar.setText("Ganaste!");
				campo_para_ingresar_letra.setEnabled(false);
				
			}
			else if (contiene_letra (palabra,caracter) && caracter.length()==1) {
				auxiliar=palabra_a_mostar(palabra,caracter); //recibe el string con las letras encontradas
				guardado=unir_palabras(auxiliar,guardado);
				if (guardado.equals(palabra)) {
					palabra_a_encontrar.setText(palabra);
					mensaje_ganar.setText("Ganaste!");
				}
			palabra_a_encontrar.setText(agregar_separacion(guardado)); // es algo estetico 

			}
			else if (listado.getContador_intentos()!=0){
				listado.reducir_intentos();
				msjnumdeintentos.setText(listado.getContador_intentos().toString());
				
			}

				
			
			else  {
				mensaje_perder.setText("Perdiste!");
				campo_para_ingresar_letra.setEnabled(false);
				
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}

