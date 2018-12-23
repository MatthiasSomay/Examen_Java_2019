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

    public Hulpdienst(Coördinaten locatie, List<Verkeerstoren> verkeerstorens, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status) {
        super(locatie, verkeerstorens, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status);
    }

    // TODO: 2018-12-19
    @Override
    public double berekenAfstand(Actor actor) {
        return 0;
    }

    // TODO: 2018-12-19
    @Override
    public void verleenHulp() {

    }
}
