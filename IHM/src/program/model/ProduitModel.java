package program.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Date;

public class ProduitModel {


    private ArrayList<String> categorieList = new ArrayList<String>() ;
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



}
