<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8" />
    <title>文件上传页面</title>
</head>
<body>
<h1>文件上传页面</h1>
<form name="fileUploadForm" method="post" action="/upload" enctype="multipart/form-data" onsubmit="onSubmit()">
    选择要上传的文件：<input type="file" name="file"><br>
    <hr>
    <input type="submit" value="提交">
</form>
<script>
    function onSubmit() {
        alert("成功上传"+document.forms["fileUploadForm"]["file"].value+"文件！")
    }

</script>
</body>
</html>