package ua.delivery.controller.filter;

import ua.delivery.model.domain.User;
import ua.delivery.model.domain.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        final HttpServletRequest reqest = (HttpServletRequest)servletRequest;
//        final User user = (User)reqest.getSession().getAttribute("user");
//        if(!(Role.ADMIN.equals(user.getRole()))) {
//            reqest.getRequestDispatcher("view/something_is_wrong.jsp").forward(reqest, servletResponse);
//        }
//        filterChain.doFilter(reqest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
