package utilities.generator;

import model.Coördinaten;
import utilities.demodata.HulpdienstTypeLijst;
import utilities.demodata.SchipTypeLijst;
import utilities.demodata.VerkeerstorenTypeLijst;

import java.util.Random;

public class Generator {
    private static final Random RANDOM = new Random();
    private HulpdienstTypeLijst hulpdienstTypeLijst = new HulpdienstTypeLijst();
    private SchipTypeLijst schipTypeLijst = new SchipTypeLijst();
    private VerkeerstorenTypeLijst verkeerstorenTypeLijst = new VerkeerstorenTypeLijst();

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
        return new Coördinaten(((1+ (Math.random()*10))), ((1+ (Math.random()*10))));
    }

    public double generateSnelheid(){
        return (1+ (Math.random()*10));
    }

    public double generateGrootte(){
        return (50+ (Math.random()*200));
    }

    public double generateWendbaarheid(){
        return (50+ (Math.random()*200));
    }

    public int generateCapaciteit(){
        return (50+ (int)(Math.random()*200));
    }

    public int generatePersonenAanBoord(){
        return (50+ (int)(Math.random()*200));
    }

    public double generateKoers(){
        return (50+ (Math.random()*200));
    }
}
