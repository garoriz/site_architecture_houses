<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro head><title>${saleAd.heading}</title></#macro>
<#macro header>${saleAd.heading}</#macro>

<#macro content>
    <a href="/">Главная страница</a>
    <br>
    <a href="/saleAds">Назад</a>
    <br>
    <a href="/profile?login=${author.login}">${author.name} ${author.surname}</a>
    <br>
    ${saleAd.content}
    <br>
    ${saleAd.urlPhoto}
    <p style="font-weight:bold; color: red"><small>Цена: ${saleAd.price} руб.</small></p>
    <p style="font-weight:bold"><small>${saleAd.phoneNumber}</small></p>
</#macro>
</html>