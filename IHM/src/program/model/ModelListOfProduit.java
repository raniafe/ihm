package program.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class ModelListOfProduit {

    private String[] categories = {"Fruit", "Legume", "Autres"} ;
    private ObservableList<String> categorieList =FXCollections.observableList( new ArrayList(Arrays.asList(categories)));
    private ObservableList<ProduitModel> listOfProduitsStock;
    private ObservableList<ProduitModel> listOfProduitsBoutique;
    private ObservableList<ProduitModel> listOfProduitsVentes;
    private ObservableList<ProduitModel> listOfProduitsRéservation ;

    public ModelListOfProduit() {

        listOfProduitsStock = FXCollections.observableList( new ArrayList<>());
        listOfProduitsBoutique = FXCollections.observableList( new ArrayList<>());
        listOfProduitsVentes = FXCollections.observableList(new ArrayList<>());
        listOfProduitsRéservation = FXCollections.observableList(new ArrayList<>());

        listOfProduitsBoutique.add(new ProduitModel("Framboises", 3, "Fruit", new Date(13 / 03 / 2019), "/resources/images/framboise1.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("Oranges", 12, "Fruit", new Date(16 / 03 / 2019), "/resources/images/oranges.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("Eggs", 2, "Autres", new Date(17 / 03 / 2019), "/resources/images/eggs.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("yaourt", 8, "Autres", new Date(12 / 03 / 2019), "/resources/images/yaourt1.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("tomat", 6, "Legume", new Date(13 / 03 / 2019), "/resources/images/tomatoes.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("poulet", 1, "Autres", new Date(15 / 03 / 2019), "/resources/images/chicken.jpg"));


        listOfProduitsStock.add(new ProduitModel("fruit", 7, "Fruit", new Date(13 / 03 / 2019), "/resources/images/passion.jpg"));
        listOfProduitsStock.add(new ProduitModel("salade", 2, "Legume", new Date(16 / 03 / 2019), "/resources/images/salad.jpg"));
        listOfProduitsStock.add(new ProduitModel("banane", 12, "Fruit", new Date(17 / 03 / 2019), "/resources/images/banana.jpg"));

        listOfProduitsVentes.add(new ProduitModel("cerise", 9, "Fruit", new Date(13 / 03 / 2019), "/resources/images/cerise.jpg"));
        listOfProduitsVentes.add(new ProduitModel("abricot", 2, "Fruit", new Date(17 / 03 / 2019), "/resources/images/abricot.jpg"));
        listOfProduitsVentes.add(new ProduitModel("champi", 20, "Legume", new Date(12 / 03 / 2019), "/resources/images/champignons.jpg"));
        listOfProduitsVentes.add(new ProduitModel("citron", 4, "Legume", new Date(16 / 03 / 2019), "/resources/images/citron.jpg"));


        listOfProduitsRéservation.add(new ProduitModel("melon", 1, "Fruit", new Date(16 / 03 / 2019), "/resources/images/melon.jpg"));
        listOfProduitsRéservation.add(new ProduitModel("pêche", 12, "Fruit", new Date(13 / 03 / 2019), "/resources/images/peach.jpg"));


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

            case "fruit":
                return listOfProduitsStock.get(0);
            case "salade":
                return listOfProduitsStock.get(1);
            case "banane":
                return listOfProduitsStock.get(2);

            case "cerise":
                return listOfProduitsVentes.get(0);
            case "abricot":
                return listOfProduitsVentes.get(1);
            case "champi":
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

    public ObservableList<ProduitModel> getListOfProduitsRéservation() {
        return listOfProduitsRéservation;
    }

    public ObservableList<String> getCategorieList() {return categorieList ; }

    public ObservableList<ProduitModel> filtrerListParCategorie(String Categorie, String list) {
        ObservableList<ProduitModel> listOfProduitAFiltrer ;
        ObservableList<ProduitModel> listOfProduitFiltre = FXCollections.observableList( new ArrayList<>());
        switch (list)
        {
            case "stock" :
                listOfProduitAFiltrer = this.listOfProduitsStock ;
                break;
            case "boutique":
                listOfProduitAFiltrer = this.listOfProduitsBoutique ;
                    break;
        }

        return listOfProduitFiltre;
    }


}
