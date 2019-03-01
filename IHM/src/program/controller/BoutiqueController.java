package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import program.model.ModelListOfProduit;



public class BoutiqueController extends HomeController {



    private ModelListOfProduit modelListCustomers = null;


    @FXML
    private ListView produitsListView;


    public ListView getProduitsListView() {
        return produitsListView;
    }


    public void initialize(ModelListOfProduit customersList){
        this.modelListCustomers = customersList;


    }


}
