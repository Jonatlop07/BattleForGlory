
package battleforglory;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Object {
    protected double posicionX;
    protected double posicionY;
    protected double velocidadX;
    protected double velocidadY;
    
    protected Image sprite = null;
    
    public Object(double x, double y) {
        this.posicionX = x;
        this.posicionY  = y;
        velocidadX = 0;
        velocidadY = 0;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(double x) {
        this.posicionX = x;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(double y) {
        this.posicionY = y;
    }

    public double getVelocidadX() {
        return velocidadX;
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

    public abstract void draw(GraphicsContext drawer, int action);
    public abstract void move();
}
