package view;

import factory.HulpdienstFactory;
import factory.SchipFactory;
import factory.VerkeerstorenFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Hulpdienst;
import model.Schip;
import model.Verkeerstoren;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import utilities.Log;
import utilities.generator.Generator;
import utilities.states.Beschikbaar;
import utilities.states.Status;

import java.util.ArrayList;
import java.util.List;

public class TestRadar extends Application {

    public List<Verkeerstoren> verkeerstorens = new ArrayList<>();
    public List<Hulpdienst> hulpdiensten = new ArrayList<>();
    private List<Schip> schepen = new ArrayList<>();
    private Generator generator = new Generator();

    public void setUp() {
        String hulpdienstTypeTemp;
        String schipTypeTemp;

        for(int i=0; i<10; i++) {
            Verkeerstoren verkeerstorenTemp = VerkeerstorenFactory.createVerkeerstoren(
                    generator.generateLocatie(),
                    generator.generateTypeVerkeerstoren()
            );
            verkeerstorens.add(verkeerstorenTemp);
            verkeerstorenTemp.setId(i+1);
            verkeerstorenTemp.setVerkeerstorens(verkeerstorens);
        }
        for(int i=0; i<5; i++){
            hulpdienstTypeTemp = generator.generateTypeHulpdienst();
            Status statusTemp = new Beschikbaar();
            Hulpdienst hulpdienstTemp = HulpdienstFactory.createHulpdienst(
                    generator.generateLocatie(),
                    generator.generateSnelheid(hulpdienstTypeTemp),
                    generator.generateGrootte(hulpdienstTypeTemp),
                    generator.generateWendbaarheid(hulpdienstTypeTemp),
                    generator.generatePersonenAanBoord(hulpdienstTypeTemp),
                    generator.generateKoers(),
                    hulpdienstTypeTemp,
                    statusTemp
            );
            hulpdiensten.add(hulpdienstTemp);
            hulpdienstTemp.setId(i+1);
            hulpdienstTemp.setVerkeerstorens(verkeerstorens);
            hulpdienstTemp.berekenDichtstbijzijndeVerkeerstoren();
        }
        for(int i=0; i<5; i++){
            schipTypeTemp = generator.generateTypeSchip();
            Status statusTemp = new Beschikbaar();
            Schip schipTemp = SchipFactory.createSchip(
                    generator.generateLocatie(),
                    generator.generateSnelheid(schipTypeTemp),
                    generator.generateGrootte(schipTypeTemp),
                    generator.generateWendbaarheid(schipTypeTemp),
                    generator.generatePersonenAanBoord(schipTypeTemp),
                    generator.generateKoers(),
                    schipTypeTemp,
                    statusTemp
            );
            schepen.add(schipTemp);
            schipTemp.setId(i+1);
            schipTemp.setVerkeerstorens(verkeerstorens);
            schipTemp.berekenDichtstbijzijndeVerkeerstoren();
        }
    }

    public void print() {
        System.out.println("VERKEERSTORENS:");
        System.out.println("---------------");
        for(int i=0; i<verkeerstorens.size(); i++)
            System.out.println(verkeerstorens.get(i));
        System.out.println("HULPDIENSTEN:");
        System.out.println("-------------");
        for(int i=0; i<hulpdiensten.size(); i++)
            System.out.println(hulpdiensten.get(i));
        System.out.println("SCHEPEN:");
        System.out.println("--------");
        for(int i=0; i<schepen.size(); i++)
            System.out.println(schepen.get(i));
    }

    public void randomReddingsactie(){
        generator.generateRandomSchip(schepen).noodsituatieBericht();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Window/MainWindow.fxml"));
        primaryStage.setTitle("Main");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();

    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Log.logger.setLevel(Level.WARN);
        TestRadar radar = new TestRadar();
        radar.setUp();
        radar.print();
        radar.randomReddingsactie();
        launch(args);
    }


}
