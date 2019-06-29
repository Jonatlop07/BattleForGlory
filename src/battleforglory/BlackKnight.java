
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
    
    
    private final Image spritesRight [][] = {
        {
            new Image(ruta + "QuietR0.png"),
            new Image(ruta + "QuietR1.png"),
            new Image(ruta + "QuietR2.png"),
            new Image(ruta + "QuietR3.png")
        }, 
        {
            new Image(ruta + "WalkR0.png"),
            new Image(ruta + "WalkR1.png"),
            new Image(ruta + "WalkR2.png"),
            new Image(ruta + "WalkR3.png")
        }, 
        {
            new Image(ruta + "RunR0.png"),
            new Image(ruta + "RunR1.png"),
            new Image(ruta + "RunR2.png"),
            new Image(ruta + "RunR3.png")
        }, 
        {
            new Image(ruta + "JumpR0.png"),
            new Image(ruta + "JumpR1.png"),
            new Image(ruta + "JumpR2.png"),
            new Image(ruta + "JumpR3.png")
        }, 
        {
            new Image(ruta + "AtkR0.png"),
            new Image(ruta + "AtkR1.png"),
            new Image(ruta + "AtkR2.png"),
            new Image(ruta + "AtkR3.png")
        },
        {
            new Image(ruta + "HurtR0.png"),
            new Image(ruta + "HurtR1.png"),
            new Image(ruta + "HurtR2.png"),
            new Image(ruta + "HurtR3.png")
        },
        {
            new Image(ruta + "DieR0.png"),
            new Image(ruta + "DieR1.png"),
            new Image(ruta + "DieR2.png"),
            new Image(ruta + "DieR3.png")
        }
    };
    
    private final Image spritesLeft [][] = {
        {
            new Image(ruta + "QuietL0.png"),
            new Image(ruta + "QuietL1.png"),
            new Image(ruta + "QuietL2.png"),
            new Image(ruta + "QuietL3.png")
        }, 
        {
            new Image(ruta + "WalkL0.png"),
            new Image(ruta + "WalkL1.png"),
            new Image(ruta + "WalkL2.png"),
            new Image(ruta + "WalkL3.png")
        }, 
        {
            new Image(ruta + "RunL0.png"),
            new Image(ruta + "RunL1.png"),
            new Image(ruta + "RunL2.png"),
            new Image(ruta + "RunL3.png")
        }, 
        {
            new Image(ruta + "JumpL0.png"),
            new Image(ruta + "JumpL1.png"),
            new Image(ruta + "JumpL2.png"),
            new Image(ruta + "JumpL3.png")
        }, 
        {
            new Image(ruta + "AtkL0.png"),
            new Image(ruta + "AtkL1.png"),
            new Image(ruta + "AtkL2.png"),
            new Image(ruta + "AtkL3.png")
        },
        {
            new Image(ruta + "HurtL0.png"),
            new Image(ruta + "HurtL1.png"),
            new Image(ruta + "HurtL2.png"),
            new Image(ruta + "HurtL3.png")
        },
        {
            new Image(ruta + "DieL0.png"),
            new Image(ruta + "DieL1.png"),
            new Image(ruta + "DieL2.png"),
            new Image(ruta + "DieL3.png")
        }
    };

    public BlackKnight(double x, double y, int direction, double health_value, int lifes) {
        super(x, y, direction, health_value, lifes);
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
        else if (x + sprite.getWidth() >= Juego.getWidth())
            x = Juego.getWidth() - sprite.getWidth() - 2;
            
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
