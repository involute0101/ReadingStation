<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title>文件上传页面</title>
</head>
<body>
<h1>文件上传页面</h1>
<form id="fileUploadForm" name="fileUploadForm" method="post" action="/upload" enctype="multipart/form-data" onsubmit="return onSubmit()">
    选择要上传的文件：<input type="file" name="file"><br>
    <hr>
    <input id="userAccount" name="userAccount" type="hidden" value="">
    <textarea id="description" name="description" form="fileUploadForm" cols="80" rows="5" placeholder="对上传的书籍做个简介吧~"></textarea>
    <input id="submitButton" type="submit" value="提交">
</form>
<script>
    function onSubmit() {
        var startIndex = document.cookie.indexOf("id=")
        var idString;
        if(document.cookie.indexOf(";")==-1){
            idString = document.cookie.substring(startIndex,document.cookie.length)
        }else{
            idString = document.cookie.substring(startIndex,document.cookie.indexOf(";"))
        }
        var id = document.cookie.substring(idString.indexOf("=")+1,idString.length);
        document.getElementById("userAccount").setAttribute("value",id)
        if(document.getElementById("description").value==""){
            alert("请输入书籍简介噢~")
            return false;
        }
        if (document.getElementById("userAccount").getAttribute("value")==""){
            alert("请先登录！")
            return false;
        }
        else{
            alert("成功上传"+document.forms["fileUploadForm"]["file"].value+"文件！")
            return true;
        }

    }

</script>
</body>
</html>