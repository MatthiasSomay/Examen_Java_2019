package factory;

import model.Coördinaten;
import model.Verkeerstoren;

import java.util.List;

public class VerkeerstorenFactory {
    public static Verkeerstoren createVerkeerstoren(Coördinaten locatie, String type, List<Verkeerstoren> verkeerstorens)
    {
        return new Verkeerstoren(locatie, type, verkeerstorens);
    }
}
