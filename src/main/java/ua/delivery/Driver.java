package ua.delivery;

import ua.delivery.model.context.ContextHandler;
import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.dao.implementation.UserDaoImpl;
import ua.delivery.model.domain.Role;
import ua.delivery.model.domain.User;
import ua.delivery.model.entity.UserEntity;
import ua.delivery.model.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws SQLException {
        ContextHandler contextHandler = ContextHandler.getInstance();
        UserService userService = contextHandler.getUserService();
//        List<User> users = userService.findAll();
//        users.forEach(System.out::println);
    }
}
