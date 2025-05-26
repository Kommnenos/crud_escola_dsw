<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${param.lang}" scope="session"/>
<fmt:setBundle basename="message"/>

<html>
<head>
    <title><fmt:message key="lista.head"/> </title>
</head>
<body>

<div align="center">
    <h1>Gerenciamento de Alunos</h1>
    <h2>
        <a href="/${requestScope.contextPath}"><fmt:message key="lista.mainmenu"/> </a> &nbsp;&nbsp;&nbsp; <a
            href="/${requestScope.contextPath}/alunos/cadastro"><fmt:message key="lista.addnew"/> </a>
    </h2>
</div>
<script>
    const confirma_deleta = '<fmt:message key="lista.areyousure"/>';
</script>

<div align="center">
    <table border="1">
        <caption><fmt:message key="lista.caption" /></caption>
        <tr>
            <th>ID</th>
            <th><fmt:message key="lista.name"/> </th>
            <th><fmt:message key="lista.surname"/></th>
            <th><fmt:message key="lista.classname"/></th>
            <th><fmt:message key="lista.pcd"/></th>
            <th><fmt:message key="lista.birthyr"/></th>
            <th><fmt:message key="lista.cursando"/></th>
            <th><fmt:message key="lista.actions"/></th>
        </tr>
        <c:forEach var="aluno" items="${requestScope.listaAlunos}">
            <tr>
                <td>${aluno.id}</td>
                <td>${aluno.nome}</td>
                <td>${aluno.sobrenome}</td>
                <td>${aluno.classe.nome}</td>
                <td>${aluno.pcd}</td>
                <td>${aluno.ano_nasc}</td>
                <td>${aluno.cursando}</td>
                <td><a href="/${requestScope.contextPath}/alunos/edicao?id=${aluno.id}"><fmt:message key="lista.edit" /></a>
                    &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="/${requestScope.contextPath}/alunos/remocao?id=${aluno.id}"
                            onclick="return confirm(confirma_deleta);">
                        <fmt:message key="lista.delete"/> </a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <a href="?lang=en">English</a> |
    <a href="?lang=pt">Português</a>
</div>

</body>
</html>
