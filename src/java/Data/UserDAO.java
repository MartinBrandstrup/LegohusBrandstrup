/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Data.DTO.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Singleton used in LogicController
 *
 * @author Martin Brandstrup
 */
public class UserDAO
{

    private static UserDAO instance = null;

    private UserDAO()
    {
    }

    public synchronized static UserDAO getInstance()
    {
        if (instance == null)
        {
            instance = new UserDAO();
        }
        return instance;
    }

    public void createUser(UserDTO user) throws LoginException
    {
        try
        {
            Connection con = DBConnector.getConnection();

            String query
                    = "INSERT INTO `User` (password, email, role) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getRole());
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException ex)
        {
            throw new LoginException(ex.getMessage());
        }
    }

    public UserDTO login(String password, String email) throws LoginException
    {
        try
        {
            Connection con = DBConnector.getConnection();

            String query
                    = "SELECT user_id, role FROM `User` "
                    + "WHERE password=? AND email=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, password);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                UserDTO user = new UserDTO(email, password, role);
                user.setId(id);
                return user;
            } else
            {
                throw new LoginException("Could not validate user");
            }
        } catch (SQLException ex)
        {
            throw new LoginException(ex.getMessage());
        }
    }
}
