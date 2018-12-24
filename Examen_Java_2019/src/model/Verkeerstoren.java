/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Verkeerstoren klasse
 */

package model;

import utilities.demodata.VerkeerstorenTypeLijst;
import utilities.interfaces.IVerkeerstorenSubject;

import java.util.List;

public class Verkeerstoren extends Actor implements IVerkeerstorenSubject {

    private List<Hulpdienst> hulpdiensten;
    private List<Schip> schepen;
    private String type;

    public Verkeerstoren(Coördinaten locatie, List<Verkeerstoren> verkeerstorens, List<Hulpdienst> hulpdiensten, List<Schip> schepen, String type) {
        super(locatie, verkeerstorens);
        setHulpdiensten(hulpdiensten);
        setSchepen(schepen);
        setType(type);
    }

    // TODO: 2018-12-19
    public void addSchipObserver() {

    }

    // TODO: 2018-12-19
    public void removeSchipObserver() {

    }

    // TODO: 2018-12-19
    public void noodsituatieBroadcastBericht() {

    }

    // TODO: 2018-12-19
    private void detecteerNoodsituatie() {

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
        return ("\nVerkeerstoren: " +
                "\nID: " + getId() +
                "\nLocatie: " + getLocatie().toString() +
                "\nType: " + getType()
                );
    }

    public List<Hulpdienst> getHulpdiensten() {
        return hulpdiensten;
    }

    public void setHulpdiensten(List<Hulpdienst> hulpdiensten) throws IllegalArgumentException {
        if (hulpdiensten.isEmpty() || hulpdiensten == null) {
            throw new IllegalArgumentException("Lijst hulpdiensten mag niet leeg zijn");
        }
        this.hulpdiensten = hulpdiensten;
    }

    public List<Schip> getSchepen() {
        return schepen;
    }

    public void setSchepen(List<Schip> schepen) throws IllegalArgumentException {
        if (schepen.isEmpty() || schepen == null) {
            throw new IllegalArgumentException("Lijst schepen mag niet leeg zijn");
        }
        this.schepen = schepen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws IllegalArgumentException {

        VerkeerstorenTypeLijst verkeerstorenTypeLijst = new VerkeerstorenTypeLijst();

        if (verkeerstorenTypeLijst.verkeerstorenType.contains(type)) {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Ongeldig type");

        }

    }


}
