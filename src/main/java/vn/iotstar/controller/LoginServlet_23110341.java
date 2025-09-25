package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.constant.Constant_23110341;
import vn.iotstar.entity.Users_23110341;
import vn.iotstar.service.UserService_23110341;
import vn.iotstar.service.impl.UserServiceImpl_23110341;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet_23110341 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UserService_23110341 userService = new UserServiceImpl_23110341();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        Users_23110341 u = userService.login(username, password);
        if (u != null) {
            req.getSession().setAttribute(Constant_23110341.SESSION_ACCOUNT, u);
            if ("on".equalsIgnoreCase(remember)) {
                Cookie c = new Cookie(Constant_23110341.COOKIE_REMEMBER, username);
                c.setMaxAge(60 * 30);
                resp.addCookie(c);
            }
            resp.sendRedirect(req.getContextPath() + "/waiting");
        } else {
            req.setAttribute("alert", "Sai tài khoản hoặc mật khẩu!");
            req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
        }
    }
}
