package ua.delivery.model.context;

import ua.delivery.controller.command.Command;
import ua.delivery.controller.command.DefaultCommand;
import ua.delivery.controller.command.guest.LoginCommand;
import ua.delivery.controller.command.guest.LogoutCommand;
import ua.delivery.controller.command.guest.RegisterCommand;
import ua.delivery.controller.command.user.StartOrderCommand;
import ua.delivery.model.dao.AddressDao;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.dao.implementation.AddressDaoImpl;
import ua.delivery.model.dao.implementation.UserDaoImpl;
import ua.delivery.model.service.AddressService;
import ua.delivery.model.service.UserService;
import ua.delivery.model.service.encoder.PasswordEncoder;
import ua.delivery.model.service.implementation.AddressServiceImpl;
import ua.delivery.model.service.implementation.UserServiceImpl;
import ua.delivery.model.service.mapper.AddressMapper;
import ua.delivery.model.service.mapper.UserMapper;
import ua.delivery.model.service.validator.LoginValidator;
import ua.delivery.model.service.validator.RegistrationValidator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ContextHandler {

    private static final UserDao USER_DAO = new UserDaoImpl();
    private static final AddressDao ADDRESS_DAO = new AddressDaoImpl();
    private static final RegistrationValidator REGISTRATION_VALIDATOR = new RegistrationValidator();
    private static final LoginValidator LOGIN_VALIDATOR = new LoginValidator();
    private static final UserMapper USER_MAPPER = new UserMapper();
    private static final AddressMapper ADDRESS_MAPPER = new AddressMapper();
    private static final PasswordEncoder PASSWORD_ENCODER = new PasswordEncoder();
    private static final UserService USER_SERVICE =
            new UserServiceImpl(REGISTRATION_VALIDATOR, LOGIN_VALIDATOR, USER_DAO, USER_MAPPER, PASSWORD_ENCODER);
    private static final AddressService ADDRESS_SERVICE = new AddressServiceImpl(ADDRESS_DAO, ADDRESS_MAPPER);
    private static final Command LOGIN_COMMAND = new LoginCommand(USER_SERVICE);
    private static final Command LOGOUT_COMMAND = new LogoutCommand();
    private static final Command REGISTER_COMMAND = new RegisterCommand(USER_SERVICE);
    private static final Command DEFAULT_COMMAND = new DefaultCommand();
    private static final Command START_ORDER_COMMAND = new StartOrderCommand(ADDRESS_SERVICE);

    private static final Map<String, Command> GUEST_COMMAND_NAME_TO_COMMAND = initGuestCommand();
    private static final Map<String, Command> USER_COMMAND_NAME_TO_COMMAND = initUserCommand();



    private static ContextHandler contextHandler;


    private ContextHandler() {
    }

    public static ContextHandler getInstance() {
        if (contextHandler == null) {
            synchronized (ContextHandler.class) {
                if (contextHandler == null) {
                    contextHandler = new ContextHandler();
                }
            }
        }
        return contextHandler;
    }

    private static Map<String, Command> initGuestCommand() {
        Map<String, Command> commandNameToCommand = new HashMap<>();
        commandNameToCommand.put("login", LOGIN_COMMAND);
        commandNameToCommand.put("logout", LOGOUT_COMMAND);
        commandNameToCommand.put("register", REGISTER_COMMAND);

        return Collections.unmodifiableMap(commandNameToCommand);

    }

    private static Map<String, Command> initUserCommand() {
        Map<String, Command> commandNameToCommand = new HashMap<>();
        commandNameToCommand.put("startOrder", START_ORDER_COMMAND);

        return Collections.unmodifiableMap(commandNameToCommand);
    }

    public UserService getUserService() {
        return USER_SERVICE;
    }

    public Map<String, Command> getGuestCommandsMap() {
        return GUEST_COMMAND_NAME_TO_COMMAND;
    }

    public Command getDefaultCommand() {
        return DEFAULT_COMMAND;
    }

    public Map<String, Command> getUserCommandsMap() {
        return USER_COMMAND_NAME_TO_COMMAND;
    }
}
