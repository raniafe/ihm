package com.example.gaspimiamva.models;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private String name;
    private String firstName;
    private String sexe ;
    private String adresse;
    private String email;
    private String mdp;
    private String ancienMdp;
    private String numeroMobile;

    // Constructeur pour un nouvel utilisateur

    public UserModel(String name, String firstName, String adresse, String email, String mdp, String numeroMobile, String sexe) {
        this.name = name;
        this.firstName = firstName;
        this.adresse = adresse;
        this.email = email;
        this.mdp = mdp;
        this.sexe = sexe;
        this.numeroMobile = numeroMobile;
    }

    // constructeur pour un ancien utilisateur: paramètre ancienMdp

    public UserModel(String name, String firstName, String adresse, String email, String mdp, String ancienMdp, String numeroMobile,String sexe) {
        this.name = name;
        this.firstName = firstName;
        this.adresse = adresse;
        this.email = email;
        this.mdp = mdp;
        this.sexe = sexe;
        this.ancienMdp = ancienMdp;
        this.numeroMobile = numeroMobile;
    }

    protected UserModel(Parcel in) {
        name = in.readString();
        firstName = in.readString();
        sexe = in.readString();
        adresse = in.readString();
        email = in.readString();
        mdp = in.readString();
        ancienMdp = in.readString();
        numeroMobile = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getAncienMdp() {
        return ancienMdp;
    }

    public String getNumeroMobile() {
        return numeroMobile;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumeroMobile(String numeroMobile) {
        this.numeroMobile = numeroMobile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(firstName);
        parcel.writeString(sexe);
        parcel.writeString(adresse);
        parcel.writeString(email);
        parcel.writeString(mdp);
        parcel.writeString(ancienMdp);
        parcel.writeString(numeroMobile);
    }
}
