<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>Загрузка фото статьи</#macro>
<#macro header>Загрузка фото профиля</#macro>
<#macro content>
    <form action="uploadPhotoArticle" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <br>
        <input type="submit" value="Загрузить фото">
    </form>
</#macro>
</html>