
package battleforglory;

import javafx.scene.canvas.GraphicsContext;

public abstract class Personaje extends Objeto {
    protected double gravity =700.0, fuerzaX, fuerzaY, masa= 10.0, tiempo=1.0/60.0;
    protected double aceleracionX, aceleracionY, velocidadX, velocidadY;
    

    public Personaje(Ubicacion ubicacion) {
        super(ubicacion);
        this.fuerzaX = 0;
        this.fuerzaY = 0;
    }
    
    
    private void actualizarPorInercia(){
        aceleracionX= 0;
        aceleracionY=gravity;
        velocidadX= aceleracionX * tiempo + velocidadX;
        velocidadY= aceleracionY * tiempo + velocidadY;
        this.ubicacion.setPosicionX(velocidadX * tiempo + this.ubicacion.getPosicionX());
        this.ubicacion.setPosicionY(velocidadY * tiempo + this.ubicacion.getPosicionY());
    }
    private void actualizarPorColision(){
        velocidadX=0;
        velocidadY=0;
        aceleracionX= fuerzaX/masa;
        aceleracionY=fuerzaY/masa+gravity;
        velocidadX= aceleracionX * tiempo + velocidadX;
        velocidadY= aceleracionY * tiempo + velocidadY;
        this.ubicacion.setPosicionX(velocidadX * tiempo + this.ubicacion.getPosicionX());
        this.ubicacion.setPosicionY(velocidadY * tiempo + this.ubicacion.getPosicionY());
    }
    
    public void mover(Escenario escenario){
        for (ElementoMapa elemento : escenario.getMapa()){
            if (elemento.getUbicacion().colisionaCon(this.ubicacion)){
                System.out.println("colision");
                this.fuerzaY = masa*(-gravity);
                this.actualizarPorColision();
                return;
            }
        }
        this.actualizarPorInercia();
    }
    
    public abstract void dibujar(GraphicsContext lapiz);

}
