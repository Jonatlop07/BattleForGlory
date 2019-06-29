package battleforglory;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Animation extends AnimationTimer {
    
    private Scene scene;
    private GraphicsContext drawer;
    private BlackKnight player1;
    private BronzeKnight player2;
    private int counter; 
    private final double gravityAcceleration = 1.0;
    
    private ArrayList<String> pulsacionTeclado = null;
    
    public Animation(Scene scene, GraphicsContext drawer) {
        this.scene = scene;
        this.drawer = drawer;
        counter = 0;
        
        this.player1 = new BlackKnight(30, 600, 1, 100, 3);
        this.player2 = new BronzeKnight(1000, 600, -1, 100, 3);
        
        this.player1.setSpecificSprite(0);
        this.player2.setSpecificSprite(0);
        
        pulsacionTeclado = new ArrayList<>();

        scene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    if ( !pulsacionTeclado.contains(code) )
                        pulsacionTeclado.add( code );
                }
            });

        scene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    pulsacionTeclado.remove( code );
                }
            });
    }
    
    @Override
    public void handle(long l) {
        drawer.clearRect(0, 0, Juego.getWidth(), Juego.getHeight());
        int code1 = 0, code2 = 0;
        
        if (player1.getSecuence() > 3) player1.setSecuence(0);
        if (player2.getSecuence() > 3) player2.setSecuence(0);
        
        player1.setVx(0);
        player2.setVx(0);
        
        //Controles player 1
        if (pulsacionTeclado.contains("A")){
            player1.setDirection(-1);
            
            if (pulsacionTeclado.contains("K")){
                code1 = 2;
                if (player1.getEnergy() > 0){
                    player1.setEnergy(player1.getEnergy() - 2);
                    player1.setVx(4);
                }
            } else {
                player1.setVx(2);
                code1 = 1;
            }
            
            if (player1.isJumping()){
                player1.setVx(6);
            }
        }
        
        if (pulsacionTeclado.contains("D")){
            player1.setDirection(1);
            if (pulsacionTeclado.contains("K")){
                code1 = 2;
                if (player1.getEnergy() > 0){
                    player1.setEnergy(player1.getEnergy() - 2);
                    player1.setVx(4);
                }
            } else {
                player1.setVx(2);
                code1 = 1;
            }
            
            if (player1.isJumping()){
                player1.setVx(6);
            }
        }
        
        if (pulsacionTeclado.contains("W")){
            if (!player1.isBoosted() && player1.getEnergy() > 20) {
                player1.setVy(28);
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
                    player2.setVx(4);
                }
            } else {
                player2.setVx(2);
                code2 = 1;
            }
            
            if (player2.isJumping()){
                player2.setVx(6);
            }
        }
        
        if (pulsacionTeclado.contains("RIGHT")){
            player2.setDirection(1);
            
            if (pulsacionTeclado.contains("NUMPAD3")){
                code2 = 2;
                if (player2.getEnergy() > 0){
                    player2.setEnergy(player2.getEnergy() - 2);
                    player2.setVx(4);
                }
            } else {
                player2.setVx(2);
                code2 = 1;
            }
            
            if (player2.isJumping()){
                player2.setVx(6);
            }
        }
        
        if (pulsacionTeclado.contains("UP")){
            if (!player2.isBoosted() && player2.getEnergy() > 20) {
                player2.setVy(28);
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
                player1.setHealth( p1Health - 0.35);
                
                if (p1Health <= 66 && p1Health > 33)
                    player1.getHealth().setColor(Color.YELLOW);
                else if ( p1Health >= 0 && p1Health <= 33 )
                    player1.getHealth().setColor(Color.RED);
            }
        }
        
        drawer.setFont(new Font("Times New Roman", 24));
        drawer.setFill(Color.DARKBLUE);
        
        drawer.fillText("Energia", 190, 105);
        drawer.fillText("Energia", 840, 105);
        
        drawer.setStroke(Color.BLACK);
        drawer.setFill(Color.GRAY);
        drawer.strokeRect(320, 90, 202, 12);
        drawer.strokeRect(970, 90, 202, 12);
        drawer.fillRect(321, 91, (2 * player1.getEnergy()), 10);
        drawer.fillRect(971, 91, (2 * player2.getEnergy()), 10);
        
        if (player1.getEnergy() < 100)
            player1.setEnergy(player1.getEnergy() + 1);
        
        if (player2.getEnergy() < 100)
            player2.setEnergy(player2.getEnergy() + 1);

        drawer.setFont(new Font("Times New Roman", 28));
        
        drawer.setFill(Color.DARKBLUE);
        drawer.fillText("Jugador 1", 100, 65);
        
        drawer.strokeRect(220, 50, 400, 20);
        drawer.setFill(player1.getHealth().getColor());
        drawer.fillRect(221, 51, ( 4 * player1.getHealth().getValue()) - 1, 19);
        
        drawer.setFill(Color.DARKBLUE);
        drawer.fillText("Jugador 2", 750, 65);
        
        drawer.strokeRect(870, 50, 400, 20);
        drawer.setFill(player2.getHealth().getColor());
        drawer.fillRect(871, 51, ( 4 * player2.getHealth().getValue()) - 1, 19);
        
        if (player1.getHealth().getValue() < 0){
            if (player1.getSecuence() >= 3) stop();
            else code1 = 6;
        }

        if (player2.getHealth().getValue() < 0){
            if (player2.getSecuence() >= 3) stop();
            else code2 = 6;
        } 
        
        player1.draw(drawer, code1);
        player2.draw(drawer, code2);
        
        player1.move();
        player2.move();
        
        if (counter % 8 == 0 && player1.getSecuence() != 4){
            player1.setSecuence(player1.getSecuence() + 1);
            player2.setSecuence(player2.getSecuence() + 1);
        }

        counter++;
    }
}
