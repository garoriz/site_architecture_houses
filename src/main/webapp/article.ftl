<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro head><title>${article.heading}</title></#macro>
<#macro header>${article.heading}</#macro>

<#macro content>
    <a href="/">Главная страница</a>
    <br>
    <a href="/articles">Назад</a>
    <br>
    <a href="/profile?login=${author.login}">${author.name} ${author.surname}</a>
    <br>
    ${article.content}
</#macro>
</html>