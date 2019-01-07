/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 05/01/2019
 * @Project: Examen_Java_2019
 * @Purpose: Hulpdienst testklasse
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

import static org.junit.Assert.assertEquals;

public class HulpdienstTest {

    private Coördinaten coordinaat = new Coördinaten(10,20);
    private Beschikbaar beschikbaar = new Beschikbaar();

    private DatabaseQueries db = new DatabaseQueries();
    private Generator generator = new Generator();

    private Hulpdienst hulpdienst = new Hulpdienst(coordinaat, 19, 7, 17, 4, 40, "Seaking",beschikbaar, new ArrayList<Verkeerstoren>());
    private Schip schip = new Schip(coordinaat, 89, 17, 9, 2, 80, "Zeilboot", beschikbaar,  new ArrayList<Verkeerstoren>());



    @Test
    public void test_berekenReactietijd_Geeft_Correct_Resultaat() {

        assertEquals(25.5,(hulpdienst.berekenReactietijd(schip, 90)), 0);

    }

    @Test
    public void test_berekenWendbaarheidstijd_Geeft_Correct_Resultaat() {
        double draaicirkel = 20;

        assertEquals(5.666666666666667, hulpdienst.berekenWendbaarheidstijd(draaicirkel), 0);
    }

    @Test
    public void test_berekenCapaciteit_Geeft_Correct_Resultaat() {
        int capaciteit = hulpdienst.berekenCapaciteit();

        assertEquals(3, capaciteit);
    }

    @Test
    public void test_setSnelheid_Geldige_Waarde_Wordt_Aanvaard() {
        hulpdienst.setSnelheid(30);

        assertEquals(30, hulpdienst.getSnelheid(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setSnelheid_Exception_Ongeldige_Waarde() {
        hulpdienst.setSnelheid(-30);
    }

    @Test
    public void test_setGrootte_Geldige_Waarde_Wordt_Aanvaard() {
        hulpdienst.setGrootte(30);

        assertEquals(30, hulpdienst.getGrootte(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setGrootte_Exception_Ongeldige_Waarde() {
        hulpdienst.setGrootte(-30);
    }

    @Test
    public void test_setWendbaarheid_Geldige_Waarde_Wordt_Aanvaard() {
        hulpdienst.setWendbaarheid(30);

        assertEquals(30, hulpdienst.getWendbaarheid(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setWendbaarheid_Exception_Ongeldige_Waarde() {
        hulpdienst.setGrootte(-30);
    }


    @Test
    public void test_setPersonenAanBoord_Geldige_Waarde_Wordt_Aanvaard() {
        hulpdienst.setPersonenAanBoord(30);

        assertEquals(30, hulpdienst.getPersonenAanBoord(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setPersonenAanBoord_Exception_Ongeldige_Waarde() {
        hulpdienst.setPersonenAanBoord(-30);
    }

    @Test
    public void test_setKoers_Geldige_Waarde_Wordt_Aanvaard() {
        hulpdienst.setKoers(76);

        assertEquals(76, hulpdienst.getKoers(), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setKoers_Exception_Ongeldige_Waarde() {
        hulpdienst.setKoers(-76);
    }


    @Test
    public void test_setType_Geldige_Waarde_Wordt_Aanvaard() {
        hulpdienst.setType("Marine");

        assertEquals("Marine", hulpdienst.getType());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setType_Exception_Ongeldige_Waarde() {
        hulpdienst.setType("Kajak");
    }

    @Test
    public void test_setStatus_Geldige_Waarde_Wordt_Aanvaard() {
        Beschikbaar beschikbaar = new Beschikbaar();

        hulpdienst.setStatus(beschikbaar);

        assertEquals(beschikbaar, hulpdienst.getStatus());
    }

    @Test
    public void test_setLaatsteReactieTijd_Geldige_Waarde_Wordt_Aanvaard() {
        hulpdienst.setLaatsteReactieTijd(10);

        assertEquals(10, hulpdienst.getLaatsteReactieTijd());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setLaatsteReactieTijd_Exception_Ongeldige_Waarde() {
        hulpdienst.setLaatsteReactieTijd(-6);
    }

    @Test
    public void stest_setDichtstbijzijndeVerkeerstoren_Geldige_Waarde_Wordt_Aanvaard() {
        Verkeerstoren verkeerstoren = new Verkeerstoren(coordinaat, "Zeehaven", new ArrayList<>());
        hulpdienst.setDichtstbijzijndeVerkeerstoren(verkeerstoren);

        assertEquals(verkeerstoren, hulpdienst.getDichtstbijzijndeVerkeerstoren());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_setDichtstbijzijndeVerkeerstoren_Exception_Ongeldige_Waarde() {
        Verkeerstoren verkeerstoren = null;
        hulpdienst.setDichtstbijzijndeVerkeerstoren(verkeerstoren);
    }

    @Test
    public void test_setLocatie_Geldige_Waarde_Wordt_Aanvaard() {

        hulpdienst.setLocatie(coordinaat);

        assertEquals(coordinaat, hulpdienst.getLocatie());
    }

    @Test
    public void test_setVerkeerstorens_Geldige_Waarde_Wordt_Aanvaard() {
        generator.setUpRandomData(db);
        hulpdienst.setVerkeerstorens(db.getVerkeerstorens());
        schip.setVerkeerstorens(db.getVerkeerstorens());

        assertEquals(db.getVerkeerstorens(), hulpdienst.getVerkeerstorens());


    }
}