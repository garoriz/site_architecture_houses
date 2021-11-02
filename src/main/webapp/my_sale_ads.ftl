<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>Объявления</#macro>
<#macro header>Объявления</#macro>
<#macro content>
    <#if saleAds?has_content>
        <#list saleAds as saleAd>
            <p><a href="/saleAd?id=${saleAd.id}">${saleAd.heading}</a></p>
            <small><a href="/deleteSaleAd?id=${saleAd.id}">Закрыть объявление</a></small>
        </#list>
    <#else>
        <p>Объявлений нет</p>
    </#if>
</#macro>
</html>