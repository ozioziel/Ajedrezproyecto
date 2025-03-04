package ches;
import java.util.ArrayList;
import java.util.Iterator;

import entity.pieza;
import entity.pinguino;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import entity.entidad;


public class panel extends JPanel implements Runnable{
    final int tamanoOrigen = 16;
    final int escala = 5;
    public final int Tile = tamanoOrigen * escala;
    final int maxScreenCol = 16;
    final int maxScreenRow = 16;
    
    final int screenWidth = 1000;
    final int screenHeight = 740;
    

    MouseInput evento_mouse = new MouseInput();
    Thread gamethread;
    pieza pieza = new pieza(this,evento_mouse,"rey");
    pieza alfil = new pieza(this,evento_mouse,"alfil");
    pieza caballo = new pieza(this,evento_mouse,"caballo");
    pieza peon = new pieza(this,evento_mouse,"peon");
    pieza torre = new pieza(this,evento_mouse,"torre");
    pieza reina = new pieza(this,evento_mouse,"reina");
    pinguino pinguin = new pinguino(this);
    tablero tableroS = new tablero();
    ArrayList<pieza> piezasList = new ArrayList<>();
    ArrayList<pos> paneles = new ArrayList<>();
    ArrayList<ArrayList<pos>> ajedrez = new ArrayList<ArrayList<pos>>();
    ArrayList<pieza> piezastablero = new ArrayList<>();
    

    
    
    private BufferedImage tablero;
    private BufferedImage pinguino1;
    private BufferedImage pinguino2;
    private BufferedImage pinguino3;
    int FPS = 60;

    public panel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addMouseListener(evento_mouse);
        this.setFocusable(true);
        piezasList.add(pieza);
        piezasList.add(alfil);
        piezasList.add(caballo);
        piezasList.add(peon);
        piezasList.add(torre);
        piezasList.add(reina);
        

        for (int i1 = 0; i1 < 8; i1++) {
            ArrayList<pos> paneles = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                paneles.add(new pos());
            }
            ajedrez.add(paneles);
        }

        for (int i2 = 0; i2 < 8; i2++) {
            for (int j = 0; j < 8; j++) {
                ajedrez.get(i2).get(j).ix += 85 * j;
                ajedrez.get(i2).get(j).iy += 85 * i2;
                ajedrez.get(i2).get(j).fx += 85 * j;
                ajedrez.get(i2).get(j).fy += 85 * i2;
            }
        }
        
        try {
            tablero = ImageIO.read(getClass().getResourceAsStream("/piezas/tablero.png"));
            pinguino1 = ImageIO.read(getClass().getResourceAsStream("/piezas/pinguino1.png"));
            pinguino2 = ImageIO.read(getClass().getResourceAsStream("/piezas/pinguino2.png"));
            pinguino3 = ImageIO.read(getClass().getResourceAsStream("/piezas/pinguino3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void start() {
        gamethread = new Thread(this);
        gamethread.start();
    }

    @Override
    
    public void run() {

        double intervalo = 1000000000/FPS;
        double delta = 0;
        long lasttime = System.nanoTime();
      
     
        long time;
        while (gamethread != null) {
            time = System.nanoTime();
            delta += (time - lasttime) / intervalo;
            
            lasttime = time;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
    public void borrarpiezas() {
        Iterator<pieza> iterator = piezasList.iterator();
        while (iterator.hasNext()) {
            pieza pieza = iterator.next();
            if (pieza.pieza == "rey")
            {
            	pieza.x = pieza.xi;
            	pieza.y = pieza.yi;
            }
            else if (pieza.piezaenpanel ) {
                iterator.remove(); 
            }
        }

        tableroS.borrartodo();
    }

    public void localizar(int mouse_x, int mouse_y, pieza pieza, ArrayList<pieza> piezas) {

        boolean piezaColocada = false;

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {

                if (ajedrez.get(r).get(c).ix <= mouse_x && ajedrez.get(r).get(c).iy <= mouse_y 
                    && ajedrez.get(r).get(c).fx >= mouse_x && ajedrez.get(r).get(c).fy >= mouse_y 
                    && !pieza.piezaenpanel) {

                    if (pieza.panelx != -1 && pieza.panely != -1) {
                        tableroS.eliminarPieza(pieza);
                    }

                    pieza.panelx = c;
                    pieza.panely = r;
                    pieza.panel = "" + (8 * r + c + 1);
                    pieza.x = ajedrez.get(r).get(c).ix - escala;
                    pieza.y = ajedrez.get(r).get(c).iy;
                    pieza.piezaenpanel = true;

                    if (!pieza.pieza.equals("rey")) {
                        pieza nuevapieza = new pieza(this, evento_mouse, pieza.pieza);
                        piezasList.add(nuevapieza);
                        pieza.contador +=1;
                    }

                    tableroS.agregarPieza(pieza);
                    piezaColocada = true;
                    break; 
                }
            }
            if (piezaColocada) break; 
        }

        if (!piezaColocada) {
            pieza.panel = "none";
            pieza.piezaenpanel = false;
            tableroS.eliminarPieza(pieza);
            
            if (pieza.pieza.equals("rey") || pieza.contador == 1) {
                pieza.x = pieza.xi;
                pieza.y = pieza.yi;
            } else {
                piezas.remove(pieza);
                pieza.contador -= 1;
            }
        }
    }




    public void update() {
        final Point mouse = MouseInfo.getPointerInfo().getLocation();

        SwingUtilities.convertPointFromScreen(mouse, getFocusCycleRootAncestor());
        mouse.y -= 30;

        
        
        for (int i = 0; i<piezasList.size();i++)
        {
        if (mouse.y > piezasList.get(i).y && mouse.y < piezasList.get(i).y + Tile && mouse.x > piezasList.get(i).x && mouse.x < piezasList.get(i).x + Tile && !pieza.on) {
            if (evento_mouse.click && !piezasList.get(i).on) {
            	piezasList.get(i).on = true;
                evento_mouse.click = false; 
                piezasList.get(i).piezaenpanel = false;

                
        } 
        }
        if (evento_mouse.click && piezasList.get(i).on) {
        	localizar(mouse.x,mouse.y, piezasList.get(i), piezasList);
        	
        	piezasList.get(i).on = false;
            evento_mouse.click = false; 
        }
        if (evento_mouse.mouseRightClicked) {
        tableroS.impresion();
        }

        if (mouse.x > pinguin.x && mouse.y> pinguin.y &&mouse.x < pinguin.x+Tile && mouse.y < pinguin.y+Tile)
        	{pinguin.imagen = pinguino2;
        	if (evento_mouse.click)
        	{
        		pinguin.imagen = pinguino3;
        		borrarpiezas();
        	}
        	}
        else if (pinguin.imagen != pinguino1)
        	pinguin.imagen = pinguino1;
        

        for (int piece = 0;  piece < piezasList.size();piece++)
        	piezasList.get(piece).update(mouse.x, mouse.y,piezasList.get(piece).pieza);


        //System.out.print(mouse+"\n");
        tableroS.update();
    }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

       
        if (tablero != null) {
            g.drawImage(tablero, 0, 0, 148*escala, 148*escala, null);
            
        }


     
        Graphics2D g2 = (Graphics2D) g;
      
        
        pinguin.draw(g2);
        for (int i = 0; i<piezasList.size();i++)
        	piezasList.get(i).draw(g2);



        g2.dispose();
    }
}
