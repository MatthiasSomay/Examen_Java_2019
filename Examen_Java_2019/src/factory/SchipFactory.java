/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 22/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Factory klasse
 */


package factory;

import model.Coördinaten;
import model.Schip;
import model.Verkeerstoren;
import utilities.states.Status;

import java.util.List;


public class SchipFactory {

    public static Schip createSchip(Coördinaten locatie, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status, List<Verkeerstoren> verkeerstorens)
    {
        return new Schip(locatie, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status, verkeerstorens);

    }

}
