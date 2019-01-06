/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 26/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Verkeerstoren testklasse
 */

package test;

import model.Coördinaten;
import model.Schip;
import model.Verkeerstoren;
import org.junit.Test;
import view.TestRadar;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VerkeerstorenTest {

    private Coördinaten coordinaat = new Coördinaten(10,20);
    private Coördinaten coordinaat2 = new Coördinaten(40, 70);
    private Verkeerstoren verkeerstoren = new Verkeerstoren(coordinaat, "Zeehaven", new ArrayList<>());
    private Verkeerstoren verkeerstoren2 = new Verkeerstoren(coordinaat2, "Vuurtoren", new ArrayList<>());
    private TestRadar testRadar = new TestRadar();



    @Test
    public void test_Constructor_Object_Wordt_Aangemaakt() {
        Verkeerstoren v = new Verkeerstoren(coordinaat, "Vuurtoren", new ArrayList<>());

        assertEquals(coordinaat, v.getLocatie());
        assertEquals("Vuurtoren", v.getType());
    }

    @Test
    public void addSchipObserver() {
    }

    @Test
    public void removeSchipObserver() {
    }

    @Test
    public void noodsituatieBroadcastBericht() {
    }

    @Test
    public void test_berekenAfstand_Geeft_Geldig_Resultaat() {
        double afstand = verkeerstoren.berekenAfstand(verkeerstoren2);

        assertEquals(58.309518948453004, afstand, 0);
    }

    @Test
    public void verleenHulp() {
    }

    @Test
    public void setHulpdiensten() {
        testRadar.setUp();
        verkeerstoren.setHulpdiensten(testRadar.hulpdiensten);

        assertEquals(testRadar.hulpdiensten, verkeerstoren.getHulpdiensten());

    }

    @Test
    public void test_setSchepen_Geldige_Waarde_Wordt_Aanvaard() {
        testRadar.setUp();
       verkeerstoren.setSchepen(testRadar.schepen);

       assertEquals(testRadar.schepen, verkeerstoren.getSchepen());


    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setSchepen_Exception_Bij_Ongeldige_Waarde() {
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