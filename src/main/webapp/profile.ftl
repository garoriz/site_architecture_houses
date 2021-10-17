<html lang="en">
<#include "base.ftl">
<#macro title>Profile</#macro>
<#macro header>${user.name} ${user.surname}</#macro>

<#macro content>
    ${user.status}
</#macro>
</html>