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
	<table id="tabela-produtos" class="display" style="width: 50%">

		<thead>
			<tr>
				<th>Classificação</th>
				<th>Estado</th>
				<th>Quantidade de municipios</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>Estado com menos Cidades</td>
				<td>${ufMenosCidades }</td>
				<td>${menorNumero }</td>
			</tr>
			<tr>
				<td>Estado com menos Cidades</td>
				<td>${ufMaisCidades }</td>
				<td>${maiorNumero }</td>
			</tr>
		</tbody>

		<tfoot>
			<tr>
				<th>Classificação</th>
				<th>Estado</th>
				<th>Quantidade de municipios</th>
			</tr>
		</tfoot>

	</table>

</body>
</html>