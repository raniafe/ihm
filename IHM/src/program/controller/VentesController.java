package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class VentesController extends Controller {
    @FXML
    private ListView produitsListView;


    public void initialize() {

        loadList(Controller.getModelListOfProduit().getListOfProduitsVentes(), produitsListView);

    }
}
