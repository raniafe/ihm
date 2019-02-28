package program.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.View;

import java.io.IOException;

public  abstract class Controller {

    public abstract void initialize() ;
    public void redirection(Parent element,String fxmlFile, Controller controller) throws IOException {
        FXMLLoader loader = new FXMLLoader() ;
        loader.setController(controller);
        Stage stage=(Stage) element.getScene().getWindow();
        controller.initialize();
        Parent root = loader.load(getClass().getResource(fxmlFile));
        stage.setTitle("Gaspi-Miam");
        stage.setScene(new Scene(root, 700, 475));
        stage.show();
    }
}
