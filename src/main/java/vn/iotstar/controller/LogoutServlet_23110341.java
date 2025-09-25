package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.constant.Constant_23110341;

import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet_23110341 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute(Constant_23110341.SESSION_ACCOUNT);
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
