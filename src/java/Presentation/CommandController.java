/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Martin Brandstrup
 */
public class CommandController
{

    private static CommandController instance = null;
    private final Map<String, Command> commands = new HashMap();

    private CommandController()
    {
        Command backToMain = new TargetCommand("main.jsp"); //frontpage
        commands.put("employee", new EmployeeCommand("employee.jsp"));
        commands.put("customer", new CustomerCommand("customer.jsp"));
        commands.put("orderdetails", new OrderDetailsCommand("orderDetails.jsp"));
        commands.put("neworder", new NewOrderCommand("newOrder.jsp"));
        commands.put("cancel", backToMain);
        commands.put("null", new TargetCommand("error.jsp"));
    }

    public static synchronized Command commandFrom(String key)
    {
        if (key == null)
        {
            key = "return";
        }
        if (instance == null)
        {
            instance = new CommandController();
        }
        return instance.commands.get(key);
    }

}
