/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 23/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: State Pattern - Niet Beschikbaar state klasse
 */


package utilities.states;

public class NietBeschikbaar extends Status {
    @Override
    public void doeActie() {

    }

    @Override
    public String toString() {
        return "Niet beschikbaar";
    }
}
