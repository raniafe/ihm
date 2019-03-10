package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import program.View;

public class VentesController extends Controller {

    @FXML
    private ListView produitsListView;
    @FXML

    private Button AjoutProduit;


    public void initialize() {

        loadList(Controller.getModelListOfProduit().getListOfProduitsVentes(), produitsListView);
        listenTo(produitsListView, View.Produit,"produitR");
        AjoutProduit.setOnMouseClicked(event -> displayMonStock());
    }
}
