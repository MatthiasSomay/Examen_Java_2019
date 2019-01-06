package test;

import db.DatabaseQueries;
import factory.VerkeerstorenFactory;
import model.Coördinaten;
import model.Schip;
import model.Verkeerstoren;
import org.junit.Test;
import utilities.generator.Generator;
import utilities.states.Beschikbaar;
import utilities.states.Status;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class DatabaseQueriesTest {

    DatabaseQueries db = new DatabaseQueries();

    @Test
    public void test_calculateState_Creert_Correcte_Status() {
        String s = "Beschikbaar";
        Status status = db.CalculateState(s);

        assertThat(status, instanceOf(Beschikbaar.class));



    }

    @Test
    public void getAllSchip() {
    }

    @Test
    public void getAllHulpdienst() {
    }

    @Test
    public void getAllVerkeerstoren() {
    }

    @Test
    public void test_addVervoermiddel() {
        try {
           db.connection = DriverManager.getConnection(db.URL, db.USERNAME, db.PASSWORD);


           try (Statement statement = db.connection.createStatement()) {
               db.connection.setAutoCommit(false);

               statement.executeUpdate("DELETE FROM vervoermiddel");

               double lengteLocatie = 29;
               double breedteLocatie = 30;
               String type = "Schip";
               String detailType = "Zeilboot";
               double snelheid = 4;
               double wendbaarheid = 16;
               double grootte = 5;
               int personenAanBoord = 3;
               double koers = 24;
               Status status = new Beschikbaar();
               List<Verkeerstoren> verkeerstorens = null;

               Generator generator = new Generator();

               for(int i=0; i<10; i++) {
                   Verkeerstoren verkeerstorenTemp = VerkeerstorenFactory.createVerkeerstoren(
                           generator.generateLocatie(),
                           generator.generateTypeVerkeerstoren(),
                           verkeerstorens
                   );
                   verkeerstorens.add(verkeerstorenTemp);
                   verkeerstorenTemp.setId(i+1);
               }

               Schip schip = new Schip(new Coördinaten(lengteLocatie, breedteLocatie), snelheid, grootte, wendbaarheid, personenAanBoord, koers, detailType, status, verkeerstorens);
               schip.berekenDichtstbijzijndeVerkeerstoren();

               assertEquals(lengteLocatie, schip.getLocatie().getLengte(), 0);
               assertEquals(breedteLocatie, schip.getLocatie().getBreedte(), 0);
               assertEquals(snelheid, schip.getSnelheid(), 0);
               assertEquals(grootte, schip.getGrootte(), 0);
               assertEquals(wendbaarheid, schip.getWendbaarheid(), 0);
               assertEquals(personenAanBoord, schip.getPersonenAanBoord());
               assertEquals(koers, schip.getKoers(), 0);
               assertEquals(detailType, schip.getType());
               assertEquals(status, schip.getStatus());
               assertEquals(verkeerstorens, schip.getVerkeerstorens());

               int schipID;
               try (ResultSet rs = statement.executeQuery("SELECT * FROM vervoermiddel WHERE type == 'Schip'")) {

                   assertTrue(rs.next());
                   schipID = rs.getInt("ID");
                   assertEquals(lengteLocatie, rs.getString("lengteLocatie"));
                   assertEquals(breedteLocatie, rs.getString("breedteLocatie"));
                   assertEquals(snelheid, rs.getDouble("snelheid"), 0);
                   assertEquals(grootte, rs.getDouble("grootte"), 0);
                   assertEquals(wendbaarheid, rs.getDouble("wendbaarheid"), 0);
                   assertEquals(personenAanBoord, rs.getInt("personenAanBoord"));
                   assertEquals(koers, rs.getDouble("koers"), 0);
                   assertEquals(detailType, rs.getString("detailType"));
                   assertEquals(status.toString(), rs.getString("status"));
                   assertEquals(schip.getDichtstbijzijndeVerkeerstoren().getId(), rs.getInt("verkeerstoren"));
                   assertFalse(rs.next());

               }
               try (ResultSet rs = statement.executeQuery("SELECT * FROM vervoermiddel WHERE ID =" + schipID)){

                   assertTrue(rs.next());
                   assertEquals(schipID, rs.getInt("ID"));
                   assertFalse(rs.next());


               }
               finally {
                   db.connection.rollback();
               }




           }

        }

        catch (SQLException s) {
            s.printStackTrace();
        }

    }

    @Test
    public void addVerkeerstoren() {
    }

    @Test
    public void addVerkeerstoren1() {
    }

    @Test
    public void deleteVervoermiddel() {
    }

    @Test
    public void deleteVerkeerstoren() {
    }
}