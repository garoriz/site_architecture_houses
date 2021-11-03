<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro head><title>Загрузка фото профиля</title></#macro>
<#macro header>Загрузка фото профиля</#macro>
<#macro content>
    <a href="/">Главная страница</a>
    <br>
    <form action="uploadPhotoProfile" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <br>
        <input type="submit" value="Загрузить фото">
    </form>
</#macro>
</html>