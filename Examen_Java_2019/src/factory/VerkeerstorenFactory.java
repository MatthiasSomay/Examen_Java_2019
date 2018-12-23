package factory;

import model.Coördinaten;
import model.Verkeerstoren;

import java.util.List;

public class VerkeerstorenFactory {
    public static Verkeerstoren createVerkeerstoren(Coördinaten locatie, List<Verkeerstoren> verkeerstorens, String type)
    {
        return new Verkeerstoren(locatie, verkeerstorens, type);
    }
}
