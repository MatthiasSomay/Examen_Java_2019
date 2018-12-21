/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 21/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: MySQL Database access klasse
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DatabaseQueries {
    private static final String URL = "jdbc:mysql://localhost:3306/Examen_Java";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Elpsycongroo";

    private Connection connection;
    private PreparedStatement selectAllShips;
    private PreparedStatement insertNewShip;

    // TODO: 2018-12-21  
    public DatabaseQueries() {

        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            selectAllShips = connection.prepareStatement(
                    "SELECT * FROM Schip s " +
                            "ORDER BY s.schipID "
            );

            insertNewShip = connection.prepareStatement(
                    "INSERT INTO Schip " +
                            ""
            );

        }

        catch (SQLException e) {
            e.printStackTrace();

        }




    }
}