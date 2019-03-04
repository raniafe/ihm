package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import program.View;
import program.model.ModelListOfProduit;
import program.view.ViewBoutique;

import javax.swing.*;

import java.io.IOException;

public class HomeController extends Controller {

    @FXML
    private BorderPane rootPane;
    @FXML
    private Menu Boutique;

    @FXML
    public void initialize(){

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
        primaryStage.setScene(new Scene(root, 700, 600));

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
           redirection(rootPane, View.MonStock, new HomeController());
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
    public void displayProduit(){
        try {
            redirection(rootPane, View.Produit, new ProduitReservationController());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
