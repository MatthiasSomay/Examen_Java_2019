/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 22/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Factory klasse
 */


package factory;

import model.Coördinaten;
import model.Schip;
import model.Status;
import model.Verkeerstoren;

import java.util.List;


public class SchipFactory {

    public static Schip createSchip(int y, Coördinaten locatie, List<Verkeerstoren> verkeerstorens, double snelheid, double grootte, double wendbaarheid, int capaciteit, int personenAanBoord, double koers, String type, Status status)
    {
        return new Schip(locatie, verkeerstorens, snelheid, grootte, wendbaarheid, capaciteit, personenAanBoord, koers, type, status);
    }

}
