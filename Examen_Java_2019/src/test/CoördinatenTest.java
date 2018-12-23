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


    }

    @Test
    public void test_setBreedte_Geldige_Waarde_Wordt_Aanvaard() {
    }
}