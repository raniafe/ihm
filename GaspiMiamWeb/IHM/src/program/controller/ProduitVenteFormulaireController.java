package program.controller;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import program.View;
import program.model.ProduitModel;

import java.awt.*;
import java.awt.TextField;
import java.io.IOException;
import java.util.Date;

public class ProduitVenteFormulaireController extends Controller {

    @FXML
    private BorderPane rootPane;
    @FXML
    private TextArea quantite;
    @FXML
    private TextArea prix;
    @FXML
    private ImageView image;
    @FXML
    private Button buttonVendre;

    private ProduitModel produit;

    public ProduitVenteFormulaireController() {
    }

    public void initialize() {
        buttonVendre.setOnMouseClicked(event -> {
            if((Integer.parseInt(quantite.getText())== produit.getQuantite() ) || ((produit.getQuantite()- Integer.parseInt(quantite.getText())) <= 0 ) )
            {
                modelListOfProduit.addBoutique(produit);
                modelListOfProduit.addVentes(produit);
                modelListOfProduit.deleteStock(produit);
                produit.setPriw(Integer.parseInt(prix.getText()));
                produit.setQuantite(0);
                displayMesVentes();

            }
            else
            {
                modelListOfProduit.addBoutique(produit);
                modelListOfProduit.addVentes(produit);
                produit.setQuantite(produit.getQuantite()-Integer.parseInt(quantite.getText()));
                produit.setPriw(Integer.parseInt(prix.getText()));
                displayMesVentes();
            }
        });
    }

    public void setProduit(ProduitModel prod) {

        this.produit = prod;
        image.setImage(new Image(produit.getImage()));

        quantite.setText(Integer.toString(produit.getQuantite()));
        prix.setText(Integer.toString(produit.getPrix()));
    }

}
