package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import program.View;
import program.model.ModelListOfProduit;

public class ResaController extends Controller {

    public ResaController() {
    }

    @FXML
    private ListView produitsListView;


    public void initialize() {
        loadList(Controller.getModelListOfProduit().getListOfProduitsRéservation(), produitsListView);
        listenTo(produitsListView, View.Produit,"produitR");

    }
}
