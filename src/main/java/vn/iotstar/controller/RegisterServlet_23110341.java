package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.iotstar.entity.Users_23110341;
import vn.iotstar.service.UserService_23110341;
import vn.iotstar.service.impl.UserServiceImpl_23110341;

@WebServlet("/register")
public class RegisterServlet_23110341 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserService_23110341 service = new UserServiceImpl_23110341();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/auth/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullname");
        String email    = req.getParameter("email");

        if(service.existsByUsername(username)){
            req.setAttribute("message", "Tên đăng nhập đã tồn tại!");
            req.getRequestDispatcher("/WEB-INF/views/auth/register.jsp").forward(req, resp);
            return;
        }

        Users_23110341 u = new Users_23110341();
        u.setUsername(username);
        u.setPassword(password);
        u.setFullname(fullname);
        u.setEmail(email);
        u.setAdmin(false);      // mặc định user
        u.setActive(true);

        service.register(u);
        // sau khi đăng ký chuyển sang login
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
