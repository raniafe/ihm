package program.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ModelListOfProduit {

    private Set<ProduitModel> listOfCustumers;

    public ModelListOfProduit() {
        listOfCustumers = new HashSet<>();
        listOfCustumers.add( new ProduitModel("Sandrine") ) ;
        listOfCustumers.add( new ProduitModel("Danielle") );
        listOfCustumers.add( new ProduitModel("Claude") );
        listOfCustumers.add( new ProduitModel("Noé") );
        listOfCustumers.add( new ProduitModel("Luna") );
    }

    public void add(ProduitModel person) {
        listOfCustumers.add( person );
    }


    public Set<ProduitModel> getListOfProduits() {
        return listOfCustumers;
    }

}
