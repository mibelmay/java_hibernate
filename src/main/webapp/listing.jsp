<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Directory</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
        }
        img{
            height: 24px;
            width: 24px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        .logout {
            position: absolute;
            top: 30px;
            right: 20px;
        }
    </style>
</head>
<body>
<p>Дата: ${date}</p>
<h2>${path}</h2>

<form method="post" action="listing">
    <button class="logout" type="submit">Log out</button>
</form>

<hr/>
<c:url value="" var="upUrl">
    <c:param name="path" value="${parentDirPath}"/>
</c:url>
<a href="${upUrl}">Вверх</a>
<table>
    <thead>
    <tr>
        <th></th>
        <th>Имя</th>
        <th>Размер</th>
        <th>Дата изменения</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="file" items="${files}">
        <tr>
            <td>
            <c:if test="${file.isDirectory() == true}">
                <img src="folder.png" alt=""/>
            </c:if>
                <c:if test="${file.isDirectory() == false}">
                    <img src="file.png" alt=""/>
                </c:if>
            </td>
            <td>
                <c:if test="${file.isDirectory() == true}">
                    <c:url value="" var="downUrl">
                        <c:param name="path" value="${file.path()}"/>
                    </c:url>
                    <a href="${downUrl}">${file.name()}</a>
                </c:if>
                <c:if test="${file.isDirectory() == false}">
                    <c:url value="download" var="loadUrl">
                        <c:param name="path" value="${file.path()}"/>
                    </c:url>
                    <a href="${loadUrl}">${file.name()}</a>
                </c:if>
            </td>
            <td>${file.size()}</td>
            <td>${file.lastModified()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>