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
	<table id="tabela-cidades" class="display" style="width: 100%">

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
				<th>Deletar</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${listaCidades }" var="cidade">
				<tr data-id="${cidade.idCidade }">
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
					<td><button type="button"
						class="btn btn-danger btn-deletar-tabela">Deletar</button></td>
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
				<th>Deletar</th>
			</tr>

<tr>
			<td colspan="8">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modalCadastrar" style="float: right;">Cadastrar
					Cidade </button>
			</td>
		</tr>
		</tfoot>

	</table>

<script type="text/javascript" src="${path}/static/js/cidade.js"></script>

</body>
</html>