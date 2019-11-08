package ua.delivery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.delivery.model.command.Command;
import ua.delivery.model.context.ContextHandler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet {
    Map<String, Command> commandMap = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(MainServlet.class);

    @Override
    public void init(ServletConfig config) {
        commandMap = ContextHandler.getUserCommandsMap();
        LOGGER.info("Servlet has been initiated");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doRequest(request, response);
        LOGGER.info("Servlet get method executed");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doRequest(request, response);
        LOGGER.info("Servlet post method executed");
    }

    private void doRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String path = request.getPathInfo();
        request.setAttribute("curReqUrl", request.getRequestURL());
        Command command = commandMap.get(path);
        if (command != null) {
            String page = command.execute(request, response);

            if (page.contains("redirect")) {
                response.sendRedirect(page.replace("redirect:", ""));
                LOGGER.info("Redirect to " + page.replace("redirect:", ""));
            } else if (page.contains("forward")) {
                request.getRequestDispatcher(page.replace("forward:", ""))
                        .forward(request, response);
                LOGGER.info("Forward to " + page.replace("redirect:", ""));
            }
        } else {
            LOGGER.info("In MainServlet command == null");
        }
    }
}
