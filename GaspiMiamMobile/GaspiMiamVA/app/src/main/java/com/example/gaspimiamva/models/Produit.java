package com.example.gaspimiamva.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Produit implements Parcelable {

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

    protected Produit(Parcel in) {
        name = in.readString();
        quantite = in.readInt();
        categorie = in.readString();
        if (in.readByte() == 0) {
            image = null;
        } else {
            image = in.readInt();
        }
        prix = in.readInt();
        localisation = in.readString();
    }

    public static final Creator<Produit> CREATOR = new Creator<Produit>() {
        @Override
        public Produit createFromParcel(Parcel in) {
            return new Produit(in);
        }

        @Override
        public Produit[] newArray(int size) {
            return new Produit[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(quantite);
        parcel.writeString(categorie);
        if (image == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(image);
        }
        parcel.writeInt(prix);
        parcel.writeString(localisation);
    }
}
