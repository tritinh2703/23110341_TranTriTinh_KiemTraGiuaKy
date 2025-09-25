package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.dao.CategoryDao_23110341;
import vn.iotstar.dao.impl.CategoryDaoImpl_23110341;
import vn.iotstar.dao.impl.StatDaoImpl_23110341;

import java.io.IOException;

@WebServlet(urlPatterns = "/categories")
public class CategoryPageServlet_23110341 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final CategoryDao_23110341 cDao = new CategoryDaoImpl_23110341();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
	    req.setAttribute("cats", cDao.countVideosPerCategory());

	    // ✅ thêm dòng này
	    req.setAttribute("statDao", new vn.iotstar.dao.impl.StatDaoImpl_23110341());

	    req.getRequestDispatcher("/WEB-INF/views/category-list.jsp").forward(req, resp);
	}

}
