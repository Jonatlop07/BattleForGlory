
package battleforglory.controlador;

import battleforglory.Animation;
import battleforglory.Juego;
import battleforglory.vista.VistaMenu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControladorMenu {
    private VistaMenu vistaMenu;
    
    public ControladorMenu(){
        this.vistaMenu = new VistaMenu();
        this.vistaMenu.getBtnJugar().setOnAction(new EventoJugar());
    }
    
    public VistaMenu getVistaMenu(){
        return vistaMenu;
    }
    
    private class EventoJugar implements EventHandler<ActionEvent>{
         @Override
        public void handle(ActionEvent event) {
            Singleton singleton = Singleton.getSingleton();
            Stage primaryStage = singleton.getStage();
            
            Pane pane = new Pane();
            Canvas canvas = new Canvas(Juego.getAncho(), Juego.getAlto());
            pane.getChildren().add(canvas);
            Scene scene = new Scene(pane, Juego.getAncho(), Juego.getAlto(), Color.WHITE);
            GraphicsContext drawer = canvas.getGraphicsContext2D();

            Animation animation = new Animation(scene, drawer);
            animation.start();

            primaryStage.setScene(scene);
            primaryStage.setTitle("Battle For Glory");
            primaryStage.show();
        }
    }
}
