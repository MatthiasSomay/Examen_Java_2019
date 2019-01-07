/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 21/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Klasse met lijst type verkeerstoren
 */

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
