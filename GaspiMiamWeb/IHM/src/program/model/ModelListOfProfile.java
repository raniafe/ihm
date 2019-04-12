package program.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelListOfProfile {

    private  ArrayList<ProfileModel>listOfProfiles;

    public ModelListOfProfile() {
        //listOfProfiles = FXCollections.observableList(new ArrayList<>());
        listOfProfiles= new ArrayList<>() ;
        listOfProfiles.add(new ProfileModel("Durand", "Jeanne", "rue des marronniers", "4400", "Nantes", "jeanne.durand@orange.fr", "jannette", "0636456767"));
    }

    public void add(ProfileModel profile) {
        listOfProfiles.add(profile);
    }

    public ArrayList<ProfileModel> getListOfProfiles() {
        return listOfProfiles;
    }

}
