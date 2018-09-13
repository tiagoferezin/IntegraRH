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
<title>Capitais Ordanadas</title>
</head>
<body>
	<br>
	<br>
	<table id="tabela-capitais" class="display" style="width: 100%">

		<thead>
			<tr>
				<th>Ibge_id</th>
				<th>UF</th>
				<th>Nome</th>
				<th>Capital</th>
				<th>Longitude</th>
				<th>Latitude</th>
				<th>no_accents</th>
				<th>Nome_Alternativo</th>
				<th>Microregion</th>
				<th>Mesoregion</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${capitaisOrdenadas }" var="cidade">
				<tr>
					<td>${cidade.idIBGE }</td>
					<td>${cidade.uf }</td>
					<td>${cidade.nome }</td>
					<td>${cidade.capital }</td>
					<td>${cidade.longitude }</td>
					<td>${cidade.latitude }</td>
					<td>${cidade.nomeSemAcentos }</td>
					<td>${cidade.nomeAlternativo }</td>
					<td>${cidade.microRegiao }</td>
					<td>${cidade.mesoRegiao }</td>
				</tr>
			</c:forEach>
		</tbody>

		<tfoot>

			<tr>
				<th>Ibge_id</th>
				<th>UF</th>
				<th>Nome</th>
				<th>Capital</th>
				<th>Longitude</th>
				<th>Latitude</th>
				<th>no_accents</th>
				<th>Nome_Alternativo</th>
				<th>Microregion</th>
				<th>Mesoregion</th>
			</tr>

		</tfoot>

	</table>
</body>
</html>