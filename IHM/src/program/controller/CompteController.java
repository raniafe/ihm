package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import program.model.ModelListOfProduit;
import program.model.ModelListOfProfile;
import program.model.ProfileModel;

public class CompteController extends HomeController {

    @FXML
    private TextArea nom;
    @FXML
    private TextArea prenom;
    @FXML
    private TextArea adresse;
    @FXML
    private TextArea codePostal;
    @FXML
    private TextArea ville;
    @FXML
    private TextArea email;
    @FXML
    private TextArea ancienMdp;
    @FXML
    private TextArea nouveauMdp;
    @FXML
    private TextArea numTel;
    @FXML
    private Button enregistrer;

    ProfileModel profile;
/*
    public CompteController(ProfileModel profile) {
        this.profile = profile;
    }
    */

    public void initialize(ModelListOfProfile modelListOfProfile, ModelListOfProduit modelListOfProduit) {
        //super.initialize(modelListOfProfile,modelListOfProduit);
        this.profile = modelListOfProfile.getListOfProfiles().get(0);
        enregistrer.setOnAction(event -> ChangeMdp());
    }

    public void setInfo() {
        nom.setText(profile.getName());
        prenom.setText(profile.getFirstName());
        adresse.setText(profile.getAdresse());
        codePostal.setText(profile.getCodePostal());
        ville.setText(profile.getVille());
        email.setText(profile.getEmail());
        numTel.setText(profile.getNumeroMobile());
    }

    public void ChangeMdp() {

        String ancienMdpSaisi = this.ancienMdp.getText();

        if (!(ancienMdpSaisi.equals(profile.getAncienMdp()))) {
            System.out.println("inside");
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Saisie non valide");
            errorAlert.setContentText("Vous devez saisir votre ancien mdp");
            errorAlert.showAndWait();
        } else {
            profile.getMdp().equals(this.nouveauMdp.getText());
        }
    }
}
