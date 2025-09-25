package vn.iotstar.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.constant.Constant_23110341;
import vn.iotstar.entity.Users_23110341;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class AdminFilter_23110341 implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest r = (HttpServletRequest) req;
        HttpServletResponse s = (HttpServletResponse) resp;
        Users_23110341 u = (Users_23110341) r.getSession().getAttribute(Constant_23110341.SESSION_ACCOUNT);
        if (u == null || !Boolean.TRUE.equals(u.getAdmin())) {
            s.sendRedirect(r.getContextPath() + "/login");
            return;
        }
        chain.doFilter(req, resp);
    }
}
