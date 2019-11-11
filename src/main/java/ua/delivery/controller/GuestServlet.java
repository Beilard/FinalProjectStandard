package ua.delivery.controller;

import ua.delivery.controller.command.Command;
import ua.delivery.model.context.ContextHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class GuestServlet extends HttpServlet {
    private final Map<String, Command> nameToCommand;
    private final Command defaultCommand;

    public GuestServlet() {
        ContextHandler contextHandler = ContextHandler.getInstance();
        this.nameToCommand = contextHandler.getUserCommandsMap();
        this.defaultCommand = contextHandler.getDefaultCommand();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("command");
        Command command = this.nameToCommand.getOrDefault(action, this.defaultCommand);

        String page = command.execute(req);
        req.getRequestDispatcher(page).forward(req, resp);
    }

}

