<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Reading Station 在线阅读网站</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="shortcut icon" type="image/ico" href="/favicon.ico" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <!-- 引入css -->
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/common.css">
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/search.css">
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/common.css">

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
                </li>

            </ul>
        </div>
    </div>
</div>

    <!-- 主体模块 -->
    <div class="w main">
        <!-- 左模块 -->
        <div class=" fl main_l">
            <!-- 左边上模块 -->
            <div class="main_l_t">
                <div class="main_l_t_t">
                    人气榜单
                </div>

                <ul>
                    <li><a href="#">· 百度热搜榜</a></li>
                </ul>
            </div>
            <!-- 左下模块 -->
            <div class="main_l_l">
                <div class="main_l_l_t">
                    站内榜单
                </div>

                <ul>
                    <li><a href="#">总点击</a></li>
                </ul>
            </div>
        </div>

        <!-- 右模块 -->
        <div class="fr main_r">
            <!-- 搜索结果模块 -->
            <div class="main_r_t">
                <span>搜索结果</span>
            </div>
            <!-- 搜索内容模块 -->
            <div class="main_r_l" th:each="book,bookStat:${searchResult}" id="searchResult">

                <script>
                    //获取url参数,r[2]是值
                    let reg = new RegExp('(^|&)' + 'searchContent' + '=([^&]*)(&|$)')
                    let r = window.location.search.substr(1).match(reg)
                    window.onload = function(){
                        $.ajax({
                            url: "http://localhost:9000/Book/getByName?bookName="+r[2],
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
                    function showData(data) {
                        data.forEach((book)=>{
                            //str += "<li><span style=\"margin-left: 20px\">"+book['bookName']+"</span><span style=\"margin-left: 35%\">"+book['uploaderAccount']+"</span><span style=\"margin-left: 35%\">"+book['uploadTime']+"</span></li>";
                            // document.getElementById("bookName").innerHTML = book['bookName'];
                            // document.getElementById("author").innerHTML = book['uploaderAccount'];

                            str +="<div style='height: 40px'></div>"+
                                "<div class=\"main_r_l\" style='margin-top: -40px'>"+
                                "<a ><img src=\"/static/css/indexWeb/statics/images/nocover.jpg\" alt=\"\"></a>"+"<div class=\"main_r_l_m\">"+
                                "<div class=\"main_r_l_m\">"+
                                "<div class=\"main_r_l_m_1\">"+"<div class=\"main_r_l_m_1_s1\"> <span th:class='bg_red'} ></span> <a >"+book['bookName']+"</a> </div>"+
                                "<span class=\"main_r_l_m_1_s2\">上传者: <a >"+book['uploaderAccount']+"</a> <span>分类：</span> <a >书籍</a> </span>"+
                                "<span class=\"main_r_l_m_1_s3\" >159人在读</span>"+"</div>"+"<span class=\"display_left\"></span>"+
                                "<div class=\"main_r_l_m_3\"><span>最新更新：<a ></a></span></div>"+"</div>"+
                                "<div class=\"main_r_l_r\" style='margin-top: -80px'><a href='book?bookName="+book['bookName']+"'>立即阅读</a></div>"+"</div>"+"</div>";
                            document.getElementById("searchResult").innerHTML = str;
                        })

                    }
                </script>


            </div>

        </div>

    </div>

    <!-- 最底部模块模版   -->
    <footer th:replace="~{./template/footer.html}"></footer>
</body>

</html>