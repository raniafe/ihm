package program.controller;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import program.View;
import program.model.ProduitModel;

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
            modelListOfProduit.addVente(produit);
            try {
                produit.setQuantite(produit.getQuantite() - Integer.parseInt(quantite.getText()));
                produit.setPriw(Integer.parseInt(prix.getText()));
                displayMesVentes();
            } catch (Exception e) {
                e.printStackTrace();
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
