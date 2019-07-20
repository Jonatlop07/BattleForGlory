package battleforglory;

import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class Animation extends AnimationTimer {
    
    //cliente
    //private ObjectInputStream fromServer;
    //private ObjectOutputStream toServer;
    
    private Scene escena;
    private Image IMGobstaculo = new Image("file:src//battleforglory//image//obstaculo.png"); 
    private Drawer drawer;
    private GraphicsContext lapiz;
    private Vector<Personaje> jugadores;
    private Escenario escenario;
    //private int player;
    
    
    private ArrayList<String> pulsacionTeclado = null;
    private KeyboardInput keyboardInput;
    public Animation(Scene escena, GraphicsContext lapiz) {
        //connectToServer();
       // player = fromServer.readInt();
        this.escena = escena;
        this.lapiz = lapiz;
        this.drawer = new Drawer(this.lapiz);
        
        this.jugadores = new Vector<Personaje>();
        Personaje jugador1 = new BlackKnight(new Ubicacion (30, 200,90,120));
        Personaje jugador2 = new BronzeKnight(new Ubicacion (1700, 200,90,120));
        jugador1.setSprite(new Image("file:src//battleforglory//image//black_knight_re//bkQuietR1.png"));
        jugador2.setSprite(new Image("file:src//battleforglory//image//bronze_knight_re//brkQuietR1.png"));
        //limites
        ElementoMapa piso = new ElementoMapa (new Ubicacion(0,870,2000,50));
        ElementoMapa limiteIzq = new ElementoMapa(new Ubicacion(0,0,10,2000));
        ElementoMapa limiteDer = new ElementoMapa(new Ubicacion(1908,0,50,2000));
        ElementoMapa limiteSup = new ElementoMapa(new Ubicacion(0,0,2000,10));
        //plataformas
        ElementoMapa obstaculo = new ElementoMapa (new Ubicacion(520,680,165,45));
        obstaculo.setSprite(IMGobstaculo);
        ElementoMapa obstaculo2 = new ElementoMapa (new Ubicacion(850,780,165,45));
        obstaculo2.setSprite(IMGobstaculo);
        ElementoMapa obstaculo3 = new ElementoMapa (new Ubicacion(710,470,165,45));
        obstaculo3.setSprite(IMGobstaculo);
        ElementoMapa obstaculo4 = new ElementoMapa (new Ubicacion(1177,680,165,45));
        obstaculo4.setSprite(IMGobstaculo);
        ElementoMapa obstaculo5 = new ElementoMapa (new Ubicacion(1510,580,165,45));
        obstaculo5.setSprite(IMGobstaculo);
        ElementoMapa obstaculo6 = new ElementoMapa (new Ubicacion(210,580,165,45));
        obstaculo6.setSprite(IMGobstaculo);
        ElementoMapa obstaculo7 = new ElementoMapa (new Ubicacion(980,470,165,45));
        obstaculo7.setSprite(IMGobstaculo);
        
        
        escenario = new Escenario();
        escenario.anadirElemento(piso);
        escenario.anadirElemento(limiteIzq);
        escenario.anadirElemento(limiteDer);
        escenario.anadirElemento(limiteSup);
        
  
        escenario.anadirElemento(obstaculo);
        escenario.anadirElemento(obstaculo2);
        escenario.anadirElemento(obstaculo3);
        escenario.anadirElemento(obstaculo4);
        escenario.anadirElemento(obstaculo5);
        escenario.anadirElemento(obstaculo6);
        escenario.anadirElemento(obstaculo7);
        
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
        if(jugador1.ubicacion.colisionaCon(escenario.mapa.elementAt(0).ubicacion))jugador1.ubicacion.setPosicionY((jugador1.ubicacion.getPosicionY())-20);
        if(jugador2.ubicacion.colisionaCon(escenario.mapa.elementAt(0).ubicacion))jugador2.ubicacion.setPosicionY((jugador2.ubicacion.getPosicionY())-20);
                
        keyboardInput = new KeyboardInput(jugador1, jugador2, pulsacionTeclado, lapiz);
    }
    
    @Override
    public void handle(long l) {
        for (Personaje jugador : jugadores){
            jugador.mover(escenario);
            
        }
        /*
        if(this.player==1){
            try {
                this.jugadores.setElementAt((Personaje) fromServer.readObject(),1);
                toServer.writeObject(this.jugadores.elementAt(0));
                
            } catch (IOException ex) {
                Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(this.player==2){
             try {
                this.jugadores.setElementAt((Personaje) fromServer.readObject(),1);
                toServer.writeObject(this.jugadores.elementAt(0));
                
            } catch (IOException ex) {
                Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        */
        
        drawer.setJugadores(this.jugadores);
        drawer.setEscenario(escenario);
        drawer.dibujar();
        
        
        
        //Manages input by keyboard
        keyboardInput.gestionarEntrada();
        int code1 = keyboardInput.getCodigo1();
        int code2 = keyboardInput.getCodigo2();
        
        
    }
    /*
    private void connectToServer(){
        try{
            Socket socket = new Socket ("Localhost",8000);
            fromServer = new ObjectInputStream(socket.getInputStream());
            toServer=new ObjectOutputStream (socket.getOutputStream());
            
            
        }catch (Exception ex) {
             System.err.println(ex);
        }
        Thread thread = new Thread((Runnable) this);
        thread.start();
    }
    */
}
