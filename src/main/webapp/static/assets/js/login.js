
var identity;
var loginUrl = "http://localhost:9000/user/userLogin";
// var loginUrl = "http://172.25.154.37:8080/student/login";
var urlArr = loginUrl.split('/');
var newUrl;

function selectIdentity(o)
{
	if(o==0)
	{
        identity = "student";
		document.getElementById("student").style.display="block";
		document.getElementById("admin").style.display="none";
	}else if(o==1) {
        identity = "admin";
		document.getElementById("student").style.display="none";
		document.getElementById("admin").style.display="block";
	}

    newUrl = urlArr[0]+"//"+urlArr[2]+"/"+identity+"/"+urlArr[4];
    document.getElementById("myForm").action = newUrl;
}

function login()
{
    var name=document.getElementById("form-username").value;
    var password=document.getElementById("form-password").value;
    var xmlhttp;

    document.cookie = "id=" + escape(name)

    if (window.XMLHttpRequest) {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    } else {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            if(xmlhttp.responseText.indexOf("invalid user")>=0){
                alert("账号或密码有误呀...");
                window.location.href=loginUrl;
            }else{
                var mainUrl = urlArr[0]+"//"+urlArr[2]+"/"+identity+"/index";
                window.location.href=mainUrl;
            }
        }
    };

    xmlhttp.open("POST",newUrl,true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("account="+name+"&password="+password);
}
