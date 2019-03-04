package program.model;

public class ProfileModel {

    private String name;
    private String firstName;
    private String adresse;
    private Integer codePostal;
    private String ville;
    private String email;
    private String mdp;
    private String ancienMdp;
    private long numeroMobile;

    // Constructeur pour un nouvel utilisateur

    public ProfileModel(String name, String firstName, String adresse, Integer codePostal, String ville, String email, String mdp, long numeroMobile) {
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

    public ProfileModel(String name, String firstName, String adresse, Integer codePostal, String ville, String email, String mdp, String ancienMdp, long numeroMobile) {
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
}
