
package battleforglory;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BronzeKnight extends Personaje{
    private String ruta = "file:src//battleforglory//image//bronze_knight_re//brk";
    public static final int QUIET = 0;
    public static final int WALK = 1;
    public static final int RUN = 2;
    public static final int JUMP = 3;
    public static final int ATTACK = 4;
    public static final int HURT = 5;
    public static final int DIE = 6;
    
    
    String[] posiciones =  {"Quiet", "Walk", "Run", "Jump", "Atk", "Hurt", "Die"};
    private Image spritesDerecha [][];
    private Image spritesIzquierda [][];
    
    public BronzeKnight(double x, double y) {
        super(x, y);
        spritesDerecha = new Image[7][4];
        spritesIzquierda = new Image[7][4];
        for (int i=0;i<7;++i){
            for (int j=0;j<4;++j){
                spritesDerecha[i][j]=new Image(ruta + posiciones[i]+"R"+j+".png");
                spritesIzquierda[i][j]=new Image(ruta + posiciones[i]+"L"+j+".png");
            }
        }
    }

    @Override
    public void dibujar(GraphicsContext lapiz) {
        lapiz.drawImage(sprite, posicionX, posicionY);
    }
}
