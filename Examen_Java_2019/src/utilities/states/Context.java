/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 23/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: State Pattern - Context klasse
 */


package utilities.states;

import utilities.interfaces.IStatus;

public class Context {

    private IStatus status;

    public Context() {
        status = null;
    }

    public IStatus getStatus() {
        return status;
    }

    public void setStatus(IStatus status) {
        this.status = status;
    }
}
