<html lang="en">
<#include "base.ftl">
<#macro title>Profile</#macro>
<#macro header>${user.name} ${user.surname}</#macro>

<#macro content>
    <img src="https://res.cloudinary.com/dfn48aqa5/image/upload/v1634713767/zmklcvkymmum9iklhape.jpg" alt="фото профиля">
    <br>
    ${user.status}
</#macro>
</html>