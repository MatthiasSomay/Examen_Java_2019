/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 26/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Verkeerstoren testklasse
 */

package test;

import model.Coördinaten;
import model.Verkeerstoren;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VerkeerstorenTest {

    private Coördinaten coordinaat = new Coördinaten(10,20);
    private Verkeerstoren verkeerstoren = new Verkeerstoren(coordinaat, "Zeehaven");


    @Test
    public void test_Constructor_Object_Wordt_Aangemaakt() {
        Verkeerstoren v = new Verkeerstoren(coordinaat, "Vuurtoren");

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
    public void berekenAfstand() {
    }

    @Test
    public void verleenHulp() {
    }

    @Test
    public void setHulpdiensten() {
    }

    @Test
    public void setSchepen() {
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