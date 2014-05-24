<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="message" items="${messageList}">
  <div class="message">
    <div>${message.user.name }</div><div>${message.content}</div>
  </div>
</c:forEach>