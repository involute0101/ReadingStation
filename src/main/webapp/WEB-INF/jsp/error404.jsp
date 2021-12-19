<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Reading Station Error</title>
    <link rel="shortcut icon" type="image/ico" href="/static/icon/favicon.ico" />
    <meta name="author" content="www.rightstar.cn">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width" />
    <meta name="applicable-device" content="pc">
    <meta http-equiv="mobile-agent" content="format=html5; url=http://m.rightstar.cn/">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta http-equiv="Cache-Control" content="no-transform" />
    <link rel="canonical" href="https://www.rightstar.cn" />
    <!-- 引入公共样式css -->
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/common.css">
    <!-- 引入index.css样式 -->
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/index.css">
    <script src="/static/css/indexWeb/statics/js/common.js"></script>
</head>

<body>
    <!--模版文件-->
    <!-- 防止乱码 -->
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">


    <section class="shortcut">
        <div class="w">
            <div class="fl">
                <ul>
                    <li>欢迎访问Reading Station</li>
                </ul>
            </div>
            <div class="fr">
                <ul>
                    <li>
                        <img src="/static/css/indexWeb/statics/images/home.png" alt="">
                        <a href="/student/index" > 返回首页</a>
                    </li>
                </ul>
            </div>
        </div>
    </section>

    <!-- 头部模块 -->
    <header>
        <div class="w">
            <div class="search" style="margin-left: 400px">
                <form action="/student/search">
                    <input type="text" placeholder="输入搜索的书名" class="search_input" name="searchContent">
                    <button type="submit" class="search_btn"><img src="/static/css/indexWeb/statics/images/search.png" alt=""></button>
                </form>
            </div>

            <div class="fr header_right" style="float:right">
                <ul>
                    <li>
                        <img src="/static/css/indexWeb/statics/images/person_icon.png">
                        <span id="userName">

                    </span>
                        <span class="span_1" id = "loginRegister">
                            <a href="/user/login" class="span_1">登录</a>|
                            <a href="/user/register" class="span_1">注册</a>
                    </span>
                        <span class="span_1" id="personInformation">
                            <a href="/user/index" class="span_1">个人中心</a>
                    </span>

                    </li>
                    <script>
                        var startIndex = document.cookie.indexOf("id=")
                        var idString;
                        if(document.cookie.indexOf(";")==-1){
                            idString = document.cookie.substring(startIndex,document.cookie.length)
                        }else{
                            idString = document.cookie.substring(startIndex,document.cookie.indexOf(";"))
                        }
                        var param = document.cookie.substring(idString.indexOf("=")+1,idString.length);
                        document.getElementById("userName").innerText=param;
                        var loginRegister = document.getElementById("loginRegister")
                        var personInformation = document.getElementById("personInformation")
                        if(param!=null){
                            loginRegister.style.display = "none"
                            personInformation.style.display = ""
                        }
                        else {
                            loginRegister.style.display = ""
                            personInformation.style.display = "none"
                        }
                    </script>
                </ul>
            </div>
        </div>


    </header>

    <!-- hotword模块 -->
    <nav class="nav_1">
        <div class="w">


        </div>

    </nav>

    <h1 id="errorMessage">404~~出错啦</h1>

<script>
    //获取url参数,r[2]是值
    let reg = new RegExp('(^|&)' + 'message' + '=([^&]*)(&|$)')
    let r = window.location.search.substr(1).match(reg)
    document.getElementById("errorMessage").innerHTML="404~~出错啦\n"+r[2];
</script>
</body>

</html>