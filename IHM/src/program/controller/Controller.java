package program.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.View;
import program.model.ProduitModel;

import java.io.IOException;

public  abstract class Controller {

    public abstract void initialize() ;
    public void redirection(Parent element,String fxmlFile, Controller controller) throws IOException {
       FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource(fxmlFile));
        loader.setController(controller);
        Stage stage=(Stage) element.getScene().getWindow();
        //controller.initialize();
        stage.setTitle("Gaspi-Miam");
        stage.setScene(new Scene(root, 770, 475));
        stage.show();
    }
    public void redirection(Parent element, String fxmlFile, ProduitModel produit,String controller) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Stage stage = (Stage) element.getScene().getWindow();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("Gaspi-Miam");
        stage.setScene(new Scene(root, 770, 475));
        switch (controller){
            case "produit": ((ProduitReservationController) loader.getController()).setProduit(produit);
        }
        stage.show();
    }

}
