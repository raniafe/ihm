package program.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;
import program.View;
import program.model.ModelListOfProduit;
import program.model.ProduitModel;

import java.io.IOException;

public  abstract class Controller {

    public abstract void initialize() ;

    public void redirection(Parent element,String fxmlFile, Controller controller) throws IOException {
       FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource(fxmlFile));
        loader.setController(controller);
        Stage stage=(Stage) element.getScene().getWindow();
        controller.initialize();
        stage.setTitle("Gaspi-Miam");
        stage.setScene(new Scene(root, 770, 475));
        stage.show();
    }

    public void redirectionProduit(Parent element, String fxmlFile, ProduitModel produit, String controller) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Stage stage = (Stage) element.getScene().getWindow();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("Gaspi-Miam");
        stage.setScene(new Scene(root, 770, 475));
        switch (controller){
            case "produit": ((ProduitReservationController) loader.getController()).setProduit(produit);
        }
        stage.show();
    }


    public void loadList(ObservableList<ProduitModel> listToObserve, ListView produitListView) {

        ObservableList observableList = FXCollections.observableArrayList();
        observableList.setAll(listToObserve);
        produitListView.setItems(observableList);
        produitListView.setCellFactory((Callback<javafx.scene.control.ListView<String>, ListCell>) listView -> new ListCell<ProduitModel>() {
            @Override
            public void updateItem(ProduitModel product, boolean empty) {
                super.updateItem(product, empty);
                if (product != null) {
                    Parent listElement = null;
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

    }


}
