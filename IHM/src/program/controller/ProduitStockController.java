package program.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import program.View;
import program.model.ProduitModel;

import java.io.IOException;


public class ProduitStockController extends Controller {

    private ProduitModel produit;

    @FXML
    BorderPane rootPane ;

    @FXML
    ImageView image ;

    @FXML
    private Button buttonManger;
    @FXML
    private Button buttonVendre;


    @FXML
    private Button donner ;

    public ProduitStockController(){

    }
    public ProduitStockController(ProduitModel produit){

        this.produit=produit;
    }

    public void setProduit(ProduitModel prod){
        this.produit=prod;
         image.setImage(new Image(produit.getImage()));
        // name.setTextContent("Salut");
    }

    public void initialize() {
        //quantity.setItems(modelListOfProduit.getQuantList());
        //name.setValue("Salut");
        buttonManger.setOnMouseClicked(event -> {
            modelListOfProduit.deleteStock(produit);
            displayMonStock();

        });

        buttonVendre.setOnMouseClicked(event ->
        {
            try {
                redirection(rootPane, View.ProduitVenteFormulaire, this.produit, "produitV");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });




        donner.setOnAction(event -> {
            modelListOfProduit.addBoutique(produit);
            modelListOfProduit.addVentes(produit);
            modelListOfProduit.deleteStock(produit);
            try {
                redirection(rootPane, View.MesVentes,new VentesController());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }




}