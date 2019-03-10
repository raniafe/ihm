package program.controller;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import program.model.ModelListOfProduit;
import program.model.ModelListOfProfile;
import program.model.ProduitModel;

import java.util.Date;

public class ProduitFormulaireController extends Controller {


    private int rangeSelectedItem = -1;

    @FXML
    private DataFormat datta;

    @FXML
    private ComboBox categorie;

    @FXML
    private TextField name;

    @FXML
    private TextField quantite2;

    @FXML
    private Button Buttonajouter;

    @FXML
    private BorderPane rootPane;


    public void initialize() {

        categorie.setItems(modelListOfProduit.getCategorieList());

        Buttonajouter.setOnMouseClicked(event -> {

            modelListOfProduit.addStock(ajoutProduit());
            displayMonStock();

        });
    }

    private ProduitModel ajoutProduit() {

        return new ProduitModel(name.getText(),
                Integer.parseInt(quantite2.getText()),
                listenToComBox(categorie),
                new Date(10 / 03 / 2019),
                "/resources/images/photo.jpg");
    }

    private String listenToComBox(ComboBox categorie) {
        String categorieSelected = "";
        categorie.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<String>) (observable, oldValue, newValue) -> {
                    rangeSelectedItem = modelListOfProduit.getCategorieList().indexOf(newValue);
                    categorieSelected.equals(newValue);
                });
        return categorieSelected;
    }
}
