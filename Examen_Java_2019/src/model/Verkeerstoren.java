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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Verkeerstoren extends Actor implements IVerkeerstorenSubject {

    VerkeerstorenTypeLijst verkeerstorenTypeLijst = new VerkeerstorenTypeLijst();
    Generator generator = new Generator();

    private List<Hulpdienst> hulpdiensten;
    private List<Schip> schepen;
    private String type;

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

    // TODO: 2018-12-19
    public void noodsituatieBroadcastBericht() {

    }

    // TODO: 2018-12-19
    private void detecteerNoodsituatie() {

    }

    @Override
    public void verleenHulp(Schip schipInNood) {
        for (Schip schip : schepen) {
            schip.setLaatsteReactieTijd(schip.berekenReactietijd(schipInNood, generator.generateDraaicirkel()));
        }
        Collections.sort(schepen, new Comparator<Schip>() {
            @Override
            public int compare(Schip o1, Schip o2) {
                return Double.compare(o1.getLaatsteReactieTijd(),o2.getLaatsteReactieTijd());
            }
        });
        int personenTeRedden = schipInNood.getPersonenAanBoord();
        for (Schip schip : schepen) {
            if (personenTeRedden > 0){
                schip.setStatus(new NietBeschikbaar());
                personenTeRedden -= schip.ber
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
