/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Hulpdienst klasse
 */

package model;

import utilities.interfaces.IStatus;

import java.util.List;

public class Hulpdienst extends Vervoermiddel {

    private String type;
    private IStatus status;


    public Hulpdienst(Coördinaten locatie, List<Verkeerstoren> verkeerstorens, double snelheid, double grootte, double wendbaarheid, int capaciteit, int personenAanBoord, double koers, String type, IStatus status) {
        super(locatie, verkeerstorens, snelheid, grootte, wendbaarheid, capaciteit, personenAanBoord, koers);
        this.type = type;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public IStatus getStatus() {
        return status;
    }

    public void setStatus(IStatus status) {
        this.status = status;
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
