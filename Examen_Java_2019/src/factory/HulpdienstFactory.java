package factory;

import model.Coördinaten;
import model.Hulpdienst;
import model.Status;
import model.Verkeerstoren;

import java.util.List;

public class HulpdienstFactory {
    public static Hulpdienst createHulpdienst(Coördinaten locatie, List<Verkeerstoren> verkeerstorens, double snelheid, double grootte, double wendbaarheid, int capaciteit, int personenAanBoord, double koers, String type, Status status)
    {
        return new Hulpdienst(locatie, verkeerstorens, snelheid, grootte, wendbaarheid, capaciteit, personenAanBoord, koers, type, status);
    }
}
