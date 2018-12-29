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
import utilities.generator.Generator;
import utilities.states.Beschikbaar;
import utilities.states.Status;

import java.util.ArrayList;
import java.util.List;

public class TestRadar extends Application {

    private List<Verkeerstoren> verkeerstorens = new ArrayList<>();
    private List<Hulpdienst> hulpdiensten = new ArrayList<>();
    private List<Schip> schepen = new ArrayList<>();
    private Generator generator = new Generator();

    public void setUp() {
        String hulpdienstTypeTemp;
        String schipTypeTemp;

        for(int i=0; i<10; i++) {
            verkeerstorens.add(VerkeerstorenFactory.createVerkeerstoren(
                    generator.generateLocatie(),
                    verkeerstorens,
                    generator.generateTypeVerkeerstoren()
            ));
        }
        for(int i=0; i<10; i++){
            hulpdienstTypeTemp = generator.generateTypeHulpdienst();
            Status statusTemp = new Beschikbaar();
            hulpdiensten.add(HulpdienstFactory.createHulpdienst(
                    generator.generateLocatie(),
                    verkeerstorens,
                    generator.generateSnelheid(hulpdienstTypeTemp),
                    generator.generateGrootte(hulpdienstTypeTemp),
                    generator.generateWendbaarheid(hulpdienstTypeTemp),
                    generator.generatePersonenAanBoord(hulpdienstTypeTemp),
                    generator.generateKoers(),
                    hulpdienstTypeTemp,
                    statusTemp
            ));
        }
        for(int i=0; i<10; i++){
            schipTypeTemp = generator.generateTypeSchip();
            Status statusTemp = new Beschikbaar();
            schepen.add(SchipFactory.createSchip(
                    generator.generateLocatie(),
                    verkeerstorens,
                    generator.generateSnelheid(schipTypeTemp),
                    generator.generateGrootte(schipTypeTemp),
                    generator.generateWendbaarheid(schipTypeTemp),
                    generator.generatePersonenAanBoord(schipTypeTemp),
                    generator.generateKoers(),
                    schipTypeTemp,
                    statusTemp
            ));
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


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("Main");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();

    }

    public static void main(String[] args) {
        try {
            TestRadar radar = new TestRadar();
            radar.setUp();
            radar.print();
            

            /*launch(args);*/
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }


}
