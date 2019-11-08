package ua.delivery.controller;

import ua.delivery.model.context.ContextHandler;
import ua.delivery.model.domain.User;
import ua.delivery.model.service.UserService;
import ua.delivery.model.domain.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserController extends HttpServlet {

    private final UserService userService;

    public UserController() {
        ContextHandler contextHandler = ContextHandler.getInstance();
        this.userService = contextHandler.getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final User user = (User) req.getSession().getAttribute("user");
        final Role role = user.getRole();

        //filter

//        final List<User> users = userService.findAll();
//        req.setAttribute("users", users);
//
//        req.getRequestDispatcher("view/table.jsp").forward(req, resp);
    }
}
