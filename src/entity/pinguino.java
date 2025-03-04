package entity;

import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import ches.panel;

public class pinguino extends entidad {
    panel gp;

    public pinguino(panel gp)
    {
        this.gp =gp;
        try {
        	if (imagen != ImageIO.read(getClass().getResourceAsStream("/piezas/pinguino1.png")))
            imagen = ImageIO.read(getClass().getResourceAsStream("/piezas/pinguino1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        x = gp.Tile*10;
        y = gp.Tile*8;

    }   
    public void update()
    {

    }
    public void draw(Graphics2D g) {
		BufferedImage image = null;
		
		image = imagen;
		g.drawImage(image,x,y,gp.Tile,gp.Tile,null);
	}
}

