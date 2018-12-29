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
import utilities.states.Beschikbaar;
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
    private List<Vervoermiddel> beschikbareHulpverleners = new ArrayList<>();

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
        for (Vervoermiddel beschikbareHulpverlener : beschikbareHulpverleners) {
            beschikbareHulpverlener.setLaatsteReactieTijd(beschikbareHulpverlener.berekenReactietijd(schipInNood, generator.generateDraaicirkel()));
        }
    }

    // TODO: 2018-12-19
    private void detecteerNoodsituatie() {

    }

    public void maakLijstBeschikbareHulpverleners(){
        for (Schip schip : schepen
        ) {
            if (schip.getStatus().equals(Beschikbaar.class)){
                beschikbareHulpverleners.add(schip);
            }
        }
        for (Hulpdienst hulpdienst : hulpdiensten
        ) {
            if (hulpdienst.getStatus().equals(Beschikbaar.class)){
                beschikbareHulpverleners.add(hulpdienst);
            }
        }
    }

    @Override
    public void verleenHulp(Schip schipInNood) {
        maakLijstBeschikbareHulpverleners();
        noodsituatieBroadcastBericht(schipInNood);

        Collections.sort(beschikbareHulpverleners, Comparator.comparingDouble(Vervoermiddel::getLaatsteReactieTijd));

        int personenTeRedden = schipInNood.getPersonenAanBoord();
        for (Vervoermiddel beschikbareHulpverlener : beschikbareHulpverleners) {
            if (personenTeRedden > 0){
                beschikbareHulpverlener.setStatus(new NietBeschikbaar());
                personenTeRedden -= beschikbareHulpverlener.berekenCapaciteit();
                System.out.println(
                        beschikbareHulpverlener.getType() +
                        ", ID: " + beschikbareHulpverlener.getId() +
                                " voegt zich bij de reddingsactie, reactietijd: " +
                                beschikbareHulpverlener.getLaatsteReactieTijd());
            }
            else if (personenTeRedden <= 0){
                break;
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
