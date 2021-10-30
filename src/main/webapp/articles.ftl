<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>Статьи</#macro>
<#macro header>Статьи</#macro>
<#macro content>
    <#if articles?has_content>
    <#list articles as article>
        <p><a href="/article?id=${article.id}">${article.heading}</a></p>
    </#list>
    <#else>
        <p>Статей нет</p>
    </#if>
</#macro>
</html>