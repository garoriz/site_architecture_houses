<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>${article.heading}</#macro>
<#macro header>${article.heading}</#macro>

<#macro content>
    ${author.name} ${author.surname}
    <br>
    ${article.content}
</#macro>
</html>