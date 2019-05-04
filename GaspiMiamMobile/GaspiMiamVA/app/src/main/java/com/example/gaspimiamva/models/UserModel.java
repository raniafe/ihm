package com.example.gaspimiamva.models;

public class UserModel {
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
}
