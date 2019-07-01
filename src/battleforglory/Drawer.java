package battleforglory;

import java.util.Vector;
import javafx.scene.canvas.GraphicsContext;

public class Drawer {
    private GraphicsContext lapiz;
    private Vector<Personaje> jugadores;
    private Escenario escenario;
    
    public Drawer(GraphicsContext lapiz) {
        this.lapiz = lapiz;
        this.jugadores = new Vector<Personaje>();
    }
    
    public void dibujar () {
        lapiz.clearRect(0, 0, Juego.getWidth(), Juego.getHeight());
        //lapiz.drawImage(escenario.getFondo(), 0, 0);
        
        for (Personaje jugador : jugadores)
            lapiz.drawImage(jugador.getSprite(), jugador.getPosicionX(), jugador.getPosicionY());
        
    }
    
    public void setJugadores(Vector<Personaje> jugadores){
        this.jugadores = jugadores;
    }
    
    public void setEscenario(String ruta){
        escenario = new Escenario(ruta);
    }
}
