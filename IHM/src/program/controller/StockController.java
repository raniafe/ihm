package program.controller;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import program.View;
import program.model.ModelListOfProduit;
import program.model.ProduitModel;

import java.io.IOException;

public class StockController extends Controller {

    private ModelListOfProduit modelListStock = null;
    private int rangeSelectedItem = -1 ;

    @FXML
    private Button fapButton;

    @FXML
    private ComboBox comboBox ;

    @FXML
    private BorderPane rootPane ;

    @FXML
    private ListView produitsListView;

    public void initialize() {

        comboBox.setItems(modelListOfProduit.getCategorieList());
        loadList(Controller.getModelListOfProduit().getListOfProduitsStock(), produitsListView);
        listenTo( produitsListView );
        //fapButton.setOnAction(event -> displayFAP());
        //Fonction à déclarer avec les autres Display() ;je ne l'ai pas fait car qqn travaillait dessus
        listenToComBox(comboBox);
    }

    public void listenToComBox (ComboBox listView) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<String>) (observable, oldValue, newValue) -> {

                    rangeSelectedItem = modelListOfProduit.getCategorieList().indexOf(newValue);
                    System.out.println(rangeSelectedItem);
                   // filtrerList(modelListOfProduit.getCategorieList().get(rangeSelectedItem)) ;
                });
    }





}
