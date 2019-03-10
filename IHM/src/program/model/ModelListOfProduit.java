package program.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class ModelListOfProduit {

    private String[] categories = {"Fruit", "Legume", "Autres"} ;
    private ObservableList<String> categorieList =FXCollections.observableList( new ArrayList(Arrays.asList(categories)));
    private Integer[] quantités = {1, 2, 3,4,5,6,7,8,9,10 } ;
    private ObservableList<Integer> quantlist =FXCollections.observableList( new ArrayList(Arrays.asList(quantités)));
    private ObservableList<ProduitModel> listOfProduitsStock;
    private ObservableList<ProduitModel> listOfProduitsBoutique;
    private ObservableList<ProduitModel> listOfProduitsVentes;
    private ObservableList<ProduitModel> listOfProduitsRéservation ;

    public ModelListOfProduit() {

        listOfProduitsStock = FXCollections.observableList( new ArrayList<>());
        listOfProduitsBoutique = FXCollections.observableList( new ArrayList<>());
        listOfProduitsVentes = FXCollections.observableList(new ArrayList<>());
        listOfProduitsRéservation = FXCollections.observableList(new ArrayList<>());

        SimpleDateFormat conversion = new SimpleDateFormat("yyyy-mm-dd");

        try {
            listOfProduitsBoutique.add(new ProduitModel("Framboises", 3, "Fruit", conversion.parse("01-03-2018"), "/resources/images/framboise1.jpg"));

        listOfProduitsBoutique.add(new ProduitModel("Oranges", 12, "Fruit", new Date(16/03/2019), "/resources/images/oranges.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("Eggs", 2, "Autres", new Date(17 / 03 / 2019), "/resources/images/eggs.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("yaourt", 8, "Autres", new Date(12 / 03 / 2019), "/resources/images/yaourt1.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("tomat", 6, "Legume", new Date(13 / 03 / 2019), "/resources/images/tomatoes.jpg"));
        listOfProduitsBoutique.add(new ProduitModel("poulet", 1, "Autres", new Date(15 / 03 / 2019), "/resources/images/chicken.jpg"));


        listOfProduitsStock.add(new ProduitModel("fruit", 7, "Fruit",conversion.parse("2018-03-29"), "/resources/images/passion.jpg"));
        listOfProduitsStock.add(new ProduitModel("salade", 2, "Legume",conversion.parse("2018-03-11"), "/resources/images/salad.jpg"));
        listOfProduitsStock.add(new ProduitModel("banane", 12, "Fruit", conversion.parse("2018-03-13"), "/resources/images/banana.jpg"));

        listOfProduitsVentes.add(new ProduitModel("cerise", 9, "Fruit", new Date(13 / 03 / 2019), "/resources/images/cerise.jpg"));
        listOfProduitsVentes.add(new ProduitModel("abricot", 2, "Fruit", new Date(17 / 03 / 2019), "/resources/images/abricot.jpg"));
        listOfProduitsVentes.add(new ProduitModel("champi", 20, "Legume", new Date(12 / 03 / 2019), "/resources/images/champignons.jpg"));
        listOfProduitsVentes.add(new ProduitModel("citron", 4, "Legume", new Date(16 / 03 / 2019), "/resources/images/citron.jpg"));


        listOfProduitsRéservation.add(new ProduitModel("melon", 1, "Fruit", new Date(16 / 03 / 2019), "/resources/images/melon.jpg"));
        listOfProduitsRéservation.add(new ProduitModel("pêche", 12, "Fruit", new Date(13 / 03 / 2019), "/resources/images/peach.jpg"));


    }catch (ParseException e) {
            e.printStackTrace();
        }}

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

    public void addStock(ProduitModel produit) {
        listOfProduitsStock.add(produit);
    }

    public void deleteStock(ProduitModel produit) {
        listOfProduitsStock.remove(produit);
    }

    public void addBoutique(ProduitModel person) {
        listOfProduitsBoutique.add( person );
    }

    public void addReseservation(ProduitModel produit){

        listOfProduitsRéservation.add(produit) ;

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
    public ObservableList<Integer> getQuantList() {return quantlist ; }

    public ObservableList<ProduitModel> filtrerListParCategorie(String Categorie, String list) {

        ObservableList<ProduitModel> listOfProduitAFiltrer = null;
        ObservableList<ProduitModel> listOfProduitFiltre = FXCollections.observableList( new ArrayList<>());
        switch (list)
        {
            case "stock" :
                listOfProduitAFiltrer = this.listOfProduitsStock ;
                break;
            case "boutique":
                listOfProduitAFiltrer = this.listOfProduitsBoutique ;
                    break;
            default:
                listOfProduitAFiltrer = this.listOfProduitsStock ;
        }
        listOfProduitAFiltrer.forEach (produitModel -> {
            if(produitModel.getCategorie().equals(Categorie))
            {
                listOfProduitFiltre.add(produitModel) ;
            }
        } );

        return listOfProduitFiltre;
    }

    public ObservableList<ProduitModel> getProduitsAlertes() {
        ObservableList<ProduitModel> listOfProduitAlertes = FXCollections.observableList( new ArrayList<>());
        listOfProduitsStock.forEach(produitModel -> {

            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int day = localDate.getDayOfMonth();

            LocalDate localDate2 = produitModel.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int day1   = localDate2.getDayOfMonth();



            if ((day1 - day <=3) && (day1 -day >=0 ) )
                listOfProduitAlertes.add(produitModel) ;


        } );

        return listOfProduitAlertes ;

    }


    public void addVente(ProduitModel produit) {

        listOfProduitsVentes.add(produit);

    }


}
