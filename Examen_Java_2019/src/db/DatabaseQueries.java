/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 21/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: MySQL Database access klasse
 */

package db;

import model.Coördinaten;
import model.Hulpdienst;
import model.Schip;
import model.Verkeerstoren;
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
    private PreparedStatement insertNewSchip;
    private PreparedStatement insertNewVerkeerstoren;
    private PreparedStatement insertNewHulpdienst;
    private PreparedStatement deleteSchip;
    private PreparedStatement deleteVerkeerstoren;
    private PreparedStatement deleteHulpdienst;

    public DatabaseQueries() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            selectAllSchip = connection.prepareStatement(
                    "SELECT * FROM vervoermiddel WHERE type = schip");

            selectAllHulpdienst = connection.prepareStatement(
                    "SELECT * FROM vervoermiddel WHERE type = hulpdienst");

            selectAllVerkeerstoren = connection.prepareStatement(
                    "SELECT * FROM verkeerstoren");

            insertNewSchip = connection.prepareStatement(
                    "INSERT INTO vervoermiddel " +
                            "(lengteLocatie, breedteLocatie, type, detailType, snelheid, wendbaarheid, grootte, pesonenAanBoord, koers, status, verkeestoren)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            insertNewHulpdienst = connection.prepareStatement(
                    "INSERT INTO vervoermiddel " +
                            "(lengteLocatie, breedteLocatie, type, detailType, snelheid, wendbaarheid, grootte, pesonenAanBoord, koers, status, verkeestoren)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            insertNewVerkeerstoren = connection.prepareStatement(
                    "INSERT INTO verkeerstoren " +
                            "(lengteLocatie, breedteLocatie, detailType)" +
                            "VALUES (?, ?, ?)");

            deleteSchip = connection.prepareStatement(
                    "DELETE FROM vervoermiddel WHERE ID = ?");

            deleteHulpdienst = connection.prepareStatement(
                    "DELETE FROM vervoermiddel WHERE ID = ?");

            deleteVerkeerstoren = connection.prepareStatement(
                    "DELETE FROM verkeerstoren WHERE ID = ?");

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
                            resultSet.getDouble("snelheid"),
                            resultSet.getDouble("grootte"),
                            resultSet.getDouble("wendbaarheid"),
                            resultSet.getInt("pesonenAanBoord"),
                            resultSet.getDouble("koers"),
                            resultSet.getString("detailType"),
                            CalculateState(resultSet.getString("status"))
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
                        resultSet.getDouble("snelheid"),
                        resultSet.getDouble("grootte"),
                        resultSet.getDouble("wendbaarheid"),
                        resultSet.getInt("pesonenAanBoord"),
                        resultSet.getDouble("koers"),
                        resultSet.getString("detailType"),
                        CalculateState(resultSet.getString("status"))
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
                        resultSet.getString("detailType")
                ));
            }
            return results;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    /* TOT HIER BEZIG*/
        public int addSchip(double lengteLocatie, double breedteLocatie,String detailType, double snelheid, double wendbaarheid, double grootte, int pesonenAanBoord, double koers, String status, int verkeestorenID) {
            try {
                insertNewCar.setInt(1, memberNumber);
                insertNewCar.setString(2, constructor);
                insertNewCar.setString(3, model);
                insertNewCar.setInt(4, year);
                insertNewCar.setString(5, color);
                insertNewCar.setString(6, field);

                return insertNewCar.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                return 0;
            }
        }

        public int addMember(String name, String firstName, String street, String number, String zipCode, String city, String country, String phone, String mobile, String email) {
            try {
                insertNewMember.setString(1, name);
                insertNewMember.setString(2, firstName);
                insertNewMember.setString(3, street);
                insertNewMember.setString(4, number);
                insertNewMember.setString(5, zipCode);
                insertNewMember.setString(6, city);
                insertNewMember.setString(7, country);
                insertNewMember.setString(8, phone);
                insertNewMember.setString(9, mobile);
                insertNewMember.setString(10, email);

                return insertNewMember.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                return 0;
            }
        }

        public int deleteCar(int carID) {
            try {
                deleteCar.setInt(1, carID);

                return deleteCar.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                return 0;
            }
        }

        public int deleteMember(int memberNumber) {
            try {
                deleteMember.setInt(1, memberNumber);

                return deleteMember.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                return 0;
            }
        }

        public int checkSearchInput(String x) {
            try {
                Integer.parseInt(x);
                return 1;
            } catch (Exception e) {
                return 0;
            }
        }


    }
}