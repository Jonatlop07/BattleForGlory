
package battleforglory;

import battleforglory.controlador.ControladorMenu;
import battleforglory.controlador.Singleton;
import battleforglory.vista.VistaMenu;
import javafx.application.Application;
import javafx.stage.Stage;

public class Juego extends Application{

    private static final int ancho = 1913;
    private static final int alto = 876;
    
    public static void main(String[] args) {
        Application.launch(args);
        
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Singleton singleton = Singleton.getSingleton();
        singleton.setStage(primaryStage);
        ControladorMenu controlador = new ControladorMenu();
        
        VistaMenu vista = controlador.getVistaMenu();
        primaryStage.setScene(vista.getEscena());
        primaryStage.setTitle("Battle For Glory");
        primaryStage.show();
 
    }
    
    public static int getAncho(){
        return ancho;
    }
    
    public static int getAlto(){
        return alto;
    }
}
    