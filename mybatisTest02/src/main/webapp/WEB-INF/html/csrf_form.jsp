<%--
  Created by IntelliJ IDEA.
  User: Thinkpad
  Date: 2020/7/9
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CSRF FORM</title>
    <form action="./commit" method="post" >
        <p>
            名称：<input id="name" name="name" type="text" value="" />
        </p>
        <p>
            描述：<input id="describe" name="describe" type="text" value="" >
        </p>
        <p>
            <input type="submit" value="提交">
        </p>
        <input type="hidden" id="${_csrf.parameterName}"
            name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
</head>
<body>

</body>
</html>
