package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.constant.Constant_23110341;
import vn.iotstar.entity.Users_23110341;

import java.io.IOException;

@WebServlet(urlPatterns = "/waiting")
public class WaitingServlet_23110341 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users_23110341 u = (Users_23110341) req.getSession().getAttribute(Constant_23110341.SESSION_ACCOUNT);
        if (u == null) { resp.sendRedirect(req.getContextPath() + "/login"); return; }
        if (Boolean.TRUE.equals(u.getAdmin())) {
            resp.sendRedirect(req.getContextPath() + "/admin/home");
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }
}
