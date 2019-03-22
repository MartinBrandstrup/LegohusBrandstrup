/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DTO.UserDTO;
import Data.LoginException;
import Data.OrderDAO;
import Data.UserDAO;

/**
 * Singleton used in FrontController
 * @author Martin Brandstrup
 */
public class LogicController
{
    
    private final OrderDAO orderMapper = OrderDAO.getInstance();
    private final UserDAO userMapper = UserDAO.getInstance();
    
    private static LogicController instance = null;

    private LogicController()
    {
    }

    public synchronized static LogicController getInstance()
    {
        if (instance == null) instance = new LogicController();
        return instance;
    }
    
    public UserDTO login(String password, String email) throws LoginException
    {
        return userMapper.login(password, email);
    }
            
}
