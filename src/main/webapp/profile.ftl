<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>Профиль</#macro>
<#macro header>${user.name} ${user.surname}</#macro>

<#macro content>
    <p>Login: ${user.login}</p>
    <img src=${user.urlPhoto} width="100" height="111">
    <br>
    ${user.status}
</#macro>
</html>