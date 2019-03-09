package program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.controller.HomeController;
import program.model.ModelListOfProduit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        /*FXMLLoader loader = new FXMLLoader();

        ViewBoutique view = new ViewBoutique();

        //create a controller
        BoutiqueController controller = new BoutiqueController();

        //attach controller
        loader.setController(controller);

        //attach XML file
        Parent root = loader.load(getClass().getResourceAsStream("../resources/fxml/Boutique2.fxml"));

        ModelListOfProduit model = new ModelListOfProduit();

        //initialize the controller
        //controller.initialize( model );

        view.init( model, controller );

        //create the view
        primaryStage.setScene(new Scene(root, 700, 600));

        //show the view
        primaryStage.show(); */


        ModelListOfProduit model = new ModelListOfProduit();
        HomeController controller = new HomeController() ;
        FXMLLoader loader = new FXMLLoader() ;
        Parent root = loader.load(getClass().getResource( "../resources/fxml/Page_acceuil.fxml"));

        root.getStylesheets().add("/resources/Accueil.css");



        loader.setController(controller);
        //controller.initialize();
        primaryStage.setTitle("Gaspi-Miam");
        primaryStage.setScene(new Scene(root, 770, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
