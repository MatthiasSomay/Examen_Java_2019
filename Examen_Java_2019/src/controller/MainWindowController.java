/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 15/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Controller klasse JavaFX
 */

package controller;

import db.DatabaseQueries;
import factory.VerkeerstorenFactory;
import factory.VervoermiddelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import model.Coördinaten;
import model.Verkeerstoren;
import model.Vervoermiddel;
import utilities.demodata.HulpdienstTypeLijst;
import utilities.demodata.SchipTypeLijst;
import utilities.demodata.VerkeerstorenTypeLijst;

public class MainWindowController {

    SchipTypeLijst schipTypeLijst = new SchipTypeLijst();
    HulpdienstTypeLijst hulpdienstTypeLijst = new HulpdienstTypeLijst();
    VerkeerstorenTypeLijst verkeerstorenTypeLijst = new VerkeerstorenTypeLijst();
    DatabaseQueries db = new DatabaseQueries();

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
    private Button slaOp;

    @FXML
    private Button Verwijder;

    @FXML
    private Button maakLeeg;

    @FXML
    private Button startRandomReddingsactie;

    @FXML
    void maakLeegButtonPressed(ActionEvent event) {

    }

    @FXML
    void slaOpButtonPressed(ActionEvent event) {
        if (hoofdType.getValue() != null){
            if (hoofdType.getValue() == "Verkeerstoren"){
                if (checkInputBasis() == 0){
                    Verkeerstoren verkeerstorenTemp = VerkeerstorenFactory.createVerkeerstoren(
                            new Coördinaten(Double.parseDouble(locatieLengte.getText()),Double.parseDouble(locatieBreedte.getText())),
                            detailType.getValue());
                    db.addVerkeerstoren(verkeerstorenTemp);
                }
            }
            else {
                if (checkInputBasis() == 0){
                    if (checkInputVervoermiddel() == 0){
                         Vervoermiddel vervoermiddelTemp = VervoermiddelFactory.createVervoermiddel(
                                 new Coördinaten(Double.parseDouble(locatieLengte.getText()), Double.parseDouble(locatieBreedte.getText())),
                                 Double.parseDouble(snelheid.getText()),
                                 Double.parseDouble(grootte.getText()),
                                 Double.parseDouble(wendbaarheid.getText()),
                                 Integer.parseInt(personenAanboord.getText()),
                                 Double.parseDouble(koers.getText()),
                                 detailType.getValue(),
                                 db.CalculateState(status.getValue()),
                                 hoofdType.getValue());
                        db.addVervoermiddel(vervoermiddelTemp, hoofdType.getValue());
                    }
                }
            }
        }
        else checkInputBasis();
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

    public void initialize(){
        hoofdType.getItems().addAll("Verkeerstoren", "Schip", "Hulpdienst");
        status.getItems().addAll("Beschikbaar", "Niet beschikbaar", "In nood");
    }

    public void visibilityVervoermiddel(Boolean bool){
        snelheid.setVisible(bool);
        wendbaarheid.setVisible(bool);
        grootte.setVisible(bool);
        personenAanboord.setVisible(bool);
        koers.setVisible(bool);
        status.setVisible(bool);
        labelGradenTovNoorden.setVisible(bool);
        labelGrootte.setVisible(bool);
        labelKoers.setVisible(bool);
        labelM.setVisible(bool);
        labelPersonenAanBoord.setVisible(bool);
        labelWendbaarheid.setVisible(bool);
        labelZeemijlUur.setVisible(bool);
        labelSnelheid.setVisible(bool);
        labelSecondeGraad.setVisible(bool);
        labelStatus.setVisible(bool);
    }

    public void clearInputVervoermiddel(){
        snelheid.clear();
        wendbaarheid.clear();
        grootte.clear();
        personenAanboord.clear();
        koers.clear();
        detailType.getSelectionModel().clearSelection();
        status.getSelectionModel().clearSelection();
    }

    public void clearInputBasis(){
        locatieBreedte.clear();
        locatieLengte.clear();
        hoofdType.getSelectionModel().clearSelection();
    }

    @FXML
    void hoofdTypeClicked(ActionEvent event) {
        if (hoofdType.getValue() != null){
            switch (hoofdType.getValue()) {
                case "Verkeerstoren":
                    clearInputVervoermiddel();
                    detailType.getItems().setAll(verkeerstorenTypeLijst.getVerkeerstorenType());
                    visibilityVervoermiddel(false);
                    break;
                case "Schip":
                    clearInputVervoermiddel();
                    detailType.getItems().setAll(schipTypeLijst.getSchipType());
                    visibilityVervoermiddel(true);
                    break;
                case "Hulpdienst":
                    clearInputVervoermiddel();
                    detailType.getItems().setAll(hulpdienstTypeLijst.getHulpdienstType());
                    visibilityVervoermiddel(true);
                    break;
                default:
                    break;
            }
        }
        else {visibilityVervoermiddel(true);}
    }

    private int validatieVervoermiddel(){
        try {
            Double.parseDouble(snelheid.getText().replace(",","."));
            Double.parseDouble(wendbaarheid.getText().replace(",","."));
            Double.parseDouble(grootte.getText().replace(",","."));
            Double.parseDouble(personenAanboord.getText().replace(",","."));
            Double.parseDouble(koers.getText().replace(",","."));
            return 0;
        }
        catch (Exception e) {
            displayAlert(Alert.AlertType.INFORMATION, "Input is incorrect",
                    "Inputvelden zijn allemaal numerieke waardes.");
            return 1;
        }
    }

   private int checkInputVervoermiddel(){
       if (    snelheid.getText().equals("") ||
               wendbaarheid.getText().equals("") ||
               grootte.getText().equals("") ||
               personenAanboord.getText().equals("") ||
               koers.getText().equals("") ||
               detailType.getValue() == null ||
               status.getValue() == null)
        {
            displayAlert(Alert.AlertType.INFORMATION, "Ontbrekende gegevens",
                    "Alle inputvelden zijn vereist.");
            return 1;
        }
        else {
            return validatieVervoermiddel();
        }
    }

    private int validatieBasis(){
        try {
            Double.parseDouble(locatieLengte.getText().replace(",","."));
            Double.parseDouble(locatieBreedte.getText().replace(",","."));
            return 0;
        }
        catch (Exception e) {
            displayAlert(Alert.AlertType.INFORMATION, "Input is incorrect",
                    "Inputvelden zijn allemaal numerieke waardes.");
            return 1;
        }
    }

    private int checkInputBasis(){
        if (    locatieLengte.getText().equals("") ||
                locatieBreedte.getText().equals("") ||
                hoofdType.getValue() == null)
        {
            displayAlert(Alert.AlertType.INFORMATION, "Ontbrekende gegevens",
                    "Alle inputvelden zijn vereist.");
            return 1;
        }
        else {
            return validatieBasis();
        }
    }

    private void displayAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

