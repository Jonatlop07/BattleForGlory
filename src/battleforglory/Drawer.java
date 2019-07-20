package battleforglory;

import java.util.Vector;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
        lapiz.drawImage(escenario.getFondo(), 0, 0);
        escenario.dibujar(lapiz);
        //vida jugadores
        lapiz.setFill(Color.BLACK);
        lapiz.fillRect(100, 50, 700, 28);        
        
        lapiz.setFill(Color.BLACK);
        lapiz.fillRect(1070, 50, 700, 28);

        
        lapiz.drawImage(new Image("file:src//battleforglory//image//vs.png"), 887, 20, 100, 100);
        int aux=0;//aux es para controlar la posicion de la vida del respectivo jugador
        for (Personaje jugador : jugadores){
            
            if(aux==0){
                lapiz.setFill(Color.GREEN);
                lapiz.fillRect(100, 50, jugador.getVida()*7, 28);
            }else{
                lapiz.setFill(Color.GREEN);
                lapiz.fillRect(1070, 50, jugador.getVida()*(7), 28);
            }
            //para visualizar el hitbox
            lapiz.setFill(Color.TRANSPARENT);
            lapiz.fillRect(jugador.getUbicacion().getPosicionX(), jugador.getUbicacion().getPosicionY(), jugador.getUbicacion().getAncho(), jugador.getUbicacion().getAlto());
            lapiz.drawImage(jugador.getSprite(), jugador.getUbicacion().getPosicionX(), jugador.getUbicacion().getPosicionY());
            aux++;
        }
        
            
        
    }
    
    public void setJugadores(Vector<Personaje> jugadores){
        this.jugadores = jugadores;
    }
    
    
    public void setEscenario(Escenario escenario){
        this.escenario = escenario;
    }
}
