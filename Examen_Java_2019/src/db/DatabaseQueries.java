/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 21/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: MySQL Database access klasse
 */

package db;

import model.*;
import utilities.states.Beschikbaar;
import utilities.states.InNood;
import utilities.states.NietBeschikbaar;
import utilities.states.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueries {

    /*
    private static final String URL = "jdbc:mysql://localhost:3306/Examen_Java";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Elpsycongroo";
    */

    private static final String URL = "jdbc:mysql://localhost:3306/radardb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "kenneth0112*";

    private Connection connection;
    private PreparedStatement selectAllSchip;
    private PreparedStatement selectAllVerkeerstoren;
    private PreparedStatement selectAllHulpdienst;
    private PreparedStatement insertNewVervoermiddel;
    private PreparedStatement insertNewVerkeerstoren;
    private PreparedStatement deleteVervoermiddel;
    private PreparedStatement deleteVerkeerstoren;
    private PreparedStatement updateVervoermiddel;
    private PreparedStatement updateVerkeerstoren;

    public DatabaseQueries() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            selectAllSchip = connection.prepareStatement(
                    "SELECT * FROM vervoermiddel WHERE type = 'Schip'");

            selectAllHulpdienst = connection.prepareStatement(
                    "SELECT * FROM vervoermiddel WHERE type = 'Hulpdienst'");

            selectAllVerkeerstoren = connection.prepareStatement(
                    "SELECT * FROM verkeerstoren");

            insertNewVervoermiddel = connection.prepareStatement(
                    "INSERT INTO vervoermiddel " +
                            "(lengteLocatie, breedteLocatie, type, detailType, snelheid, wendbaarheid, grootte, personenAanBoord, koers, status, verkeerstoren)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            insertNewVerkeerstoren = connection.prepareStatement(
                    "INSERT INTO verkeerstoren " +
                            "(lengteLocatie, breedteLocatie, detailType)" +
                            "VALUES (?, ?, ?)");

            deleteVervoermiddel = connection.prepareStatement(
                    "DELETE FROM vervoermiddel WHERE ID = ?");


            deleteVerkeerstoren = connection.prepareStatement(
                    "DELETE FROM verkeerstoren WHERE ID = ?");

            updateVervoermiddel = connection.prepareStatement(
                    "UPDATE vervoermiddel SET WHERE ID = ?");

            updateVerkeerstoren = connection.prepareStatement(
                    "UPDATE verkeerstoren WHERE ID = ?");


        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public Status CalculateState(String statusString) {
        switch (statusString) {
            case "Beschikbaar":
                return new Beschikbaar();
            case "Niet beschikbaar":
                return new NietBeschikbaar();
            case "In nood":
                return new InNood();
            default:
                return new Beschikbaar();
        }
    }

        public List<Schip> getAllSchip() {
            try (ResultSet resultSet = selectAllSchip.executeQuery()) {
                List<Schip> results = new ArrayList<Schip>();

                while (resultSet.next()) {
                    results.add(new Schip(
                            new Coördinaten(
                                    resultSet.getDouble("lengteLocatie"),
                                    resultSet.getDouble("breedteLocatie")
                            ),
                            resultSet.getInt("ID"),
                            resultSet.getDouble("snelheid"),
                            resultSet.getDouble("grootte"),
                            resultSet.getDouble("wendbaarheid"),
                            resultSet.getInt("personenAanBoord"),
                            resultSet.getDouble("koers"),
                            resultSet.getString("detailType"),
                            CalculateState(resultSet.getString("status")),
                            getAllVerkeerstoren()
                    ));
                }
                return results;
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            return null;
        }

    public List<Hulpdienst> getAllHulpdienst() {
        try (ResultSet resultSet = selectAllHulpdienst.executeQuery()) {
            List<Hulpdienst> results = new ArrayList<Hulpdienst>();

            while (resultSet.next()) {
                results.add(new Hulpdienst(
                        new Coördinaten(
                                resultSet.getDouble("lengteLocatie"),
                                resultSet.getDouble("breedteLocatie")
                        ),
                        resultSet.getInt("ID"),
                        resultSet.getDouble("snelheid"),
                        resultSet.getDouble("grootte"),
                        resultSet.getDouble("wendbaarheid"),
                        resultSet.getInt("personenAanBoord"),
                        resultSet.getDouble("koers"),
                        resultSet.getString("detailType"),
                        CalculateState(resultSet.getString("status")),
                        getAllVerkeerstoren()
                ));
            }
            return results;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public List<Verkeerstoren> getAllVerkeerstoren() {
        try (ResultSet resultSet = selectAllVerkeerstoren.executeQuery()) {
            List<Verkeerstoren> results = new ArrayList<Verkeerstoren>();

            while (resultSet.next()) {
                results.add(new Verkeerstoren(
                        new Coördinaten(
                                resultSet.getDouble("lengteLocatie"),
                                resultSet.getDouble("breedteLocatie")
                        ),
                        resultSet.getInt("ID"),
                        resultSet.getString("detailType"),
                        results
                ));
            }
            return results;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }


        public int addVervoermiddel(Vervoermiddel vervoermiddel, String hoofdType) {
            try {
                insertNewVervoermiddel.setDouble(1, vervoermiddel.getLocatie().getLengte());
                insertNewVervoermiddel.setDouble(2, vervoermiddel.getLocatie().getBreedte());
                insertNewVervoermiddel.setString(3, hoofdType);
                insertNewVervoermiddel.setString(4, vervoermiddel.getType());
                insertNewVervoermiddel.setDouble(5, vervoermiddel.getSnelheid());
                insertNewVervoermiddel.setDouble(6, vervoermiddel.getWendbaarheid());
                insertNewVervoermiddel.setDouble(7, vervoermiddel.getGrootte());
                insertNewVervoermiddel.setInt(8, vervoermiddel.getPersonenAanBoord());
                insertNewVervoermiddel.setDouble(9, vervoermiddel.getKoers());
                insertNewVervoermiddel.setString(10, vervoermiddel.getStatus().toString());
                insertNewVervoermiddel.setInt(11, vervoermiddel.getDichtstbijzijndeVerkeerstoren().getId());

                return insertNewVervoermiddel.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                return 0;
            }
        }

        public int addVerkeerstoren(double lengteLocatie, double breedtelocatie, String detailType) {
            try {
                insertNewVerkeerstoren.setDouble(1, lengteLocatie);
                insertNewVerkeerstoren.setDouble(2, breedtelocatie);
                insertNewVerkeerstoren.setString(3, detailType);

                return insertNewVerkeerstoren.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                return 0;
            }
        }

    public int addVerkeerstoren(Verkeerstoren verkeerstoren) {
        try {
            insertNewVerkeerstoren.setDouble(1, verkeerstoren.getLocatie().getLengte());
            insertNewVerkeerstoren.setDouble(2, verkeerstoren.getLocatie().getBreedte());
            insertNewVerkeerstoren.setString(3, verkeerstoren.getType());

            return insertNewVerkeerstoren.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return 0;
        }
    }


        public int deleteVervoermiddel(int ID) {
            try {
                deleteVervoermiddel.setInt(1, ID);

                return deleteVervoermiddel.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                return 0;
            }
        }

        public int deleteVerkeerstoren(int ID) {
            try {
                deleteVerkeerstoren.setInt(1, ID);

                return deleteVerkeerstoren.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                return 0;
            }
        }


    }