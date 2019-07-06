
package battleforglory;

import javafx.scene.canvas.GraphicsContext;

public abstract class Personaje extends Objeto {

    public Personaje(Ubicacion ubicacion) {
        super(ubicacion);
    }
    
    

    public void mover() {
        
    }
    
    public abstract void dibujar(GraphicsContext lapiz);

}
