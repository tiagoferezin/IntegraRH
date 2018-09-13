<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
<title>Insert title here</title>
</head>
<body>

	<br>

	<br>
	<table id="tabela-produtos" class="display" style="width: 100%">

		<thead>
			<tr>

				<th>UF</th>
				<th>Nome</th>

			</tr>
		</thead>

		<tbody>

			<c:forEach items="${listaCidadesDoEstado }" var="cidade">
				<tr>

					<td>${cidade.uf }</td>
					<td>${cidade.nome }</td>

				</tr>
			</c:forEach>
		</tbody>

		<tfoot>

			<tr>

				<th>UF</th>
				<th>Nome</th>

			</tr>

		</tfoot>

	</table>

</body>
</html>