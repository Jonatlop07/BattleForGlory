
package battleforglory;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

public class KeyboardInput {
    private int codigo1, codigo2;
    private ArrayList<String> pulsacionTeclado;
    private GraphicsContext lapiz;
    private Personaje jugador1, jugador2;

    public KeyboardInput(Personaje jugador1, Personaje jugador2, ArrayList<String> pulsacionTeclado, GraphicsContext lapiz) {
        this.pulsacionTeclado = pulsacionTeclado;
        this.lapiz = lapiz;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
    
    
    
    
    public void gestionarEntrada(){
        codigo1=0; codigo2=0;
        //Controles jugador 1
        if (pulsacionTeclado.contains("A")){
            
        }
        
        if (pulsacionTeclado.contains("D")){
            
        }
        
        if (pulsacionTeclado.contains("W")){
            
        }
        
        if (pulsacionTeclado.contains("ENTER")){
            
        }

        //Controles jugador 2
        if (pulsacionTeclado.contains("LEFT")){
            
        }
        
        if (pulsacionTeclado.contains("RIGHT")){
            
        }
        
        if (pulsacionTeclado.contains("UP")){
            
        }
        
        if (pulsacionTeclado.contains("J")){
            
        } 
    }

    public int getCodigo1() {
        return codigo1;
    }

    public int getCodigo2() {
        return codigo2;
    }
    
    
}
