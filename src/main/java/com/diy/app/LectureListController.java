package com.diy.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LectureListController implements Controller {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("lectures", LectureStorage.LECTURES);
        request.getRequestDispatcher("/lecture-list.jsp").forward(request, response);
    }
}
