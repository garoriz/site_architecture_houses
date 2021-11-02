package ru.kpfu.itis.garipov.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "rememberMeFilter", urlPatterns = {"/settings", "/upload", "/messages",
        "/addArticle", "/addPhoto", "/addSaleAd", "/myArticles", "/myPhotos", "/mySaleAds", "/profile"})
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        HttpSession session = request.getSession(false);
        Cookie[] cookies = request.getCookies();
        String login = null;

        if (session == null && !uri.contains("login")) {
            if (cookies == null) {
                response.sendRedirect("/login");
            } else {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("login")) {
                        login = cookie.getValue();
                        break;
                    }
                }
                if (login != null) {
                    session = request.getSession();
                    session.setAttribute("login", login);
                    session.setMaxInactiveInterval(2 * 60 * 60);
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    response.sendRedirect("/login");
                }
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
