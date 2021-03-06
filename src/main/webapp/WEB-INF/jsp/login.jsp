<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>登录</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="/static/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/static/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="/static/assets/css/form-elements.css">
        <link rel="stylesheet" href="/static/assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/static/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/static/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/static/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="/static/assets/ico/apple-touch-icon-57-precomposed.png">
        <script src="/static/assets/js/login.js"></script>
    </head>

    <body>
    <script type="text/javascript" src="/static/css/indexWeb/statics/js/jquery.min.js"></script>
    <script type="text/javascript" src="/static/css/indexWeb/statics/js/jquery.cookie.js"></script>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Reading Station</strong></h1>
                            <div class="description">
                            	<p>
	                            	这是一个校园在线阅读系统
                                    登陆进 <a href="#"><strong>在线阅读系统</strong></a>, 你可以分享并下载图书电子资源
                            	</p>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login" style="margin-top:0px;">
                        	<h3>欢迎访问</h3>
                        	<div class="social-login-buttons">
	                        	<button class="btn btn-link-2" onclick="selectIdentity(0)">
                                    <i class="fa fa-child"></i> 登录
	                        	</button>
	                        	<button class="btn btn-link-2" onclick="window.location.href='http://localhost:9000/student/register'">
	                        		<i class="fa fa-meh-o"></i> 注册
	                        	</button>
                        	</div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>登陆Reading Station</h3>
                            		<p>输入您的账号以及密码进行登陆:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" id="myForm" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="id" placeholder="账号..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="password" placeholder="密码..." class="form-password form-control" id="form-password">
			                        </div>
			                        <button id="student" class="btn" onclick="login();" value="登陆！" style="width:100%;display:none"/>登陆!</button>
                                </form>
                                    <button id="admin" class="btn" onclick="login();" style="width:100%;display:none">登陆!</button>
                            </div>
		                            
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="/static/assets/js/jquery-1.11.1.min.js"></script>
        <script src="/static/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="/static/assets/js/jquery.backstretch.min.js"></script>
        <script src="/static/assets/js/scripts.js"></script>

        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>