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
