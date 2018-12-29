package utilities.generator;

import model.Coördinaten;
import utilities.afronden.Afronden;
import utilities.demodata.HulpdienstTypeLijst;
import utilities.demodata.SchipTypeLijst;
import utilities.demodata.VerkeerstorenTypeLijst;

import java.util.Random;

public class Generator {
    private static final Random RANDOM = new Random();
    private HulpdienstTypeLijst hulpdienstTypeLijst = new HulpdienstTypeLijst();
    private SchipTypeLijst schipTypeLijst = new SchipTypeLijst();
    private VerkeerstorenTypeLijst verkeerstorenTypeLijst = new VerkeerstorenTypeLijst();
    private Afronden afronden = new Afronden();

    public String generateTypeHulpdienst(){
        return (hulpdienstTypeLijst.hulpdienstType.get(RANDOM.nextInt(hulpdienstTypeLijst.hulpdienstType.size())));
    }

    public String generateTypeSchip(){
        return (schipTypeLijst.schipType.get(RANDOM.nextInt(schipTypeLijst.schipType.size())));
    }

    public String generateTypeVerkeerstoren(){
        return (verkeerstorenTypeLijst.verkeerstorenType.get(RANDOM.nextInt(verkeerstorenTypeLijst.verkeerstorenType.size())));
    }

    public Coördinaten generateLocatie(){
        return new Coördinaten((1+ (Math.random()*10)), (1+ (Math.random()*10)));
    }

    public double generateSnelheid(String Type){
        switch (Type) {
            case "Tanker": return (13+ (Math.random()*4));
            case "Cruiseschip": return (18+ (Math.random()*4));
            case "ContainerSchip": return (25+ (Math.random()*8));
            case "Zeilboot": return (6+ (Math.random()*4));
            case "Speedboot": return (30+ (Math.random()*20));
            case "Vissersboot": return (13+ (Math.random()*4));
            case "Seaking": return (140+ (Math.random()*40));
            case "Zeepolitie": return (85+ (Math.random()*20));
            case "Marine": return (40+ (Math.random()*20));
            case "Zeebrandweer": return (65+ (Math.random()*20));
            default: return 0;
        }
    }

    public double generateGrootte(String Type){
        switch (Type) {
            case "Tanker": return (25000+ (Math.random()*10000));
            case "Cruiseschip": return (10000+ (Math.random()*5000));
            case "ContainerSchip": return (15000+ (Math.random()*10000));
            case "Zeilboot": return (30+ (Math.random()*15));
            case "Speedboot": return (20+ (Math.random()*60));
            case "Vissersboot": return (150+ (Math.random()*100));
            case "Seaking": return (8+ (Math.random()*3));
            case "Zeepolitie": return (60+ (Math.random()*20));
            case "Marine": return (2000+ (Math.random()*10000));
            case "Zeebrandweer": return (60+ (Math.random()*20));
            default: return 0;
        }
    }

    public double generateWendbaarheid(String Type){
        switch (Type) {
            case "Tanker": return (7+ (Math.random()*4));
            case "Cruiseschip": return (5+ (Math.random()*3));
            case "ContainerSchip": return (6+ (Math.random()*4));
            case "Zeilboot": return (0.6+ (Math.random()*0.4));
            case "Speedboot": return (0.09+ (Math.random()*0.05));
            case "Vissersboot": return (3+ (Math.random()*5));
            case "Seaking": return (0.09+ (Math.random()*0.05));
            case "Zeepolitie": return (0.25+ (Math.random()*0.1));
            case "Marine": return (5+ (Math.random()*3));
            case "Zeebrandweer": return (0.35+ (Math.random()*0.15));
            default: return 0;
        }
    }

    public int generatePersonenAanBoord(String Type){
        switch (Type) {
            case "Tanker": return afronden.RondAfNaarGeheelGetal(20+ (Math.random()*10));
            case "Cruiseschip": return afronden.RondAfNaarGeheelGetal(500+ (Math.random()*6000));
            case "ContainerSchip": return afronden.RondAfNaarGeheelGetal(30+ (Math.random()*15));
            case "Zeilboot": return afronden.RondAfNaarGeheelGetal(2+ (Math.random()*8));
            case "Speedboot": return afronden.RondAfNaarGeheelGetal(2+ (Math.random()*8));
            case "Vissersboot": return afronden.RondAfNaarGeheelGetal(10+ (Math.random()*5));
            case "Seaking": return afronden.RondAfNaarGeheelGetal(3+ (Math.random()*2));
            case "Zeepolitie": return afronden.RondAfNaarGeheelGetal(7+ (Math.random()*3));
            case "Marine": return afronden.RondAfNaarGeheelGetal(1500+ (Math.random()*500));
            case "Zeebrandweer": return afronden.RondAfNaarGeheelGetal(7+ (Math.random()*10));
            default: return 0;
        }
    }

    public double generateKoers(){
        return ((Math.random()*360));
    }

    public double generateDraaicirkel(){
        return ((Math.random()*360));
    }

}
