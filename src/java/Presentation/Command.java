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
public interface Command
{

    String execute(
            HttpServletRequest request,
            LogicController ctrl
    ) throws CommandException;
}
