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
