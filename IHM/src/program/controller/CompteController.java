package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import program.model.ModelListOfProduit;
import program.model.ModelListOfProfile;
import program.model.ProfileModel;

import java.util.Calendar;

public class CompteController extends Controller {

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

    public void initialize() {
        //super.initialize(modelListOfProfile,modelListOfProduit);
        this.profile = Controller.getModelListOfProfile().getListOfProfiles().get(0);
        setInfo();
        enregistrer.setOnAction(event -> {ChangeMdp() ;
            profile.setName(this.nom.getText());
            profile.setFirstName(prenom.getText());
            displayAccueil();

        });


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

        if (!(ancienMdpSaisi.equals(profile.getMdp()))) {
            System.out.println(profile.getMdp());
            boolean test = confirmation() ;

            if(!test){displayAccueil(); }

        } else if(ancienMdpSaisi.equals(profile.getAncienMdp())){
            profile.setMdp(this.nouveauMdp.getText());

        }
    }

}
