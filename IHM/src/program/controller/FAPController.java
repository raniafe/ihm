package program.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.util.Callback;
import program.model.ModelListOfProduit;
import program.model.ProduitModel;

import java.io.IOException;

public class FAPController extends Controller {

    @FXML
    private Button addButton;

    @FXML
    private DatePicker calendar;

    @FXML
    private ComboBox category;

    @FXML
    private TextField nameTag;

    @FXML
    private TextField quantityTag;



    public FAPController() {

    }


/*
    public void initialize() {

        addButton.setOnAction(event -> new ModelListOfProduit().addStock(new ProduitModel(nameTag.getText(),"")));
    }

*/

}
