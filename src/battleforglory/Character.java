
package battleforglory;

public abstract class Character extends Object {
    protected Health health;
    protected int lifes;
    protected int secuence;
    protected int direction;
    protected double energy;
    protected boolean isJumping;
    protected boolean isBoosted;
    
    public Character(double x, double y, int direction, double health_value, int lifes) {
        super(x, y);
        this.health = new Health(health_value);
        this.secuence = 0;
        this.direction = direction;
        this.lifes = lifes;
        this.energy = 100.0;
        this.isJumping = false;
        this.isBoosted = false;
    }

    public abstract boolean isCollidingCharacter(Character character);
    
    public Health getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health.setValue(health);
    }
    
    public double getEnergy() {
        return energy;
    }
    
    public void setEnergy(double energy){
        this.energy = energy;
    }
    
    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public int getSecuence() {
        return secuence;
    }

    public void setSecuence(int secuence) {
        this.secuence = secuence;
    }
    
    public int getDirection() {
        return secuence;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    public void hasJumped(boolean isJumping){
        this.isJumping = isJumping; 
    }
    
    public boolean isJumping(){
        if (this.y < 600) return true; 
        else return false;
    }
    
    public void hasBoost(boolean isBoosted){
        this.isBoosted = isBoosted;
    }
    
    public boolean isBoosted(){
        return isBoosted;
    }
}
