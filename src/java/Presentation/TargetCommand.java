package Presentation;

import Logic.LogicController;
import Presentation.Command;
import javax.servlet.http.HttpServletRequest;

class TargetCommand implements Command
{

    private final String target;

    TargetCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, LogicController ctrl)
    {
        return target;
    }

}
