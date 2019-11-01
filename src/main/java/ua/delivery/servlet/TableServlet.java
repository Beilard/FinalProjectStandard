package ua.delivery.servlet;

import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.dao.implementation.UserDaoImpl;
import ua.delivery.model.entity.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TableServlet extends HttpServlet {
    UserDao userDao = new UserDaoImpl(new DBConnector("database"));
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserEntity> list = userDao.findAll();
        req.setAttribute("list", list);
        getServletContext().getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
