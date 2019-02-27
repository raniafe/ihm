package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import program.View;

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
            redirection(rootPane, View.Accueil);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayBoutique(){
        try {
            redirection(rootPane, View.BOUTIQUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMonCompte(){
        try {
            redirection(rootPane, View.MonCompte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


   public void displayMonStock() {
       try {
           redirection(rootPane, View.MonStock);
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public void displayMesReservation(){
        try {
            redirection(rootPane, View.MesReservations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayMesVentes() {
        try {
            redirection(rootPane, View.MesVentes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
