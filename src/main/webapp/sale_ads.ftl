<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>Объявления</#macro>
<#macro header>Объявления</#macro>
<#macro content>
    <form action="/saleAds" method="post">
        Поиск:
        <input name="searchName" type="text">
        <br>
        Фильтр
        <br>
        Максимальная цена:
        <input name="maxPrice" type="number">
        <input type="submit" value="Найти">
    </form>
    <#if saleAds?has_content>
        <#list saleAds as saleAd>
            <p><a href="/saleAd?id=${saleAd.id}">${saleAd.heading}</a></p>
        </#list>
    <#else>
        <p>Объявлений нет</p>
    </#if>
</#macro>
</html>