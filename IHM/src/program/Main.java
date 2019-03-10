package program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.controller.BoutiqueController;
import program.controller.Controller;
import program.controller.HomeController;
import program.model.ModelListOfProduit;
import program.model.ModelListOfProfile;
import program.view.ViewBoutique;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{



        ModelListOfProduit modelListOfProduit = new ModelListOfProduit();
        ModelListOfProfile modelListOfProfile = new ModelListOfProfile();
        Controller controller1 = new Controller(modelListOfProduit, modelListOfProfile);
        HomeController controller = new HomeController() ;
        FXMLLoader loader = new FXMLLoader() ;
        Parent root = loader.load(getClass().getResource( "../resources/fxml/Page_acceuil.fxml"));

        root.getStylesheets().add("/resources/Accueil.css");



        loader.setController(controller);

        //controller.initialize();
        primaryStage.setTitle("Gaspi-Miam");
        primaryStage.setScene(new Scene(root, 900, 700));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
