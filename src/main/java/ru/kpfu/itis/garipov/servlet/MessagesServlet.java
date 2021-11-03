package ru.kpfu.itis.garipov.servlet;


import ru.kpfu.itis.garipov.dto.MessageDTO;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

@WebServlet(name = "messagesServlet", urlPatterns = "/messages")
public class MessagesServlet extends HttpServlet {

    MessageServiceImpl messageService = new MessageServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");
        String recipient = req.getParameter("recipient");
        session.setAttribute("recipient", recipient);
        int userId = userService.get(sessionUser).getId();
        int recipientId = userService.get(recipient).getId();
        String nameUser = userService.get(userId).getName() + " " + userService.get(userId).getSurname();
        String nameRecipient = userService.get(recipientId).getName() + " " + userService.get(recipientId).getSurname();
        List<MessageDTO> messages = messageService.getAll(userId, recipientId);
        List<MessageDTO> messagesRecipient = messageService.getAll(recipientId, userId);
        messages.addAll(messagesRecipient);
        messages.sort(Comparator.comparingInt(MessageDTO::getId));
        Collections.reverse(messages);
        LinkedHashMap<MessageDTO, String> map = new LinkedHashMap<>();
        for (MessageDTO message:
             messages) {
            if (message.getUserId() == userId) {
                map.put(message, nameUser);
            } else {
                map.put(message, nameRecipient);
            }
        }

        req.setAttribute("map", map);

        req.getRequestDispatcher("chat.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("login");
        String recipient = (String) session.getAttribute("recipient");
        session.removeAttribute("recipient");
        String message = req.getParameter("message_input");
        if (message == null) {
            message = "";
        }
        messageService.save(createMessage(userService.get(sessionUser).getId(),
                userService.get(recipient).getId(), message));
        resp.sendRedirect("/messages?recipient=" + recipient);
    }

    private Message createMessage(int userId, int recipientId, String content) {
        return new Message(userId, recipientId, content);
    }
}
