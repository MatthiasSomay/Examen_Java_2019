/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 22/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Factory klasse
 */


package factory;

import model.Actor;
import model.Hulpdienst;
import model.Schip;
import model.Verkeerstoren;
import utilities.generator.Generator;

import java.util.List;

public class ActorFactory {
    
    //Hoe implementeren we Status? En wat met random lijst met verkeerstorens? Genereren we eerst random lijst torens en wijzen we deze toe aan schepen?

    public static Actor createActor(int y)
    {
        Generator g = new Generator();

        // Voor verkeerstoren heb je lijst met hulpdiensten nodig en lijst schepen
        // TODO: 2018-12-22  
        List<Verkeerstoren> torens;
        for (int i = 0; i <= 5; i++) {
            Verkeerstoren toren = new Verkeerstoren();
            torens.add(toren);
            i++;
        }
        
        switch(y){
            case 0: return new Schip(0,g.generateLocatie(), torens, g.generateSnelheid(), g.generateGrootte(), g.generateWendbaarheid(), g.generateCapaciteit(), g.generatePersonenAanBoord(), g.generateKoers(), g.generateTypeSchip(), null    );
            case 1: return new Hulpdienst();
            case 2: return new Verkeerstoren();
            default:return null;
        }
    }

}
