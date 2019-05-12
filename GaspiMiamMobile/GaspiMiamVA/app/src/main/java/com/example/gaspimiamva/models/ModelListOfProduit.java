package com.example.gaspimiamva.models;

//import android.icu.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.example.gaspimiamva.R;
import com.google.android.gms.maps.model.LatLng;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelListOfProduit implements Parcelable {

    private static ArrayList<Produit> listProduitsStock = new ArrayList<>();
    private static ArrayList<Produit> listProduitsBoutique = new ArrayList<>();
    private static ArrayList<Produit> listProduitReservation = new ArrayList<>();
    private static ArrayList<Produit> listProduitVente = new ArrayList<>();



    public ModelListOfProduit() throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        listProduitReservation.clear();
        listProduitsBoutique.clear();
        listProduitsStock.clear();
        listProduitVente.clear();

        listProduitsStock.add(new Produit("Carotte", 19, "Légume", format.parse( "2019-05-15" ), R.drawable.carot, 2, "Nice" , "Carottes de plein champs",new LatLng(43.415280, 7.072272)));
        listProduitsStock.add(new Produit("Noix de coco", 9, "Fruit", format.parse( "2019-05-15" ), R.drawable.coconut, 9, "Nice", "Récoltées en Martinique. Savoureuses, chair croquante" ,new LatLng(43.515280, 7.072272)));
        listProduitsStock.add(new Produit("Pêche", 5, "Fruit", format.parse( "2019-05-15" ), R.drawable.peach, 3, "Nice", "Du Tarn et Garonne",new LatLng(43.516280, 7.072272) ));
        listProduitsStock.add(new Produit("Fraises", 8, "Fruit",format.parse( "2019-05-12" ), R.drawable.strawberry, 4, "Antibes","Fraises bio, non traitées",new LatLng(43.565280, 7.072272) ));
        listProduitsStock.add(new Produit("Tomate", 3, "Légume", format.parse( "2019-05-19" ), R.drawable.tomatoe, 2, "Nice", "Sans pesticides",new LatLng(43.515280, 7.172272)));
        listProduitsStock.add(new Produit("Yaourt", 19, "Autre", format.parse( "2019-05-12" ), R.drawable.yaourt, 6, "Nice", "Au lait fermier entier et fermenté",new LatLng(43.515280, 7.002272) ));



        listProduitsBoutique.add(new Produit("Poisson", 8, "Autre",format.parse( "2019-05-21" ), R.drawable.poisson, 12, "Marseille" , "Récolte du jour. Poisson frais",new LatLng(43.2699185, 5.395928)));
        listProduitsBoutique.add(new Produit("Pommes", 8, "Fruit", format.parse( "2019-07-16" ), R.drawable.apple, 0, "Amiens" , "Idéales en compote",new LatLng(49.8948549, 2.3019093)));
        listProduitsBoutique.add(new Produit("Raisin", 8, "Fruit", format.parse( "2019-06-23" ), R.drawable.grapes, 0, "Lille" ,"A conserver au frais",new LatLng(50.6081594, 3.1376585)));
        listProduitsBoutique.add(new Produit("Mangue", 8, "Fruit",format.parse( "2019-08-31" ), R.drawable.mango, 0, "Antibes", "Récoltées sur l'arbre à maturité. Transport en avion",new LatLng(43.6157082, 7.0737165) ));
        listProduitsBoutique.add(new Produit("Papaye", 8, "Fruit", format.parse( "2019-09-31" ), R.drawable.papaya, 0, "Antibes", "Transport en avion",new LatLng(43.6182677, 7.0759757) ));
        listProduitsBoutique.add(new Produit("Pastèque", 8, "Fruit", format.parse( "2019-08-23" ), R.drawable.watermelon, 0, "Madrid", "Melon Espagnol, gros calibre.",new LatLng(40.3953004, -3.757726) ));
        listProduitsBoutique.add(new Produit("Avocat", 6, "Légume", format.parse( "2019-06-24" ), R.drawable.avocat, 14, "Antibes", "Récolté au Mexique. Agriculture raisonnée",new LatLng(43.6183584, 7.042719) ));
        listProduitsBoutique.add(new Produit("Yaourts", 8, "Autre", format.parse( "2019-07-25" ), R.drawable.yaourt, 34, "Berneuil-en-bray", "Lait entier",new LatLng(49.3656931, 2.0486548)));
        listProduitsBoutique.add(new Produit("Escalope", 30, "Autre", new Date(2/06/19), R.drawable.escalope, 0, "Beauvais", "Elevage non intensif" ,new LatLng(49.4236079, 2.0987459)));

        listProduitVente.add(new Produit("Poisson", 8, "Autre",format.parse( "2019-06-02" ), R.drawable.poisson, 12, "Antibes" ,"Elevage non intensif",new LatLng(43.515480, 7.072272) ));
        listProduitVente.add(new Produit("Pommes", 8, "Fruit",format.parse( "2019-06-03" ), R.drawable.apple, 0, "Antibes" ,"Bio. Sans pesticides." ,new LatLng(43.515220, 7.072272)));
        listProduitVente.add(new Produit("Raisin", 8, "Fruit",format.parse( "2019-06-04" ), R.drawable.grapes, 0, "Antibes","Bio" ,new LatLng(41.415280, 7.072272) ));
        listProduitVente.add(new Produit("Mangue", 8, "Fruit",format.parse( "2019-07-05" ), R.drawable.mango, 0, "Antibes" ,"Bio" ,new LatLng(38.515280, 7.072272)));
        listProduitVente.add(new Produit("Papaye", 8, "Fruit", format.parse( "2019-07-03" ), R.drawable.papaya, 0, "Antibes","Bio" ,new LatLng(39.915280, 7.072272) ));

    }

    protected ModelListOfProduit(Parcel in) {
    }

    public static final Creator<ModelListOfProduit> CREATOR = new Creator<ModelListOfProduit>() {
        @Override
        public ModelListOfProduit createFromParcel(Parcel in) {
            return new ModelListOfProduit(in);
        }

        @Override
        public ModelListOfProduit[] newArray(int size) {
            return new ModelListOfProduit[size];
        }
    };

    public static ArrayList<Produit> getListProduitReservation() {
        return listProduitReservation;
    }

    public static ArrayList<Produit> getListProduitsStock() {
        return listProduitsStock;
    }

    public static ArrayList<Produit> getListProduitsBoutiqueGratuits() {
        ArrayList<Produit> list = new ArrayList<Produit>() ;
        for(int i=0; i<listProduitsBoutique.size();i++)
            if (listProduitsBoutique.get(i).getPrix()==0) list.add(listProduitsBoutique.get(i));
        return list;
    }

    public static ArrayList<Produit> getListProduitsBoutique() {
        return listProduitsBoutique;
    }

    public static ArrayList<Produit> getListProduitVente() {
        return listProduitVente;
    }

    public ArrayList<Produit> filtrerListParCategorie(final String categorie, ArrayList<Produit> list){
        final ArrayList<Produit> listFiltre = new ArrayList<>();
        for(int i=0; i<list.size();i++){
            if(list.get(i).getCategorie().equals(categorie)) listFiltre.add(list.get(i)) ;
        }

        return listFiltre ;
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
            case "Yaourts":
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

    public void addMesVentes(Produit produit) {
        getListProduitVente().add( produit );
    }

    public void addBoutique(Produit produit) {
        listProduitsBoutique.add( produit );
    }
    public void addReservation(Produit produit) {
        listProduitReservation.add( produit );
    }

    public void deleteBoutique(Produit produit){listProduitsBoutique.remove(produit);}
    public void deleteReservation(Produit produit){listProduitReservation.remove(produit);}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public ArrayList<Produit> getProduitsNotification(){

        ArrayList<Produit>  listProduitNotification = new ArrayList<>();

        for (int i=0; i<listProduitsStock.size(); i++) {

            Date date = new Date();

            // date de l'application: date du jour
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int day = localDate.getDayOfMonth();
            //System.out.println("date de l'appli" + day);

            // date du produit

            LocalDate localDate2 = listProduitsStock.get(i).getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int day1   = localDate2.getDayOfMonth();
            //System.out.println(" date de la liste stock " + day1);


            /*Date day2 = listProduitsStock.get(i).getDate();
            System.out.println("date du produit + " + day2);
            int day3 = day2.getDay();
            */

            // si on a 3 jours d'écart ou moins, et si on est pas le même jour
            if ((day1 - day <=3) && (day1 -day >=0 ) )
            {
                listProduitNotification.add(listProduitsStock.get(i)) ; System.out.println("produit liste notif ajouté ");}
        // System.out.println("produit liste notif ajouté "+ listProduitNotification.get(i));
        }
        return listProduitNotification;
        }

        public ArrayList<Produit > getProduitsNotifMore(){

        ArrayList<Produit> listProduitNotifMore = new ArrayList<>();

        for (int i=0; i<listProduitsStock.size(); i++){
            Date date = new Date();

            // date de l'application: date du jour
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int day = localDate.getDayOfMonth();
            //System.out.println("date de l'appli" + day);

            // date du produit

            LocalDate localDate2 = listProduitsStock.get(i).getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int day1   = localDate2.getDayOfMonth();


            // si on a 3 jours d'écart ou plus
            if ((day1 - day <=7)  )
            {
                listProduitNotifMore.add(listProduitsStock.get(i)) ; System.out.println("produit liste notif ajouté ");}
            // System.out.println("produit liste notif ajouté "+ listProduitNotification.get(i));
        }
            return listProduitNotifMore;
        }

}




