/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleforglory;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author gabri
 */
public class ElementoMapa extends Objeto {

    public ElementoMapa(Ubicacion ubicacion) {
        super(ubicacion);
    }

    @Override
    public void dibujar(GraphicsContext lapiz) {
        
        lapiz.setFill(Color.TRANSPARENT);
        
        lapiz.fillRect(this.ubicacion.getPosicionX(), this.ubicacion.getPosicionY()
                ,this.ubicacion.getAncho(), this.ubicacion.getAlto());
        lapiz.drawImage(this.sprite, this.ubicacion.getPosicionX(),this.ubicacion.getPosicionY());
    } 
}
