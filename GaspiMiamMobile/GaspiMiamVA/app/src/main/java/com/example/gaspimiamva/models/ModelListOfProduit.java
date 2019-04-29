package com.example.gaspimiamva.models;

import android.util.Pair;
import com.example.gaspimiamva.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelListOfProduit {

    private static List<Produit> listProduitsStock = new ArrayList<>();
    private static List<Produit> listProduitsBoutique = new ArrayList<>();
    private static List<Produit> listProduitReservation = new ArrayList<>();
    private static List<Produit> listProduitVente = new ArrayList<>();

    public static void init(){

        listProduitReservation.clear();
        listProduitsBoutique.clear();
        listProduitsStock.clear();
        listProduitVente.clear();

        listProduitsStock.add(new Produit("Carotte", 19, "Légume", new Date(9/06/19), R.drawable.carot, 2, "Nice" ));
        listProduitsStock.add(new Produit("Noix de coco", 9, "Fruit", new Date(7/05/19), R.drawable.coconut, 9, "Nice" ));
        listProduitsStock.add(new Produit("Pêche", 5, "Fruit", new Date(7/06/19), R.drawable.peach, 3, "Nice" ));
        listProduitsStock.add(new Produit("Fraises", 8, "Fruit", new Date(3/06/19), R.drawable.strawberry, 4, "Antibes" ));
        listProduitsStock.add(new Produit("Tomate", 3, "Légume", new Date(9/06/19), R.drawable.tomatoe, 2, "Nice" ));
        listProduitsStock.add(new Produit("Yaourt", 19, "Autre", new Date(9/06/19), R.drawable.yaourt, 6, "Nice" ));

        listProduitsBoutique.add(new Produit("Posson", 8, "Autre", new Date(2/06/19), R.drawable.poisson, 34, "Antibes" ));
        listProduitsBoutique.add(new Produit("Avocat", 6, "Legume", new Date(3/06/19), R.drawable.avocat, 14, "Antibes" ));
        listProduitsBoutique.add(new Produit("yaourt", 8, "Autre", new Date(2/06/19), R.drawable.yaourt, 34, "Antibes" ));
        listProduitsBoutique.add(new Produit("Escalope", 30, "Autre", new Date(2/06/19), R.drawable.escalope, 34, "Antibes" ));


    }

    public Produit getByName(String produitName){
        switch (produitName){

            case "Carotte":
                return listProduitsStock.get(0);
            case "Noix de coco":
                return listProduitsStock.get(1);
            case "Pêche":
                return listProduitsStock.get(2);
            case "Fraises":
                return listProduitsStock.get(3);
            case "Tomate":
                return listProduitsStock.get(4);
            case "Yaourt":
                return listProduitsStock.get(5);

            case "Poisson":
                return listProduitsBoutique.get(0);
            case "Avocat":
                return listProduitsBoutique.get(1);
            case "yaourt":
                return listProduitsBoutique.get(2);
            case "Escalope":
                return listProduitsBoutique.get(3);

                default:
                    return listProduitsBoutique.get(0);

        }
    }

    public void addStock(Produit produit) {
        listProduitsStock.add(produit);
    }

    public void deleteStock(Produit produit) {
        listProduitsStock.remove(produit);
    }

    public void addBoutique(Produit produit) {
        listProduitsBoutique.add( produit );
    }

    public void deleteBoutique(Produit produit){listProduitsBoutique.remove(produit);}

}
