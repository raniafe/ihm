package program.controller;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import program.View;
import program.model.ModelListOfProduit;
import program.model.ModelListOfProduit;
import program.model.ModelListOfProfile;
import program.model.ProduitModel;
import program.view.ViewBoutique;

import java.io.IOException;

public   class Controller {
    @FXML
    private BorderPane rootPane;

    protected static ModelListOfProduit modelListOfProduit ;
    ModelListOfProfile modelListOfProfile ;
    public Controller(){
        modelListOfProduit = new ModelListOfProduit() ;
        modelListOfProfile = new ModelListOfProfile() ;
    }
   // public void initialize(ModelListOfProduit modelListOfProduit) {}
   // public void initialize(ModelListOfProfile modelListOfProfile) {}
    public  void initialize() {}

    public void displayAccueil(){
        try {
            redirection(rootPane, View.Accueil,new HomeController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayBoutique()  throws Exception{

        FXMLLoader loader = new FXMLLoader();

        ViewBoutique view = new ViewBoutique();

        //create a controller
        BoutiqueController controller = new BoutiqueController();

        //attach controller
        loader.setController(controller);

        //attach XML file
        Parent root = loader.load(getClass().getResourceAsStream(View.BOUTIQUE));


        //initialize the controller
        controller.initialize( );

        view.init( modelListOfProduit, controller );

        //create the view
        Stage primaryStage=(Stage) rootPane.getScene().getWindow();
        primaryStage.setScene(new Scene(root, 770, 475));

        //show the view
        primaryStage.show();
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


    public void redirection(Parent element,String fxmlFile, Controller controller) throws IOException {
       FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource(fxmlFile));
        loader.setController(controller);
        Stage stage=(Stage) element.getScene().getWindow();
//        controller.initialize();
        stage.setTitle("Gaspi-Miam");
        stage.setScene(new Scene(root, 770, 475));
        stage.show();
    }
    public void redirection(Parent element, String fxmlFile, ProduitModel produit,String controller) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Stage stage = (Stage) element.getScene().getWindow();
        Parent root = loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setScene(new Scene(root, 770, 475));
        switch (controller){
            case "produit": ((ProduitReservationController) loader.getController()).setProduit(produit);
        }
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

    public void listenTo(ListView listView) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<ProduitModel>) (observable, oldValue, newValue) -> {

                    try {
                        redirection(rootPane,View.Produit,newValue,"produit");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }


}
