package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tile.UI;

public class KeyHandlerUI implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, numPressed, enterPressed, pausePressed;
    public boolean pause = true;
    public int numKey;
    private TitlePanel titlePanel;

    public KeyHandlerUI(TitlePanel titlePanel){
        this.titlePanel = titlePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        // TITLE STATE
        if (TitlePanel.gameState == TitlePanel.titleState){
            if(code == KeyEvent.VK_UP){
                UI.commandNum--;
                if (UI.commandNum < 1){
                    UI.commandNum = 5;
                }
            }

            if(code == KeyEvent.VK_DOWN){
                UI.commandNum++;
                if (UI.commandNum > 5){
                    UI.commandNum = 1;
                }
            }

            if(code == KeyEvent.VK_ENTER){
                if (UI.commandNum == 1){
                    TitlePanel.gameState = TitlePanel.playState;
                    titlePanel.switchToInventoryPanel();
                } else if (UI.commandNum == 2) { 
                    TitlePanel.gameState = TitlePanel.helpState;
                } else if (UI.commandNum == 5){
                    System.exit(0); 
                }
            }
        } 
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}