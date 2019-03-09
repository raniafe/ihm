package program.view;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import program.controller.BoutiqueController;
import program.controller.ProduitController;
import program.model.ModelListOfProduit;
import program.model.ProduitModel;

import java.io.IOException;

public class ViewBoutique {

    public static final String XML_FILE = "../../resources/fxml/Boutique2.fxml";
    private static final String PRODUIT = "../../resources/Produit.fxml";
    private static ModelListOfProduit model;
    private static BoutiqueController controller;
    public static final String imageLogo = "program/resources/images/logo11.jpg";



    public void init(ModelListOfProduit model, BoutiqueController controller) {
        ViewBoutique.model = model;
        ViewBoutique.controller = controller;
        //init the ObservableList of custumers to the ListView
        // controller.getProduitsListView().setItems(model.getListOfProduits());

        //call a cell factory and display each observable item in the ListView
       // adaptItems( controller.getProduitsListView() );


    }




}
