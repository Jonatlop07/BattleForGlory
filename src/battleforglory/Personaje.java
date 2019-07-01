
package battleforglory;

import javafx.scene.canvas.GraphicsContext;

public abstract class Personaje extends Objeto {
    
    public Personaje(double posicionX, double posicionY) {
        super(posicionX, posicionY);
    }

    public void mover() {
        
    }
    
    public abstract void dibujar(GraphicsContext lapiz);

}
