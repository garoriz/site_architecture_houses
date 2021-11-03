<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro head>
    <title>Сообщения</title>
    <style>
        div {
            padding: 20px;
            border: 8px #17baef;
            background: lightblue;
        }
        .content-box {
            box-sizing: content-box;

        }
    </style>
    </#macro>
<#macro header><title>Чат</title></#macro>
<#macro content>
    <a href="/">Главная страница</a>
    <br>
    <form action="/messages" method="post">
        <input name="message_input" placeholder="Напишите своё сообщение..."/>
        <input type="submit" value="Отправить">
    </form>
    <div class="content-box">
        <#if map?has_content>
            <#list map as message, user>
                <p>${user}: ${message.content}</p>
            </#list>
        <#else>
            <p>Нет сообщений</p>
        </#if>
    </div>
</#macro>
</html>