
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
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
    <h1>Sign up</h1>
    <form action="<%=request.getContextPath()%>/signup" method="post">
        <table style="with: 100%">
            <tr>
                <td>Login</td>
                <td><input required type="text" name="login" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input required type="password" name="password" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input required type="email" name="email" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit"/>
    </form>
</div>
</body>
</html>
