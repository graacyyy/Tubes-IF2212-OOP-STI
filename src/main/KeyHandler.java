package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// import tile.UI;
// import tile.GameMap;

public class KeyHandler implements KeyListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed, numPressed, enterPressed, pausePressed, menuPressed;
    public boolean pause = true;
    public int numKey;
    public int numberPressed;
    public boolean swapPressed;

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
        if(code == KeyEvent.VK_M){
            menuPressed = true;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {}
    
}
