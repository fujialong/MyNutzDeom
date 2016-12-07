<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/1
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<body>
<form action="${base}/mynutzdeom/uploadController/file/upload/image" enctype="multipart/form-data" method="post">
    选择一个文件:
    <input type="file" name="filedate"/>
    <br/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
