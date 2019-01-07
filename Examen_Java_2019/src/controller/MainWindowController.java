/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 15/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Controller klasse JavaFX
 */

package controller;

import db.DatabaseQueries;
import factory.HulpdienstFactory;
import factory.SchipFactory;
import factory.VerkeerstorenFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import model.*;
import utilities.demodata.HulpdienstTypeLijst;
import utilities.demodata.SchipTypeLijst;
import utilities.demodata.VerkeerstorenTypeLijst;
import utilities.generator.Generator;
import utilities.states.InNood;
import view.TestRadar;

public class MainWindowController {

    SchipTypeLijst schipTypeLijst = new SchipTypeLijst();
    HulpdienstTypeLijst hulpdienstTypeLijst = new HulpdienstTypeLijst();
    VerkeerstorenTypeLijst verkeerstorenTypeLijst = new VerkeerstorenTypeLijst();
    DatabaseQueries db = new DatabaseQueries();
    Generator generator = new Generator();
    TestRadar testRadar = new TestRadar();


    @FXML private Pane mapDisplay;
    @FXML private ListView<Actor> listData;
    @FXML private Button toonAlleVerkeerstorens;
    @FXML private Button toonAllehulpdiensten;
    @FXML private Button toonAlleSchepen;
    @FXML private Button toonAlles;
    @FXML private Label labelSnelheid;
    @FXML private Label labelKoers;
    @FXML private Label labelPersonenAanBoord;
    @FXML private Label labelWendbaarheid;
    @FXML private TextField ID;
    @FXML private TextField locatieLengte;
    @FXML private TextField locatieBreedte;
    @FXML private TextField snelheid;
    @FXML private TextField wendbaarheid;
    @FXML private TextField grootte;
    @FXML private TextField personenAanboord;
    @FXML private TextField koers;
    @FXML private ComboBox<String> detailType;
    @FXML private Label labelGrootte;
    @FXML private Label labelStatus;
    @FXML private Label labelZeemijlUur;
    @FXML private Label labelSecondeGraad;
    @FXML private Label labelM;
    @FXML private Label labelGradenTovNoorden;
    @FXML private ComboBox<String> status;
    @FXML private ComboBox<String> hoofdType;
    @FXML private Button slaOp;
    @FXML private Button Verwijder;
    @FXML private Button maakLeeg;
    @FXML private Button startRandomReddingsactie;

    @FXML
    void maakLeegButtonPressed(ActionEvent event) {
        clearInputBasis();
        clearInputVervoermiddel();
        hoofdType.setDisable(false);
        detailType.setDisable(false);
    }

    @FXML
    void slaOpButtonPressed(ActionEvent event) {
        if(ID.getText().equals("")){
            creatieActor();
        }
        else{
            updateActor();
        }
    }

    public void initialize(){
        hoofdType.getItems().addAll("Verkeerstoren", "Schip", "Hulpdienst");
        status.getItems().addAll("Beschikbaar", "Niet beschikbaar", "In nood");
        ID.setDisable(true);

        // Method voor het vullen van de database.
        /*generator.setUpRandomData(db);*/

        db.refreshData();
        db.print();
    }

    public void drawActorOnPane(){
        mapDisplay.getChildren().clear();
        Paint brushColor;
        Circle newCircle;
        for (Actor actor: listData.getItems()
        ) {
            if (actor.getClass() == Schip.class){
                brushColor = Color.BLACK;
                newCircle = new Circle(actor.getLocatie().getBreedte(), actor.getLocatie().getLengte(),5,brushColor);
            }
            else if (actor.getClass() == Hulpdienst.class){
                brushColor = Color.BLUE;
                newCircle = new Circle(actor.getLocatie().getBreedte(), actor.getLocatie().getLengte(),5,brushColor);
            }
            else {
                brushColor = Color.RED;
                newCircle = new Circle(actor.getLocatie().getBreedte(), actor.getLocatie().getLengte(),7,brushColor);
            }
            newCircle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (actor.getClass() == Hulpdienst.class){
                        toonDataHulpdienst((Hulpdienst)actor);
                    }
                    else if (actor.getClass() == Schip.class){
                        toonDataSchip((Schip)actor);
                    }
                    else if (actor.getClass() == Verkeerstoren.class){
                        toonDataVerkeerstoren((Verkeerstoren) actor);
                    }
                }
            });
            mapDisplay.getChildren().add(newCircle);
        }
    }

    @FXML
    void mapDisplayClicked(MouseEvent event) {
        if (ID.getText().equals("")) {
            locatieBreedte.setText(String.valueOf(event.getX()));
            locatieLengte.setText(String.valueOf(event.getY()));
        }
    }

    public void updateActor(){
        if (hoofdType.getValue() != null){
            if (hoofdType.getValue() == "Verkeerstoren"){
                if (checkInputBasis() == 0){
                    Verkeerstoren verkeerstorenTemp = null;
                    for (Verkeerstoren v: db.getVerkeerstorens()
                         ) {
                            if (v.getId() == Integer.parseInt(ID.getText())){
                                verkeerstorenTemp = v;
                                break;
                            }
                    }
                    verkeerstorenTemp.getLocatie().setBreedte(Double.parseDouble(locatieBreedte.getText()));
                    verkeerstorenTemp.getLocatie().setLengte(Double.parseDouble(locatieLengte.getText()));
                    db.updateVerkeerstoren(verkeerstorenTemp);
                    displayAlert(Alert.AlertType.INFORMATION, "Informatie",
                            "Verkeerstoren  is aangepast.");
                }
            }
            else if (hoofdType.getValue() == "Schip"){
                if (checkInputBasis() == 0){
                    if (checkInputVervoermiddel() == 0){
                        Schip schipTemp = null;
                        for (Schip s: db.getSchepen()
                        ) {
                            if (s.getId() == Integer.parseInt(ID.getText())){
                                schipTemp = s;
                                break;
                            }
                        }
                        schipTemp.getLocatie().setBreedte(Double.parseDouble(locatieBreedte.getText()));
                        schipTemp.getLocatie().setLengte(Double.parseDouble(locatieLengte.getText()));
                        schipTemp.setSnelheid(Double.parseDouble(snelheid.getText()));
                        schipTemp.setGrootte(Double.parseDouble(grootte.getText()));
                        schipTemp.setWendbaarheid(Double.parseDouble(wendbaarheid.getText()));
                        schipTemp.setPersonenAanBoord(Integer.parseInt(personenAanboord.getText()));
                        schipTemp.setKoers(Double.parseDouble(koers.getText()));
                        schipTemp.setStatus(db.CalculateState(status.getValue()));
                        db.updateVervoermiddel(schipTemp, hoofdType.getValue());
                        displayAlert(Alert.AlertType.INFORMATION, "Informatie",
                                "Schip is aangepast.");
                    }
                }
            }
            else {
                if (checkInputBasis() == 0){
                    if (checkInputVervoermiddel() == 0){
                        Hulpdienst hulpdienstTemp = null;
                        for (Hulpdienst h: db.getHulpdiensten()
                        ) {
                            if (h.getId() == Integer.parseInt(ID.getText())){
                                hulpdienstTemp = h;
                                break;
                            }
                        }
                        hulpdienstTemp.getLocatie().setBreedte(Double.parseDouble(locatieBreedte.getText()));
                        hulpdienstTemp.getLocatie().setLengte(Double.parseDouble(locatieLengte.getText()));
                        hulpdienstTemp.setSnelheid(Double.parseDouble(snelheid.getText()));
                        hulpdienstTemp.setGrootte(Double.parseDouble(grootte.getText()));
                        hulpdienstTemp.setWendbaarheid(Double.parseDouble(wendbaarheid.getText()));
                        hulpdienstTemp.setPersonenAanBoord(Integer.parseInt(personenAanboord.getText()));
                        hulpdienstTemp.setKoers(Double.parseDouble(koers.getText()));
                        hulpdienstTemp.setStatus(db.CalculateState(status.getValue()));
                        db.updateVervoermiddel(hulpdienstTemp, hoofdType.getValue());
                        displayAlert(Alert.AlertType.INFORMATION, "Informatie",
                                "Schip is aangepast.");
                    }
                }
            }
            clearInputBasis();
            clearInputVervoermiddel();
            db.refreshData();
            toonAlleActors();
        }
        else checkInputBasis();
    }

    public void creatieActor(){
        if (hoofdType.getValue() != null){
            if (hoofdType.getValue() == "Verkeerstoren"){
                if (checkInputBasis() == 0){
                    Verkeerstoren verkeerstorenTemp = VerkeerstorenFactory.createVerkeerstoren(
                            new Coördinaten(Double.parseDouble(locatieLengte.getText()),Double.parseDouble(locatieBreedte.getText())),
                            detailType.getValue(),
                            db.getVerkeerstorens());
                    if (ID.getText().equals("")) {
                        db.addVerkeerstoren(verkeerstorenTemp);
                        displayAlert(Alert.AlertType.INFORMATION, "Informatie",
                                "Verkeerstoren  is toegevoegd.");
                    }
                }
            }
            else if (hoofdType.getValue() == "Schip"){
                if (checkInputBasis() == 0){
                    if (checkInputVervoermiddel() == 0){
                        Schip schipTemp = SchipFactory.createSchip(
                                new Coördinaten(Double.parseDouble(locatieLengte.getText()), Double.parseDouble(locatieBreedte.getText())),
                                Double.parseDouble(snelheid.getText()),
                                Double.parseDouble(grootte.getText()),
                                Double.parseDouble(wendbaarheid.getText()),
                                Integer.parseInt(personenAanboord.getText()),
                                Double.parseDouble(koers.getText()),
                                detailType.getValue(),
                                db.CalculateState(status.getValue()),
                                db.getVerkeerstorens());
                        if (ID.getText().equals("")) {
                            db.addVervoermiddel(schipTemp, hoofdType.getValue());
                            displayAlert(Alert.AlertType.INFORMATION, "Informatie",
                                    "Schip is toegevoegd.");
                        }
                    }
                }
            }
            else {
                if (checkInputBasis() == 0){
                    if (checkInputVervoermiddel() == 0){
                        Hulpdienst hulpdienstTemp = HulpdienstFactory.createHulpdienst(
                                new Coördinaten(Double.parseDouble(locatieLengte.getText()), Double.parseDouble(locatieBreedte.getText())),
                                Double.parseDouble(snelheid.getText()),
                                Double.parseDouble(grootte.getText()),
                                Double.parseDouble(wendbaarheid.getText()),
                                Integer.parseInt(personenAanboord.getText()),
                                Double.parseDouble(koers.getText()),
                                detailType.getValue(),
                                db.CalculateState(status.getValue()),
                                db.getVerkeerstorens());
                        if (ID.getText().equals("")) {
                            db.addVervoermiddel(hulpdienstTemp, hoofdType.getValue());
                            displayAlert(Alert.AlertType.INFORMATION, "Informatie",
                                    "Hulpdienst is toegevoegd.");
                        }
                    }
                }
            }
            clearInputBasis();
            clearInputVervoermiddel();
            db.refreshData();
            toonAlleActors();
        }
        else checkInputBasis();
    }

    @FXML
    void startRandomReddingsactieButtonPressed(ActionEvent event) {
        generator.generateRandomSchip(db.getSchepen()).setStatus(new InNood());
    }

    @FXML
    void toonAlleSchepenButtonPressed(ActionEvent event) {
        listData.getItems().setAll(db.getSchepen());
        drawActorOnPane();
    }

    @FXML
    void toonAlleVerkeerstorensButttonPressed(ActionEvent event) {
        listData.getItems().setAll(db.getVerkeerstorens());
        drawActorOnPane();
    }

    @FXML
    void toonAllehulpdienstenButtonPressed(ActionEvent event) {
        listData.getItems().setAll(db.getHulpdiensten());
        drawActorOnPane();
    }

    @FXML
    void toonAllesButtonPressed(ActionEvent event) {
        toonAlleActors();
    }

    public void toonAlleActors(){
        listData.getItems().setAll(db.getVerkeerstorens());
        listData.getItems().addAll(db.getHulpdiensten());
        listData.getItems().addAll(db.getSchepen());
        drawActorOnPane();
    }

    @FXML
    void verwijderButtonPressed(ActionEvent event) {
        if (ID.getText() != null){
            if (hoofdType.getSelectionModel().getSelectedItem() == "Verkeerstoren"){
                db.deleteVerkeerstoren(Integer.parseInt(ID.getText()));
                maakLeegButtonPressed(event);
                toonAlleActors();
                displayAlert(Alert.AlertType.INFORMATION, "Informatie",
                        "Verkeerstoren is verwijderd.");
            }
            else if (hoofdType.getSelectionModel().getSelectedItem() == "Schip"){
                db.deleteVervoermiddel(Integer.parseInt(ID.getText()));
                clearInputVervoermiddel();
                maakLeegButtonPressed(event);
                toonAlleActors();
                displayAlert(Alert.AlertType.INFORMATION, "Informatie",
                        "Schip is verwijderd.");
            }
            else if (hoofdType.getSelectionModel().getSelectedItem() == "Hulpdienst"){
                db.deleteVervoermiddel(Integer.parseInt(ID.getText()));
                clearInputVervoermiddel();
                maakLeegButtonPressed(event);
                toonAlleActors();
                displayAlert(Alert.AlertType.INFORMATION, "Informatie",
                        "Hulpdienst is verwijderd.");
            }
        }
    }

    @FXML
    void listDataClicked(MouseEvent event) {
        if (listData.getSelectionModel().getSelectedItem() != null) {
            if (listData.getSelectionModel().getSelectedItem().getClass() == Schip.class) {
                Schip schipTemp = (Schip) listData.getSelectionModel().getSelectedItem();
                toonDataSchip(schipTemp);
            } else if (listData.getSelectionModel().getSelectedItem().getClass() == Verkeerstoren.class) {
                Verkeerstoren verkeerstorenTemp = (Verkeerstoren) listData.getSelectionModel().getSelectedItem();
                toonDataVerkeerstoren(verkeerstorenTemp);
            } else if (listData.getSelectionModel().getSelectedItem().getClass() == Hulpdienst.class) {
                Hulpdienst hulpdienstTemp = (Hulpdienst) listData.getSelectionModel().getSelectedItem();
                toonDataHulpdienst(hulpdienstTemp);
            }
        }
    }


    public void toonDataVerkeerstoren(Verkeerstoren verkeerstoren){
        ID.setText(String.valueOf(verkeerstoren.getId()));
        locatieBreedte.setText(String.valueOf(verkeerstoren.getLocatie().getBreedte()));
        locatieLengte.setText(String.valueOf(verkeerstoren.getLocatie().getLengte()));
        hoofdType.getSelectionModel().select("Verkeerstoren");
        hoofdType.setDisable(true);
        detailType.setValue(String.valueOf(verkeerstoren.getType()));
        detailType.setDisable(true);
    }

    public void toonDataSchip(Schip schip){
        ID.setText(String.valueOf(schip.getId()));
        locatieBreedte.setText(String.valueOf(schip.getLocatie().getBreedte()));
        locatieLengte.setText(String.valueOf(schip.getLocatie().getLengte()));
        hoofdType.getSelectionModel().select("Schip");
        hoofdType.setDisable(true);
        detailType.setValue(String.valueOf(schip.getType()));
        detailType.setDisable(true);
        snelheid.setText(String.valueOf(schip.getSnelheid()));
        wendbaarheid.setText(String.valueOf(schip.getWendbaarheid()));
        grootte.setText(String.valueOf(schip.getGrootte()));
        personenAanboord.setText(String.valueOf(schip.getPersonenAanBoord()));
        koers.setText(String.valueOf(schip.getKoers()));
        status.setValue(schip.getStatus().toString());
    }

    public void toonDataHulpdienst(Hulpdienst hulpdienst){
        ID.setText(String.valueOf(hulpdienst.getId()));
        locatieBreedte.setText(String.valueOf(hulpdienst.getLocatie().getBreedte()));
        locatieLengte.setText(String.valueOf(hulpdienst.getLocatie().getLengte()));
        hoofdType.getSelectionModel().select("Hulpdienst");
        hoofdType.setDisable(true);
        detailType.setValue(String.valueOf(hulpdienst.getType()));
        detailType.setDisable(true);
        snelheid.setText(String.valueOf(hulpdienst.getSnelheid()));
        wendbaarheid.setText(String.valueOf(hulpdienst.getWendbaarheid()));
        grootte.setText(String.valueOf(hulpdienst.getGrootte()));
        personenAanboord.setText(String.valueOf(hulpdienst.getPersonenAanBoord()));
        koers.setText(String.valueOf(hulpdienst.getKoers()));
        status.setValue(hulpdienst.getStatus().toString());
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
        status.getSelectionModel().clearSelection();
    }

    public void clearInputBasis(){
        ID.clear();
        locatieBreedte.clear();
        locatieLengte.clear();
        hoofdType.getSelectionModel().clearSelection();
        detailType.getSelectionModel().clearSelection();
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
            displayAlert(Alert.AlertType.ERROR, "Input is incorrect",
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
               status.getValue() == null)
        {
            displayAlert(Alert.AlertType.ERROR, "Ontbrekende gegevens",
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
            displayAlert(Alert.AlertType.ERROR, "Input is incorrect",
                    "Inputvelden zijn allemaal numerieke waardes.");
            return 1;
        }
    }

    private int checkInputBasis(){
        if (    locatieLengte.getText().equals("") ||
                locatieBreedte.getText().equals("") ||
                detailType.getValue() == null ||
                hoofdType.getValue() == null)
        {
            displayAlert(Alert.AlertType.ERROR, "Ontbrekende gegevens",
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

