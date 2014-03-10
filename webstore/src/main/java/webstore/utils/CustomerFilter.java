package webstore.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * AuthFilter
 *
 * @author Josef Haddad
 */
public class CustomerFilter implements Filter {

    public CustomerFilter() {
    }

    /**
     * Filter for login, makes the session valid or redirect the user to a page
     * that has been set to visible for the user with no authentication
     *
     * @param request
     * @param response
     * @param chain
     *
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession ses = req.getSession(true);
            String reqURI = req.getRequestURI();
            //checks if the user the login, addUser page or if a session and a user are 
            //existing and not null, if it's null then redirect to index.html
            if (reqURI.indexOf("/jsf/login/login.xhtml") >= 0 || (ses != null && ses.getAttribute("username") != null)
                    || reqURI.indexOf("/public/") >= 0 || reqURI.contains("javax.faces.resource")) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(req.getContextPath() + "/jsf/public/index.xhtml");
            }
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}