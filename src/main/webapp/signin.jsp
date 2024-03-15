
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
    <h1>Sign in</h1>
    <form action="<%=request.getContextPath()%>/signin" method="post">
        <table style="with: 100%">
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>
