/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Hulpdienst klasse
 */

package model;

import utilities.states.Status;

import java.util.List;

public class Hulpdienst extends Vervoermiddel {

    public Hulpdienst(Coördinaten locatie, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status,  List<Verkeerstoren> verkeerstorens) {
        super(locatie, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status, verkeerstorens);
    }

    public Hulpdienst(Coördinaten locatie, Integer id, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status, List<Verkeerstoren> verkeerstorens) {
        super(locatie, id, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status, verkeerstorens);

    }

    @Override
    public void aanmeldenDichtstbijzijndeVerkeerstoren(Verkeerstoren oldVerkeerstoren){
        getDichtstbijzijndeVerkeerstoren().getHulpdiensten().add(this);
        if (oldVerkeerstoren != null){
            getDichtstbijzijndeVerkeerstoren().getHulpdiensten().remove(this);
        }
    }
}
