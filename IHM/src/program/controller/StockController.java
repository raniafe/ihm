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

public class StockController extends HomeController {

    private ModelListOfProduit modelListCustomers = null;
    private ObservableList observableList = FXCollections.observableArrayList();

    @FXML
    private Button fapButton;

    @FXML
    private ListView produitsListView;

    public void initialize(ModelListOfProduit customersList) {
        this.modelListCustomers = customersList;
        observableList.setAll(customersList.getListOfProduitsStock());
        produitsListView.setItems(observableList);
        produitsListView.setCellFactory((Callback<ListView<String>, ListCell>) listView -> new ListCell<ProduitModel>() {
            @Override
            public void updateItem(ProduitModel product, boolean empty) {
                super.updateItem(product, empty);
                if (product != null) {
                    Parent listElement=null;
                    // Load fxml file for this Person
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resources/fxml/Produit.fxml"));

                    ProduitController produitController = new ProduitController();
                    loader.setController(produitController);
                    try {
                        listElement = loader.load(getClass().getResourceAsStream("../../resources/fxml/Produit.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    produitController.setInfo(product);
                    setGraphic(listElement);

                }
            }
        });
        //fapButton.setOnAction(event -> displayFAP());
        //Fonction à déclarer avec les autres Display() ;je ne l'ai pas fait car qqn travaillait dessus
    }
}
