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

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import program.View;
import program.model.ModelListOfProduit;
import program.model.ProduitModel;
import program.view.ViewBoutique;


import java.io.IOException;


public class BoutiqueController extends Controller {



    private ModelListOfProduit modelListCustomers ;


    @FXML
    private BorderPane rootPane ;
    @FXML
    private ListView produitsListView;
    @FXML
    private Button acceuil;
    @FXML
    private Button reservations;
    @FXML
    private Button stock;
    @FXML
    private Button ventes;
    @FXML
    private Button boutique;
    @FXML
    private ImageView imageLogo;

    @FXML
    private ComboBox comboBox ;


    private ObservableList observableList = FXCollections.observableArrayList();


    /*//public ListView getProduitsListView() {
        return produitsListView;
    }*/


    public void initialize(){

        comboBox.setItems(modelListOfProduit.getCategorieList());
        listenToComBox(comboBox);

        loadList(Controller.getModelListOfProduit().getListOfProduitsBoutique(),produitsListView);
        listenTo(produitsListView, View.Produit,"produitR");

        acceuil.setOnAction(event -> displayAccueil());
        //boutique.setOnAction(event->displayBoutique());
        reservations.setOnAction(event -> displayMesReservation());
        stock.setOnAction(event -> displayMonStock());
        ventes.setOnAction(event -> displayMesVentes());


    }

    public void listenToComBox (ComboBox listView) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<String>) (observable, oldValue, newValue) -> {
                    loadList(modelListOfProduit.filtrerListParCategorie(newValue,"stock"), produitsListView);
                    listenTo( produitsListView,View.ProduitStock ,"produitS");

                });
    }




}
