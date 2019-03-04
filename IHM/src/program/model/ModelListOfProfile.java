package program.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelListOfProfile {

    private ObservableList<ProfileModel> listOfProfiles;

    public ModelListOfProfile() {
        listOfProfiles = FXCollections.observableList(new ArrayList<>());
        listOfProfiles.add(new ProfileModel("Durand", "Jeanne", "rue des marronniers", 45160, "Orléans", "jeanne.durand@orange.fr", "jannette", 0636456767));
        listOfProfiles.add(new ProfileModel("Dupont", "Isabelle", "avenue du Soleil", 06600, "Antibes", "isabelle.dupont@gmail.com", "isa", "sasa", 0616416717));
        listOfProfiles.add(new ProfileModel("Dhermy", "Louis", "rue des fleurs", 06600, "Antibes", "louis.dhermy@gmail.com", "louis", 0736156763));

    }

    public void add(ProfileModel profile) {
        listOfProfiles.add(profile);
    }


    public ObservableList<ProfileModel> getListOfProfiles() {
        return listOfProfiles;
    }

}
