package program.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ModelListOfProduit {

    private ObservableList<ProduitModel> listOfCustumers;

    public ModelListOfProduit() {
        listOfCustumers = FXCollections.observableList( new ArrayList<>());
        listOfCustumers.add( new ProduitModel("Framboises", "/resources/images/framboise1.jpg") ) ;
        listOfCustumers.add( new ProduitModel("Oranges","/resources/images/oranges.jpg") );
        listOfCustumers.add( new ProduitModel("Eggs","/resources/images/eggs.jpg") );
        listOfCustumers.add( new ProduitModel("yaourt","/resources/images/yaourt1.jpg") );
        listOfCustumers.add( new ProduitModel("tomates","/resources/images/tomatoes.jpg") );
    }

    public void add(ProduitModel person) {
        listOfCustumers.add( person );
    }


    public ObservableList<ProduitModel> getListOfProduits() {
        return listOfCustumers;
    }

}
