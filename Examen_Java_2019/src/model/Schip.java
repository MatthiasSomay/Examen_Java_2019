/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Schip klasse
 */

package model;

import utilities.interfaces.IVerkeerstorenObserver;

import java.util.List;

public class Schip extends Vervoermiddel implements IVerkeerstorenObserver {


    private String type;
    private Status status;

    public Schip(Coördinaten locatie, List<Verkeerstoren> verkeerstorens, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status) {
        super(locatie, verkeerstorens, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status);
    }

    // TODO: 2018-12-19
    public void noodsituatieBericht() {

    }

    // TODO: 2018-12-19
    public void stuurLaatsteVaargegevens() {

    }

    // TODO: 2018-12-19
    public void berekenDichtsteVerkeerstoren() {

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

    @Override
    public String toString() {
        return super.toString();
    }
}
