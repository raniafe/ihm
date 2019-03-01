package program.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelListOfProduit {

    private ObservableList<ProduitModel> listOfCustumers;

    public ModelListOfProduit() {
        listOfCustumers = FXCollections.observableList( new ArrayList<>());
        listOfCustumers.add( new ProduitModel("Sandrine") ) ;
        listOfCustumers.add( new ProduitModel("Danielle") );
        listOfCustumers.add( new ProduitModel("Claude") );
        listOfCustumers.add( new ProduitModel("Noé") );
        listOfCustumers.add( new ProduitModel("Luna") );
    }

    public void add(ProduitModel person) {
        listOfCustumers.add( person );
    }



    public ObservableList<ProduitModel> getListOfProduits() {
        return listOfCustumers;
    }

}
