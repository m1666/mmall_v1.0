<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>

<body>
<div id="login_frame">
    <form method="post" action="/user/login.do">
        <p><label>用户名</label><input type="text" id="username" name="username"/></p>
        <p><label>密码</label><input type="password" id="password" name="password"/></p>
        <input type="submit" value="登陆">
    </form>
</div>

</body>