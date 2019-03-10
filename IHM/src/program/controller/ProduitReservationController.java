package program.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import program.model.ProduitModel;

public class ProduitReservationController extends Controller {


    private ProduitModel produit;

    @FXML
    private ImageView image ;
    @FXML
    private ChoiceBox quantity;
    @FXML
    private Button reserver ;

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

        reserver.setOnAction(event -> {
            modelListOfProduit.addReseservation(produit);
            try {
                displayMesReservation();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
       // quantity.setItems(modelListOfProduit.getQuantList());
    }


}
