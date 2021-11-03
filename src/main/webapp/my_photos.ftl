<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro head><title>Мои фото</title></#macro>
<#macro header>Мои фото домов и архитектуры</#macro>
<#macro content>
    <a href="/">Главная страница</a>
    <br>
    <#if photos?has_content>
        <#list photos as photo>
            <p>${photo.urlPhoto}</p>
        </#list>
    <#else>
        <p>Фото нет</p>
    </#if>
</#macro>
</html>