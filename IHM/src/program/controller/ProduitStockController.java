package program.controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import program.View;
import program.model.ProduitModel;

import java.io.IOException;


public class ProduitStockController extends Controller {

    private ProduitModel produit;

    @FXML
    BorderPane rootPane ;
@FXML
private Text text;
    @FXML
    ImageView image ;

    @FXML
    private Button buttonManger;
    @FXML
    private Button buttonVendre;
    @FXML
    private TextField quantity ;
    @FXML
    private Button donner ;
    String error="";

    public ProduitStockController(){

    }
    public ProduitStockController(ProduitModel produit){

        this.produit=produit;
    }

    public void setProduit(ProduitModel prod){
        this.produit=prod;
        String error = "";

        quantity.setText(Integer.toString(produit.getQuantite()));



         image.setImage(new Image(produit.getImage()));

        // name.setTextContent("Salut");
    }

    public void initialize() {
        //quantity.setItems(modelListOfProduit.getQuantList());
        //name.setValue("Salut");
        //quantity.setText(Integer.toString(produit.getQuantite()));


        buttonManger.setOnMouseClicked(event -> {
            if((Integer.parseInt(quantity.getText())== produit.getQuantite() )  )
            { modelListOfProduit.deleteStock(produit);
              produit.setQuantite(0);
            }
            else if (produit.getQuantite()- Integer.parseInt(quantity.getText()) < 0) {
                quantity.setStyle("-fx-background-color: red;");
                
            }
            else
            {
                modelListOfProduit.addBoutique(produit);
                modelListOfProduit.addVentes(produit);
                produit.setQuantite(produit.getQuantite()-Integer.parseInt(quantity.getText()));
                displayMonStock();
            }


        });


        buttonVendre.setOnMouseClicked(event ->
        {
            if((Integer.parseInt(quantity.getText())== produit.getQuantite() )) {

                try {
                    redirection(rootPane, View.ProduitVenteFormulaire, this.produit, "produitV");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (produit.getQuantite()- Integer.parseInt(quantity.getText()) < 0) {
                quantity.setStyle("-fx-background-color: red;");
            }
            else
            {
                modelListOfProduit.addBoutique(produit);
                modelListOfProduit.addVentes(produit);
                produit.setQuantite(produit.getQuantite()-Integer.parseInt(quantity.getText()));
                displayMonStock();
            }

        });




        donner.setOnAction(event -> {
            if((Integer.parseInt(quantity.getText())== produit.getQuantite() ))
            {
                modelListOfProduit.addBoutique(produit);
                modelListOfProduit.addVentes(produit);
                modelListOfProduit.deleteStock(produit);
                produit.setQuantite(0);
                try {
                    redirection(rootPane, View.MesVentes,new VentesController());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(produit.getQuantite()- Integer.parseInt(quantity.getText()) < 0){
                ControleQuantity();
            }
            else
            {
                modelListOfProduit.addBoutique(produit);
                modelListOfProduit.addVentes(produit);
                produit.setQuantite(produit.getQuantite()-Integer.parseInt(quantity.getText()));
                displayMonStock();
            }




        });
    }

    public void ControleQuantity() {
        if (((produit.getQuantite()- Integer.parseInt(quantity.getText())) < 0 )) {
            quantity.setStyle("-fx-background-color: red;");
        }
    }




}