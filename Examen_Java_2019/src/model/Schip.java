/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Schip klasse
 */

package model;

import utilities.Log;
import utilities.interfaces.IVerkeerstorenObserver;
import utilities.states.Status;

import java.util.List;

public class Schip extends Vervoermiddel implements IVerkeerstorenObserver {

    public Schip(Coördinaten locatie, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status, List<Verkeerstoren> verkeerstorens) {
        super(locatie, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status, verkeerstorens);
    }

    public Schip(Coördinaten locatie, Integer id, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status, List<Verkeerstoren> verkeerstorens) {
        super(locatie, id, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status, verkeerstorens);
    }


    public void noodsituatieBericht() {
        Log.logger.warn(
                    getType() +
                    ", ID: " + getId() +
                    " is in nood, " +
                    getLocatie().toString() +
                    " SOS!");

        getDichtstbijzijndeVerkeerstoren().verleenHulp(this);
    }

    // TODO: 2018-12-19
    public void stuurLaatsteVaargegevens() {

    }

    @Override
    public void aanmeldenDichtstbijzijndeVerkeerstoren(Verkeerstoren oldVerkeerstoren){
        getDichtstbijzijndeVerkeerstoren().addSchipObserver(this);
        if (oldVerkeerstoren != null){
            oldVerkeerstoren.removeSchipObserver(this);
        }
    }
}
