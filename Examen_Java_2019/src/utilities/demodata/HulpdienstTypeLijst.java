/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 21/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Klasse met lijst type hulpdiensten
 */

package utilities.demodata;

import java.util.Arrays;
import java.util.List;

public class HulpdienstTypeLijst {
    public List<String> hulpdienstType;

    public HulpdienstTypeLijst() {
        this.hulpdienstType = Arrays.asList(
                "Seaking", "Zeepolitie", "Marine", "Zeebrandweer");
    }

    public List<String> getHulpdienstType() {
        return hulpdienstType;
    }

    public void setHulpdienstType(List<String> hulpdienstType) {
        this.hulpdienstType = hulpdienstType;
    }
}
