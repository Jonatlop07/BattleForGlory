package battleforglory;

import javafx.scene.canvas.GraphicsContext;

public class Drawer {
    private GraphicsContext lapiz;
    private Personaje jugador1;
    private Personaje jugador2;
    private Escenario escenario;
    
    public Drawer(GraphicsContext lapiz) {
        this.lapiz = lapiz;
    }
    
    public void dibujar () {
        lapiz.clearRect(0, 0, Juego.getWidth(), Juego.getHeight());
        //lapiz.drawImage(escenario.getFondo(), 0, 0);
        lapiz.drawImage(jugador1.getSprite(), jugador1.getPosicionX(), jugador1.getPosicionY());
        lapiz.drawImage(jugador2.getSprite(), jugador2.getPosicionX(), jugador2.getPosicionY());
    }
    
    public void setJugador1(Personaje jugador1){
        this.jugador1 = jugador1;
    }
    
    public void setJugador2(Personaje jugador2){
        this.jugador2 = jugador2;
    }
    
    public void setEscenario(String ruta){
        escenario = new Escenario(ruta);
    }
}
