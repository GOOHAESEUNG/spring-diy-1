package com.diy.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LectureDeleteController implements Controller {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String idStr = request.getParameter("id");

        if (idStr == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Long id = Long.parseLong(idStr);
        boolean removed = LectureStorage.LECTURES.removeIf(l -> l.getId().equals(id));

        if (!removed) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
