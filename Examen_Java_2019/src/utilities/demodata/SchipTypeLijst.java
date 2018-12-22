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
