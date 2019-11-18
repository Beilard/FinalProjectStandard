package ua.delivery.controller.command.user;

import ua.delivery.controller.command.Command;
import ua.delivery.model.service.AddressService;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

public class StartOrderCommand implements Command {
    private final AddressService addressService;

    public StartOrderCommand(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<String> citiesList = new LinkedList<>(addressService.findAllCities());
        request.getSession().setAttribute("citiesList", citiesList);
        return "order-service.jsp";
    }
}
