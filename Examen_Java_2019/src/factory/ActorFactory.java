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

public class ActorFactory {

    public static Actor createActor(int y)
    {
        switch(y){
            case 0: return new Schip();
            case 1: return new Hulpdienst();
            case 2: return new Verkeerstoren();
            default:return null;
        }
    }

}
