
package battleforglory;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

public abstract class Objeto {
    protected Ubicacion ubicacion;
    
    
    protected Image sprite = null;
    
    public Objeto(Ubicacion ubicacion) {
        this.ubicacion= ubicacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
    
    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public abstract void dibujar(GraphicsContext lapiz);
}
