package program.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ModelListOfProduit {

    private ObservableList<ProduitModel> listOfProduitsStock;
    private ObservableList<ProduitModel> listOfProduitsBoutique;

    public ModelListOfProduit() {
        listOfProduitsStock = FXCollections.observableList( new ArrayList<>());
        listOfProduitsBoutique = FXCollections.observableList( new ArrayList<>());
        listOfProduitsStock.add( new ProduitModel("Framboises", "/resources/images/framboise1.jpg") ) ;
        listOfProduitsStock.add( new ProduitModel("Oranges","/resources/images/oranges.jpg") );
        listOfProduitsStock.add( new ProduitModel("Eggs","/resources/images/eggs.jpg") );
        listOfProduitsStock.add(new ProduitModel("Yaourt", "/resources/images/yaourt1.jpg"));
        listOfProduitsStock.add(new ProduitModel("Tomates", "/resources/images/tomatoes.jpg"));
    }

    public void addStock(ProduitModel person) {
        listOfProduitsStock.add( person );
    }

    public void addBoutique(ProduitModel person) {
        listOfProduitsBoutique.add( person );
    }

    public ObservableList<ProduitModel> getListOfProduitsStock() {
        return listOfProduitsBoutique;
    }

    public ObservableList<ProduitModel> getListOfProduitsBoutique() {
        return listOfProduitsBoutique;
    }

}
