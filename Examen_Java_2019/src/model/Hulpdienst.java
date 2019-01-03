/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Hulpdienst klasse
 */

package model;

import utilities.states.Status;

public class Hulpdienst extends Vervoermiddel {

    public Hulpdienst(Coördinaten locatie, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status) {
        super(locatie, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status);
    }

    @Override
    public void aanmeldenDichtstbijzijndeVerkeerstoren(Verkeerstoren oldVerkeerstoren){
        getDichtstbijzijndeVerkeerstoren().getHulpdiensten().add(this);
        if (oldVerkeerstoren != null){
            getDichtstbijzijndeVerkeerstoren().getHulpdiensten().remove(this);
        }
    }
}
