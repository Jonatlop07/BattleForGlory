
package battleforglory;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class KeyboardInput {
    private int codigo1, codigo2;
    private ArrayList<String> pulsacionTeclado;
    private GraphicsContext lapiz;
    private Personaje jugador1, jugador2;
    private BlackKnight jugador3;
    private BronzeKnight jugador4;
    private int walk=0,jump=0,walk2=0,jump2=0,quiet=0,quiet2=0,attack=0,attack2=0;
    private boolean este=true,oeste=false,este2=false,oeste2=true;

    public KeyboardInput(Personaje jugador1, Personaje jugador2, ArrayList<String> pulsacionTeclado, GraphicsContext lapiz) {
        this.pulsacionTeclado = pulsacionTeclado;
        this.lapiz = lapiz;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugador3 = (BlackKnight) jugador1;
        this.jugador4 = (BronzeKnight) jugador2;
    }
    
    public void gestionarEntrada(){
        codigo1=0; codigo2=0;
        //Controles jugador 1
        if (pulsacionTeclado.contains("A")){
            jugador1.correrIzquierda();
            Image spritesCambio[][]=jugador3.getSpritesIzquierda();
            if(walk==30)walk=0;
            int j = walk/10;
                jugador1.setSprite(spritesCambio[2][j]);
                jugador1.ubicacion.setAlto(135);
                jugador1.ubicacion.setAncho(120);
            walk++;
            este=false;
            oeste=true;
        }
        
        if (pulsacionTeclado.contains("D")){
            jugador1.correrDerecha();
            Image spritesCambio[][]=jugador3.getSpritesDerecha();
            if(walk==30)walk=0;
                int j= walk/10;
                jugador1.setSprite(spritesCambio[2][j]);
                jugador1.ubicacion.setAlto(135);
                jugador1.ubicacion.setAncho(100);
            walk++;
            este=true;
            oeste=false;
        }
        
        if (!pulsacionTeclado.contains("D") && !pulsacionTeclado.contains("A")){
            
            jugador1.dejarDeCorrer();
            if(quiet==30)quiet=0;
                int j = quiet/10;
            if(este==true&&oeste==false){
                Image spritesCambio[][]=jugador3.getSpritesDerecha();
                jugador1.setSprite(spritesCambio[0][j]);
            }
            if(este==false&&oeste==true){
                Image spritesCambio[][]=jugador3.getSpritesIzquierda();
                jugador1.setSprite(spritesCambio[0][j]);
            }
                jugador1.ubicacion.setAlto(120);
                jugador1.ubicacion.setAncho(90);
            quiet++;
        }
        
        if (pulsacionTeclado.contains("W")){
            jugador1.saltar();
            if(jump==90)jump=0;
            int j=jump/30;
            if(este==true&&oeste==false){
                Image spritesCambio[][]=jugador3.getSpritesDerecha();
                jugador1.setSprite(spritesCambio[3][j]);
            }
            if(este==false&&oeste==true){
                Image spritesCambio[][]=jugador3.getSpritesIzquierda();
                jugador1.setSprite(spritesCambio[3][j]);
            }   
            jump++;
        }
        
        if (pulsacionTeclado.contains("SPACE")){
            
            if(attack==30)attack=0;
            int j = attack/10;
            if(este==true&&oeste==false){
                Image spritesCambio[][]=jugador3.getSpritesDerecha();
                jugador1.setSprite(spritesCambio[4][j]);
                jugador1.ubicacion.setAlto(120);
                attack++;
            }
            if(este==false&&oeste==true){
                Image spritesCambio[][]=jugador3.getSpritesIzquierda();
                jugador1.setSprite(spritesCambio[4][j]);
                jugador1.ubicacion.setAlto(120);
                attack++;
            }
            if(jugador1.ubicacion.colisionaCon(jugador2.ubicacion)){
                jugador2.setVida(jugador2.getVida()-0.7);
            }
            
        }

        //Controles jugador 2
        if (pulsacionTeclado.contains("LEFT")){
            jugador2.correrIzquierda();
            Image spritesCambio[][]=jugador4.getSpritesIzquierda();
            if(walk2==30)walk2=0;
            int j = walk2/10;
                jugador2.setSprite(spritesCambio[2][j]);
                jugador2.ubicacion.setAlto(135);
                jugador2.ubicacion.setAncho(120);
            walk2++;
            este2=false;
            oeste2=true;
        }
        
        if (pulsacionTeclado.contains("RIGHT")){
             jugador2.correrDerecha();
            Image spritesCambio[][]=jugador4.getSpritesDerecha();
            if(walk2==30)walk2=0;
                int j= walk2/10;
                jugador2.setSprite(spritesCambio[2][j]);
                jugador2.ubicacion.setAlto(135);
                jugador2.ubicacion.setAncho(100);
            walk2++;
            este2=true;
            oeste2=false;
        }
        
        if (pulsacionTeclado.contains("UP")){
            jugador2.saltar();
            if(jump2==90)jump2=0;
            int j=jump2/30;
            if(este2==true&&oeste2==false){
                Image spritesCambio[][]=jugador4.getSpritesDerecha();
                jugador2.setSprite(spritesCambio[3][j]);
            }
            if(este2==false&&oeste2==true){
                Image spritesCambio[][]=jugador4.getSpritesIzquierda();
                jugador2.setSprite(spritesCambio[3][j]);
            }   
            jump2++;
        }
        
        if (!pulsacionTeclado.contains("LEFT") && !pulsacionTeclado.contains("RIGHT")){
            
            jugador2.dejarDeCorrer();
            if(quiet2==30)quiet2=0;
                int j = quiet2/10;
            if(este2==true&&oeste2==false){
                Image spritesCambio[][]=jugador4.getSpritesDerecha();
                jugador2.setSprite(spritesCambio[0][j]);
            }
            if(este2==false&&oeste2==true){
                Image spritesCambio[][]=jugador4.getSpritesIzquierda();
                jugador2.setSprite(spritesCambio[0][j]);
            }
                jugador2.ubicacion.setAlto(120);
                jugador2.ubicacion.setAncho(90);
            quiet2++;
        }
        
        if (pulsacionTeclado.contains("L")){
            
            if(attack2==30)attack2=0;
            int j = attack2/10;
            if(este2==true&&oeste2==false){
                Image spritesCambio[][]=jugador4.getSpritesDerecha();
                
                jugador2.setSprite(spritesCambio[4][j]);
                jugador2.ubicacion.setAlto(100);
                
                attack2++;
            }
            if(este2==false&&oeste2==true){
                Image spritesCambio[][]=jugador4.getSpritesIzquierda();
                
                jugador2.setSprite(spritesCambio[4][j]);
                jugador2.ubicacion.setAlto(100);
                attack2++;
            }
            if(jugador2.ubicacion.colisionaCon(jugador1.ubicacion)){
                jugador1.setVida(jugador1.getVida()-0.7);
            }
        } 
    }

    public int getCodigo1() {
        return codigo1;
    }

    public int getCodigo2() {
        return codigo2;
    }
    
    
}
