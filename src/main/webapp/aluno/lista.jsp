<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Escola Virtual</title>
</head>
<body>

<div align="center">
    <h1>Gerenciamento de Alunos</h1>
    <h2>
        <a href="/${requestScope.contextPath}">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a
            href="/${requestScope.contextPath}/alunos/cadastro">Adicione Novo Aluno</a>
    </h2>
</div>

<div align="center">
    <table border="1">
        <caption>Lista de Alunos</caption>
        <tr>
            <th>ID</th>
            <th>Nomes</th>
            <th>Sobrenome</th>
            <th>Classe</th>
            <th>PCD</th>
            <th>Ano Nascimento</th>
            <th>Cursando</th>
            <th>Acões</th>
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
                <td><a href="/${requestScope.contextPath}/alunos/edicao?id=${aluno.id}">Edição</a>
                    &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="/${requestScope.contextPath}/alunos/remocao?id=${aluno.id}"
                            onclick="return confirm('Tem certeza de que deseja excluir este item?');">
                        Remoção </a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
