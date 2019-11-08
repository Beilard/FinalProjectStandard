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
    private UserService userService = contextHandler.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int rowsPerPage = 5;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }

        List<User> list = userService.findAll((page - 1) * rowsPerPage, rowsPerPage);
        int numOfRows = list.size();
        int numOfPages = numOfRows / rowsPerPage;
        req.setAttribute("userList", list);
        req.setAttribute("numOfPages", numOfPages);
        req.setAttribute("currentPage", page);
        req.getRequestDispatcher("view/table.jsp").forward(req, resp);
    }
}
