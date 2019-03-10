package program.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ProduitModel {



    private String name;
    private int quantite;
    private String categorie;
    private Date date ;
    private String image ;

    public ProduitModel(String name, int quantite, String categorie, Date date, String image) {
        this.name = name;
        this.quantite = quantite;
        this.categorie = categorie;
        this.date = date;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image ;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getCategorie() {
        return categorie;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Date getDate() {
        return date;
    }
}
