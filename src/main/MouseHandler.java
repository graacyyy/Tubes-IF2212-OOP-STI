package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener{

    private boolean isMouseClicked;
    private boolean isMousePressed;
    private int mouseX, mouseY;

    public MouseHandler(){

        mouseX = 0;
        mouseY = 0;
        isMouseClicked = false;
        isMousePressed = false;
    }
    
    public boolean getMouseClicked(){

        return isMouseClicked;
    }

    public boolean getMousePressed(){
        
        return isMousePressed;
    }

    public void clearMouseClick(){
        
        isMouseClicked = false;
    }

    public int getX(){

        return mouseX;
    }

    public int getY(){

        return mouseY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();
        isMouseClicked = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        isMousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        mouseX = e.getX();
        mouseY = e.getY();
        isMouseClicked = true;
        isMousePressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
