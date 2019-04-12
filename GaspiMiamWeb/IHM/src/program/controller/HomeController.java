package program.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import program.View;


public  class HomeController extends Controller{

    @FXML
    private BorderPane rootPane;
    @FXML
    private Menu Boutique;
    @FXML
    private ImageView framb ;
    @FXML
    private ImageView tomat ;
    @FXML
    private ImageView yaour ;
    @FXML
    private ImageView oeufs ;
    @FXML
    private ImageView poulet ;
    @FXML
    private ImageView orang ;



    @FXML
    private MenuItem services ;


    public void initialize(){

        framb.setOnMouseClicked(event -> displayProduit("framb"));
        yaour.setOnMouseClicked(event -> displayProduit("yaour"));
        tomat.setOnMouseClicked(event -> displayProduit("tomat"));
        oeufs.setOnMouseClicked(event -> displayProduit("oeufs"));
        poulet.setOnMouseClicked(event -> displayProduit("poulet"));
        orang.setOnMouseClicked(event -> displayProduit("orang"));


    }

    public void displayProduit(String produitName){
        try {
            redirection(rootPane, View.Produit, Controller.getModelListOfProduit().getByName(produitName), "produitR");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






}
