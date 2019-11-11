package ua.delivery.controller.command.guest;

import ua.delivery.controller.command.Command;
import ua.delivery.model.domain.Role;
import ua.delivery.model.domain.User;
import ua.delivery.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final User user = userService.login(email, password);
        request.getSession().setAttribute("user", user);
        Role role = user.getRole();

        String nextPage;
        if (role == Role.ADMIN) {
            nextPage = "admin-home.jsp";
        } else if (role == Role.USER) {
            nextPage = "user-home.jsp";
        } else {
            nextPage = "index.jsp";
        }
        return nextPage;
    }
}
