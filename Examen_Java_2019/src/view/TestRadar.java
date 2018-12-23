package view;

import factory.VerkeerstorenFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Verkeerstoren;
import utilities.generator.Generator;

import java.util.ArrayList;
import java.util.List;

public class TestRadar extends Application {

    private List<Verkeerstoren> verkeerstorens = new ArrayList<>();
    private List<Verkeerstoren> hulpdiensten = new ArrayList<Verkeerstoren>();
    private Generator generator = new Generator();

    public void setUp() {
        for(int i=0; i<10; i++){
            verkeerstorens.add(VerkeerstorenFactory.createVerkeerstoren(
                    generator.generateLocatie(),
                    verkeerstorens,
                    generator.generateTypeVerkeerstoren()
            ));
        }
    }

    public void print() {
        for(int i=0; i<verkeerstorens.size(); i++)
            System.out.println(verkeerstorens.get(i));
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
            launch(args);
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }


}
