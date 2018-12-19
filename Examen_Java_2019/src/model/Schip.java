/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Schip klasse
 */

package model;

public class Schip extends Vervoermiddel implements IVerkeerstorenObserver{

    private String type;
    private Status status;

    public Schip(double snelheid, double grootte, double wendbaarheid, int capaciteit, int personenAanBoord, double koers, String type, Status status) {
        super(snelheid, grootte, wendbaarheid, capaciteit, personenAanBoord, koers);
        this.type = type;
        this.status = status;
    }

    // TODO: 2018-12-19
    public void noodsituatieBericht() {

    }

    // TODO: 2018-12-19
    public void stuurLaatsteVaargegevens() {

    }

    // TODO: 2018-12-19
    public void berekenDichtsteVerkeerstoren() {

    }

    // TODO: 2018-12-19
    @Override
    public double berekendAfstand(Actor actor) {
        return 0;
    }

    // TODO: 2018-12-19
    @Override
    public void verleenHulp() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
