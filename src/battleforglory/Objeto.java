
package battleforglory;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

public abstract class Objeto {
    protected Ubicacion ubicacion;
    protected double velocidadX, velocidadY;
    
    
    protected Image sprite = null;
    
    public Objeto(Ubicacion ubicacion) {
        this.ubicacion= ubicacion;
    }

    public double getVelocidadX() {
        return velocidadX;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
    
    
    
    public void setVelocidadX(double vx) {
        this.velocidadX = vx;
    }

    public double getVelocidadY() {
        return velocidadY;
    }

    public void setVelocidadY(double vy) {
        this.velocidadY = vy;
    }
    
    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public abstract void dibujar(GraphicsContext lapiz);
    public abstract void mover();
}
