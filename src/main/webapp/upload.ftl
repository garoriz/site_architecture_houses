<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>Upload file</#macro>
<#macro header>Upload file:</#macro>
<#macro content>
    <form action="upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <br>
        <input type="submit" value="Загрузить фото">
    </form>
</#macro>
</html>