/**
 * 
 */
package xpto.model.entity.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xpto.factory.CalculoDistanciaFactory;
import xpto.model.entity.Cidade;
import xpto.model.repositories.CidadeRepositorio;

/**
 * @author Tiago Ferezin Data: 03/09/2018
 */
public class CidadeFactory {

	public Map<Integer, String> getEstadoQuantidade(
			CidadeRepositorio cidadeRepositorio) {
		Map<Integer, String> retorno = new HashMap<Integer, String>();

		Map<String, Integer> mapEstado = new HashMap<String, Integer>();

		mapEstado = getQuantidadeCidadePorEstado(cidadeRepositorio);

		Integer qtdMaiorRegistro = 0;
		Integer qtdMenorRegistro = 0;
		String ufMaisRegistro = "";
		String ufMenosRegistro = "";
		for (String uf : mapEstado.keySet()) {
			Integer qtdRegistros = mapEstado.get(uf);
			if (qtdRegistros > qtdMaiorRegistro) {
				qtdMaiorRegistro = qtdRegistros;
				ufMaisRegistro = uf;
			}

			if ((qtdMenorRegistro == 0) || (qtdRegistros < qtdMenorRegistro)) {
				qtdMenorRegistro = qtdRegistros;
				ufMenosRegistro = uf;
			}

		}

		retorno.put(qtdMenorRegistro, ufMenosRegistro);
		retorno.put(qtdMaiorRegistro, ufMaisRegistro);

		return retorno;
	}

	public Map<String, Integer> getQuantidadeCidadePorEstado(
			CidadeRepositorio cidadeRepositorio) {
		Map<String, Integer> retorno = new HashMap<String, Integer>();

		List<Cidade> listaCidades = new ArrayList<Cidade>();
		listaCidades = (List<Cidade>) cidadeRepositorio.findAll();

		for (Cidade cidade : listaCidades) {
			Integer quantidade = 0;

			String uf = cidade.getUf();

			if (retorno.containsKey(uf)) {
				Integer qtdRegistrado = retorno.get(uf);
				quantidade = qtdRegistrado + 1;
				retorno.replace(uf, quantidade);
			} else {
				retorno.put(uf, quantidade + 1);
			}

		}
		return retorno;
	}

	public Map<List<Cidade>, Double> retornaDuasCidadesMaisDistantes(
			List<Cidade> listaCidades) {
		Map<List<Cidade>, Double> retorno = new HashMap<List<Cidade>, Double>();
		List<Cidade> cidadesDistantes = new ArrayList<Cidade>();

		Double distanciaMaior = 0D;
		CalculoDistanciaFactory cdf = new CalculoDistanciaFactory();
		for (Cidade cidade : listaCidades) {

			String lat1 = cidade.getLatitude();
			String long1 = cidade.getLongitude();

			for (int i = 0; i < listaCidades.size(); i++) {
				Cidade cidadeComparacao = new Cidade();
				cidadeComparacao = listaCidades.get(i);
				if (cidadeComparacao.getIdCidade() != cidade.getIdCidade()) {

					String lat2 = cidadeComparacao.getLatitude();
					String long2 = cidadeComparacao.getLongitude();

					Double distancia = 0D;
					distancia = cdf.distanciaEmKM(lat1, long1, lat2, long2);

					if (distancia > distanciaMaior) {
						if (cidadesDistantes.size() > 0) {
							cidadesDistantes.clear();
						}

						cidadesDistantes.add(0, cidade);
						cidadesDistantes.add(1, cidadeComparacao);
					}

				}
			}

		}
		
		retorno.put(cidadesDistantes, distanciaMaior);

		return retorno;
	}

}
