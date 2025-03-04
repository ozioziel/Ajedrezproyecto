package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import ches.MouseInput;
import ches.panel;
import ches.tablero;

public class pieza extends entidad{
	panel gp;
	BufferedImage rey,alfil,caballo,reina,peon,torre,reyjaque;
	MouseInput evento_mouse;


	public pieza(panel gp,  MouseInput evento_mouse, String piezai) {
		this.gp =gp;

		this.evento_mouse = evento_mouse;
		pieza = piezai;
		area = new Rectangle(x+0,y+0,48,48);
		try {
		rey = ImageIO.read(getClass().getResourceAsStream("/piezas/rey.png"));;
		alfil = ImageIO.read(getClass().getResourceAsStream("/piezas/alfil.png"));
		caballo = ImageIO.read(getClass().getResourceAsStream("/piezas/caballo.png"));
		reina = ImageIO.read(getClass().getResourceAsStream("/piezas/reina.png"));
		peon = ImageIO.read(getClass().getResourceAsStream("/piezas/peon.png"));
		torre = ImageIO.read(getClass().getResourceAsStream("/piezas/torre.png"));
		reyjaque = ImageIO.read(getClass().getResourceAsStream("/piezas/reyjaque.png"));
		
		
		}		catch(IOException e) {
			e.printStackTrace();
		}
		defaultv();
		imagen(piezai);
	}
	public void defaultv() {

		x = 753;
		y = 30;
		xi = 753;
		yi = 30;
		on = false;
		clic = false;
		panel = "none";
		contador = 1;

	}
	public void imagen(String piezai) {
		

			if (piezai == "rey")
			{
				imagen = rey;
			}
			else if (piezai == "alfil")
			{
				imagen = alfil;
				y += 200;
				yi = y;
				
			}
			else if (piezai == "caballo")
			{
				imagen = caballo;
				y += 100;
				yi = y;
			}
			else if (piezai == "torre")
			{
				imagen = torre;
				y += 100;
				x += 100;
				yi = y;
				xi = x;
			}
			else if (piezai == "peon")
			{
				imagen = peon;
				y += 200;
				x += 100;
				yi = y;
				xi = x;
			}
			else if (piezai == "reina")
			{
				imagen = reina;
				x += 100;
				yi = y;
				xi = x;
			}
		
	}
	public void update(int mousex, int mousey, String piezai) {
		if (on)
		{  
	        x = mousex-30;
	        y = mousey-30;
		}

		if (piezai == "rey")
		{
		if (tablero.jaque)
		{
			imagen = reyjaque;
		}
		else if(imagen != rey || !this.piezaenpanel)
			imagen = rey;
		}
	}
	public void draw(Graphics2D g) {
		BufferedImage image = null;
		
		image = imagen;
		g.drawImage(image,x,y,gp.Tile,gp.Tile,null);
	}
}
