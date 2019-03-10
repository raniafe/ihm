package program.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
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
    private TextArea quantity ;
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
         quantity.setText(Integer.toString(produit.getQuantite()));
        // name.setTextContent("Salut");
    }

    public void initialize() {
        //quantity.setItems(modelListOfProduit.getQuantList());
        //name.setValue("Salut");
        buttonManger.setOnMouseClicked(event -> {
            if((Integer.parseInt(quantity.getText())== produit.getQuantite() ) || ((produit.getQuantite()- Integer.parseInt(quantity.getText())) == 0 ) )
            modelListOfProduit.deleteStock(produit);
            else
                produit.setQuantite(produit.getQuantite()-Integer.parseInt(quantity.getText()));

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
            if((Integer.parseInt(quantity.getText())== produit.getQuantite() ) || ((produit.getQuantite()- Integer.parseInt(quantity.getText())) == 0 ) )
            {
                modelListOfProduit.addBoutique(produit);
                modelListOfProduit.addVentes(produit);
                modelListOfProduit.deleteStock(produit);
                try {
                    redirection(rootPane, View.MesVentes,new VentesController());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        else
            {produit.setQuantite(produit.getQuantite()-Integer.parseInt(quantity.getText()));
            displayMonStock();
            }




        });
    }




}