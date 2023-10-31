package uniandes.dpoo.taller4.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelTablero extends JPanel implements MouseListener{
	
	private boolean[][] tablero;
	private Tablero tableroModelo;
	private PanelInferior panelInferior;
	private VentanaPrincipal principal;
	
	public PanelTablero(Tablero tableroModelo, PanelInferior panelInferior, VentanaPrincipal principal)
    {	
		this.principal = principal;
		this.panelInferior = panelInferior;
		this.tableroModelo = tableroModelo;
		
		tablero = tableroModelo.darTablero();
        add(new JLabel(  "                                   "));
        addMouseListener(this);        
    }
	    
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        int ancho= getWidth( );
        int alto= getHeight( );
        int anchoRect= ancho/tablero.length;
        int altoRect= alto/tablero.length;
        for( int i = 0; i < tablero.length; i++ )
        {
            for( int j = 0; j < tablero.length; j++ )
            {
                Rectangle2D.Double rect= new Rectangle2D.Double( i*anchoRect , j*altoRect, anchoRect, altoRect );
                if(tablero[j][i]==true)
                {
                    g.setColor( Color.YELLOW );
                }
                else
                {
                    g.setColor( Color.GRAY );
                }
                g2d.fill(rect);
                g.setColor( Color.BLACK );
                g2d.draw( rect );
            }
        }
               
    }
    @Override
    public void mouseClicked( MouseEvent e )
    {
        
    }

    @Override
    public void mousePressed( MouseEvent e )
    {
    	int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        tableroModelo.jugar(casilla[0], casilla[1]);
        int jugadas = tableroModelo.darJugadas();
        panelInferior.modificarJugadas(jugadas);
        repaint();
        
        if (principal.ganador()) {
        	JOptionPane.showMessageDialog( principal, "¡¡¡Felicidades, has ganado!!!" );
        }
    }
    
    private int[] convertirCoordenadasACasilla(int x, int y)
    {
    int ladoTablero = tablero.length;
    int altoPanelTablero = getHeight();
    int anchoPanelTablero = getWidth();
    int altoCasilla = altoPanelTablero / ladoTablero;
    int anchoCasilla = anchoPanelTablero / ladoTablero;
    int fila = (int) (y / altoCasilla);
    int columna = (int) (x / anchoCasilla);
    return new int[] { fila, columna };
    }
    @Override
    public void mouseReleased( MouseEvent e )
    {
    	
    }

    @Override
    public void mouseEntered( MouseEvent e )
    {
    }
    @Override
    public void mouseExited( MouseEvent e )
    {

        
    }
    
}
