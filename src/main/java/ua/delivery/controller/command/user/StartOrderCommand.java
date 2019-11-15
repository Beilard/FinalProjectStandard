package ua.delivery.controller.command.user;

import ua.delivery.controller.command.Command;
import ua.delivery.model.domain.Address;
import ua.delivery.model.service.AddressService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class StartOrderCommand implements Command {
    private final AddressService addressService;

    public StartOrderCommand(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Address> kyivList = addressService.findAllByCity("Kyiv");
        List<Address> odessaList = addressService.findAllByCity("Odessa");
        List<Address> lvivList = addressService.findAllByCity("Lviv");
        request.getSession().setAttribute("kyivList", kyivList);
        request.getSession().setAttribute("odessaList", odessaList);
        request.getSession().setAttribute("lvivList", lvivList);
        return "order-service.jsp";
    }
}
