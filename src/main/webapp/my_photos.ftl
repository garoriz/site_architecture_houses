<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>Мои фото</#macro>
<#macro header>Мои фото домов и архитектуры</#macro>
<#macro content>
    <#if photos?has_content>
        <#list photos as photo>
            <p>${photo.urlPhoto}</p>
        </#list>
    <#else>
        <p>Фото нет</p>
    </#if>
</#macro>
</html>