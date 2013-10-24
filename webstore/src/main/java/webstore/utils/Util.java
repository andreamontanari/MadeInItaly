package webstore.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Utils to get Session, reqeust and username when someone is logged on
 *
 * @author Jonas Ha
 */
public class Util {

    /**
     * static method to get the session
     *
     * @return HTTPSession
     */
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.
                getCurrentInstance().
                getExternalContext().
                getSession(false);
    }

    /**
     * static method to get the request
     *
     * @return HTTServletRequest
     */
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.
                getCurrentInstance().
                getExternalContext().getRequest();
    }

    /**
     * static method to get the username for the session
     *
     * @return String username
     */
    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }
}