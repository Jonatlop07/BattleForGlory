/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleforglory;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author gabri
 */
public class KeyboardInput {
    private int code1, code2;
    private ArrayList<String> pulsacionTeclado;
    private GraphicsContext drawer;
    private Character player1, player2;

    public KeyboardInput(Character player1, Character player2, ArrayList<String> pulsacionTeclado, GraphicsContext drawer) {
        this.pulsacionTeclado = pulsacionTeclado;
        this.drawer = drawer;
        this.player1 = player1;
        this.player2 = player2;
    }
    
    
    
    
    public void manageInput(){
        code1=0; code2=0;
        //Controles player 1
        if (pulsacionTeclado.contains("A")){
            player1.setDirection(-1);
            
            if (pulsacionTeclado.contains("K")){
                code1 = 2;
                if (player1.getEnergy() > 0){
                    player1.setEnergy(player1.getEnergy() - 2);
                    player1.setVelocidadX(4);
                }
            } else {
                player1.setVelocidadX(2);
                code1 = 1;
            }
            
            if (player1.isJumping()){
                player1.setVelocidadX(6);
            }
        }
        
        if (pulsacionTeclado.contains("D")){
            player1.setDirection(1);
            if (pulsacionTeclado.contains("K")){
                code1 = 2;
                if (player1.getEnergy() > 0){
                    player1.setEnergy(player1.getEnergy() - 2);
                    player1.setVelocidadX(4);
                }
            } else {
                player1.setVelocidadX(2);
                code1 = 1;
            }
            
            if (player1.isJumping()){
                player1.setVelocidadX(6);
            }
        }
        
        if (pulsacionTeclado.contains("W")){
            if (!player1.isBoosted() && player1.getEnergy() > 20) {
                player1.setVelocidadY(28);
                player1.hasBoost(true); 
            }
            if (player1.getEnergy() <= 20){
                code1 = 0;
            } else {
                code1 = 3;
            }
        }

        //Controles player 2
        if (pulsacionTeclado.contains("LEFT")){
            player2.setDirection(-1);
            if (pulsacionTeclado.contains("NUMPAD3")){
                code2 = 2;
                if (player2.getEnergy() > 0){
                    player2.setEnergy(player2.getEnergy() - 2);
                    player2.setVelocidadX(4);
                }
            } else {
                player2.setVelocidadX(2);
                code2 = 1;
            }
            
            if (player2.isJumping()){
                player2.setVelocidadX(6);
            }
        }
        
        if (pulsacionTeclado.contains("RIGHT")){
            player2.setDirection(1);
            
            if (pulsacionTeclado.contains("NUMPAD3")){
                code2 = 2;
                if (player2.getEnergy() > 0){
                    player2.setEnergy(player2.getEnergy() - 2);
                    player2.setVelocidadX(4);
                }
            } else {
                player2.setVelocidadX(2);
                code2 = 1;
            }
            
            if (player2.isJumping()){
                player2.setVelocidadX(6);
            }
        }
        
        if (pulsacionTeclado.contains("UP")){
            if (!player2.isBoosted() && player2.getEnergy() > 20) {
                player2.setVelocidadY(28);
                player2.hasBoost(true); 
            }
            if (player2.getEnergy() <= 20){
                code2 = 0;
            } else {
                code2 = 3;
            }     
        }
        
        if (pulsacionTeclado.contains("J")){
            code1 = 4;

            if (player1.isCollidingCharacter(player2)){
                double p2Health = player2.getHealth().getValue();
                code2 = 5;
                player2.draw(drawer, code2);
                player2.setHealth(p2Health - 0.2);
                
                if (p2Health <= 66 && p2Health > 33)
                    player2.getHealth().setColor(Color.YELLOW);
                else if ( p2Health >= 0 && p2Health <= 33 )
                    player2.getHealth().setColor(Color.RED);
            }
        } 
        if (pulsacionTeclado.contains("ENTER")){
            code2 = 4;

            if (player2.isCollidingCharacter(player1)){
                double p1Health = player1.getHealth().getValue();
                code1 = 5;
                player1.draw(drawer, code1);
                player1.setHealth( p1Health - 0.2);
                
                if (p1Health <= 66 && p1Health > 33)
                    player1.getHealth().setColor(Color.YELLOW);
                else if ( p1Health >= 0 && p1Health <= 33 )
                    player1.getHealth().setColor(Color.RED);
            }
        }
        
        
    }

    public int getCode1() {
        return code1;
    }

    public int getCode2() {
        return code2;
    }
    
    
}
