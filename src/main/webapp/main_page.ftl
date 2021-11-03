<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro head><title>Архитектура & дома</title>
    <style>
        #navigation ul
        {
            margin: 0;
            padding: 0;
        }

        #navigation ul li
        {
            list-style-type: none;
            display: inline;
        }

        #navigation li:not(:first-child):before {
            content: " | ";
        }
    </style>
</#macro>
<#macro header>Архитектура & дома</#macro>

<#macro content>
    <div id="navigation">
        <ul>
            <li><a href="/profile">Мой профиль</a></li>
            <li><a href="/articles">Статьи</a></li>
            <li><a href="/photos">Фото пользователей</a></li>
            <li><a href="/saleAds">Объявления о продаже домов</a></li>
        </ul>
    </div>
</#macro>
</html>