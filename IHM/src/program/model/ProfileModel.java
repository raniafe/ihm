package program.model;

public class ProfileModel {

    private String name;
    private String firstName;
    private String adresse;
    private String codePostal;
    private String ville;
    private String email;
    private String mdp;
    private String ancienMdp;
    private String numeroMobile;

    // Constructeur pour un nouvel utilisateur

    public ProfileModel(String name, String firstName, String adresse, String codePostal, String ville, String email, String mdp, String numeroMobile) {
        this.name = name;
        this.firstName = firstName;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.email = email;
        this.mdp = mdp;
        this.numeroMobile = numeroMobile;
    }

    // constructeur pour un ancien utilisateur: paramètre ancienMdp

    public ProfileModel(String name, String firstName, String adresse, String codePostal, String ville, String email, String mdp, String ancienMdp, String numeroMobile) {
        this.name = name;
        this.firstName = firstName;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.email = email;
        this.mdp = mdp;
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

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
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

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumeroMobile(String numeroMobile) {
        this.numeroMobile = numeroMobile;
    }
}
