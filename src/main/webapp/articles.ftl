<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro head><title>Статьи</title></#macro>
<#macro header>Статьи</#macro>
<#macro content>
    <a href="/">Главная страница</a>
    <br>
    <#if articles?has_content>
    <#list articles as article>
        <p><a href="/article?id=${article.id}">${article.heading}</a></p>
    </#list>
    <#else>
        <p>Статей нет</p>
    </#if>
</#macro>
</html>