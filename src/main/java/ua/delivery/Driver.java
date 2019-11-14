package ua.delivery;

import org.apache.log4j.Logger;
import ua.delivery.model.context.ContextHandler;
import ua.delivery.model.domain.Role;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws SQLException {
        Logger logger = Logger.getLogger(Driver.class);
        ContextHandler contextHandler = ContextHandler.getInstance();
        UserService userService = contextHandler.getUserService();
//        User user = User.builder()
//                .withRole(Role.USER)
//                .withUserCredentials(new UserCredentials("mathew@mail.com", "Qwerty123456#"))
//                .withName("Mathew")
//                .withSurname("Perry")
//                .build();
//        userService.register(user);
        System.out.println("success!");
        logger.info("test");
        logger.debug("another test");
        User loginUser = userService.login("gildan@ukr.net", "Qwerty123#");
        System.out.println(loginUser.getName());
        System.out.println("login success");
        List<User> users = userService.findAll();
        users.forEach(System.out::println);
    }
}
