<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
  <caption>
    <c:choose>
      <c:when test="${aluno != null}">
        Edição
      </c:when>
      <c:otherwise>
        Cadastro
      </c:otherwise>
    </c:choose>
  </caption>
  <c:if test="${aluno != null}">
    <input type="hidden" name="id" value="${aluno.id}" />
  </c:if>
  <tr>
    <td><label for="nome">Nome</label></td>
    <td><input type="text" id="nome" name="nome" size="45"
               required value="${aluno.nome}" /></td>
  </tr>
  <tr>
    <td><label for="sobrenome">Sobrenome</label></td>
    <td><input type="text" id="sobrenome" name="sobrenome" size="45" required
               value="${aluno.sobrenome}" /></td>
  </tr>
  <tr>
    <td><label for="classe">Classe</label></td>
    <td><select id="classe" name="classe">
      <c:forEach items="${classes}" var="classe">
        <option value="${classe.key}"
          ${aluno.classe.nome==classe.value ? 'selected' : '' }>
            ${classe.value}</option>
      </c:forEach>
    </select></td>
  </tr>
  <tr>
    <td><label for="ano_nasc">Ano Nascimento</label></td>
    <td><input type="number" id="ano_nasc" name="ano_nasc" size="5" required
               min="1500" value="${aluno.ano_nasc}" /></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input type="submit" value="Salva" /></td>
  </tr>
</table>