package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.dao.StatDao_23110341;
import vn.iotstar.dao.impl.StatDaoImpl_23110341;
import vn.iotstar.service.VideoService_23110341;
import vn.iotstar.service.impl.VideoServiceImpl_23110341;

import java.io.IOException;

@WebServlet(urlPatterns = "/video/detail")
public class VideoDetailServlet_23110341 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final VideoService_23110341 vService = new VideoServiceImpl_23110341();
    private final StatDao_23110341 statDao = new StatDaoImpl_23110341();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("video", vService.findById(id));
        req.setAttribute("likeCount", statDao.likesOf(id));
        req.setAttribute("shareCount", statDao.sharesOf(id));
        req.getRequestDispatcher("/WEB-INF/views/video-detail.jsp").forward(req, resp);
    }
}
