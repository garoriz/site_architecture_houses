<%@ page import="ru.kpfu.itis.garipov.dto.ArticleDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Статьи</title>
</head>
<body>
<div>
    <h1>Статьи</h1>
</div>
<div>
    <%
        List<ArticleDTO> articles = (List<ArticleDTO>) request.getAttribute("articles");
        if (articles != null && !articles.isEmpty()) {
            out.println("<ui>");
            for (ArticleDTO a : articles) {
                out.println("<li><a href=\"/article\">" + a.getHeading() + "</a></li>");
            }
            out.println("</ui>");
        } else out.println("<p>Статей нет</p>");
    %>
</div>
</body>
</html>