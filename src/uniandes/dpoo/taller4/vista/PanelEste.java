package uniandes.dpoo.taller4.vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class PanelEste extends JPanel implements ActionListener{

	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop;
	private JButton btnCambiarJugador;
	private VentanaPrincipal principal;
	private PanelInferior panelInferior;
	private PanelTop panelTop;
	
	public PanelEste(VentanaPrincipal principal, PanelInferior panelInferior) {
		
		this.principal = principal;
		this.panelInferior = panelInferior;
		
		setLayout(new GridLayout(9,1));
		
		add(new JLabel());
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBackground(Color.BLUE);
		btnNuevo.setForeground(Color.WHITE);
		add(btnNuevo);
		
		
		add(new JLabel());
		
		btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.setBackground(Color.BLUE);
		btnReiniciar.setForeground(Color.WHITE);
		add(btnReiniciar);
		
		add(new JLabel());
		
		btnTop = new JButton("TOP - 10");
		btnTop.setBackground(Color.BLUE);
		btnTop.setForeground(Color.WHITE);
		add(btnTop);
		
		add(new JLabel());
		
		btnCambiarJugador = new JButton("CAMBIAR JUGADOR");
		btnCambiarJugador.setBackground(Color.BLUE);
		btnCambiarJugador.setForeground(Color.WHITE);
		add(btnCambiarJugador);
		
		add(new JLabel());
		
		btnNuevo.addActionListener(this);
        btnNuevo.setActionCommand( "NUEVO" );
        
        btnReiniciar.addActionListener(this);
        btnReiniciar.setActionCommand( "REINICIAR" );
        
        btnTop.addActionListener(this);
        btnTop.setActionCommand( "TOP" );
        
        btnCambiarJugador.addActionListener(this);
        btnCambiarJugador.setActionCommand( "CAMBIAR" );
	}
	
	 public void actionPerformed( ActionEvent evento )
	    {
	     
	        if(evento.getActionCommand( ).equals( "NUEVO" ))
	        {
	        	int tamaño = principal.cambiarTamanio();
	        	int dificultad = principal.cambiarDificultad();
	            principal.nuevoJuego(tamaño, dificultad);
	           
	        }
	        else if (evento.getActionCommand( ).equals( "REINICIAR" ))
	        {
	           principal.reiniciarJuego();
	        }
	        else if (evento.getActionCommand( ).equals( "TOP" ))
	        {
	        	panelTop = new PanelTop();
	        	int i = 1;
	        	PriorityQueue<RegistroTop10> top = (PriorityQueue<RegistroTop10>) principal.getTop10();
	        	for(var jugador:top){
	        		String nombre = jugador.darNombre();
	        		int puntaje = jugador.darPuntos();
	        		panelTop.agregarJugador(i,nombre,puntaje);
	        		i++;
	        	}
	        	panelTop.mostrarTop();
	        }
	        else if (evento.getActionCommand( ).equals( "CAMBIAR" ))
	        {
	         String nombre = JOptionPane.showInputDialog(principal,"Ingrese el nombre de usuario");
	         panelInferior.modificarJugador(nombre);
	        }
	    }
}

