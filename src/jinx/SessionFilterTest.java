package jinx;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Filter测试用例
 * Created by jinx on 9/26/16.
 */
public class SessionFilterTest implements Filter{

    protected FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(600);
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if("sessionTest".equals(cookie.getName())){
                session.setAttribute(cookie.getName(),cookie.getValue());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                cookie = new Cookie(cookie.getName(),sdf.format(new Date()));
                response.addCookie(cookie);
            }
        }
        return;
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
