
package battleforglory;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BlackKnight extends Character {
    private String ruta = "file:src//battleforglory//image//black_knight_re//bk";
    public static final int QUIET = 0;
    public static final int WALK = 1;
    public static final int RUN = 2;
    public static final int JUMP = 3;
    public static final int ATTACK = 4;
    public static final int HURT = 5;
    public static final int DIE = 6;
    
    String[] posiciones =  {"Quiet", "Walk", "Run", "Jump", "Atk", "Hurt", "Die"};
    private Image spritesRight [][];
    private Image spritesLeft [][];
    
    public BlackKnight(double x, double y, int direction, double health_value, int lifes) {
        super(x, y, direction, health_value, lifes);
        spritesRight = new Image[7][4];
        spritesLeft = new Image[7][4];
        for (int i=0;i<7;++i){
            for (int j=0;j<4;++j){
                spritesRight[i][j]=new Image(ruta + posiciones[i]+"R"+j+".png");
                spritesLeft[i][j]=new Image(ruta + posiciones[i]+"L"+j+".png");
            }
        }
    }
    
    @Override
    public void draw(GraphicsContext drawer, int action) {
        if (this.direction <= 0){
            this.sprite = spritesLeft[action][this.getSecuence()];
            if (action == 4)
                drawer.drawImage(sprite, this.x - (sprite.getWidth() / 2), this.y - sprite.getHeight());
            else drawer.drawImage(sprite, this.x, this.y - sprite.getHeight());
            
        } else if (this.direction >= 0){
            this.sprite = spritesRight[action][this.getSecuence()];
            drawer.drawImage(sprite, this.x, this.y - sprite.getHeight());
        }
    }

    @Override
    public void move() {
        double gravityAcceleration = 1.5;
        
        if (x <= 0) x = 1;
        else if (x + sprite.getWidth() >= Game.getWidth())
            x = Game.getWidth() - sprite.getWidth() - 2;
            
        x += (vx * direction);
        if (isBoosted){
            vy -= gravityAcceleration;
            y -= vy;
            energy -= 2;
        }
        if (y >= 600){
            y = 600;
            isBoosted = false;
            vy = 0;
        }
    }
    
    @Override
    public boolean isCollidingCharacter(Character character){
        boolean isColliding = false; 
        double characterRightLimit = character.getX() + character.getSprite().getWidth();
        
        if (this.direction == 1)
            return (this.x + this.sprite.getWidth() - 100 >= character.getX() && 
                    this.x + this.sprite.getWidth() - 50 <= characterRightLimit &&
                    this.y < character.getY() + ( 2 * character.sprite.getHeight() / 3));
        else if (this.direction == -1)
            return (this.x - 30 <= characterRightLimit && this.x >= character.getX() &&
                    this.y < character.getY() + ( 2 * character.sprite.getHeight() / 3));
        
        return isColliding;
    }
    
    public void setSpecificSprite(int action){
        sprite = (direction > 0) ? spritesRight[action][secuence]:spritesLeft[action][secuence];
    }
}
