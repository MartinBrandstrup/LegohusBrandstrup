/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Presentation.commands.TargetCommand;
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
        Command backToMain = new TargetCommand("main.jsp");
        commands.put("list", new ListCommand("list.jsp"));
        commands.put("return", backToMain);
        commands.put("cancel", backToMain);
        commands.put("create", new CreateCommand("edit.jsp"));
        commands.put("edit", new EditCommand("edit.jsp"));
        commands.put("save", new SaveCommand("main.jsp", "edit.jsp"));
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
