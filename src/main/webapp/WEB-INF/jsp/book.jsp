<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reading Station 在线阅读网站</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/bookMain.css">
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/bookReset.css">
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/common.css" href="/static/css/indexWeb/statics/css/common.css">
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/index.css" href="/static/css/indexWeb/statics/css/index.css">
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/search.css" href="/static/css/indexWeb/statics/css/search.css">
</head>
<body>
<div th:fragment="head">
    <!--可复用部分-->
    <!-- 快捷导航模块 -->
    <section class="shortcut">
        <div class="w">
            <div class="fl" style="float:left">
                <ul>
                    <li>欢迎访问Reading Station</li>
                </ul>
            </div>
            <div class="fr" style="float:right">
                <ul>
                    <li style="float:right">
                        <img src="/static/css/indexWeb/statics/images/home.png" alt="">
                        <a href="#" onclick="toDesktop('http:\//www.rightstar.cn/','ReadingStation')"> 设为首页</a>
                    </li>
                    <li style="float:right">
                        <img src="/static/css/indexWeb/statics/images/icon_star.png" alt="">
                        <a href="#"> 加入收藏</a>
                    </li>
                    <li style="float:right">
                        <img src="/static/css/indexWeb/statics/images/icon_plane.png" alt="">
                        <a href="#"> 桌面快捷</a>
                    </li>
                </ul>
            </div>
        </div>
    </section>

    <!-- 头部模块 -->
    <div class="w">

        <div class="fr header_right" style="float:right;margin-top: -20px;">
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
                    <script>
                        var startIndex = document.cookie.indexOf("id=")
                        var idString;
                        if(document.cookie.indexOf(";")==-1){
                            idString = document.cookie.substring(startIndex,document.cookie.length)
                        }else{
                            idString = document.cookie.substring(startIndex,document.cookie.indexOf(";"))
                        }
                        var param = document.cookie.substring(idString.indexOf("="),idString.length);
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
                </li>

            </ul>
        </div>
    </div>


</div>

<!-- 商品信息栏 -->
<div class="navbar_con">
    <div class="navbar clearfix">
        <div class="subnav_con fl">
            <h1>书籍详情 <i></i></h1>
        </div>
    </div>
</div>
<div class="submena clearfix">
</div>
<div class="center_con clearfix">
    <div class="main_menu fl"><img src="/static/css/indexWeb/statics/images/nocover.jpg"></div>
    <div class="goods_detail_list fr">
        <h3 id="bookName">书名</h3>
        <div class="prize_bar" style="margin-top: 20px">
            <div class="show_prize fl" style="font-size: 15px">简介：<em id="description">书籍简介</em></div>
        </div>
        <div class="total">上传者：<em id="uploadAccount">张三</em></div>
        <div class="total">上传时间：<em id="uploadDate">16.80元</em></div>
        <div class="operate_btn" id="startRead">
            <a href='file://localhost/E:/PDF/Head First Java.pdf'>访问菜鸟教程</a>
        </div>
    </div>
</div>


<hr style="background-color: #9d9d9d;height: 3px"/>

<%--评论--%>
<div class="containerComment">
     <div class="comment-send">
<%--         这里可以http--%>
         <form id="commentForm" method="GET" action="">
             <span class="comment-avatar">
                 <img src="/static/css/indexWeb/statics/images/personHead.png" alt="avatar">
             </span>
             <textarea class="comment-send-input" name="comment" form="commentForm" cols="80" rows="5" placeholder="请自觉遵守互联网相关的政策法规，严禁发布色情、暴力、反动的言论。"></textarea>
             <br><br>
             <input class="comment-send-button" type="submit" value="发表评论" style="margin-left:100px;margin-bottom: 10px">
         </form>
     </div>
        <%--    读取评论--%>
     <div class="comment-list" id="commentList"></div>

    <script>
        //获取url参数,r[2]是值
        let reg = new RegExp('(^|&)' + 'bookName' + '=([^&]*)(&|$)')
        let r = window.location.search.substr(1).match(reg)
        window.onload = function(){
            $.ajax({
                url: "http://localhost:9000/Book/oneBook?bookName="+r[2],
                type: "get",
                dataType: "json",
                success: function(data){
                    /*这个方法里是ajax发送请求成功之后执行的代码*/
                    showData(data);
                },
                error: function(msg){
                    alert("ajax连接异常："+msg);
                }
            });
        };
        var str = "";
        var commentStr = ""
        function showData(data) {
            document.getElementById("bookName").innerHTML = data['bookName']
            document.getElementById("uploadAccount").innerHTML = data['uploaderAccount']
            document.getElementById("uploadDate").innerHTML = data['uploadTime']
            document.getElementById("description").innerHTML = data['description']
            document.getElementById("startRead").innerHTML = "<a href='../../Book/PDF/"+data['bookName']+".pdf' class=\"buy_btn\">开始阅读</a>";

            data['comments'].forEach((comment)=>{
                commentStr+="<div class=\"comment\"><span class=\"comment-avatar\">"+
                    "<img src=\"/static/css/indexWeb/statics/images/personHead.png\" alt=\"avatar\"></span>"+
                    "<div class=\"comment-content\"><p class=\"comment-content-name\">"+comment['sender']+"</p>"+
                    "<p class=\"comment-content-article\">"+comment['content']+"</p>"+"<p class=\"comment-content-footer\">"+
                    "<span class=\"comment-content-footer-id\">#"+comment['id']+"</span>"+ "<span class=\"comment-content-footer-device\">来自Web端</span>"+
                    "<span class=\"comment-content-footer-timestamp\">"+comment['sendTime']+"</span>"+
                    "</p></div><div class=\"cls\"></div></div>";
            })
            document.getElementById("commentList").innerHTML = commentStr;
        }
    </script>
</div>


</body>
</html>
