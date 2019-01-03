/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 15/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Controller klasse JavaFX
 */

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import utilities.demodata.SchipTypeLijst;

public class MainWindowController {

    @FXML
    private Pane mapDisplay;

    @FXML
    private ListView<?> listData;

    @FXML
    private Button toonAlleVerkeerstorens;

    @FXML
    private Button toonAllehulpdiensten;

    @FXML
    private Button toonAlleSchepen;

    @FXML
    private Button toonAlles;

    @FXML
    private TextField ID;

    @FXML
    private TextField locatieLengte;

    @FXML
    private TextField locatieBreedte;

    @FXML
    private TextField snelheid;

    @FXML
    private TextField wendbaarheid;

    @FXML
    private TextField grootte;

    @FXML
    private TextField personenAanboord;

    @FXML
    private TextField koers;

    @FXML
    private ComboBox<String> detailType;

    @FXML
    private TextField capaciteit;

    @FXML
    private ComboBox<?> status;

    @FXML
    private ComboBox<?> hoofdType;

    @FXML
    private Button slaOp;

    @FXML
    private Button Verwijder;

    @FXML
    private Button maakLeeg;

    @FXML
    private Button startRandomReddingsactie;

    public void setUp(){
        SchipTypeLijst schipTypeLijst = new SchipTypeLijst();
        detailType.getItems().setAll(schipTypeLijst.getSchipType());
    }

    @FXML
    void maakLeegButtonPressed(ActionEvent event) {

    }

    @FXML
    void slaOpButtonPressed(ActionEvent event) {


        /*if (    carColor.getText().equals("") ||
                carConstructor.getText().equals("") ||
                carField.getText().equals("") ||
                carModel.getText().equals("") ||
                carYear.getText().equals("") ||
                carMemberNumber.getText().equals(""))
        {
            displayAlert(Alert.AlertType.INFORMATION, "Please fill in all fields",
                    "All fields are required.");
            return 1;
        }
        else {
            return checkCarYear();
        }
    }*/

    }

    @FXML
    void startRandomReddingsactieButtonPressed(ActionEvent event) {

    }

    @FXML
    void toonAlleSchepenButtonPressed(ActionEvent event) {

    }

    @FXML
    void toonAlleVerkeerstorensButttonPressed(ActionEvent event) {

    }

    @FXML
    void toonAllehulpdienstenButtonPressed(ActionEvent event) {
    }

    @FXML
    void toonAllesButtonPressed(ActionEvent event) {

    }

    @FXML
    void verwijderButtonPressed(ActionEvent event) {

    }

    private void displayAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

