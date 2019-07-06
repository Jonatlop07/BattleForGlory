package battleforglory;

import java.util.Vector;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Drawer {
    private GraphicsContext lapiz;
    private Vector<Personaje> jugadores;
    private Escenario escenario;
    
    public Drawer(GraphicsContext lapiz) {
        this.lapiz = lapiz;
        this.jugadores = new Vector<Personaje>();
    }
    
    public void dibujar () {
        lapiz.clearRect(0, 0, Juego.getAncho(), Juego.getAlto());
        //lapiz.drawImage(escenario.getFondo(), 0, 0);
        escenario.dibujar(lapiz);
        
        for (Personaje jugador : jugadores){
            //para visualizar el hitbox
            lapiz.setFill(Color.BLACK);
            lapiz.fillRect(jugador.getUbicacion().getPosicionX(), jugador.getUbicacion().getPosicionY(), jugador.getUbicacion().getAncho(), jugador.getUbicacion().getAlto());
            lapiz.drawImage(jugador.getSprite(), jugador.getUbicacion().getPosicionX(), jugador.getUbicacion().getPosicionY());
        }
        
            
        
    }
    
    public void setJugadores(Vector<Personaje> jugadores){
        this.jugadores = jugadores;
    }
    
    
    public void setEscenario(Escenario escenario){
        this.escenario = escenario;
    }
}
