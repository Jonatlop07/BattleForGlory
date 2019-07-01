
package battleforglory.vista;

import battleforglory.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class VistaMenu {
    private Scene escena;
    private Image fondo = null;
    private Button btnJugar;
    private Button btnAjustes;
    private Button btnCreditos;
    private final Image bgImage = new Image("file:src//battleforglory//image//fondoMenu.png");
    
    public VistaMenu(){
        Pane layoutMenu = new Pane();
        btnJugar = new Button("Jugar");
        btnAjustes = new Button("Ajustes");
        btnCreditos = new Button("Creditos");
        
        btnJugar.setLayoutX(680);
        btnJugar.setLayoutY(350);
        btnAjustes.setLayoutX(680);
        btnAjustes.setLayoutY(380);
        btnCreditos.setLayoutX(680);
        btnCreditos.setLayoutY(410);
        
        
        BackgroundImage myBI = new BackgroundImage(bgImage,BackgroundRepeat.REPEAT,
                                                    BackgroundRepeat.NO_REPEAT,
                                                    BackgroundPosition.DEFAULT,
                                                    BackgroundSize.DEFAULT);

        layoutMenu.setBackground(new Background(myBI));
        
        layoutMenu.getChildren().add(btnJugar);
        layoutMenu.getChildren().add(btnAjustes);
        layoutMenu.getChildren().add(btnCreditos);
        
        escena = new Scene(layoutMenu, Juego.getAncho(), Juego.getAlto());
        
    }
    
    public Scene getEscena(){
        return escena;
    }
    
    public Button getBtnJugar(){
        return btnJugar;
    }
    
    public Button getBtnAjustes(){
        return btnAjustes;
    }
    
    public Button getBtnCreditos(){
        return btnCreditos;
    }
}
