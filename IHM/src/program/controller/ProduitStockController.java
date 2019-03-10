package program.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import program.model.ProduitModel;


public class ProduitStockController extends Controller {

    private ProduitModel produit;

  @FXML
  ImageView image ;
  @FXML
  private ChoiceBox quantity;
    @FXML
    private Button buttonManger;

    public ProduitStockController(){

    }
    public ProduitStockController(ProduitModel produit){

        this.produit=produit;
    }

    public void setProduit(ProduitModel prod){
        this.produit=prod;
         image.setImage(new Image(produit.getImage()));
        // name.setTextContent("Salut");
    }

    public void initialize() {
        quantity.setItems(modelListOfProduit.getQuantList());
        //name.setValue("Salut");
        buttonManger.setOnMouseClicked(event -> {
            modelListOfProduit.deleteStock(produit);
            displayMonStock();
        });
    }




}