<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>Загрузка фото</#macro>
<#macro header>Загрузка фото</#macro>
<#macro content>
    <form action="addPhoto" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <br>
        <input type="submit" value="Загрузить фото">
    </form>
</#macro>
</html>