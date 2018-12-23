/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Hulpdienst klasse
 */

package model;

import java.util.List;

public class Hulpdienst extends Vervoermiddel {

    private String type;

    public Hulpdienst(Coördinaten locatie, List<Verkeerstoren> verkeerstorens, double snelheid, double grootte, double wendbaarheid, int capaciteit, int personenAanBoord, double koers, String type) {
        super(locatie, verkeerstorens, snelheid, grootte, wendbaarheid, capaciteit, personenAanBoord, koers);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
