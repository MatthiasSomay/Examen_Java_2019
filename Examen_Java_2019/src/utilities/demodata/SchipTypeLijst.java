/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 21/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Klasse met lijst type schepen
 */
package utilities.demodata;

import java.util.Arrays;
import java.util.List;

public class SchipTypeLijst {
    public List<String> schipType;

    public SchipTypeLijst() {
        this.schipType = Arrays.asList(
                "Tanker", "Cruiseschip", "ContainerSchip", "Zeilboot", "Speedboot", "Vissersboot");
    }

    public List<String> getSchipType() {
        return schipType;
    }

    public void setSchipType(List<String> schipType) {
        this.schipType = schipType;
    }
}
