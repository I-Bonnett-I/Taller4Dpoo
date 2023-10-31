package uniandes.dpoo.taller4.vista;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class PanelTop extends JFrame {
	
	private JList<String> lstTop;
	private DefaultListModel<String> lst;
	
	public PanelTop() {
		
		lstTop = new JList<>();
		lst = new DefaultListModel<String>();
		
		setSize( 200, 300 );
        setTitle( "Top 10" );
        
	}
	
	public void agregarJugador(int rank, String nombre, int puntuacion) {
		lst.addElement(rank+" "+ nombre+ " "+puntuacion);
	}
	
	public void mostrarTop() {
		lstTop = new JList<String>(lst);
		lstTop.setFont(new Font("Tahoma",Font.BOLD,18));
		JScrollPane scroll = new JScrollPane(lstTop);
		this.add(scroll);
		this.setLocationRelativeTo( null );
		this.setVisible(true);
	}
	
}
