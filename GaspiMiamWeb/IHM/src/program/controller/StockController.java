package program.controller;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import program.View;
import program.model.ModelListOfProduit;
import program.model.ProduitModel;

import java.io.IOException;
import java.util.Date;

public class StockController extends Controller {

    private ModelListOfProduit modelListStock = null;
    private int rangeSelectedItem = -1 ;

    @FXML
    private Button alertes;

    @FXML
    private Button fapButton;

    @FXML
    private Button tousProd ;


    @FXML
    private ComboBox comboBox ;

    @FXML
    private BorderPane rootPane ;

    @FXML
    private DatePicker Date ;

    @FXML
    private ListView produitsListView;

    public StockController() {

    }


    public void initialize() {

        comboBox.setItems(modelListOfProduit.getCategorieList());
        loadList(Controller.getModelListOfProduit().getListOfProduitsStock(), produitsListView);
        listenTo(produitsListView, View.ProduitStock,"produitS");
        //fapButton.setOnAction(event -> displayFAP());
        //Fonction à déclarer avec les autres Display() ;je ne l'ai pas fait car qqn travaillait dessus
        listenToComBox(comboBox);

        fapButton.setOnMouseClicked(event -> displayProduitFormulaire());
        listenToDate(Date);

        alertes.setOnAction(event -> {
            loadList(modelListOfProduit.getProduitsAlertes(),produitsListView) ;
            listenTo(produitsListView, View.Produit,"produitS");
        });

        tousProd.setOnAction(event -> {
            loadList(Controller.getModelListOfProduit().getListOfProduitsStock(), produitsListView);
            listenTo(produitsListView, View.ProduitStock,"produitS");
        });

    }

    public void listenToComBox (ComboBox listView) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<String>) (observable, oldValue, newValue) -> {

                    rangeSelectedItem = modelListOfProduit.getCategorieList().indexOf(newValue);
                    System.out.println(newValue) ;
                    loadList(modelListOfProduit.filtrerListParCategorie(newValue,"stock"), produitsListView);
                    listenTo( produitsListView,View.ProduitStock ,"produitS");

                   // filtrerList(modelListOfProduit.getCategorieList().get(rangeSelectedItem)) ;
                });
    }

    public void displayProduitFormulaire() {
        try {
            redirection(rootPane, View.ProduitFormulaire, new ProduitFormulaireController());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void listenToDate(DatePicker date)
    {

    }





}
