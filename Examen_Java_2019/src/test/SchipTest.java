/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 05/01/2019
 * @Project: Examen_Java_2019
 * @Purpose: Schip testklasse
 */

package test;

import db.DatabaseQueries;
import model.Coördinaten;
import model.Schip;
import model.Verkeerstoren;
import org.junit.Test;
import utilities.generator.Generator;
import utilities.states.Beschikbaar;
import utilities.states.NietBeschikbaar;
import view.TestRadar;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SchipTest {

    private Coördinaten coordinaat = new Coördinaten(10,20);
    private TestRadar testRadar = new TestRadar();
    private Beschikbaar beschikbaar = new Beschikbaar();

    private DatabaseQueries db = new DatabaseQueries();
    private Generator generator = new Generator();

    private Schip schip = new Schip(coordinaat, 19, 7, 17, 4, 40, "Speedboot", beschikbaar, new ArrayList<Verkeerstoren>());
    private Schip schip2 = new Schip(coordinaat, 89, 17, 9, 2, 80, "Zeilboot", beschikbaar, new ArrayList<Verkeerstoren>());


    @Test
    public void test_berekenReactietijd_Geeft_Correct_Resultaat() {
        assertEquals(25.5,(schip.berekenReactietijd(schip2, 90)), 0);

    }

    @Test
    public void test_berekenWendbaarheidstijd_Geeft_Correct_Resultaat() {
        double draaicirkel = 20;

        assertEquals(5.666666666666667, schip.berekenWendbaarheidstijd(draaicirkel), 0);
    }

    @Test
    public void test_berekenCapaciteit_Geeft_Correct_Resultaat() {
        int capaciteit = schip.berekenCapaciteit();

        assertEquals(3, capaciteit);
    }

    @Test
    public void test_setSnelheid_Geldige_Waarde_Wordt_Aanvaard() {
        schip.setSnelheid(30);

        assertEquals(30, schip.getSnelheid(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setSnelheid_Exception_Ongeldige_Waarde() {
        schip.setSnelheid(-30);
    }

    @Test
    public void test_setGrootte_Geldige_Waarde_Wordt_Aanvaard() {
        schip.setGrootte(30);

        assertEquals(30, schip.getGrootte(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setGrootte_Exception_Ongeldige_Waarde() {
        schip.setGrootte(-30);
    }

    @Test
    public void test_setWendbaarheid_Geldige_Waarde_Wordt_Aanvaard() {
        schip.setWendbaarheid(30);

        assertEquals(30, schip.getWendbaarheid(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setWendbaarheid_Exception_Ongeldige_Waarde() {
        schip.setGrootte(-30);
    }


    @Test
    public void test_setPersonenAanBoord_Geldige_Waarde_Wordt_Aanvaard() {
        schip.setPersonenAanBoord(30);

        assertEquals(30, schip.getPersonenAanBoord(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setPersonenAanBoord_Exception_Ongeldige_Waarde() {
        schip.setPersonenAanBoord(-30);
    }

    @Test
    public void test_setKoers_Geldige_Waarde_Wordt_Aanvaard() {
        schip.setKoers(76);

        assertEquals(76, schip.getKoers(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setKoers_Exception_Ongeldige_Waarde() {
        schip.setKoers(-76);
    }


    @Test
    public void test_setType_Geldige_Waarde_Wordt_Aanvaard() {
        schip.setType("Speedboot");

        assertEquals("Speedboot", schip.getType());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setType_Exception_Ongeldige_Waarde() {
        schip.setType("Kajak");
    }

    @Test
    public void test_setStatus_Geldige_Waarde_Wordt_Aanvaard() {
        NietBeschikbaar nietBeschikbaar = new NietBeschikbaar();

        schip.setStatus(nietBeschikbaar);

        assertEquals(nietBeschikbaar, schip.getStatus());
    }

    @Test
    public void test_setLaatsteReactieTijd_Geldige_Waarde_Wordt_Aanvaard() {
        schip.setLaatsteReactieTijd(10);

        assertEquals(10, schip.getLaatsteReactieTijd());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setLaatsteReactieTijd_Exception_Ongeldige_Waarde() {
        schip.setLaatsteReactieTijd(-6);
    }

    @Test
    public void stest_setDichtstbijzijndeVerkeerstoren_Geldige_Waarde_Wordt_Aanvaard() {
        Verkeerstoren verkeerstoren = new Verkeerstoren(coordinaat, "Zeehaven", new ArrayList<>());
        schip.setDichtstbijzijndeVerkeerstoren(verkeerstoren);

        assertEquals(verkeerstoren, schip.getDichtstbijzijndeVerkeerstoren());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setDichtstbijzijndeVerkeerstoren_Exception_Ongeldige_Waarde() {
        Verkeerstoren verkeerstoren = null;
        schip.setDichtstbijzijndeVerkeerstoren(verkeerstoren);
    }

    @Test
    public void test_setLocatie_Geldige_Waarde_Wordt_Aanvaard() {

        schip.setLocatie(coordinaat);

        assertEquals(coordinaat, schip.getLocatie());
    }

    @Test
    public void test_setVerkeerstorens_Geldige_Waarde_Wordt_Aanvaard() {
        generator.setUpRandomData(db);
        schip.setVerkeerstorens(db.getVerkeerstorens());

        assertEquals(db.getVerkeerstorens(), schip.getVerkeerstorens());


    }

}