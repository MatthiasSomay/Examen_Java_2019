/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 15/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Controller klasse JavaFX
 */

package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import model.Hulpdienst;
import view.TestRadar;

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
    private ComboBox<?> detailType;

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

    @FXML
    void maakLeegButtonPressed(ActionEvent event) {

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
        for (Hulpdienst hulpdienst: TestRadar.hulpdiensten
             ) {

        }
        Circle newCircle = new Circle(event.getX(), event.getY(),radius.getRadius(),brushColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void toonAllesButtonPressed(ActionEvent event) {

    }

    @FXML
    void verwijderButtonPressed(ActionEvent event) {

    }


}

