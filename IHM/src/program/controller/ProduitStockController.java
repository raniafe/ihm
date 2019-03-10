package program.controller;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import program.model.ProduitModel;

import javax.xml.soap.Text;

public class ProduitStockController extends Controller {


    private ProduitModel produit;

  @FXML
  ImageView image ;

   /* @FXML
    private Text name ;*/

    public ProduitStockController(){

    }
    public ProduitStockController(ProduitModel produit){
        this.produit=produit;
    }
    public void setProduit(ProduitModel prod){

         image.setImage(new Image(produit.getImage()));
        // name.setTextContent("Salut");
    }

    public void initialize() {
        // quantity.setItems(modelListOfProduit.getQuantList());
        //name.setValue("Salut");
    }




}