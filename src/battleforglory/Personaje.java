
package battleforglory;

import javafx.scene.canvas.GraphicsContext;

public abstract class Personaje extends Objeto {
    protected double vida=100.0;
    protected double gravedad =700.0, fuerzaX, fuerzaY, masa= 10.0, tiempo=1.0/60.0;
    protected double aceleracionX, aceleracionY, velocidadX, velocidadY;
    protected double aceleracionMaxima, fuerzaCorriendo;
    private boolean saltando = false;
    
    

    public Personaje(Ubicacion ubicacion) {
        super(ubicacion);
        this.fuerzaX = 0;
        this.fuerzaY = 0;
        fuerzaCorriendo=7000.0;
    }
    
    
    private void actualizarPorInerciaY(){
        aceleracionY=gravedad;
        velocidadY= aceleracionY * tiempo + velocidadY;
        velocidadY=ajustarVelocidad(velocidadY);
        this.ubicacion.setPosicionY(velocidadY * tiempo + this.ubicacion.getPosicionY());
    }
    
    private void actualizarPorInerciaX(){
        aceleracionX= fuerzaX/masa;
        velocidadX= aceleracionX * tiempo + velocidadX;
        velocidadX=ajustarVelocidad(velocidadX);
        this.ubicacion.setPosicionX(velocidadX * tiempo + this.ubicacion.getPosicionX());
    }
    private void actualizarPorColisionX(){
        velocidadX=0;
        aceleracionX= fuerzaX/masa;
        velocidadX= aceleracionX * tiempo + velocidadX;
        velocidadX=ajustarVelocidad(velocidadX);
        this.ubicacion.setPosicionX(velocidadX * tiempo + this.ubicacion.getPosicionX());
        
    }
    private void actualizarPorColisionY(){
        velocidadY=0;
        aceleracionY=fuerzaY/masa+gravedad;
        velocidadY= aceleracionY * tiempo + velocidadY;
        velocidadY=ajustarVelocidad(velocidadY);
        this.ubicacion.setPosicionY(velocidadY * tiempo + this.ubicacion.getPosicionY());
    }
    
    public void mover(Escenario escenario){
        double impactoX=0.0, impactoY=0.0;
        for (ElementoMapa elemento : escenario.getMapa()){
            if (elemento.getUbicacion().colisionaCon(this.ubicacion)){
                impactoY+= this.ubicacion.colisionY(elemento.getUbicacion());
                impactoX+= this.ubicacion.colisionX(elemento.getUbicacion());
                
            }
        }
        if (Math.abs(impactoY)>0.02){
            this.fuerzaY=(impactoY/Math.abs(impactoY))*masa*gravedad;
            if (saltando  && impactoY<0){
                this.fuerzaY-=masa*gravedad*40;
            }
            this.actualizarPorColisionY();
        }else{
            if (saltando){
                this.fuerzaY=0;
                saltando=false;
            }
            this.actualizarPorInerciaY();
        }
        if (Math.abs(impactoX)>0.09){
            this.fuerzaX=Math.abs(fuerzaX)*impactoX/Math.abs(impactoX)*4;
            this.actualizarPorColisionX();
            
        }else{
            this.actualizarPorInerciaX();
        }
        
    }
    
    public void correrDerecha(){
        velocidadX=fuerzaX>0?velocidadX:0;
        fuerzaX= fuerzaCorriendo;
    }
    public void correrIzquierda(){
        velocidadX=fuerzaX<0?velocidadX:0;
        fuerzaX= -fuerzaCorriendo;
    }
    
    public abstract void dibujar(GraphicsContext lapiz);

    public void dejarDeCorrer() {
        velocidadX=0;
        fuerzaX=0;
    }

    void saltar() {
        saltando=true;
    }
    
    private double ajustarVelocidad(double velocidad){
        double velocidadMaxima=700.0;
        if (Math.abs(velocidad)<velocidadMaxima){
            return velocidad;
        }
        return (velocidad>0?700:-700);
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }
    
    public void Atacar(){
        
    }
    
}
