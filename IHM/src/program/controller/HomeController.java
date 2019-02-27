package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;

import java.io.IOException;

public class HomeController extends Controller {

    @FXML
    private BorderPane rootPane;
    @FXML
    private Menu Boutique;

    @FXML
    public void initialize(){
        /*Boutique.setOnAction(event -> {
            try {
                redirectionBoutique(rootPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });*/

    }

    public void displayMonCompte(){
        try {
            redirectionMonCompte(rootPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   public void displayMonStock() {
        String fxmlFile = "../../resources/fxxml/Mon_stock.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        try {

            Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
            this.rootPane.setRight(rootNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
