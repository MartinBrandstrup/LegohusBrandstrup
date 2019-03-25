/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.LogicController;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Martin Brandstrup
 */
public class OrderDetailsCommand implements Command
{

    public OrderDetailsCommand(String orderDetailsjsp)
    {
    }

    @Override
    public String execute(HttpServletRequest request, LogicController ctrl) throws CommandException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
