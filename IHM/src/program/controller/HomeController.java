package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import program.View;
import program.model.ModelListOfProduit;
import program.model.ProduitModel;
import program.view.ViewBoutique;


import java.io.IOException;

public class HomeController extends Controller {

    @FXML
    private BorderPane rootPane;
    @FXML
    private Menu Boutique;
    @FXML
    private ImageView framb ;
    @FXML
    private ImageView tomat ;
    @FXML
    private ImageView yaour ;
    @FXML
    private ImageView oeufs ;
    @FXML
    private ImageView poulet ;
    @FXML
    private ImageView orang ;

    public void initialize(){
        framb.setOnMouseClicked(event -> displayProduit("framb"));
        yaour.setOnMouseClicked(event -> displayProduit("yaour"));
        tomat.setOnMouseClicked(event -> displayProduit("tomat"));
        oeufs.setOnMouseClicked(event -> displayProduit("oeufs"));
        poulet.setOnMouseClicked(event -> displayProduit("poulet"));
        orang.setOnMouseClicked(event -> displayProduit("orang"));
    }

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
        Parent root = loader.load(getClass().getResourceAsStream(view.XML_FILE));

        ModelListOfProduit model = new ModelListOfProduit();

        //initialize the controller
        controller.initialize( model );

        view.init( model, controller );

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
    public void displayProduit(String produitName){
        try {
            redirection(rootPane, View.Produit, new ModelListOfProduit().getByName(produitName), "produit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
