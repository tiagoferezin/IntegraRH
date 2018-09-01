/**
 * 
 */
package xpto.factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import xpto.model.entity.Cidade;
import xpto.model.repositories.CidadeRepositorio;

/**
 * @author Tiago Ferezin Data: 01/09/2018
 */
public class ArquivoFactory {

	public static List<Cidade> gerarArquivo(CidadeRepositorio cidadeRepositorio)
			throws IOException {
		List<Cidade> retorno = new ArrayList<Cidade>();
		Cidade cidade = new Cidade();

		String csvArquivo = "cidades.csv";

		BufferedReader conteudoCSV = null;

		String linha = "";

		String separador = ",";

		conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
		String[] atributo = null;
		while ((linha = conteudoCSV.readLine()) != null) {

			atributo = linha.split(separador);
			// System.out.println(atributo[0]);
			// System.out.println(atributo[1]);
			// System.out.println(atributo[2]);
			// System.out.println(atributo[3]);
			// System.out.println(atributo[4]);
			// System.out.println(atributo[5]);
			// System.out.println(atributo[6]);
			// System.out.println(atributo[7]);
			// System.out.println(atributo[8]);
			// System.out.println(atributo[9]);
			if (!atributo[0].equals("ibge_id")) {

				cidade = new Cidade();
				Long idIBGE = Long.parseLong(atributo[0]);
				cidade = cidadeRepositorio.getCidadePorIdIBGE(idIBGE);
				if (cidade == null) {
					cidade = new Cidade();

					cidade.setIdIBGE(idIBGE);
					cidade.setUf(atributo[1]);
					cidade.setNome(atributo[2]);
					cidade.setCapital(Boolean.valueOf(atributo[3]));
					cidade.setLongitude(atributo[4]);
					cidade.setLatitude(atributo[5]);
					cidade.setNomeSemAcentos(atributo[6]);
					cidade.setNomeAlternativo(atributo[7]);
					cidade.setMicroRegiao(atributo[8]);
					cidade.setMesoRegiao(atributo[9]);
					cidadeRepositorio.save(cidade);
				}
				retorno.add(cidade);

			}
		}

		System.out.println(atributo);

		return retorno;

	}

}
