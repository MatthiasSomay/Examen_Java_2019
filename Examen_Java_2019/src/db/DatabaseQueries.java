/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 21/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: MySQL Database access klasse
 */

package db;

import model.Schip;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/Examen_Java";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Elpsycongroo";

    private Connection connection;
    private PreparedStatement selectAllShips;
    private PreparedStatement insertNewVervoermiddel;
    private PreparedStatement insertNewActor;
    private PreparedStatement insertNewShip;
    private PreparedStatement insertNewLocation;

    // TODO: 2018-12-21  
    public DatabaseQueries() {

        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            selectAllShips = connection.prepareStatement(
                    "SELECT * FROM Vervoermiddel v, Schip s " +
                            "WHERE s.vervoermiddelID = v.vervoermiddelID" +
                            "ORDER BY s.schipID "
            );

            insertNewLocation = connection.prepareStatement(
                    "INSERT INTO Locatie" + "(lengte, breedte)" + "VALUES (?, ?)"
            );

            insertNewActor = connection.prepareStatement(
                    "INSERT INTO Actor" +
                            "(locatieID)" + "VALUES (?)"
            );

            insertNewVervoermiddel = connection.prepareStatement(
                    "INSERT INTO Vervoermiddel " +
                            "(actorID, snelheid, grootte, wendbaarheid, capaciteit, personenAanBoord, koers) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?) "

            );

            insertNewShip = connection.prepareStatement(
                    "INSERT INTO Schip" +
                            "(vervoermiddelID, status) " + "VALUES (?,?)"
            );

        }

        catch (SQLException e) {
            e.printStackTrace();

        }

        public List<Schip> getAllShips() {
            try (ResultSet resultSet = selectAllShips.executeQuery()) {
                List<Schip> schips = new ArrayList<Schip>();

                while(resultSet.next()) {
                    schips.add(new Schip(
                            resultSet.getInt("locatie"),
                            resultSet.getInt("schipID"),
                            resultSet.getInt("vervoermiddelID"),
                            resultSet.getString("status")
                    ));
                }

            }

            catch (SQLException e){
                e.printStackTrace();

            }
        }




    }
}