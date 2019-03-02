package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import program.model.ProduitModel;

import java.io.IOException;

public class ProduitController {

    @FXML
    private VBox VBox;

    @FXML
    private Label name;

    public ProduitController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/Produit.fxml"));
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void init(ProduitModel produit) {
        name.setText(produit.getName());
    }

    public void setInfo(ProduitModel product) {
        name.setText(product.getName());
    }

    public Node getBox() {
        return VBox;
    }
}
