package ua.delivery.controller.filter;

import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.domain.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoleFilter implements Filter {
    private final Map<Role, Set<String>> rights = new HashMap<>();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Set<String> adminLinks = new HashSet<>();
        Set<String> userLinks = new HashSet<>();
        Set<String> guestLinks = new HashSet<>();

        //jsp links

        rights.put(Role.ADMIN, adminLinks);
        rights.put(Role.USER, userLinks);
        rights.put(Role.GUEST, guestLinks);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI()
                .replace(request.getContextPath(), "")
                .replace(request.getServletPath(), "");

        if (request.getSession().getAttribute("sessionUser") == null) {
            request.getSession().setAttribute("sessionUser", User.builder()
            .withName("")
            .withSurname("")
            .withUserCredentials(new UserCredentials("", ""))
            .withId(0L)
            .withRole(Role.GUEST));
        }

        final Role sessionRole = ((User) request.getSession().getAttribute("userSession")).getRole();

        if (!rights.get(sessionRole).contains(requestURI)) {
            request.getRequestDispatcher(request.getContextPath() + "/WEB-INF/errors/not_found.jsp")
                    .forward(request, response);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Override
    public void destroy() {

    }
}