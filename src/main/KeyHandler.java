package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import tile.UI;
import tile.GameMap;

public class KeyHandler implements KeyListener{

    public boolean upPressed, downPressed, leftPressed, rightPressed, numPressed, enterPressed, pausePressed;
    public boolean pause = true;
    public int numKey;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        
        if (TitlePanel.gameState == TitlePanel.loseState){
            if(code == KeyEvent.VK_UP){
                UI.commandNum--;
                if (UI.commandNum < 1){
                    UI.commandNum = 2;
                }
            }

            if(code == KeyEvent.VK_DOWN){
                UI.commandNum++;
                if (UI.commandNum > 2){
                    UI.commandNum = 1;
                }
            }

            if(code == KeyEvent.VK_ENTER){
                if (UI.commandNum == 1){
                    TitlePanel.gameState = TitlePanel.playState;
                    GameMap.zombies.clear();
                    GameMap.plants.clear();
                    GameMap.bullets.clear();
                    GamePanel.gametime = 0;
                    // Sun nya = 0
                } else {
                    System.exit(0); 
                }
            }
        } 
        
        else if (TitlePanel.gameState == TitlePanel.winState){
            if(code == KeyEvent.VK_UP){
                UI.commandNum--;
                if (UI.commandNum < 1){
                    UI.commandNum = 2;
                }
            }

            if(code == KeyEvent.VK_DOWN){
                UI.commandNum++;
                if (UI.commandNum > 2){
                    UI.commandNum = 1;
                }
            }

            if(code == KeyEvent.VK_ENTER){
                if (UI.commandNum == 1){
                    TitlePanel.gameState = TitlePanel.playState;
                } else {
                    System.exit(0); 
                }
            } 
        } 
        
        else if (TitlePanel.gameState == TitlePanel.stepState){
            if(code == KeyEvent.VK_ENTER) {
                TitlePanel.gameState = TitlePanel.titleState;
            }
        } 
        
        else if (TitlePanel.gameState == TitlePanel.helpState){
            if(code == KeyEvent.VK_ENTER){
                TitlePanel.gameState = TitlePanel.stepState;
            } 
        } 
        
        else if (TitlePanel.gameState == TitlePanel.playState){
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
            if (code == KeyEvent.VK_P){
                if(pause){
                    pausePressed = false;
                    pause = false;
                    GamePanel.pause = true;
                } else {
                    pausePressed = false;
                    pause = true;
                    GamePanel.pause = false;
                    Main.startThread();
                }
                
            }  
        }
        /* else if (GamePanel.gameState == GamePanel.inventoryState){
            if(code == KeyEvent.VK_I){

            }
            if(code == KeyEvent.VK_W){
                if(UI.slotRow != 0){
                    UI.slotRow--;
                }
                // GamePanel.ui.slotRow++;

            }
            if(code == KeyEvent.VK_A){
                if(UI.slotCol != 0){
                    UI.slotCol--;
                }
                // GamePanel.ui.slotCol--;
            }
            if(code == KeyEvent.VK_S){
                if(UI.slotRow != 0){
                    UI.slotRow++;
                }
                // GamePanel.ui.slotRow++;
            }
            if(code == KeyEvent.VK_D){
                if(UI.slotCol != 0){
                    UI.slotCol++;
                }
                // GamePanel.ui.slotCol++;

            }

        }
        */
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    
}
