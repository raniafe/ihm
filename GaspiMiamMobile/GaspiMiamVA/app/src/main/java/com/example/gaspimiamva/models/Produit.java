package com.example.gaspimiamva.models;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.text.ParseException;
import java.util.Date;
import java.util.Observable;

public class Produit extends Observable implements Parcelable  {

    private String name;
    private Integer quantite;
    private String categorie;
    private Date date ;
    private Integer image ;
    private Integer prix;
    private String localisation; // pour les produits de la Boutique
    private String description;
    private LatLng positiongps;

    // constructeur pour la ListStock

    public Produit(String name, Integer quantite, String categorie, Date date, Integer image, String description) {
        this.name = name;
        this.quantite = quantite;
        this.categorie = categorie;
        this.date = date;
        this.image = image;
        this.description = description;
    }

    // constructeur pour la Listvente, ListBoutique, ListReservation

    public Produit(String name, Integer quantite, String categorie, Date date, Integer image, Integer prix, String localisation, String description, LatLng positiongps) {
        this.name = name;
        this.quantite = quantite;
        this.categorie = categorie;
        this.date = date;
        this.image = image;
        this.prix = prix;
        this.localisation = localisation;
        this.description = description;
        this.positiongps=positiongps;
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

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
        if (quantite ==0) Log.d("quant"," null");

        if (this.quantite!=0) Log.d("quant","not null");
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

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LatLng getPositiongps() {
        return positiongps;
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
