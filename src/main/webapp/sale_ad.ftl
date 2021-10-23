<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>${saleAd.heading}</#macro>
<#macro header>${saleAd.heading}</#macro>

<#macro content>
    ${saleAd.content}
    <br>
    <p style="font-weight:bold; color: red"><small>Цена: ${saleAd.price} руб.</small></p>
    <p style="font-weight:bold"><small>${saleAd.phoneNumber}</small></p>
    <br>
    <p><small>${saleAd.date}</small></p>
</#macro>
</html>