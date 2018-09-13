/**
 * 
 */

$(document).ready(function() {

	aplicarListaners();
	

});

var aplicarListaners = function() {
	
	$('#tabela-produtos').DataTable({
		dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
	});

	$('.btn-deletar-tabela').click(function() {
		
		var idCidade = $('.btn-deletar-tabela').parents('tr').data('id');

		$.ajax({
			url : "cidade/" + idCidade,
			type : 'DELETE',
			success : function(result) {
			
				$('tr[data-id="' + idCidade + '"]').remove();
			}
		});

		
	});

	$('#btn-salvar').click(function() {

		var url = "cidade";
		var dadosCidade = $('#form-cidade').serialize();

		$.post(url, dadosCidade).done(function(pagina) {

			$('#secao-cidades').html(pagina);
			aplicarListaners();

		}).fail(function() {
			alert('Erro ao salvar');
		}).always(function() {
			$('#modalCadastrar').modal('hide');
		});

	});

};