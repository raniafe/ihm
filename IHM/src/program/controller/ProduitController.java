package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import program.model.ProduitModel;

public class ProduitController {

    @FXML
    private Label name;

    public void init(ProduitModel produit) {
        name.setText(produit.getName());
    }

}
