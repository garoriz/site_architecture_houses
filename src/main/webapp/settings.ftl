<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>Настройки профиля</#macro>
<#macro header>Настройки профиля</#macro>

<#macro content>
    <form action="/settings" method="post">
        Сменить имя: <input name="name" type="text"/>
        <br>
        Сменить фамилию: <input name="surname" type="text"/>
        <br>
        Сменить логин: <input name="login" type="text"/>
        <br>
        Сменить статус: <input name="status" type="text"/>
        <br>
        Сменить пароль: <input name="password" type="password"/>
        <br>
        Подтвердить пароль: <input name="confirmedPassword" type="password"/>
        <br>
        <input type="submit" value="Сохранить">
    </form>
</#macro>
</html>