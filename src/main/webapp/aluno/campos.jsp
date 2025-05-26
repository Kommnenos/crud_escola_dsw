<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${param.lang}" scope="session"/>
<fmt:setBundle basename="message"/>
<table border="1">
  <caption>
    <c:choose>
      <c:when test="${aluno != null}">
        <fmt:message key="field.edit"/>
      </c:when>
      <c:otherwise>
        <fmt:message key="field.register"/>
      </c:otherwise>
    </c:choose>
  </caption>
  <c:if test="${aluno != null}">
    <input type="hidden" name="id" value="${aluno.id}" />
  </c:if>
  <tr>
    <td><label for="nome"><fmt:message key="lista.name"/> </label></td>
    <td><input type="text" id="nome" name="nome" size="45"
               required value="${aluno.nome}" /></td>
  </tr>
  <tr>
    <td><label for="sobrenome"><fmt:message key="lista.surname"/> </label></td>
    <td><input type="text" id="sobrenome" name="sobrenome" size="45" required
               value="${aluno.sobrenome}" /></td>
  </tr>
  <tr>
    <td><label for="pcd"><fmt:message key="lista.pcd"/> </label></td>
    <td><select id="pcd" name="pcd" required>
      <option value="true" ${aluno.pcd ? 'selected' : ''}>true</option>
      <option value="false" ${!aluno.pcd ? 'selected' : ''}>false</option>
    </select></td>
  </tr>
  <tr>
    <td><label for="classe"><fmt:message key="lista.class"/> </label></td>
    <td><select id="classe" name="classe_id" required>
      <c:forEach items="${requestScope.classes}" var="classe">
        <option value="${classe.key}" ${aluno.classe.id == classe.key ? 'selected' : ''}>
            ${classe.value}
        </option>
      </c:forEach>
    </select></td>
  </tr>

  <tr>
    <td><label for="ano_nasc"><fmt:message key="lista.birthyr"/> </label></td>
    <td><input type="number" id="ano_nasc" name="ano_nasc" size="5" required
               min="1500" value="${aluno.ano_nasc}" /></td>
  </tr>

  <tr>
    <td><label for="cursando"><fmt:message key="lista.cursando"/> </label></td>
    <td><select id="cursando" name="cursando" required>
      <option value="true" ${aluno.cursando ? 'selected' : ''}>true</option>
      <option value="false" ${!aluno.cursando ? 'selected' : ''}>false</option>
    </select></td>
  </tr>
  <tr>
    <td colspan="2" align="center"><input type="submit" value="Salva" /></td>
  </tr>
</table>
