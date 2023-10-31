package uniandes.dpoo.taller4.vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class PanelSuperior extends JPanel{
	
	private JLabel txtTamaño;
	private String[] tamaños = {"5x5","7x7","9x9"};
	private JLabel txtDificultad;
	private JComboBox<String> comboTamaños;
	private JRadioButton btnFacil;
	private JRadioButton btnMedio;
	private JRadioButton btnDificil;
	private String tamanio;
	private int respuesta;
	
	public PanelSuperior(int tamanio) {
		
		setTamanio(respuesta);
		setLayout(new GridLayout(1,7));
		setBackground(Color.BLUE);
		
		add(new JLabel());
		txtTamaño = new JLabel("Tamaño:");
		add(txtTamaño);
		txtTamaño.setForeground(Color.WHITE);
		
		comboTamaños = new JComboBox<>(tamaños);
		add(comboTamaños);
		
		add(new JLabel());
		txtDificultad = new JLabel("Dificultad:");
		add(txtDificultad);
		txtDificultad.setForeground(Color.WHITE);
		
		ButtonGroup gDificultad = new ButtonGroup();
		
		btnFacil = new JRadioButton("Facil",true);
		btnFacil.setBackground(Color.BLUE);
		btnFacil.setForeground(Color.WHITE);
		
		gDificultad.add(btnFacil);
		add(btnFacil);
		
		btnMedio = new JRadioButton("Medio");
		gDificultad.add(btnMedio);
		add(btnMedio);
		btnMedio.setBackground(Color.BLUE);
		btnMedio.setForeground(Color.WHITE);
		
		
		btnDificil = new JRadioButton("Dificil");
		gDificultad.add(btnDificil);
		add(btnDificil);
		btnDificil.setForeground(Color.WHITE);
		btnDificil.setBackground(Color.BLUE);
		
		add(new JLabel());
	}
	
	private void setTamanio(int respuesta) {
		this.respuesta = respuesta;
	}

	public int getTamanio() {
		tamanio = (String) comboTamaños.getSelectedItem();;
		if (tamanio.equals("5x5")) {
        	respuesta = 5;
        }else if(tamanio.equals("7x7")){
        	respuesta = 7;
        }else if(tamanio.equals("9x9")){
        	respuesta = 9;
        }
		return respuesta;
	}

	public int getDificultad() {
		int dificultad = 0;
		if (btnFacil.isSelected()) {
			dificultad = 5;
		}else if(btnMedio.isSelected()) {
			dificultad = 8;
		}else if(btnDificil.isSelected()) {
			dificultad = 12;
		}
		return dificultad;
	}
	
}
