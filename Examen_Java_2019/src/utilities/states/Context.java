/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 23/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: State Pattern - Context klasse
 */


package utilities.states;

public class Context {

    private Status status;

    public Context() {
        status = null;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
