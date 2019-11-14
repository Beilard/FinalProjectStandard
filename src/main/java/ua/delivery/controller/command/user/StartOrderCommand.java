package ua.delivery.controller.command.user;

import ua.delivery.controller.command.Command;
import ua.delivery.model.service.OrderService;

import javax.servlet.http.HttpServletRequest;

public class StartOrderCommand implements Command {
    private final OrderService orderService;

    public StartOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        return null;
    }
}
