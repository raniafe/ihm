package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import program.View;
import program.model.ModelListOfProduit;
import program.model.ProduitModel;
import program.view.ViewBoutique;


import java.io.IOException;

public  class HomeController extends Controller {

    @FXML
    private BorderPane rootPane;
    @FXML
    private Menu Boutique;
    @FXML
    private ImageView framb ;
    @FXML
    private ImageView tomat ;
    @FXML
    private ImageView yaour ;
    @FXML
    private ImageView oeufs ;
    @FXML
    private ImageView poulet ;
    @FXML
    private ImageView orang ;



    public HomeController() {
        this.modelListOfProduit = Controller.getModelListOfProduit() ;
    }

    public void initialize(){
        framb.setOnMouseClicked(event -> displayProduit("framb"));
        yaour.setOnMouseClicked(event -> displayProduit("yaour"));
        tomat.setOnMouseClicked(event -> displayProduit("tomat"));
        oeufs.setOnMouseClicked(event -> displayProduit("oeufs"));
        poulet.setOnMouseClicked(event -> displayProduit("poulet"));
        orang.setOnMouseClicked(event -> displayProduit("orang"));
    }

    public void displayProduit(String produitName){
        try {
            redirection(rootPane, View.Produit, this.modelListOfProduit.getByName(produitName), "produit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
