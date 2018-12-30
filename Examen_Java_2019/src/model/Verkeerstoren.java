/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Verkeerstoren klasse
 */

package model;

import utilities.demodata.VerkeerstorenTypeLijst;
import utilities.generator.Generator;
import utilities.interfaces.IVerkeerstorenSubject;
import utilities.states.NietBeschikbaar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Verkeerstoren extends Actor implements IVerkeerstorenSubject {

    VerkeerstorenTypeLijst verkeerstorenTypeLijst = new VerkeerstorenTypeLijst();
    Generator generator = new Generator();

    private List<Hulpdienst> hulpdiensten = new ArrayList<>();
    private List<Schip> schepen = new ArrayList<>();
    private String type;
    private List<Vervoermiddel> hulpverleners = new ArrayList<>();

    public Verkeerstoren(Coördinaten locatie, List<Verkeerstoren> verkeerstorens, String type) {
        super(locatie, verkeerstorens);
        setType(type);
    }

    public void addSchipObserver(Schip schip) {
        schepen.add(schip);
    }

    public void removeSchipObserver(Schip schip) {
        schepen.remove(schip);
    }

    public void noodsituatieBroadcastBericht(Schip schipInNood) {
        for (Vervoermiddel hulpverlener : hulpverleners) {
            hulpverlener.setLaatsteReactieTijd(hulpverlener.berekenReactietijd(schipInNood, generator.generateDraaicirkel()));
        }
    }

    // TODO: 2018-12-19
    private void detecteerNoodsituatie() {

    }

    public void maakLijstHulpverleners(Schip schipInNood){
        for (Schip schip : schepen
        ) {
            hulpverleners.add(schip);
        }
        for (Hulpdienst hulpdienst : hulpdiensten
        ) {
            hulpverleners.add(hulpdienst);
        }
        hulpverleners.remove(schipInNood);
    }

    @Override
    public void verleenHulp(Schip schipInNood) {
        maakLijstHulpverleners(schipInNood);
        noodsituatieBroadcastBericht(schipInNood);

        Collections.sort(hulpverleners, Comparator.comparingDouble(Vervoermiddel::getLaatsteReactieTijd));

        if (hulpverleners.size() == 0){
            System.out.println(
                        "Geen hulpverleners beschikbaar bij verkeerstoren " +
                        "ID: " + getId() +
                        ", Type: " + getType());
        }
        else {
            System.out.println(
                    hulpverleners.size() +
                    " mogelijke hulpverlener(s) beschikbaar bij verkeerstoren " +
                    "ID: " + getId() +
                    ", Type: " + getType());

            int opvarendenTeRedden = schipInNood.getPersonenAanBoord();
            for (Vervoermiddel hulpverlener : hulpverleners) {
                if (schipInNood.getPersonenAanBoord() > 0) {
                    hulpverlener.verleenHulp(schipInNood);
                    hulpverlener.setStatus(new NietBeschikbaar());
                }
                else {break;}
            }
            if (schipInNood.getPersonenAanBoord() > 0){
                System.out.println((opvarendenTeRedden - schipInNood.getPersonenAanBoord()) + " opvarenden zijn gered.");
            }
            else{
                System.out.println("Alle " + (opvarendenTeRedden - schipInNood.getPersonenAanBoord()) + " opvarenden zijn gered.");
            }
        }
    }

    @Override
    public String toString() {
        return ("ID: " + getId() +
                "\nLocatie: " + getLocatie().toString() +
                "\nType: " + getType() + "\n"
                );
    }

    public List<Hulpdienst> getHulpdiensten() {
        return hulpdiensten;
    }

    public void setHulpdiensten(List<Hulpdienst> hulpdiensten) throws IllegalArgumentException {
        if (hulpdiensten == null) {
            throw new IllegalArgumentException("Lijst hulpdiensten ongeldig");
        }
        this.hulpdiensten = hulpdiensten;
    }

    public List<Schip> getSchepen() {
        return schepen;
    }

    public void setSchepen(List<Schip> schepen) throws IllegalArgumentException {
        if (schepen == null) {
            throw new IllegalArgumentException("Lijst schepen ongeldig");
        }
        this.schepen = schepen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws IllegalArgumentException {
        if (verkeerstorenTypeLijst.verkeerstorenType.contains(type)) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Ongeldig type");
        }
    }


}
