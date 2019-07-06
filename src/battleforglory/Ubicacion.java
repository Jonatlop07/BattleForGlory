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
    
    public double colisionY(Ubicacion objeto){
        Rectangle arriba = new Rectangle (posicionX, posicionY, ancho, 1);
        Rectangle abajo = new Rectangle (posicionX, posicionY+alto-1, ancho, 1);
        Shape inter_abajo = SVGPath.intersect(objeto.getHitbox(), abajo);
        Shape inter_arriba = SVGPath.intersect(objeto.getHitbox(), arriba);
        double ans=1;
        if (inter_arriba.getLayoutBounds().getWidth()>inter_abajo.getLayoutBounds().getWidth()){
            ans= inter_arriba.getLayoutBounds().getWidth();
        }else{
            ans = -inter_abajo.getLayoutBounds().getWidth();
        }
        return ans/ancho;
    }
    public double colisionX(Ubicacion objeto){
        Rectangle izquierda = new Rectangle (posicionX, posicionY, 1, alto);
        Rectangle derecha = new Rectangle (posicionX+ancho-1, posicionY, 1, alto);
        Shape inter_izquierda = SVGPath.intersect(objeto.getHitbox(), izquierda);
        Shape inter_derecha = SVGPath.intersect(objeto.getHitbox(), derecha);
        double ans=1;
        if (inter_derecha.getLayoutBounds().getWidth()>inter_izquierda.getLayoutBounds().getWidth()){
            ans= -inter_derecha.getLayoutBounds().getHeight();
        }else{
            ans = inter_izquierda.getLayoutBounds().getHeight();
        }
        return ans/alto;
    }
    
    public Rectangle getHitbox() {
        return hitbox;
    }
    
    private void updateHitox(){
         hitbox= new Rectangle(posicionX, posicionY, ancho, alto);
    }
    public double getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
        this.updateHitox();
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
        this.updateHitox();
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
