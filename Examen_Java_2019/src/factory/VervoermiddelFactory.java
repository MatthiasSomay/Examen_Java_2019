/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 22/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Factory klasse
 */


package factory;

import model.Coördinaten;
import model.Hulpdienst;
import model.Schip;
import model.Vervoermiddel;
import utilities.states.Status;


public class VervoermiddelFactory {

    public static Vervoermiddel createVervoermiddel(Coördinaten locatie, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status, String hoofdType)
    {
        switch (hoofdType){
            case "Schip": return new Schip(locatie, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status);
            case "Hulpdienst": return new Hulpdienst(locatie, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status);
            default: return null;
        }
    }

}
