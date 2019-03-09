package program.controller;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import program.model.ProduitModel;

public class ProduitReservationController extends HomeController {


    private ProduitModel produit;

    @FXML
    private ImageView image ;
    @FXML
    private ChoiceBox quantity;
    public ProduitReservationController(){

    }
    public ProduitReservationController(ProduitModel produit){
        this.produit=produit;
    }
    public void setProduit(ProduitModel prod){
        this.produit=prod;
        image.setImage(new Image(produit.getImage()));
    }

    public void initialize() {
        quantity.setItems(modelListOfProduit.getQuantList());
    }



}
