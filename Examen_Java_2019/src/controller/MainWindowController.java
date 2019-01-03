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
import utilities.demodata.HulpdienstTypeLijst;
import utilities.demodata.SchipTypeLijst;
import utilities.demodata.VerkeerstorenTypeLijst;

public class MainWindowController {

    @FXML
    private Pane mapDisplay;

    @FXML
    private ListView<String> listData;

    @FXML
    private Button toonAlleVerkeerstorens;

    @FXML
    private Button toonAllehulpdiensten;

    @FXML
    private Button toonAlleSchepen;

    @FXML
    private Button toonAlles;

    @FXML
    private Label labelSnelheid;

    @FXML
    private Label labelKoers;

    @FXML
    private Label labelPersonenAanBoord;

    @FXML
    private Label labelCapaciteit;

    @FXML
    private Label labelWendbaarheid;

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
    private Label labelGrootte;

    @FXML
    private Label labelStatus;

    @FXML
    private TextField capaciteit;

    @FXML
    private Label labelZeemijlUur;

    @FXML
    private Label labelSecondeGraad;

    @FXML
    private Label labelM;

    @FXML
    private Label labelGradenTovNoorden;

    @FXML
    private ComboBox<String> status;

    @FXML
    private ComboBox<String> hoofdType;

    @FXML
    private Label labelPersonen;

    @FXML
    private Button slaOp;

    @FXML
    private Button Verwijder;

    @FXML
    private Button maakLeeg;

    @FXML
    private Button startRandomReddingsactie;

    @FXML
    void maakLeegButtonPressed(ActionEvent event) {
        clearInputData();
        clearInputLocatiePlusType();
    }

    @FXML
    void slaOpButtonPressed(ActionEvent event) {

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

    SchipTypeLijst schipTypeLijst = new SchipTypeLijst();
    HulpdienstTypeLijst hulpdienstTypeLijst = new HulpdienstTypeLijst();
    VerkeerstorenTypeLijst verkeerstorenTypeLijst = new VerkeerstorenTypeLijst();

    public void initialize(){
        hoofdType.getItems().addAll("Verkeerstoren", "Schip", "Hulpdienst");
        status.getItems().addAll("Beschikbaar", "Niet beschikbaar", "In nood");
    }

    public void visibility(Boolean bool){
        snelheid.setVisible(bool);
        wendbaarheid.setVisible(bool);
        grootte.setVisible(bool);
        personenAanboord.setVisible(bool);
        koers.setVisible(bool);
        capaciteit.setVisible(bool);
        status.setVisible(bool);
        labelCapaciteit.setVisible(bool);
        labelGradenTovNoorden.setVisible(bool);
        labelGrootte.setVisible(bool);
        labelKoers.setVisible(bool);
        labelM.setVisible(bool);
        labelPersonen.setVisible(bool);
        labelPersonenAanBoord.setVisible(bool);
        labelWendbaarheid.setVisible(bool);
        labelZeemijlUur.setVisible(bool);
        labelSnelheid.setVisible(bool);
        labelSecondeGraad.setVisible(bool);
        labelStatus.setVisible(bool);
    }

    public void clearInputData(){
        snelheid.clear();
        wendbaarheid.clear();
        grootte.clear();
        personenAanboord.clear();
        koers.clear();
        capaciteit.clear();
        detailType.getSelectionModel().clearSelection();
        status.getSelectionModel().clearSelection();
    }

    public void clearInputLocatiePlusType(){
        locatieBreedte.clear();
        locatieLengte.clear();
        hoofdType.getSelectionModel().clearSelection();
    }

    @FXML
    void hoofdTypeClicked(ActionEvent event) {
        if (hoofdType.getValue() != null){
            switch (hoofdType.getValue()) {
                case "Verkeerstoren":
                    detailType.getItems().setAll(verkeerstorenTypeLijst.getVerkeerstorenType());
                    visibility(false);
                    break;
                case "Schip":
                    detailType.getItems().setAll(schipTypeLijst.getSchipType());
                    visibility(true);
                    break;
                case "Hulpdienst":
                    detailType.getItems().setAll(hulpdienstTypeLijst.getHulpdienstType());
                    visibility(true);
                    break;
                default:
                    break;
            }
        }
    }

   /* private int checkInput(){
        if (    carColor.getText().equals("") ||
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

    private void displayAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

