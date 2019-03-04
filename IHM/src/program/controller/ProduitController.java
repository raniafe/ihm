package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import program.model.ProduitModel;

import java.io.IOException;

public class ProduitController {

    private ProduitModel produitModel ;

    @FXML
    private VBox VBox;

    @FXML
    private Label name;

    @FXML
    private Label nam ;

    @FXML
    private ImageView image ;

    public ProduitController() {
      /* FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resources/fxml/Produit.fxml"));
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    }

    public void init(ProduitModel produitModel) {
       name.setText(produitModel.getName());
    }

    public void setInfo(ProduitModel product) {
        name.setText(product.getName());
        image.setImage(new Image(product.getImage()));
      //  nam.setText("Rania");
    }

    public Parent getBox() {
        return VBox;
    }
}
