/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton used in DAO classes
 * @author Martin Brandstrup
 */
public class DBConnector
{

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://188.166.82.245:3306/legohus";
    private static final String USERNAME = "brandstrup";
    private static final String PASSWORD = "???";
    private static Connection connection = null;

    public synchronized static Connection getConnection()
    {
        if (connection == null)
        {
            try
            {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException ex)
            {
                ex.printStackTrace();
            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        return connection;
    }
}
