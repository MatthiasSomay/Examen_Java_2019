package factory;

import model.Coördinaten;
import model.Hulpdienst;
import utilities.states.Status;

public class HulpdienstFactory {
    public static Hulpdienst createHulpdienst(Coördinaten locatie, double snelheid, double grootte, double wendbaarheid, int personenAanBoord, double koers, String type, Status status)
    {
        return new Hulpdienst(locatie, snelheid, grootte, wendbaarheid, personenAanBoord, koers, type, status);
    }
}
