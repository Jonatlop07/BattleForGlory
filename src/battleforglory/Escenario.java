
package battleforglory;

import java.util.Vector;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Escenario {
    private Image fondo ;
    Vector<ElementoMapa> mapa;
    
    
    public Escenario(){
        mapa = new Vector<>();
        this.fondo= new Image("file:src//battleforglory//image//scenario.png");
    }
    
    public void anadirElemento(ElementoMapa elemento){
        mapa.add(elemento);
    }
    
    public void dibujar(GraphicsContext lapiz){
        for (ElementoMapa elemento: mapa){
            elemento.dibujar(lapiz);
        }
    }

    public Vector<ElementoMapa> getMapa() {
        return mapa;
    }
    
    
    
    public Image getFondo(){
        return fondo;
    }
    
}
