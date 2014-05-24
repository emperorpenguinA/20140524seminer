<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="content/css/style.css" type="text/css"/>
<title>MyPage</title>
</head>
<body>
<div class="area">
  <div class="userArea">
    <div class="welcome">
      ようこそ${user.name}
    </div>
    <div class="profileArea">
      <table>
        <tr>
          <th>年齢</th><td>${user.age}</td>
        </tr>
        <tr>
          <th>性別</th>
          <td>
            <c:choose>
              <c:when test="${user.gender == '0'}">女性</c:when>
              <c:when test="${user.gender == '1'}">男性</c:when>
            </c:choose>
          </td>
        </tr>
        <tr>
          <th>出身地</th><td>${user.hometown}</td>
        </tr>
      </table>
    </div>
 </div>
 <div class="messageArea">
    <div class="insertArea">
      <textarea name="content" class="insert"></textarea><br/>
      <input type="button" name="insert" value="投稿" class="insert"/>
    </div>
    <div class="listArea">
      <c:import url="/WEB-INF/page/listArea.jsp"/>
    </div>
  </div>
</div>
</body>
</html>