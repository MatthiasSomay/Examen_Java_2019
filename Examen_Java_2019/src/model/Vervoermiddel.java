/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 15/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Vervoermiddel klasse
 */

package model;

import utilities.afronden.Afronden;
import utilities.demodata.HulpdienstTypeLijst;
import utilities.demodata.SchipTypeLijst;
import utilities.states.Status;
import java.util.List;

public abstract class Vervoermiddel extends Actor {

    HulpdienstTypeLijst hulpdienstTypeLijst = new HulpdienstTypeLijst();
    SchipTypeLijst schipTypeLijst = new SchipTypeLijst();
    Afronden afronden = new Afronden();

    private double snelheid;
    private double grootte;
    private double wendbaarheid;
    private int personenAanBoord;
    private double koers;
    private String type;
    private Status status;

    public Vervoermiddel() {
    }

    public Vervoermiddel(Coördinaten locatie, List<Verkeerstoren> verkeerstorens, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status) {
        super(locatie, verkeerstorens);
        setSnelheid(snelheid);
        setGrootte(grootte);
        setWendbaarheid(wendbaarheid);
        setPersonenAanBoord(personenAanBoord);
        setKoers(koers);
        setType(type);
        setStatus(status);
    }

    // TODO: 2018-12-19
    public double berekenReactietijd(Actor actor) {
        return 0;
    }

    @Override
    public String toString() {
        return ("ID: " + getId() +
                "\nLocatie: " + getLocatie().toString() +
                "\nSnelheid: " + getSnelheid() + " knopen" +
                "\nGrootte: " + getGrootte() + " m²" +
                "\nWendbaarheid: " + getWendbaarheid() + " sec/graad" +
                "\nAantal personen aan boord: " + getPersonenAanBoord() +
                "\nKoers: " + getKoers() + " graden" +
                "\nType: " + getType() +
                "\nStatus: " + getStatus() + "\n"
        );
    }

    public double getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(double snelheid) throws IllegalArgumentException {
        if (snelheid < 0) {
            throw new IllegalArgumentException("Ongeldige snelheid");
        }
        this.snelheid = afronden.RondAfNaarTweeNaKomma(snelheid);
    }

    public double getGrootte() {
        return grootte;
    }

    public void setGrootte(double grootte) throws IllegalArgumentException{
        if (grootte < 0) {
            throw new IllegalArgumentException("Ongeldige grootte");
        }
        this.grootte = afronden.RondAfNaarTweeNaKomma(grootte);
    }

    public double getWendbaarheid() {
        return wendbaarheid;
    }

    public void setWendbaarheid(double wendbaarheid) throws IllegalArgumentException {
        if (wendbaarheid <= 0) {
            throw new IllegalArgumentException("Ongeldige wendbaarheid");
        }
        this.wendbaarheid = afronden.RondAfNaarTweeNaKomma(wendbaarheid);
    }

    public int getPersonenAanBoord() {
        return personenAanBoord;
    }

    public void setPersonenAanBoord(int personenAanBoord) throws IllegalArgumentException {
        if (personenAanBoord <= 0) {
            throw new IllegalArgumentException("Personen aan boord mag niet nul of negatief zijn");
        }
        this.personenAanBoord = afronden.RondAfNaarGeheelGetal(personenAanBoord);
    }

    public double getKoers() {
        return koers;
    }

    public void setKoers(double koers) throws IllegalArgumentException {
        if (koers < 0) {
            throw new IllegalArgumentException("Ongeldige koers");
        }
        this.koers = afronden.RondAfNaarTweeNaKomma(koers);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws IllegalArgumentException {

        if (!hulpdienstTypeLijst.hulpdienstType.contains(type) && !schipTypeLijst.schipType.contains(type)) {
            throw new IllegalArgumentException("Ongeldig type");
        }
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
