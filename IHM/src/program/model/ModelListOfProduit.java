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
        listOfProduitsStock.add( new ProduitModel("yaourt","/resources/images/yaourt1.jpg") );
        listOfProduitsStock.add( new ProduitModel("tomat","/resources/images/tomatoes.jpg") );
        listOfProduitsStock.add( new ProduitModel("poulet","/resources/images/chicken.jpg") );
    }

    public ProduitModel getByName(String produitName){
        switch (produitName){
            case "framb": return listOfProduitsStock.get(0);
            case "yaour": return listOfProduitsStock.get(3);
            case "tomat": return listOfProduitsStock.get(4);
            case "oeufs": return listOfProduitsStock.get(2);
            case "poulet": return listOfProduitsStock.get(5);
            case "orang": return listOfProduitsStock.get(1);
            default:return listOfProduitsStock.get(0);
        }
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
