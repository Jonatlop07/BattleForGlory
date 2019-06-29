
package battleforglory;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Object {
    protected double x;
    protected double y;
    protected double vx;
    protected double vy;
    
    protected Image sprite = null;
    
    public Object(double x, double y) {
        this.x = x;
        this.y  = y;
        vx = 0;
        vy = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
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
