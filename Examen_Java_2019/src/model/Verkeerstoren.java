/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Verkeerstoren klasse
 */

package model;

import utilities.Log;
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

    public Verkeerstoren(Coördinaten locatie, String type, List<Verkeerstoren> verkeerstorens) {
        super(locatie,verkeerstorens);
        setType(type);
    }

    public Verkeerstoren(Coördinaten locatie,Integer id, String type, List<Verkeerstoren> verkeerstorens) {
        super(locatie, id, verkeerstorens);
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


    public void detecteerNoodsituatie(Schip schipInNood) {
        verleenHulp(schipInNood);

    }

    public void maakLijstHulpverleners(Verkeerstoren verkeerstoren){
        hulpverleners.addAll(verkeerstoren.schepen);
        hulpverleners.addAll(verkeerstoren.hulpdiensten);
    }

    public void berekenHulpverleners(Verkeerstoren verkeerstoren){
        maakLijstHulpverleners(verkeerstoren);
        List<Verkeerstoren> verkeerstorensTemp = getVerkeerstorens();
        verkeerstorensTemp.remove(verkeerstoren);

        for(int i=0; i<2; i++) {
            Verkeerstoren hulpVerkeerstoren = null;
            double afstand = 0;
            for (Verkeerstoren v : verkeerstorensTemp) {
                double afstandTemp = berekenAfstand(v);
                if (hulpVerkeerstoren == null && afstand == 0) {
                    hulpVerkeerstoren = v;
                    afstand = afstandTemp;
                } else if (afstand > afstandTemp) {
                    hulpVerkeerstoren = v;
                    afstand = afstandTemp;
                }
            }
            if (hulpVerkeerstoren != null){
                maakLijstHulpverleners(hulpVerkeerstoren);
                verkeerstorensTemp.remove(hulpVerkeerstoren);
            }
        }
    }

    @Override
    public void verleenHulp(Schip schipInNood) {
        berekenHulpverleners(schipInNood.getDichtstbijzijndeVerkeerstoren());
        noodsituatieBroadcastBericht(schipInNood);
        hulpverleners.remove(schipInNood);

        Collections.sort(hulpverleners, Comparator.comparingDouble(Vervoermiddel::getLaatsteReactieTijd));

        if (hulpverleners.size() == 0){
            Log.logger.warn(
                        "Geen hulpverleners beschikbaar bij de drie dichtsbijzijnde verkeerstorens.");
        }
        else {
            Log.logger.info(
                    hulpverleners.size() +
                    " mogelijke hulpverlener(s) beschikbaar bij de drie dichtsbijzijnde verkeerstorens.");

            int opvarendenTeRedden = schipInNood.getPersonenAanBoord();
            for (Vervoermiddel hulpverlener : hulpverleners) {
                if (schipInNood.getPersonenAanBoord() > 0) {
                    hulpverlener.verleenHulp(schipInNood);
                    hulpverlener.setStatus(new NietBeschikbaar());
                }
                else {break;}
            }
            if (schipInNood.getPersonenAanBoord() > 0){
                Log.logger.info((opvarendenTeRedden - schipInNood.getPersonenAanBoord()) + " opvarenden zijn gered.");
            }
            else{
                Log.logger.info("Alle " + (opvarendenTeRedden - schipInNood.getPersonenAanBoord()) + " opvarenden zijn gered.");
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
        if (schepen == null ) {
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
