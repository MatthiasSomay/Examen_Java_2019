/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Schip klasse
 */

package model;

import utilities.interfaces.IVerkeerstorenObserver;
import utilities.states.Status;

public class Schip extends Vervoermiddel implements IVerkeerstorenObserver {

    public Schip(Coördinaten locatie, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status) {
        super(locatie, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status);
    }


    public void noodsituatieBericht() {
        System.out.println(
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
