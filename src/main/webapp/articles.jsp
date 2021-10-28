<%@ page import="ru.kpfu.itis.garipov.dto.ArticleDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Статьи</title>
</head>
<body>
<div>
    <h1>Статьи</h1>
</div>
<div id="content-box">
    <%
        /*List<ArticleDTO> articles = (List<ArticleDTO>) request.getAttribute("articles");
        if (articles != null && !articles.isEmpty()) {
            for (int i = 0; i < 10000; i++) {

                out.println("<ui>");
                for (ArticleDTO a : articles) {
                    out.println("<li><a href=\"/article?id=" + a.getId() + "\">" + a.getHeading() + "</a></li>");
                }
                out.println("</ui>");
            }
        } else out.println("<p>Статей нет</p>");*/
    %>
   <script>
       for( let i = 0; i < 100; i++ )
           document.write("<div>Случайный текст или еще, что то</div>");
   </script>
</div>
<script>

    window.addEventListener("scroll", function(){

        var block = document.getElementById('content-box');
        var counter = 1;

        var contentHeight = block.offsetHeight;      // 1) высота блока контента вместе с границами
        var yOffset       = window.pageYOffset;      // 2) текущее положение скролбара
        var window_height = window.innerHeight;      // 3) высота внутренней области окна документа
        var y             = yOffset + window_height;

        // если пользователь достиг конца
        if(y >= contentHeight)
        {
            //загружаем новое содержимое в элемент
            block.innerHTML = block.innerHTML + "<div>Случайный текст или еще, что то</div>";
        }
    });

</script>
</body>
</html>