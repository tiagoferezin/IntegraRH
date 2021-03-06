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
<title>Estados com mais e menos cidades</title>
</head>
<body>

	<br>
	<br>
	<table id="tabela-produtos" class="display" style="width: 30%">

		<thead>
			<tr>
				
				<th>Estado</th>
				<th>Quantidade de municipios</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${mapCidadesEstado }" var="estado">
			<tr>
				
				<td>${estado.key }</td>
				<td>${estado.value }</td>
			</tr>
			</c:forEach>
		</tbody>

		<tfoot>
			<tr>
				
				<th>Estado</th>
				<th>Quantidade de municipios</th>
			</tr>
		</tfoot>

	</table>

</body>
</html>