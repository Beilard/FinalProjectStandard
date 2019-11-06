package ua.delivery.model.context;

import ua.delivery.model.command.Command;
import ua.delivery.model.command.user.LoginCommand;
import ua.delivery.model.command.user.LogoutCommand;
import ua.delivery.model.command.user.RegisterCommand;
import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.dao.implementation.UserDaoImpl;
import ua.delivery.model.service.UserService;
import ua.delivery.model.service.implementation.UserServiceImpl;
import ua.delivery.model.service.validator.RegistrationValidator;
import ua.delivery.model.service.validator.Validator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ContextHandler {
    private static final DBConnector DB_CONNECTOR = new DBConnector("database");
    private static final UserDao USER_DAO = new UserDaoImpl(DB_CONNECTOR);
    private static final Validator VALIDATOR = new RegistrationValidator(USER_DAO);
    private static final UserService USER_SERVICE = new UserServiceImpl(VALIDATOR, USER_DAO);
    private static final Command LOGIN_COMMAND = new LoginCommand(USER_SERVICE);
    private static final Command LOGOUT_COMMAND = new LogoutCommand();
    private static final Command REGISTER_COMMAND = new RegisterCommand(USER_SERVICE);
    private static final Map<String, Command> USER_COMMAND_NAME_TO_COMMAND = initUserCommand();


    private static ContextHandler contextHandler;


    private ContextHandler() {
    }

    public static ContextHandler getInstance() {
        if(contextHandler ==null) {
            synchronized (ContextHandler.class) {
                if (contextHandler == null) {
                    contextHandler = new ContextHandler();
                }
            }
        }
        return contextHandler;
    }

    private static Map<String, Command> initUserCommand() {
        Map<String, Command> commandNameToCommand = new HashMap<>();
        commandNameToCommand.put("login", LOGIN_COMMAND);
        commandNameToCommand.put("logout", LOGOUT_COMMAND);
        commandNameToCommand.put("register", REGISTER_COMMAND);

        return Collections.unmodifiableMap(commandNameToCommand);

    }

    public DBConnector getDbConnector() {
        return DB_CONNECTOR;
    }

    public UserDao getUserDao() {
        return USER_DAO;
    }

    public Validator getVALIDATOR() {
        return VALIDATOR;
    }

    public UserService getUserService() {
        return USER_SERVICE;
    }

    public static Map<String, Command> getUserCommandsMap() {
        return USER_COMMAND_NAME_TO_COMMAND;
    }
}