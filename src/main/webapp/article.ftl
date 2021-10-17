<html lang="en">
<#include "base.ftl">
<#macro title>Article</#macro>
<#macro header>${article.heading}</#macro>

<#macro content>
    ${article.content}
    <br>
    <p><small>${article.date}</small></p>
</#macro>
</html>