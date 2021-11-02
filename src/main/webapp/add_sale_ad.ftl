<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro title>Новое объявление</#macro>
<#macro header>Новое объявление</#macro>
<#macro content>
    <form action="/addSaleAd" method="post" enctype="multipart/form-data">
        Заголовок:
        <p><textarea rows="2" cols="160" name="heading"></textarea></p>
        <br>
        Текст:
        <p><textarea rows="50" cols="160" name="content"></textarea></p>
        <br>
        Цена:
        <input name="price" type="number">
        <br>
        Номер телефона:
        <input name="phoneNumber" type="text">
        <br>
        <input type="file" name="file">
        <br>
        <input type="submit" value="Добавить объявление">
    </form>
</#macro>