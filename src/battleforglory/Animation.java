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
    private KeyboardInput keyboardInput;
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
        keyboardInput = new KeyboardInput(player1, player2, pulsacionTeclado, drawer);
    }
    
    @Override
    public void handle(long l) {
        drawer.clearRect(0, 0, Game.getWidth(), Game.getHeight());
        drawer.setFill(Color.LIGHTBLUE);
        drawer.fillRect(0, 0, Game.getWidth(), Game.getHeight());
        
        
        if (player1.getSecuence() > 3) player1.setSecuence(0);
        if (player2.getSecuence() > 3) player2.setSecuence(0);
        
        player1.setVelocidadX(0);
        player2.setVelocidadX(0);
        
        //Manages input by keyboard
        keyboardInput.manageInput();
        int code1=keyboardInput.getCode1();
        int code2=keyboardInput.getCode2();
        
        
        
        
        
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
