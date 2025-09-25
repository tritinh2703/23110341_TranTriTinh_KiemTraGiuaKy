package vn.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.entity.Category_23110341;
import vn.iotstar.entity.Videos_23110341;
import vn.iotstar.service.VideoService_23110341;
import vn.iotstar.service.impl.VideoServiceImpl_23110341;

import jakarta.persistence.EntityManager;
import vn.iotstar.config.JPAConfig_23110341;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/videos", "/admin/videos/create", "/admin/videos/edit", "/admin/videos/delete"})
public class AdminVideoServlet_23110341 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final VideoService_23110341 service = new VideoServiceImpl_23110341();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.endsWith("/videos")) {
            int page = parseInt(req.getParameter("page"), 1);
            int size = 6;
            long total = service.countAll();
            int totalPages = (int) Math.ceil(total / (double) size);
            req.setAttribute("videos", service.findPage(page, size));
            req.setAttribute("page", page);
            req.setAttribute("totalPages", totalPages);
            req.getRequestDispatcher("/WEB-INF/views/admin/video-list.jsp").forward(req, resp);
        } else if (uri.endsWith("/create")) {
            loadCategories(req);
            req.setAttribute("video", new Videos_23110341());
            req.getRequestDispatcher("/WEB-INF/views/admin/video-form.jsp").forward(req, resp);
        } else if (uri.endsWith("/edit")) {
            String id = req.getParameter("id");
            loadCategories(req);
            req.setAttribute("video", service.findById(id));
            req.getRequestDispatcher("/WEB-INF/views/admin/video-form.jsp").forward(req, resp);
        } else if (uri.endsWith("/delete")) {
            service.delete(req.getParameter("id"));
            resp.sendRedirect(req.getContextPath() + "/admin/videos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String id = req.getParameter("videoId");
        String title = req.getParameter("title");
        String poster = req.getParameter("poster");
        Integer views = parseInt(req.getParameter("views"), 0);
        Boolean active = "on".equals(req.getParameter("active"));
        String description = req.getParameter("description");
        Integer cateId = parseInt(req.getParameter("categoryId"), null);

        Videos_23110341 v = "/admin/videos/create".equals(req.getServletPath())
                ? new Videos_23110341() : service.findById(id);

        v.setVideoId(id);
        v.setTitle(title);
        v.setPoster(poster);
        v.setViews(views);
        v.setActive(active);
        v.setDescription(description);
        if (cateId != null) {
            EntityManager em = JPAConfig_23110341.getEntityManager();
            try {
                Category_23110341 c = em.find(Category_23110341.class, cateId);
                v.setCategory(c);
            } finally { em.close(); }
        }

        if (uri.endsWith("/create")) service.create(v); else service.update(v);
        resp.sendRedirect(req.getContextPath() + "/admin/videos");
    }

    private int parseInt(String s, int d) { try { return Integer.parseInt(s); } catch (Exception e) { return d; } }
    private Integer parseInt(String s, Integer d){ try { return Integer.valueOf(s);} catch(Exception e){ return d; } }

    private void loadCategories(HttpServletRequest req){
        EntityManager em = JPAConfig_23110341.getEntityManager();
        try {
            List<Category_23110341> c = em.createQuery("SELECT c FROM Category_23110341 c", Category_23110341.class).getResultList();
            req.setAttribute("categories", c);
        } finally { em.close(); }
    }
}
