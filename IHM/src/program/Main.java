package program;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import program.controller.HomeController;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        HomeController controller = new HomeController() ;
        FXMLLoader loader = new FXMLLoader() ;
        loader.setController(controller);
        controller.initialize();
        Parent root = loader.load(getClass().getResource(View.BOUTIQUE));
        primaryStage.setTitle("Gaspi-Miam");
        primaryStage.setScene(new Scene(root, 700, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
