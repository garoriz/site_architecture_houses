package ru.kpfu.itis.garipov.servlet;


import ru.kpfu.itis.garipov.model.Message;
import ru.kpfu.itis.garipov.service.impl.MessageServiceImpl;
import ru.kpfu.itis.garipov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "messagesServlet", urlPatterns = "/messages")
public class MessagesServlet extends HttpServlet {

    MessageServiceImpl messageService = new MessageServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("chat.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message_input");
        if (message == null) {
            message = "";
        }
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");
        messageService.save(createMessage(userService.get(sessionUser).getId(),
                userService.get(req.getParameter("login")).getId(), message));
    }

    private Message createMessage(int userId, int recipientId, String content) {
        return new Message(userId, recipientId, content);
    }
}
