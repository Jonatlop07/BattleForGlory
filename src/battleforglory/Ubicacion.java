/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleforglory;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

/**
 *
 * @author gabri
 */
public class Ubicacion {
    private double posicionX , posicionY,ancho, alto;
    Rectangle hitbox;

    public Ubicacion(double posicionX, double posicionY, double ancho, double alto) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.ancho = ancho;
        this.alto = alto;
        hitbox = new Rectangle(posicionX, posicionY, ancho, alto);
    }
    public boolean colisionaCon(Ubicacion objeto){
        Shape inter = SVGPath.intersect(objeto.getHitbox(), this.getHitbox());
        return inter.getLayoutBounds().getWidth() !=-1;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
    
    
    public double getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }
    
}
