/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Actor klasse
 */


package model;

import utilities.interfaces.ILocaliseerbaar;
import utilities.interfaces.IVerleenHulp;

import java.util.ArrayList;
import java.util.List;

public abstract class Actor implements ILocaliseerbaar, IVerleenHulp {

    private int id;
    private Coördinaten locatie;
    private List<Verkeerstoren> verkeerstorens = new ArrayList<>();

    public Actor(Coördinaten locatie, List<Verkeerstoren> verkeerstorens) {
        setLocatie(locatie);
        setVerkeerstorens(verkeerstorens);
    }

    public Actor(Coördinaten locatie, Integer id, List<Verkeerstoren> verkeerstorens) {
        setLocatie(locatie);
        setId(id);
        setVerkeerstorens(verkeerstorens);
    }

    public double berekenAfstand(Actor actor) {
        double dx = this.getLocatie().getBreedte() - actor.getLocatie().getBreedte();
        double dy = this.getLocatie().getLengte() - actor.getLocatie().getLengte();
        double dist = Math.sqrt( dx*dx + dy*dy );
        return dist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coördinaten getLocatie() {
        return locatie;
    }

    public void setLocatie(Coördinaten locatie) {
        this.locatie = locatie;
    }

    public List<Verkeerstoren> getVerkeerstorens() {
        return verkeerstorens;
    }

    public void setVerkeerstorens(List<Verkeerstoren> verkeerstorens) throws IllegalArgumentException {
        if (verkeerstorens == null) {
            throw new IllegalArgumentException("Lijst verkeerstorens ongeldig");
        }
        this.verkeerstorens = verkeerstorens;
    }
}
