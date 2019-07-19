
package battleforglory.vista;

import battleforglory.Juego;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;

public class VistaMenu {
    private Scene escena;
    private Image fondo = null;
    private Button btnJugar;
    private Button btnAjustes;
    private Button btnCreditos;
    
    private final Image bgImage = new Image("file:src//battleforglory//image//fondoMenu.png");
    private final Image butIM = new Image("file:src//battleforglory//image//play.png");
    private final Image butO = new Image("file:src//battleforglory//image//setting.png");
    private final Image butS = new Image("file:src//battleforglory//image//exit.png");
    public VistaMenu(){
        Pane layoutMenu = new Pane();
        btnJugar = new Button("Jugar");
        btnJugar.setBackground(Background.EMPTY);
        btnJugar.setGraphic(new ImageView(butIM));
        btnJugar.setStyle("-fx-font-family: 'Copperplate Gothic Light'; -fx-font-size: 22;");
        btnAjustes = new Button("Ajustes");
        btnAjustes.setBackground(Background.EMPTY);
        btnAjustes.setGraphic(new ImageView(butO));
        btnAjustes.setStyle("-fx-font-family: 'Copperplate Gothic Light'; -fx-font-size: 22;");
        btnCreditos = new Button("Salir");
        btnCreditos.setBackground(Background.EMPTY);
        btnCreditos.setGraphic(new ImageView(butS));
        btnCreditos.setStyle("-fx-font-family: 'Copperplate Gothic Light'; -fx-font-size: 22;");
        
        
        
        btnJugar.setLayoutX(620);
        btnJugar.setLayoutY(350);
        btnAjustes.setLayoutX(620);
        btnAjustes.setLayoutY(430);
        btnCreditos.setLayoutX(620);
        btnCreditos.setLayoutY(510);
        
        BackgroundImage myBI = new BackgroundImage(bgImage,BackgroundRepeat.REPEAT,
                                                    BackgroundRepeat.NO_REPEAT,
                                                    BackgroundPosition.DEFAULT,
                                                    BackgroundSize.DEFAULT);

        layoutMenu.setBackground(new Background(myBI));
        
        layoutMenu.getChildren().add(btnJugar);
        layoutMenu.getChildren().add(btnAjustes);
        layoutMenu.getChildren().add(btnCreditos);
        
        escena = new Scene(layoutMenu, 1400,700);
        
        DropShadow shadow = new DropShadow();
        btnJugar.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    btnJugar.setEffect(shadow);
                }
        });

        btnJugar.addEventHandler(MouseEvent.MOUSE_EXITED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    btnJugar.setEffect(null);
                }
        });

        btnAjustes.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    btnAjustes.setEffect(shadow);
                }
        });

        btnAjustes.addEventHandler(MouseEvent.MOUSE_EXITED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    btnAjustes.setEffect(null);
                }
        });
        
        btnCreditos.addEventHandler(MouseEvent.MOUSE_ENTERED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    btnCreditos.setEffect(shadow);
                }
        });

        btnCreditos.addEventHandler(MouseEvent.MOUSE_EXITED, 
            new EventHandler<MouseEvent>() {
                @Override public void handle(MouseEvent e) {
                    btnCreditos.setEffect(null);
                }
        });
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
