/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Actor klasse
 */


package model;

import utilities.interfaces.ILocaliseerbaar;
import utilities.interfaces.IVerleenHulp;

import java.util.List;

public abstract class Actor implements ILocaliseerbaar, IVerleenHulp {

    private int id;
    private Coördinaten locatie;
    private List<Verkeerstoren> verkeerstorens;
    private IVerleenHulp hulpverlening;

    public Actor() {
    }

    public Actor(int id, Coördinaten locatie, List<Verkeerstoren> verkeerstorens) {
        this.id = id;
        this.locatie = locatie;
        this.verkeerstorens = verkeerstorens;
    }

    // TODO: 2018-12-19
    public double berekenAfstand(Actor actor) {
        return 0;

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

    public void setVerkeerstorens(List<Verkeerstoren> verkeerstorens) {
        this.verkeerstorens = verkeerstorens;
    }
}
