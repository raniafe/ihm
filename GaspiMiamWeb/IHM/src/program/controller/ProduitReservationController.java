package program.controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import program.model.ProduitModel;

public class ProduitReservationController extends Controller {


    private ProduitModel produit;

    @FXML
    private ImageView image ;
    @FXML
    private Label quantity;
    @FXML
    private Button reserver ;
    @FXML
    private TextArea prix;

    public ProduitReservationController(){

    }
    public void initialize() {
        reserver.setOnMouseClicked(event -> displayMesReservation());
    }

    public void setProduit(ProduitModel prod){
        this.produit=prod;
        image.setImage(new Image(produit.getImage()));
        quantity.setText(Integer.toString(produit.getQuantite()));
        prix.setText(Integer.toString(produit.getPrix()));
    }

    public void reserverProduit() {
        modelListOfProduit.addReseservation(produit);
        try {
            displayMesReservation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
