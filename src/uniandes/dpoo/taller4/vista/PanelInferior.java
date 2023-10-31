package uniandes.dpoo.taller4.vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelInferior extends JPanel{
	
	private JLabel txtJugadas;
	private JTextField contadorJugadas;
	private JLabel txtJugador;
	private JTextField nomJugador;
	
	public PanelInferior(PanelTablero tablero) {
		setLayout( new GridLayout( 1,4));
		
		txtJugadas = new JLabel("Jugadas");
		add(txtJugadas);
		
		contadorJugadas = new JTextField("0");
		add(contadorJugadas);
		
		txtJugador = new JLabel("Jugador: ");
		add(txtJugador);
		
		nomJugador = new JTextField("Invitado");
		add(nomJugador);
	}

	public void modificarJugadas(int jugadas){
		String strJugadas = Integer.toString(jugadas);
		contadorJugadas.setText(strJugadas);
	}
	
	public void modificarJugador(String nombre) {
		nomJugador.setText(nombre);
	}
	
	public String getNombre() {
		return nomJugador.getText();
	}
}
