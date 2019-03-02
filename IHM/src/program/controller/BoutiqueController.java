package program.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import javafx.util.Callback;

import program.model.ModelListOfProduit;
import program.model.ProduitModel;


public class BoutiqueController extends HomeController {



    private ModelListOfProduit modelListCustomers = null;


    @FXML
    private ListView produitsListView;
    private ObservableList observableList = FXCollections.observableArrayList();


    public ListView getProduitsListView() {
        return produitsListView;
    }


    public void initialize(ModelListOfProduit customersList){
        this.modelListCustomers = customersList;
        observableList.setAll(customersList.getListOfProduits());
        produitsListView.setItems(observableList);
        produitsListView.setCellFactory((Callback<ListView<String>, ListCell>) listView -> {
            return new ListCell<ProduitModel>() {
                @Override
                public void updateItem(ProduitModel product, boolean empty) {
                    super.updateItem(product, empty);
                    if (product != null) {
                        ProduitController produitController = new ProduitController();
                        produitController.setInfo(product);
                        setGraphic(produitController.getBox());
                    }
                }
            };
        });

    }


}
