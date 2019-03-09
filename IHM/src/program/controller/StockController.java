package program.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import program.model.ModelListOfProduit;
import program.model.ProduitModel;

import java.io.IOException;

public class StockController extends Controller {

    private ModelListOfProduit modelListStock = null;

    @FXML
    private Button fapButton;

    @FXML
    private ListView produitsListView;

    public void initialize(ModelListOfProduit listOfProduitStock) {
        this.modelListStock = listOfProduitStock;
        loadList(modelListStock.getListOfProduitsBoutique(), produitsListView);
        //fapButton.setOnAction(event -> displayFAP());
        //Fonction à déclarer avec les autres Display() ;je ne l'ai pas fait car qqn travaillait dessus
    }
}
