package test;

import model.Coördinaten;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.*;

public class CoördinatenTest {

    private Coördinaten coordinaat = new Coördinaten(10,20);
    private Coördinaten zelfdeCoordinaat = new Coördinaten(10,20);
    private Coördinaten andereCoordinaat = new Coördinaten(30, 40);

    @Test
    public void test_Constructor_Object_Wordt_Aangemaakt() {
        Coördinaten c = new Coördinaten(30, 40);

        assertEquals(30, c.getLengte(), 0);
        assertEquals(40, c.getBreedte(), 0);
    }

    @Test
    public void test_toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String expected = "Coördinaten(" + "Lengte: " + df.format(coordinaat.getLengte()) + "; " + "Breedte: " + df.format(coordinaat.getBreedte()) + ")";
        assertEquals(expected, coordinaat.toString());
    }

    @Test
    public void test_Equals_True_Als_Coördinaten_Gelijk() {
        assertTrue(zelfdeCoordinaat.equals(coordinaat));
        assertTrue(coordinaat.equals(zelfdeCoordinaat));
    }

    @Test
    public void test_Equals_False_Als_Coördinaten_Ongelijk() {
        assertFalse(andereCoordinaat.equals(coordinaat));
        assertFalse(coordinaat.equals(andereCoordinaat));
    }

    @Test
    public void test_setLengte_Geldige_Waarde_Wordt_Aanvaard() {
        coordinaat.setLengte(80);

        assertEquals(80, coordinaat.getLengte(), 0 );
    }

    @Test
    public void test_setBreedte_Geldige_Waarde_Wordt_Aanvaard() {
        coordinaat.setBreedte(70);

        assertEquals(70, coordinaat.getBreedte(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setLengte_Exception_Ongeldige_Waarde() {
        coordinaat.setLengte(-20);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setBreedte_Exception_Ongeldige_Waarde() {
        coordinaat.setBreedte(-20);
    }
}