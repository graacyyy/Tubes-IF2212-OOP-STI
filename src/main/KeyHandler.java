package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed, numPressed, enterPressed;
    public int numKey;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }
        if(code == KeyEvent.VK_UP){
            upPressed = true;
        }
        if(code == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        if(code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_1){
            numPressed = true;
            numKey = 1;
        }
        if(code == KeyEvent.VK_2){
            numPressed = true;
            numKey = 2;
        }
        if(code == KeyEvent.VK_3){
            numPressed = true;
            numKey = 3;
        }
        if(code == KeyEvent.VK_4){
            numPressed = true;
            numKey = 4;
        }
        if(code == KeyEvent.VK_5){
            numPressed = true;
            numKey = 5;
        }
        if(code == KeyEvent.VK_6){
            numPressed = true;
            numKey = 6;
        }
        if(code == KeyEvent.VK_7){
            numPressed = true;
            numKey = 7;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if(code == KeyEvent.VK_ENTER){
            enterPressed = false;
        }
        if(code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_1){
            numPressed = false;
            numKey = 1;
        }
        if(code == KeyEvent.VK_2){
            numPressed = false;
            numKey = 2;
        }
        if(code == KeyEvent.VK_3){
            numPressed = false;
            numKey = 3;
        }
        if(code == KeyEvent.VK_4){
            numPressed = false;
            numKey = 4;
        }
        if(code == KeyEvent.VK_5){
            numPressed = false;
            numKey = 5;
        }
        if(code == KeyEvent.VK_6){
            numPressed = false;
            numKey = 6;
        }
        if(code == KeyEvent.VK_7){
            numPressed = false;
            numKey = 7;
        }
    }
    
}
