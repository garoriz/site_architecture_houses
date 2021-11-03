<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro head><title>Профиль</title></#macro>
<#macro header>${user.name} ${user.surname}</#macro>

<#macro content>
    <a href="/">Главная страница</a>
    <br>
    <p>Login: ${user.login}</p>
    ${user.urlPhoto}
    <br>
    ${user.status}
    <br>
    <p><a href="/messages?recipient=${user.login}">Чат с пользователем ${user.name} ${user.surname}</a></p>
</#macro>
</html>