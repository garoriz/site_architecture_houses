<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>Настройки профиля</#macro>
<#macro header>Настройки профиля</#macro>

<#macro content>
    Сменить имя: <input name="name" type="text"/>
    <br>
    Сменить фамилию: <input name="surname" type="text"/>
    <br>
    Сменить логин: <input name="login" type="text"/>
    <br>
    <form action="upload" method="post" enctype="multipart/form-data">
        Сменить фото профиля:
        <input type="file" name="file">
    </form>
    <br>
    Сменить статус: <input name="status" type="text"/>
    <br>
    Сменить пароль: <input name="password" type="text"/>
    <br>
    Подтвердить пароль: <input name="confirmedPassword" type="text"/>
    <br>
    <input type="submit" value="Сохранить">
</#macro>
</html>