<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>강의 목록</title>
</head>

<style>
    table {
        width : 70%;
        margin: auto;
    }

    table, td, th{
        border-collapse: collapse;
        border : 1px solid black;
    }

    th, td{
        text-align: center;
    }

    div {
        text-align : center;
    }
</style>

<body>
<form method="post">
    <table>
        <tr>
            <th>아이디</th>
            <th>선생님 이름</th>
            <th>강의 이름</th>
            <th>등록 날짜</th>
        </tr>
        <c:forEach var="item"  items="${courseRepositoryList}">
            <tr>
                <td>${item.getId()}</td>
                <td>${item.getTeacher().getName()}</td>
                <td>${item.getSubject().getName()}</td>
                <td>${item.getTimestamp()}</td>
            </tr>
        </c:forEach>
    </table>
</form>
<form method="get" action="/register">
    <input type="submit" value="강의 추가">
</form>

<form method="get" action="/update">
    <input type="submit" value="강의 수정">
</form>

<form method="get" action="/delete">
    <input type="submit" value="강의 삭제">
</form>
<br />

</body>
<br />
<a href="/logout">로그아웃</a><br />
</html>
