package ua.delivery.model.command.user;

import ua.delivery.model.command.Command;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.service.UserService;
import ua.delivery.model.domain.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class RegisterCommand implements Command {
    private final UserService userService;

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        final String name = request.getParameter("name");
        final String surname = request.getParameter("surname");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String confirmPassword = request.getParameter("confirmPassword");

        //date to implement;

        if (!(Objects.equals(password, confirmPassword))) {
            return "view/register.jsp";
        }

        final User user = User.builder()
                .withUserCredentials(new UserCredentials(email, password))
                .withName(name)
                .withSurname(surname)
                .withRole(Role.USER)
                .build();

        return "view/login.jsp";
    }
}
