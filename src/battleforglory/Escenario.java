
package battleforglory;

import javafx.scene.image.Image;

public class Escenario {
    private Image fondo = null;
    
    public Escenario(String ruta){
        fondo = new Image(ruta);
    }
    
    public Image getFondo(){
        return fondo;
    }
}
