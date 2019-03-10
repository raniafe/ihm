package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import program.View;

public class VentesController extends Controller {
    @FXML
    private ListView produitsListView;


    public void initialize() {

        loadList(Controller.getModelListOfProduit().getListOfProduitsVentes(), produitsListView);
        listenTo(produitsListView, View.Produit,"produitR");


    }
}
