package com.example.gaspimiamva.models;



import java.util.ArrayList;
public class UsersListModel {

    private  ArrayList<UserModel>listOfProfiles;

    public UsersListModel() {
        //listOfProfiles = FXCollections.observableList(new ArrayList<>());
        listOfProfiles= new ArrayList<>() ;
        listOfProfiles.add(new UserModel("Durand", "Jeanne", "Antibes", "jeanne.durand@orange.fr", "ass", "0636456767", "M"));
    }

    public void add(UserModel profile) {
        listOfProfiles.add(profile);
    }

    public ArrayList<UserModel> getListOfProfiles() {
        return listOfProfiles;
    }

}

