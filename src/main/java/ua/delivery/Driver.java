package ua.delivery;

import ua.delivery.model.context.ContextHandler;
import ua.delivery.model.domain.Role;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.service.UserService;

import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) throws SQLException {
        ContextHandler contextHandler = ContextHandler.getInstance();
        UserService userService = contextHandler.getUserService();
        User user = User.builder()
                .withRole(Role.USER)
                .withUserCredentials(new UserCredentials("gildan@ukr.net", "Qwerty123#"))
                .withName("Test")
                .withSurname("Testovich")
                .build();
//        userService.register(user);
        System.out.println("success!");
        User loginUser = userService.login("gildan@ukr.net", "Qwerty123#");
        System.out.println(loginUser.getName());
        System.out.println("login success");
//        List<User> users = userService.findAll();
//        users.forEach(System.out::println);
    }
}
