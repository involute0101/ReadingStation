<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ReadingStation用户注册</title>
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
    <!-- 引入favicon图标 -->
    <link rel="shortcut icon" href="/static/icon/favicon.ico" />
    <!-- 引入base的css样式 -->
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/common.css">
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/base.css">
    <!-- 引入register的css样式 -->
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/register.css">
    <!-- 引入js 加密-->
    <script  src="/static/css/indexWeb/statics/crypto-js/crypto-js.js"></script>
    <script src="/static/css/indexWeb/statics/js/reg.js"></script>
</head>

<body>
    <div class="w">
        <header>
            <div class="logo">
                <a>
                    <img src="/static/css/indexWeb/statics/images/1.jpg" alt="">
                </a>
            </div>
        </header>

        <div class="registerarea">
            <h3>
                注册新用户
                <div class="login">已有账户，去<a href="http://localhost:9000/student/login">登录</a></div>
            </h3>
            <div class="reg_form">
                <form action="/Account/createAccount" enctype="multipart/form-data" id="form" method="post" onsubmit="return onSubmit()">
                    <ul>
                        <!-- 账号 -->
                        <li>
                            <label for="">账号：</label>
                            <input type="text" class="inp" id="userName" name="userName">
                            <span class="success">
                                字母开头,可包含字母和数字
                            <i class=""></i>
                            </span>
                        </li>

                        <!-- 邮箱 -->
                        <li> <label for="">邮箱：</label>
                            <input type="text" class="inp" id="email" name="email">
                            <span class="success">
                                您的邮箱
                                <i class=""></i>
                            </span>
                        </li>

                        <!-- 密码 -->
                        <li> <label for="">密码：</label>
                            <input type="password" class="inp" id="password" name="password">
                            <span class="success">
                                请输入6-16位密码
                                <i class=""></i>
                            </span>
                        </li>

                        <!-- 确认密码 -->
                        <li> <label >确认密码：</label>
                            <input type="password" class="inp" id="repassword" name="repassword">
                            <span class="success">
                                <i class=""></i>
                            </span>
                        </li>

                        <li class="agree">
                            <input type="checkbox" name="agree" id="agree" checked="checked"> 同意协议并使用
                            <a href="">《知晓用户协议》</a>
                        </li>

                        <input type="submit" id="submit" class="btn"></input>

                    </ul>
                </form>
            </div>
        </div>
        <!-- 最底部模块模版   -->
        <footer th:replace="/static//template/footer.html"></footer>
    </div>


</body>
<script>
    function onSubmit() {
        var account = document.getElementById("userName").value
        var email = document.getElementById("email").value
        var password = document.getElementById("password").value
        var repassword = document.getElementById("repassword").value
        if(account == "" || email == "" || password==""){
            alert("请完善信息~")
            return false;
        }else if(password!=repassword){
            alert("两次密码输入不正确噢~")
            return false;
        } else {
            return true;
        }

    }
</script>

</html>