
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
    <style>
        body {
            line-height: 1.5;
            font-family: 'Segoe UI', sans-serif;
        }
        .container {
            display: grid;
            place-items: center;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Log in</h1>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <table style="with: 100%">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>
    <a href="<%=request.getContextPath()%>/signup">Sign in</a>
</div>
</body>
</html>
