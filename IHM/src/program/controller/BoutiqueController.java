package program.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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


    private ObservableList observableList = FXCollections.observableArrayList();


    /*//public ListView getProduitsListView() {
        return produitsListView;
    }*/


    public void initialize(){

        loadList(Controller.getModelListOfProduit().getListOfProduitsBoutique(),produitsListView);
        listenTo(produitsListView, View.Produit,"produitR");

        acceuil.setOnAction(event -> displayAccueil());
        //boutique.setOnAction(event->displayBoutique());
        reservations.setOnAction(event -> displayMesReservation());
        stock.setOnAction(event -> displayMonStock());
        ventes.setOnAction(event -> displayMesVentes());


    }




}
