package program.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AlertController {



        static boolean answer;

        @FXML
        private Button yesButton;
        @FXML
        private Button noButton;
        @FXML
        private BorderPane borderPane;

        public boolean init(Stage stage){


            yesButton.setOnAction( event -> {answer=true;stage.close();});
            noButton.setOnAction( event -> {answer=false;stage.close();});
            stage.showAndWait();

            return answer;

        }






    }



