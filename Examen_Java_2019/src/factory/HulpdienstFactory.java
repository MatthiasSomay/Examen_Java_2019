package factory;

import model.Coördinaten;
import model.Hulpdienst;
import model.Verkeerstoren;
import utilities.states.Status;

import java.util.List;

public class HulpdienstFactory {
    public static Hulpdienst createHulpdienst(Coördinaten locatie, List<Verkeerstoren> verkeerstorens, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status)
    {
        return new Hulpdienst(locatie, verkeerstorens, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status);
    }
}
