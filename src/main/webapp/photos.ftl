<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro head><title>Фото</title></#macro>
<#macro header>Фото домов и архитектуры от пользователей</#macro>
<#macro content>
    <a href="/">Главная страница</a>
    <br>
    <#if linkedHashMap?has_content>
        <#list linkedHashMap as photo, user>
            <small><a href="/profile?login=${user.login}">${user.name} ${user.surname}</a></small>
            <p>${photo.urlPhoto}</p>
        </#list>
    <#else>
        <p>Фото нет</p>
    </#if>
</#macro>
</html>