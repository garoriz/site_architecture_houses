<html lang="en">
<#include "base.ftl">
<#macro title>${article.heading}</#macro>
<#macro header>${article.heading}</#macro>

<#macro content>
    ${author.name} ${author.surname}
    <br>
    ${article.content}
    <br>
    <p><small>${article.date}</small></p>
</#macro>
</html>