package ua.delivery;

import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.dao.implementation.UserDaoImpl;
import ua.delivery.model.domain.Role;

public class Driver {
    public static void main(String[] args) {
        DBConnector connector = new DBConnector("database");
        UserDao userDao = new UserDaoImpl(connector);
        Role role = Role.ADMIN;
    }
}
