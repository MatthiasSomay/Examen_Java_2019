/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 15/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Vervoermiddel klasse
 */

package model;

import java.util.List;

public abstract class Vervoermiddel extends Actor {

    private double snelheid;
    private double grootte;
    private double wendbaarheid;
    private int personenAanBoord;
    private double koers;

    public Vervoermiddel() {
    }



    public Vervoermiddel(Coördinaten locatie, List<Verkeerstoren> verkeerstorens, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers) {
        super(locatie, verkeerstorens );
        this.snelheid = snelheid;
        this.grootte = grootte;
        this.wendbaarheid = wendbaarheid;
        this.personenAanBoord = personenAanBoord;
        this.koers = koers;
    }

    // TODO: 2018-12-19
    public double berekenReactietijd(Actor actor) {
        return 0;
    }

    @Override
    public String toString() {
        return "Vervoermiddel{" +
                "snelheid=" + snelheid +
                ", grootte=" + grootte +
                ", wendbaarheid=" + wendbaarheid +
                ", capaciteit=" + /*capaciteit +*/
                ", personenAanBoord=" + personenAanBoord +
                ", koers=" + koers +
                '}';
    }

    public double getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(double snelheid) {
        this.snelheid = snelheid;
    }

    public double getGrootte() {
        return grootte;
    }

    public void setGrootte(double grootte) {
        this.grootte = grootte;
    }

    public double getWendbaarheid() {
        return wendbaarheid;
    }

    public void setWendbaarheid(double wendbaarheid) {
        this.wendbaarheid = wendbaarheid;
    }

    public int getPersonenAanBoord() {
        return personenAanBoord;
    }

    public void setPersonenAanBoord(int personenAanBoord) {
        this.personenAanBoord = personenAanBoord;
    }

    public double getKoers() {
        return koers;
    }

    public void setKoers(double koers) {
        this.koers = koers;
    }
}
