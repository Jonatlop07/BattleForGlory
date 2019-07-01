package battleforglory;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class Animation extends AnimationTimer {
    
    private Scene escena;
    private Drawer drawer;
    private GraphicsContext lapiz;
    private BlackKnight jugador1;
    private BronzeKnight jugador2; 
    
    private ArrayList<String> pulsacionTeclado = null;
    private KeyboardInput keyboardInput;
    public Animation(Scene escena, GraphicsContext lapiz) {
        this.escena = escena;
        this.lapiz = lapiz;
        this.drawer = new Drawer(this.lapiz);
        
        this.jugador1 = new BlackKnight(30, 400);
        this.jugador2 = new BronzeKnight(1000, 400);
        
        pulsacionTeclado = new ArrayList<>();
        
        escena.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    if ( !pulsacionTeclado.contains(code) )
                        pulsacionTeclado.add( code );
                }
            });

        escena.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    pulsacionTeclado.remove( code );
                }
            });
        keyboardInput = new KeyboardInput(jugador1, jugador2, pulsacionTeclado, lapiz);
    }
    
    @Override
    public void handle(long l) {
        jugador1.setSprite(new Image("file:src//battleforglory//image//black_knight_re//bkQuietR1.png"));
        jugador2.setSprite(new Image("file:src//battleforglory//image//bronze_knight_re//brkQuietR1.png"));
        
        drawer.setJugador1(jugador1);
        drawer.setJugador2(jugador2);
        
        drawer.dibujar();
        
        //Manages input by keyboard
        keyboardInput.gestionarEntrada();
        int code1 = keyboardInput.getCodigo1();
        int code2 = keyboardInput.getCodigo2();
        
        jugador1.mover();
        jugador2.mover();
    }
}
