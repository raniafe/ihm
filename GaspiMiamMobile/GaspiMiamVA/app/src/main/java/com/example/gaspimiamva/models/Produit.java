package com.example.gaspimiamva.models;

import java.util.Date;

public class Produit {

    private String name;
    private int quantite;
    private String categorie;
    private Date date ;
    private Integer image ;
    private int prix;
    private String localisation; // pour les produits de la Boutique

    // constructeur pour la ListStock

    public Produit(String name, int quantite, String categorie, Date date, Integer image) {
        this.name = name;
        this.quantite = quantite;
        this.categorie = categorie;
        this.date = date;
        this.image = image;
    }

    // constructeur pour la Listvente, ListBoutique, ListReservation

    public Produit(String name, int quantite, String categorie, Date date, Integer image, int prix, String localisation) {
        this.name = name;
        this.quantite = quantite;
        this.categorie = categorie;
        this.date = date;
        this.image = image;
        this.prix = prix;
        this.localisation = localisation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
