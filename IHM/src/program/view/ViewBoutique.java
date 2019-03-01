package program.view;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import program.controller.BoutiqueController;
import program.controller.ProduitController;
import program.model.ModelListOfProduit;
import program.model.ProduitModel;

import java.io.IOException;

public class ViewBoutique {

    public static final String XML_FILE = "../../resources/fxml/Boutique2.fxml";
    private static final String PRODUIT = "../../resources/Produit.fxml";
    private static ModelListOfProduit model;
    private static BoutiqueController controller;



    public void init(ModelListOfProduit model, BoutiqueController controller) {
        ViewBoutique.model = model;
        ViewBoutique.controller = controller;
        //init the ObservableList of custumers to the ListView
//        controller.getProduitsListView().setItems(model.getListOfProduits());

        //call a cell factory and display each observable item in the ListView
//        adaptItems( controller.getProduitsListView() );


    }


    private void adaptItems(ListView listView) {
        //Set a new cell factory to use in the ListView.
        listView.setCellFactory(
                //  first parameter specifies the type of the object passed in to the call method
                //  the second parameter specifying the return type of the method.
                new Callback<ListView, ListCell>() {
                    //define what to do when ModelListCustomers.listOfCustumers is changed
                    @Override
                    public ListCell call(ListView listView) {
                        return new ListCell() {
                            @Override
                            protected void updateItem(Object item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    Parent listElement=null;
                                    // Load fxml file for this Person
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(PRODUIT));
                                    //create the person controller
                                    ProduitController personController = new ProduitController();
                                    //attach the person controller to this person
                                    loader.setController(personController);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream(PRODUIT));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    //initialize the person controller
                                    personController.init((ProduitModel) item);
                                    // Display content of the fxml file
                                    setGraphic(listElement);
                                    adaptItems(listView);

                                    //remove TextField name contents
                                }
                            }

                        };
                    }
                });
    }

}
