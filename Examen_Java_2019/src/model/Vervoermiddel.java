/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 15/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Vervoermiddel klasse
 */

package model;

import utilities.Log;
import utilities.afronden.Afronden;
import utilities.demodata.HulpdienstTypeLijst;
import utilities.demodata.SchipTypeLijst;
import utilities.interfaces.IVerleenHulp;
import utilities.states.Status;

import java.util.List;

public abstract class Vervoermiddel extends Actor implements IVerleenHulp {

    HulpdienstTypeLijst hulpdienstTypeLijst = new HulpdienstTypeLijst();
    SchipTypeLijst schipTypeLijst = new SchipTypeLijst();
    private Afronden afronden = new Afronden();

    private double snelheid;
    private double grootte;
    private double wendbaarheid;
    private int personenAanBoord;
    private double koers;
    private String type;
    private Status status;
    private int laatsteReactieTijd;
    private Verkeerstoren dichtstbijzijndeVerkeerstoren;


    public Vervoermiddel(Coördinaten locatie, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status, List<Verkeerstoren> verkeerstorens) {
        super(locatie, verkeerstorens);
        setSnelheid(snelheid);
        setGrootte(grootte);
        setWendbaarheid(wendbaarheid);
        setPersonenAanBoord(personenAanBoord);
        setKoers(koers);
        setType(type);
        setStatus(status);
        berekenDichtstbijzijndeVerkeerstoren();
    }

    public Vervoermiddel(Coördinaten locatie, Integer id, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status, List<Verkeerstoren> verkeerstorens) {
        super(locatie, id, verkeerstorens);
        setSnelheid(snelheid);
        setGrootte(grootte);
        setWendbaarheid(wendbaarheid);
        setPersonenAanBoord(personenAanBoord);
        setKoers(koers);
        setType(type);
        setStatus(status);
        berekenDichtstbijzijndeVerkeerstoren();
    }


    public double berekenReactietijd(Actor actorInNood, double draaicirkel) {
        return (berekenWendbaarheidstijd(draaicirkel) + ((berekenAfstand(actorInNood)/getSnelheid())*60));
    }

    public double berekenWendbaarheidstijd (double draaicirkel) {
        return ((draaicirkel * getWendbaarheid())/60);
    }

    public int berekenCapaciteit () {
        return (int) Math.round(getGrootte() - getPersonenAanBoord());
    }

    public void berekenDichtstbijzijndeVerkeerstoren(){
        Verkeerstoren verkeerstoren = getDichtstbijzijndeVerkeerstoren();
        double afstand = 0;
        if (verkeerstoren != null){
            afstand = berekenAfstand(verkeerstoren);
        }
        for (Verkeerstoren v : getVerkeerstorens()
        ) {
            double afstandTemp = berekenAfstand(v);
            if (verkeerstoren == null && afstand == 0){
                verkeerstoren = v;
                afstand = afstandTemp;
            }
            else if (afstand > afstandTemp){
                verkeerstoren = v;
                afstand = afstandTemp;
            }
        }
        if (verkeerstoren != getDichtstbijzijndeVerkeerstoren()){
            setDichtstbijzijndeVerkeerstoren(verkeerstoren);
            aanmeldenDichtstbijzijndeVerkeerstoren(verkeerstoren);
        }
    }

    public void verleenHulp(Schip schipInNood) {
        switch (getStatus().beschikbaarheid()){
            case 0:
                Log.logger.warn(
                            getType() +
                            ", ID: " + getId() +
                            " is momenteel niet beschikbaar.");
                break;
            case 1:
                Log.logger.warn(
                            getType() +
                            ", ID: " + getId() +
                            " is in nood.");
                break;
            case 2:
                Log.logger.info(
                        getType() +
                                ", ID: " + getId() +
                                " voegt zich bij de reddingsactie, reactietijd: " +
                                getLaatsteReactieTijd() + " minuten");
                if (berekenCapaciteit() > schipInNood.getPersonenAanBoord()){
                    setPersonenAanBoord(getPersonenAanBoord() + schipInNood.getPersonenAanBoord());
                    schipInNood.setPersonenAanBoord(0);
                }
                else {
                    schipInNood.setPersonenAanBoord(schipInNood.getPersonenAanBoord() - berekenCapaciteit());
                    setPersonenAanBoord(getPersonenAanBoord() + berekenCapaciteit());
                }
                break;
                default: break;
        }
    }

    public void aanmeldenDichtstbijzijndeVerkeerstoren(Verkeerstoren oldVerkeerstoren){}

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
        if (personenAanBoord < 0) {
            throw new IllegalArgumentException("Personen aan boord mag niet negatief zijn");
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

    public int getLaatsteReactieTijd() {
        return laatsteReactieTijd;
    }

    public void setLaatsteReactieTijd(double laatsteReactieTijd) throws IllegalArgumentException {
        if (laatsteReactieTijd <= 0) {
            throw new IllegalArgumentException("Ongeldige reactietijd");
        }
        this.laatsteReactieTijd = afronden.RondAfNaarGeheelGetal(laatsteReactieTijd);
    }

    public Verkeerstoren getDichtstbijzijndeVerkeerstoren() {
        return dichtstbijzijndeVerkeerstoren;
    }

    public void setDichtstbijzijndeVerkeerstoren(Verkeerstoren dichtstbijzijndeVerkeerstoren) throws IllegalArgumentException {
        if (dichtstbijzijndeVerkeerstoren == null) {
            throw new IllegalArgumentException("Ongeldige toren");
        }
        this.dichtstbijzijndeVerkeerstoren = dichtstbijzijndeVerkeerstoren;
    }
}
