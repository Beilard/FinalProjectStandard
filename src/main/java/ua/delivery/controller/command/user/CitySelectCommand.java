package ua.delivery.controller.command.user;

import ua.delivery.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class CitySelectCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "order-service";
    }
}
