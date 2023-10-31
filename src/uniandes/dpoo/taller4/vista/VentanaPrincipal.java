package uniandes.dpoo.taller4.vista;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;
import uniandes.dpoo.taller4.vista.VentanaPrincipal;

public class VentanaPrincipal extends JFrame{
	private PanelSuperior panelSuperior;
	private PanelTablero panelTablero;
	private PanelEste panelEste;
	private PanelInferior panelInferior;
	private Tablero tablero;
	private Top10 top;
	
	public VentanaPrincipal(int tamanio,int dificultad){
		
		top = new Top10();
		
		setSize( 900, 700 );
        setTitle( "LightsOut" );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
                        
        panelInferior = new PanelInferior(panelTablero);
        add(panelInferior, BorderLayout.SOUTH);
        
        panelEste = new PanelEste(this,panelInferior);
        add(panelEste, BorderLayout.EAST);
        
        panelSuperior = new PanelSuperior(tamanio);
        add(panelSuperior, BorderLayout.NORTH);
        
        tablero = new Tablero(tamanio);
        tablero.desordenar(dificultad);
        panelTablero = new PanelTablero(tablero,panelInferior,this);
        add(panelTablero, BorderLayout.CENTER);
	}
	
	public int cambiarTamanio() {
		int tamanio = panelSuperior.getTamanio();
		return tamanio;
	}
	
	public int cambiarDificultad() {
		int dificultad = panelSuperior.getDificultad();
		return dificultad;
	}
	
	public void nuevoJuego(int tamanio, int dificultad) {
		tablero = new Tablero(tamanio);
        tablero.desordenar(dificultad);
        panelTablero.setVisible(false);
        panelTablero = new PanelTablero(tablero, panelInferior,this);
        add(panelTablero, BorderLayout.CENTER);
	}
	
	public void reiniciarJuego(){
		tablero.reiniciar();
		panelTablero.setVisible(false);
        panelTablero = new PanelTablero(tablero, panelInferior,this);
        add(panelTablero, BorderLayout.CENTER);
        panelInferior.modificarJugadas(0);
	}
	
	
	public void cargarTop10() {
		
		File top10 = new File("./data/top10.csv");
		top.cargarRecords(top10);
		
    }

	public Collection<RegistroTop10> getTop10() {
		Collection<RegistroTop10> top10 = top.darRegistros();
		return top10;
	}
	
	public static void main(String[] args)
    {
        VentanaPrincipal ventana = new VentanaPrincipal(5,5);
        ventana.setLocationRelativeTo( null );
        ventana.setVisible( true );
        ventana.cargarTop10();
    }
	
	public boolean ganador() {
		boolean ganar = tablero.tableroIluminado();
		if (ganar) {
			int puntaje = tablero.calcularPuntaje();
			boolean ntop = top.esTop10(puntaje);
			if(ntop) {
				top.agregarRegistro(panelInferior.getNombre(), puntaje);
			}
		}
		return ganar;
	}
}
