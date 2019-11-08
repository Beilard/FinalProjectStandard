package ua.delivery.model.command.user;

import ua.delivery.model.command.Command;
import ua.delivery.model.domain.User;
import ua.delivery.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final User user = userService.login(email, password);
        final HttpSession session = request.getSession();
        session.setAttribute("sessionUser", user);
        return "forward:/WEB-INF/user/index.jsp";
    }
}
