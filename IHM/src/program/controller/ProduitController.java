package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import program.View;
import program.model.ProduitModel;

import java.io.IOException;

public class ProduitController extends Controller{

    private ProduitModel produitModel ;

    @FXML
    private HBox HBox;

    @FXML
    private Label name;

    @FXML
    private Label nam ;

    @FXML
    private ImageView image ;


    public ProduitController() {

    }

    public void initialize() {




    }

    public void setInfo(ProduitModel product) {
        name.setText(product.getName());
        image.setImage(new Image(product.getImage()));

      //  nam.setText("Rania");
    }

    public Parent getBox() {
        return HBox;
    }


}
