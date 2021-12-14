<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Reading Station 在线阅读网站</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <link rel="shortcut icon" type="image/ico" href="/static/css/indexWeb/favicon.ico" />
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
    <!-- 引入index.css样式 -->
    <!-- 引入css -->
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/common.css" href="/static/css/indexWeb/statics/css/common.css">
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/index.css" href="/static/css/indexWeb/statics/css/index.css">
    <link rel="stylesheet" href="/static/css/indexWeb/statics/css/search.css" href="/static/css/indexWeb/statics/css/search.css">


    <script src="/static/css/indexWeb/statics/js/common.js"></script>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery_lazyload/1.9.7/jquery.lazyload.js"></script>
    <script>
        $("img").lazyload({
            effect: "fadeIn"
        });
    </script>
</head>

<body>
<!-- 头部模块模版  -->
<%--<div th:replace="/static/template/head.html">--%>
<%--    <iframe align="center" width="100%" src="/static/template/head.html" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no"></iframe>--%>
<%--</div>--%>

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



<!-- 主体模块 -->
<div class=" w main" style="margin-top: 80px">
    <!-- 第一模块 -->
    <!-- 1-1左模块 -->
    <div class="fl main_1">
        <div class="main_1_l">
            <div class="main_1_l_t">作品分类</div>
<%--            <ul>--%>
<%--                <li th:each="book,bookStat:${bookType}" th:value="${book}">--%>
<%--                    <a href="/category" th:href="|/category/|+${typeMap.get(__${bookStat.index}__)}">--%>
<%--                        <span th:text="${book}"></span>--%>
<%--                        <span th:text="${booksCount.get(__${bookStat.index}__)}">0</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--            </ul>--%>
        </div>
    </div>
    <!-- 1-2中模块 -->
    <div class=" fl main_1_m">
        <div class="main_1_m_t">
            <ul>
                <li>
                    <a href=""><img src="/static/css/indexWeb/statics/images/1.jpg" alt=""></a>
                </li>
            </ul>
            <div class="main_1_m_t_b"><span>新闻公告</span> <a href="#" class="fr">更多 +</a></div>
        </div>
    </div>

    <!-- 1-3右模块 -->
    <div class=" fr">
        <div class="main_1_r">
            <div class="main_1_r_t">新书推荐</div>
            <ul>
<%--                <li th:each="book:${booksRecommend}">--%>
<%--                    <a th:href="|./book/detail/|+${book.getId()}">--%>
<%--                        <span th:text="${book.getBooktype()}">[类型]</span>--%>
<%--                        <span th:text="${book.getName()}">书名</span>--%>
<%--                    </a>--%>
<%--                </li>--%>
            </ul>
        </div>
    </div>

    <!-- 第二模块 -->
    <div class=" w main_2">
        <!-- 2-1左模块 -->
        <div class=" fl main_2_l">
            <div class="main_2_l_t">站长推荐</div>
            <ul>
                <li th:each="book:${books.get('xuanhuan')}">
                    <a href="#" th:href="|./book/detail/|+${book.getId()}">
                        <img th:data-original="/static/css/indexWeb/statics/images/nocover.jpg" src="/static/css/indexWeb/statics/images/nocover.jpg" alt=""></a>
                    <div class="main_2_l_r">
                            <span>
                                <a href="#" th:href="|./book/detail/|+${book.getId()}" th:text="${book.getName()}"></a>
                            </span>
                        <span>
                                <strong>作者:</strong>
                                <a href="#" th:href="|./book/detail/|+${book.getId()}" th:text="${book.getAuthor()}"> </a>
                            </span>
                        <span></span>
                        <span><a href="#" th:href="|./book/detail/|+${book.getId()}">前往阅读 >></a></span>
                    </div>
                </li>
            </ul>
        </div>

        <!-- 2-2右模块 -->
        <div class=" fr main_2_r">
            <div class="main_2_r_t">
                <span>周点击</span>
                <span>月点击</span>
            </div>
            <ul>
                <li th:each="book,bookStat:${viewTop}">
                    <span th:class="${bookStat.index<3?'bg_red':'bg_grey'}" th:text="${bookStat.count}">1</span>
                    <a th:href="|./book/detail/|+${book.getId()}" class="a_1" th:text="${book.getName()}"></a>
                    <a th:href="|./book/detail/|+${book.getId()}" class="a_2" th:text="${book.getAuthor()}"></a>
                </li>
            </ul>
        </div>
    </div>
    <!-- 第三模块 -->
    <div class=" w main_3">
        <!-- 3-1左模块 -->
        <div class="fl main_3_l">
            <div class="fl main_3_l_a" th:each="type,typeStat:${bookType}">
                <div class="main_3_l_t">
                    <span></span>
<%--                    <a href="#" th:href="|/category/|+${typeMap.get(__${typeStat.index}__)}">--%>
<%--                        <strong th:text="${type}">玄幻</strong>--%>
<%--                    </a>--%>
                </div>
                <div class="main_3_l_m" th:each="book,bookStat:${books.get(typeMap.get(typeStat.index))}" th:if="${bookStat.index==0}">
                    <a href="#" th:href="|./book/detail/|+${book.getId()}">
                        <img th:data-original="/static/css/indexWeb/statics/images/nocover.jpg" src="/static/css/indexWeb/statics/images/nocover.jpg" alt="">
                    </a>
                    <div class="main_3_l_m_1">
                        <div class="main_3_l_m_1_1">
                            <a href="#" th:href="|./book/detail/|+${book.getId()}" th:text="${book.getName()}">书名</a>
                        </div>
                        <div class="main_3_l_m_1_2" th:text="${book.getInfo()}">书籍介绍</div>
                        <div>
                            <a href="#" class="main_3_l_m_1_3" th:href="|./book/detail/|+${book.getId()}" th:text="${book.getAuthor()}">作者</a>
                        </div>
                    </div>
                </div>
                <div class="main_3_l_l" th:each="book,bookStat:${books.get(typeMap.get(typeStat.index))}" th:if="${bookStat.index>=1&&bookStat.index<5}">
                    <a href="#" th:href="|/book/detail/|+${book.getId()}" th:text="${book.getName()}">书名</a>
                    <a href="#" th:href="|/book/detail/|+${book.getId()}" th:text="${book.getAuthor()}">作者</a>
                </div>
            </div>
        </div>

    </div>



</div>

<!-- 第四模块 -->
<div class="w main_4">
    <!-- 4-1左模块 -->
    <div class="fl main_4_l">
        <div class="main_2_l_t">最新更新</div>

        <table width="100%" id="Books"></table>

        <script>
            window.onload = function(){
                $.ajax({
                    url: "http://localhost:9000/Book/all",
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
            str+="<tr> <th>书名</th> <th>上传者</th> <th>上传时间</th> </tr>";
            function showData(data) {
                data.forEach((book)=>{
                    str += "<tr> <td width=\"33%\" align=\"center\">"+book['bookName']+"</td> <td width=\"33%\" align=\"center\">"+book['uploaderAccount']+"</td> <td width=\"33%\" align=\"center\">"+book['uploadTime']+"</td> </tr>";
                    document.getElementById("Books").innerHTML = str;
                })

            }
        </script>
    </div>

</div>

<!-- 最底部模块模版   -->
<footer th:replace="/static/template/footer.html"></footer>

</body>

</html>