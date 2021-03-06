package program.controller;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import program.View;
import program.model.ModelListOfProduit;
import program.model.ModelListOfProduit;
import program.model.ModelListOfProfile;
import program.model.ProduitModel;
import program.view.ViewBoutique;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public   class Controller extends Application {
    @FXML
    private BorderPane rootPane;

    protected static ModelListOfProduit modelListOfProduit ;
    protected static ModelListOfProfile modelListOfProfile ;

    public Controller(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    public Controller(ModelListOfProduit modelListOfProduit, ModelListOfProfile modelListOfProfile) {

        this.modelListOfProduit = modelListOfProduit;
        this.modelListOfProfile = modelListOfProfile;
    }

    public  void initialize() {}


    public void displayAccueil(){
        try {
            redirection(rootPane, View.Accueil,new HomeController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayBoutique()  throws Exception{

        try {
            redirection(rootPane, View.BOUTIQUE,new BoutiqueController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayMonCompte(){
        try {
            redirection(rootPane, View.MonCompte, new CompteController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMonStock() {
        try {
            redirection(rootPane, View.MonStock, new StockController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMesReservation(){
        try {
            redirection(rootPane, View.MesReservations, new ResaController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMesVentes() {
        try {
            redirection(rootPane, View.MesVentes, new VentesController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void displayServicesClient(){
        final TextField textField = new TextField("gaspi-miam@gmail.com");
        getHostServices().showDocument("mailto:"+textField.getText());
    }


    public void redirection(Parent element,String fxmlFile, Controller controller) throws IOException {
       FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource(fxmlFile));
        root.getStylesheets().add("/resources/Accueil.css");
        loader.setController(controller);
        Stage stage=(Stage) element.getScene().getWindow();
        stage.setTitle("Gaspi-Miam");
        stage.setScene(new Scene(root, 900, 700));
        stage.show();
    }
    public void redirection(Parent element, String fxmlFile, ProduitModel produit,String controller) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Stage stage = (Stage) element.getScene().getWindow();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        root.getStylesheets().add("/resources/Accueil.css");
        stage.setScene(new Scene(root, 900, 700));
        switch (controller){
            case "produitR": ((ProduitReservationController) loader.getController()).setProduit(produit);break;
            case "produitS" :  ((ProduitStockController) loader.getController()).setProduit(produit);break;
            case "produitV":
                ((ProduitVenteFormulaireController) loader.getController()).setProduit(produit);
                break;
        }
        System.out.println(produit);
        stage.show();
    }

    public static ModelListOfProduit getModelListOfProduit() { return modelListOfProduit ;
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

    public void listenTo(ListView listView, String fxml, String prodT) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<ProduitModel>) (observable, oldValue, newValue) -> {
                    try {
                        redirection(rootPane, fxml, newValue, prodT);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static ModelListOfProfile getModelListOfProfile() {
        return modelListOfProfile;
    }


    public Boolean confirmation(){

        FXMLLoader loader = new FXMLLoader();
        try {
            AlertController controler=new AlertController();
            loader.setController(controler);
            Stage stage=new Stage();
            Parent rootNode = loader.load(getClass().getResourceAsStream(View.Alertes));
            rootNode.getStylesheets().add("/resources/styles/styles.css");

            stage.setScene(new Scene(rootNode));
            stage.setTitle("Alerte");
            stage.setMinWidth(250);
            return controler.init(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


}
