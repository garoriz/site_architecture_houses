<#ftl encoding='UTF-8'>
<html lang="en">
<#include "base.ftl">
<#macro head><title>Профиль</title></#macro>
<#macro header>${user.name} ${user.surname}</#macro>

<#macro content>
    <a href="/">Главная страница</a>
    <br>
    <p>Login: ${user.login}</p>
    <p>${user.urlPhoto}</p>
    <p>${user.status}</p>
    <br>
    <form action="/settings">
        <button>Настройки профиля</button>
    </form>
    <form action="/logout">
        <button>Выход</button>
    </form>
    <form action="/addArticle">
        <button>Добавить статью</button>
    </form>
    <form action="/addPhoto">
        <button>Добавить фото</button>
    </form>
    <form action="/addSaleAd">
        <button>Добавить объявление</button>
    </form>
    <form action="/myArticles">
        <button>Мои статьи</button>
    </form>
    <form action="/myPhotos">
        <button>Мои фото</button>
    </form>
    <form action="/mySaleAds">
        <button>Мои объявления</button>
    </form>
</#macro>
</html>