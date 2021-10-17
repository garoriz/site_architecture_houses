<html lang="en">
<#include "base.ftl">
<#macro title>Sale Ad</#macro>
<#macro header>${saleAd.heading}</#macro>

<#macro content>
    ${saleAd.content}
    <br>
    <p style="font-weight:bold; color: red"><small>&#8381: ${saleAd.price}</small></p>
    <p style="font-weight:bold"><small>${saleAd.phoneNumber}</small></p>
    <br>
    <p><small>${saleAd.date}</small></p>
</#macro>
</html>