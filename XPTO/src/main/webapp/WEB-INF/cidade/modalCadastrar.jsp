<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modalCadastrar" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-cidade" method="post">
				<div class="modal-header">
				<h4 class="modal-title">Informações da Cidade</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					
				</div>
				<div class="modal-body">
					<label for="nome">Nome: </label> <input id="nome"
						name="nome" class="form-control"> 
						<label for="idIBGE">idIBGE: </label> <input id="idIBGE"
						name="idIBGE" class="idIBGE form-control" style="display: inline-block" placeholder="100"> 
						
						<label for="uf">UF: </label> <input id="uf"
						name="uf" class="uf form-control" style="display: inline-block" placeholder="SP">
						
						<label for="capital">capital: </label> <input id="capital"
						name="capital" class="capital form-control" style="display: inline-block" placeholder="TRUE">
						
						<label for="longitude">longitude: </label> <input id="longitude"
						name="longitude" class="longitude form-control" style="display: inline-block" >
						
						<label for="latitude">latitude: </label> <input id="latitude"
						name="latitude" class="latitude form-control" style="display: inline-block">
						
						<label for="nomeSemAcentos">Nome Sem Acentos: </label> <input id="nomeSemAcentos"
						name="nomeSemAcentos" class="nomeSemAcentos form-control" style="display: inline-block" >
						
						<label for="nomeAlternativo">Nome Alternativo: </label> <input id="nomeAlternativo"
						name="nomeAlternativo" class="nomeAlternativo form-control" style="display: inline-block">
						
						<label for="microRegiao">microRegiao: </label> <input id="microRegiao"
						name="microRegiao" class="microRegiao form-control" style="display: inline-block">
						
						<label for="mesoRegiao">mesoRegiao: </label> <input id="mesoRegiao"
						name="mesoRegiao" class="mesoRegiao form-control" style="display: inline-block" >
				

					<input id="idCidade" name="idCidade" type="hidden"> <input id="csrf"
						name="_csrf" type="hidden" value="${_csrf.token}">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button id="btn-salvar" type="button" class="btn btn-success">Salvar</button>
				</div>
			</form>
		</div>
	</div>
</div>