package utilities.demodata;

import java.util.Arrays;
import java.util.List;

public class VerkeerstorenTypeLijst {
    public List<String> verkeerstorenType;

    public VerkeerstorenTypeLijst() {
        this.verkeerstorenType = Arrays.asList(
                "Zeehaven", "Luchthaven", "Vuurtoren");
    }

    public List<String> getVerkeerstorenType() {
        return verkeerstorenType;
    }

    public void setVerkeerstorenType(List<String> verkeerstorenType) {
        this.verkeerstorenType = verkeerstorenType;
    }
}
