package battleforglory;

import java.util.ArrayList;
import java.util.Vector;
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
    private Vector<Personaje> jugadores;
    private Escenario escenario;
    
    
    private ArrayList<String> pulsacionTeclado = null;
    private KeyboardInput keyboardInput;
    public Animation(Scene escena, GraphicsContext lapiz) {
        this.escena = escena;
        this.lapiz = lapiz;
        this.drawer = new Drawer(this.lapiz);
        
        this.jugadores = new Vector<Personaje>();
        Personaje jugador1 = new BlackKnight(new Ubicacion (30, 200,100,130));
        Personaje jugador2 = new BronzeKnight(new Ubicacion (1000, 200,100,130));
        jugador1.setSprite(new Image("file:src//battleforglory//image//black_knight_re//bkQuietR1.png"));
        jugador2.setSprite(new Image("file:src//battleforglory//image//bronze_knight_re//brkQuietR1.png"));
        ElementoMapa piso = new ElementoMapa (new Ubicacion(0,600,2000,1000));
        escenario = new Escenario();
        escenario.anadirElemento(piso);
        
        
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        
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
        drawer.setJugadores(this.jugadores);
        drawer.setEscenario(escenario);
        drawer.dibujar();
        
        //Manages input by keyboard
        keyboardInput.gestionarEntrada();
        int code1 = keyboardInput.getCodigo1();
        int code2 = keyboardInput.getCodigo2();
        
        for (Personaje jugador : jugadores) jugador.mover();
    }
}
