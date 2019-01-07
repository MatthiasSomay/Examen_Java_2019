/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 22/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Factory klasse
 */

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
