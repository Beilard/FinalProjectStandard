package ua.delivery.controller;

import ua.delivery.model.context.ContextHandler;
import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.domain.User;
import ua.delivery.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TableController extends HttpServlet {
    private ContextHandler contextHandler = ContextHandler.getInstance();
    private DBConnector dbConnector = contextHandler.getDbConnector();
    private UserService userService = contextHandler.getUserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = userService.findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
