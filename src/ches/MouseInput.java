package ches;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    public boolean click, mouseRightClicked;
    private boolean processedLeftClick, processedRightClick;  

    public MouseInput() {
        click = false;
        mouseRightClicked = false;
        processedLeftClick = false;
        processedRightClick = false;
     
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && !processedLeftClick) {  
            click = true;  
            processedLeftClick = true; 
        } else if (e.getButton() == MouseEvent.BUTTON3 && !processedRightClick) {  
            mouseRightClicked = true;  
            processedRightClick = true;  
            
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            click = false;  
            processedLeftClick = false; 
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            mouseRightClicked = false;  
            processedRightClick = false;  
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
 
    }
}
