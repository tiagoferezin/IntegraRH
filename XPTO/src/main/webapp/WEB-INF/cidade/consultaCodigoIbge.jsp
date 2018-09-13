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
<title>Consultar codigo ibge</title>
<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
</head>
<body>

	<c:if test="${not empty mensagemErro }">

Codigo inserido não existe.

	</c:if>


	<form action="${path }/app/cidade/cidadeDoIbge/idIBGE">
		<input type="text" name="idIBGE" class="inputCod" />
		<button id="btn-Pesquisar">Pesquisar</button>
	</form>


	<script type="text/javascript">
		$(document).ready(function() {

			$('#btn-Pesquisar').click(function() {
				var idIBGE = $('.inputCod').val();
				var url = "cidadeDoIbge/" + idIBGE;
				
				$.get(url);
			});

		});
	</script>
</body>
</html>