package ua.delivery.model.command.user;

import ua.delivery.model.command.Command;
import ua.delivery.model.domain.Role;
import ua.delivery.model.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegForward implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Role role = ((User) request.getSession().getAttribute("sessionUser")).getRole();
        String roleValue = null;
        if (role == Role.USER) {
            roleValue = "user";
        } else if (role == Role.ADMIN) {
            roleValue = "admin";
        } else {
            roleValue = "guest";
        }
        return
                "forward:/WEB-INF/" + roleValue + "/registration.jsp";
    }
}
