<html lang="en">
<head><@head></@head>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <style>
        #header {
            border:1px solid;
            border-color:rgba(0,0,0,0.1);
            border-bottom-color:rgba(0,0,0,0.2);
            border-top:none;
            background:#f7f7f7;
            background:-webkit-linear-gradient(top, #f7f7f7, #f4f4f4);
            background:-moz-linear-gradient(top, #f7f7f7, #f4f4f4);
            background:-o-linear-gradient(top, #f7f7f7, #f4f4f4);
            background:linear-gradient(to bottom, #f7f7f7, #f4f4f4);
            background-clip:padding-box;
            border-radius:0 0 5px 5px;
            margin: auto;
            position: relative;
            width: 1000px;
        }
        #header a {
            color: #4C9FEB;
        }
        #header a:hover {
            color: #FF7D4C;
        }
        body {
            font-family: 'Lato', arial, sans-serif;
            color: #444;
            font-size: 16px;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }
        h1,
        h2,
        h3,
        h4,
        h5,
        h6 {
            font-family: 'Montserrat', sans-serif;
            font-weight: 700;
            color: #17baef;
        }
        a {
            color: #17baef;
            -webkit-transition: all 0.4s ease-in-out;
            -moz-transition: all 0.4s ease-in-out;
            -ms-transition: all 0.4s ease-in-out;
            -o-transition: all 0.4s ease-in-out;
        }
        a:hover {
            text-decoration: underline;
            color: #0e98c5;
        }
        button {
            position: relative;
            display: block;
            width: 200px;
            height: 36px;
            border-radius: 18px;
            background-color: #1c89ff;
            border: solid 1px transparent;
            color: #fff;
            font-size: 18px;
            font-weight: 300;
            cursor: pointer;
            transition: all .1s ease-in-out;
        }
        input[type="text"] {
            border: 1px solid cornflowerblue;
            border-radius: 5px;
        }
        input[type="password"] {
            border: 1px solid cornflowerblue;
            border-radius: 5px;
        }
        input[type="submit"] {
            border: 1px solid cornflowerblue;
            border-radius: 5px;
            background-color: #17baef;
        }
        input[type="file"] {
            border: 1px solid cornflowerblue;
            border-radius: 5px;
            background-color: #17baef;
        }
    </style>
</head>

<body>
<div id="header">
    <H3><@header></@header></H3>
</div>


<div class="content1">
    <div class="content"><@content></@content></div>
</div>

</body>

</html>