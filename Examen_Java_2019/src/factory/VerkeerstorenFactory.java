package factory;

import model.Coördinaten;
import model.Verkeerstoren;

public class VerkeerstorenFactory {
    public static Verkeerstoren createVerkeerstoren(Coördinaten locatie, String type)
    {
        return new Verkeerstoren(locatie, type);
    }
}
