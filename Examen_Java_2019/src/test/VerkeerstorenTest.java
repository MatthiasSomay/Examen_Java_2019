/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 26/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Verkeerstoren testklasse
 */

package test;

import db.DatabaseQueries;
import model.Coördinaten;
import model.Hulpdienst;
import model.Schip;
import model.Verkeerstoren;
import org.junit.Test;
import utilities.generator.Generator;
import utilities.states.Beschikbaar;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VerkeerstorenTest {

    private Coördinaten coordinaat = new Coördinaten(10,20);
    private Coördinaten coordinaat2 = new Coördinaten(40, 70);
    private Verkeerstoren verkeerstoren = new Verkeerstoren(coordinaat, "Zeehaven", new ArrayList<>());
    private Verkeerstoren verkeerstoren2 = new Verkeerstoren(coordinaat2, "Vuurtoren", new ArrayList<>());

    private DatabaseQueries db = new DatabaseQueries();
    private Generator generator = new Generator();

    private Beschikbaar beschikbaar = new Beschikbaar();
    private Schip schip = new Schip(coordinaat, 19, 7, 17, 4, 40, "Speedboot", beschikbaar, new ArrayList<>());




    @Test
    public void test_Constructor_Object_Wordt_Aangemaakt() {
        Verkeerstoren v = new Verkeerstoren(coordinaat, "Vuurtoren", new ArrayList<>());

        assertEquals(coordinaat, v.getLocatie());
        assertEquals("Vuurtoren", v.getType());
    }

    @Test
    public void test_addSchipObserver_Doet_Correcte_Bewerking() {
        verkeerstoren.addSchipObserver(schip);

        assertTrue(verkeerstoren.getSchepen().contains(schip));
    }

    @Test
    public void test_removeSchipObserver_Doet_Correcte_Bewerking() {
        verkeerstoren.addSchipObserver(schip);
        verkeerstoren.removeSchipObserver(schip);

        assertFalse(verkeerstoren.getSchepen().contains(schip));
    }

    @Test
    public void test_berekenAfstand_Geeft_Geldig_Resultaat() {
        double afstand = verkeerstoren.berekenAfstand(verkeerstoren2);

        assertEquals(58.309518948453004, afstand, 0);
    }

    @Test
    public void test_setHulpdiensten_Geldige_Waarde_Wordt_Aanvaard() {
        generator.setUpRandomData(db);
        verkeerstoren.setHulpdiensten(db.getHulpdiensten());

        assertEquals(db.getHulpdiensten(), verkeerstoren.getHulpdiensten());

    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setHulpdiensten_Exception_Bij_Lege_Lijst() {
        List<Hulpdienst> hulpdiensten = null;
        verkeerstoren.setHulpdiensten(hulpdiensten);

    }

    @Test
    public void test_setSchepen_Geldige_Waarde_Wordt_Aanvaard() {
        generator.setUpRandomData(db);
       verkeerstoren.setSchepen(db.getSchepen());

       assertEquals(db.getSchepen(), verkeerstoren.getSchepen());


    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setSchepen_Exception_Bij_Lege_Lijst() {
        List<Schip> schips = null;
        verkeerstoren.setSchepen(schips);

    }

    @Test
    public void test_setType_Geldige_Waarde_Wordt_Aanvaard() {
        verkeerstoren.setType("Vuurtoren");

        assertEquals("Vuurtoren", verkeerstoren.getType());

    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setType_Exception_Bij_Ongeldige_Waarde() {
        verkeerstoren.setType("Toren");


    }
}