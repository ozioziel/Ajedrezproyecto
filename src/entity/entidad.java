package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class entidad {
	public int x,y, xi, yi;
	public int panelx = -1;
	public int panely = -1;
	public int contador = 1;
	
	public String pieza;
	
	public BufferedImage imagen;
	public String panel;
	
	
	
	
	
	public Rectangle area;
	public boolean on = false;
	public boolean clic = false;
	public boolean piezaenpanel = false;
}
