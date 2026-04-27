package com.diy.app;

import com.diy.app.lecture.controller.LectureCreateController;
import com.diy.app.lecture.controller.LectureDeleteController;
import com.diy.app.lecture.controller.LectureListController;
import com.diy.app.lecture.controller.LectureUpdateController;
import com.diy.framework.web.Controller;
import com.diy.framework.web.HandlerMapping;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    private HandlerMapping handlerMapping;

    @Override
    public void init() {
        handlerMapping = new HandlerMapping();
        handlerMapping.setMapping("GET", "/lectures", new LectureListController());
        handlerMapping.setMapping("POST", "/lectures", new LectureCreateController());
        handlerMapping.setMapping("PUT", "/lectures", new LectureUpdateController());
        handlerMapping.setMapping("DELETE", "/lectures", new LectureDeleteController());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            Controller controller = handlerMapping.getController(req);
            if (controller == null) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            controller.handleRequest(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
