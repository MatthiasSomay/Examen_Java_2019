/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 23/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: State Pattern - In Nood state klasse
 */


package utilities.states;

public class InNood extends Status {

    @Override
    public int beschikbaarheid(){
        return 1;
    }

    @Override
    public String toString() {
        return "In nood";
    }
}
