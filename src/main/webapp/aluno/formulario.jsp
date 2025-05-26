<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${param.lang}" scope="session"/>
<fmt:setBundle basename="message"/>
<html>
<head>
  <title><fmt:message key="form.title"/> </title>
</head>

<body>
<div align="center">
  <h1><fmt:message key="form.management"/> </h1>
  <h2>
    <a href="lista"><fmt:message key="form.list"/> </a>
  </h2>
</div>
<div align="center">
  <c:choose>
    <c:when test="${aluno != null}">
      <form action="atualizacao" method="post">
        <%@include file="campos.jsp"%>
      </form>
    </c:when>
    <c:otherwise>
      <form action="insercao" method="post">
        <%@include file="campos.jsp"%>
      </form>
    </c:otherwise>
  </c:choose>
</div>
<c:if test="${!empty requestScope.mensagens}">
  <ul class="erro">
    <c:forEach items="${requestScope.mensagens}" var="mensagem">
      <li>${mensagem}</li>
    </c:forEach>
  </ul>
</c:if>
<div>
  <a href="?lang=en">English</a> |
  <a href="?lang=pt">Português</a>
</div>

</body>
</html>