package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;
import vn.iotstar.entity.Videos_23110341;
import vn.iotstar.service.VideoService_23110341;
import vn.iotstar.service.impl.VideoServiceImpl_23110341;

@WebServlet(urlPatterns = "/product")
public class ProductServlet_23110341 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final VideoService_23110341 videoService = new VideoServiceImpl_23110341();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       
        List<Videos_23110341> videos = videoService.findAll();
        req.setAttribute("videos", videos);

        // Chuyển tới trang hiển thị
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp")
           .forward(req, resp);
    }
}
