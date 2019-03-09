package program.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ModelListOfProduit {

    private ObservableList<ProduitModel> listOfProduitsStock;
    private ObservableList<ProduitModel> listOfProduitsBoutique;
    private ObservableList<ProduitModel> listOfProduitsVentes;

    public ModelListOfProduit() {
        listOfProduitsStock = FXCollections.observableList( new ArrayList<>());
        listOfProduitsBoutique = FXCollections.observableList( new ArrayList<>());
        listOfProduitsVentes = FXCollections.observableList(new ArrayList<>());

        listOfProduitsBoutique.add(new ProduitModel("Framboises", "/resources/images/framboise1.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("Eggs", "/resources/images/eggs.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("yaourt", "/resources/images/yaourt1.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("tomat", "/resources/images/tomatoes.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("poulet", "/resources/images/chicken.jpg"));


        listOfProduitsStock.add(new ProduitModel("passsion", "/resources/images/passion.jpg"));
        listOfProduitsStock.add(new ProduitModel("salade", "/resources/images/salad.jpg"));
        listOfProduitsStock.add(new ProduitModel("banane", "/resources/images/banana.jpg"));

        listOfProduitsVentes.add(new ProduitModel("cerise", "/resources/images/cerise.jpg"));
        listOfProduitsVentes.add(new ProduitModel("abricot", "/resources/images/abricot.jpg"));
        listOfProduitsVentes.add(new ProduitModel("champignons", "/resources/images/champignons.jpg"));
        listOfProduitsVentes.add(new ProduitModel("citron", "/resources/images/citron.jpg"));


    }

    public ProduitModel getByName(String produitName){
        switch (produitName){

            case "framb":
                return listOfProduitsBoutique.get(0);
            case "yaour":
                return listOfProduitsBoutique.get(3);
            case "tomat":
                return listOfProduitsBoutique.get(4);
            case "oeufs":
                return listOfProduitsBoutique.get(2);
            case "poulet":
                return listOfProduitsBoutique.get(5);
            case "orang":
                return listOfProduitsBoutique.get(1);

            case "passion":
                return listOfProduitsStock.get(0);
            case "salade":
                return listOfProduitsStock.get(1);
            case "banane":
                return listOfProduitsStock.get(2);

            case "cerise":
                return listOfProduitsVentes.get(0);
            case "abricot":
                return listOfProduitsVentes.get(1);
            case "champignons":
                return listOfProduitsVentes.get(2);
            case "citron":
                return listOfProduitsVentes.get(3);

            default:
                return listOfProduitsBoutique.get(0);
        }
    }

    public void addStock(ProduitModel person) {
        listOfProduitsStock.add( person );
    }

    public void addBoutique(ProduitModel person) {
        listOfProduitsBoutique.add( person );
    }

    public ObservableList<ProduitModel> getListOfProduitsStock() {
        return listOfProduitsStock;
    }

    public ObservableList<ProduitModel> getListOfProduitsBoutique() {
        return listOfProduitsBoutique;
    }

    public ObservableList<ProduitModel> getListOfProduitsVentes() {
        return listOfProduitsVentes;
    }
}
