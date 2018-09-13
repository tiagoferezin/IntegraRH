/**
 * 
 */
package xpto.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xpto.factory.ArquivoFactory;
import xpto.model.entity.Cidade;
import xpto.model.entity.factory.CidadeFactory;
import xpto.model.repositories.CidadeRepositorio;

/**
 * @author Tiago Ferezin Data: 03/09/2018
 */
@Controller
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	HttpServletRequest context;

	@Autowired
	CidadeRepositorio cidadeRepositorio;

	public CidadeController() {
		System.out.println("Criou Cidade Controller");
	}

	public String listaCidades(Model model) {

		List<Cidade> listaCidades = new ArrayList<Cidade>();
		listaCidades = (List<Cidade>) cidadeRepositorio.findAll();

		Integer qtdRegistros = listaCidades.size();
		model.addAttribute("qtdRegistros", qtdRegistros);
		model.addAttribute("listaCidades", listaCidades);

		return "cidade/listaCidades";
	}

	@RequestMapping("/capitaisOrdenadas")
	public String capitaisOrdenadas(Model model) {

		ArquivoFactory af = new ArquivoFactory();
		List<Cidade> listaCidades = new ArrayList<Cidade>();
		try {

			listaCidades = af.gerarArquivo(cidadeRepositorio);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Cidade> capitaisOrdenadas = cidadeRepositorio
				.capitaisOrdenadadasPorNome();

		model.addAttribute("capitaisOrdenadas", capitaisOrdenadas);

		return "cidade/capitaisOrdenadas";
	}

	@RequestMapping("/capitaisComMaisEMenosCidades")
	public String capitaisComMaisEMenosCidades(Model model) {
		CidadeFactory cf = new CidadeFactory();
		Map<Integer, String> mapCapitais = new HashMap<Integer, String>();

		mapCapitais = cf.getEstadoQuantidade(cidadeRepositorio);

		Integer maiorNumero = 0;
		Integer menorNumero = 0;

		for (Integer i : mapCapitais.keySet()) {
			if (i > maiorNumero) {
				maiorNumero = i;
			}
			if ((menorNumero == 0) || (i < menorNumero)) {
				menorNumero = i;
			}
		}

		String ufMenosCidades = mapCapitais.get(menorNumero);
		String ufMaisCidades = mapCapitais.get(maiorNumero);

		model.addAttribute("ufMenosCidades", ufMenosCidades);
		model.addAttribute("ufMaisCidades", ufMaisCidades);
		model.addAttribute("maiorNumero", maiorNumero);
		model.addAttribute("menorNumero", menorNumero);

		return "cidade/capitaisComMaisEMenosCidades";
	}

	@RequestMapping("/numeroCidadesPorEstado")
	public String numeroCidadesPorEstado(Model model) {
		CidadeFactory cf = new CidadeFactory();

		Map<String, Integer> mapCidadesEstado = cf
				.getQuantidadeCidadePorEstado(cidadeRepositorio);

		model.addAttribute("mapCidadesEstado", mapCidadesEstado);

		return "cidade/numeroCidadesPorEstado";
	}

	@RequestMapping("cidadeDoIbge/{idIBGE}")
	public String cidadeDoIbge(@PathVariable Long idIBGE, Model model) {
		if (idIBGE == null) {
			model.addAttribute("mensagemErro", "");
			return "cidade/consultaCodigoIbge";
		} else {
			Cidade cidade = new Cidade();

			cidade = cidadeRepositorio.getCidadePorIdIBGE(idIBGE);

			if (cidade == null) {
				model.addAttribute("mensagemErro", "Codigo Inexistente");
				return "cidade/consultaCodigoIbge";
			}
			model.addAttribute("mensagemErro", "");
			model.addAttribute("cidade", cidade);

			return "cidade/cidadeDoIbge";
		}
	}

	public String cidadesMaisDistantes(Model model) {
		List<Cidade> listaCidades = (List<Cidade>) cidadeRepositorio.findAll();
		Map<List<Cidade>, Double> mapCidades = new HashMap<List<Cidade>, Double>();
		CidadeFactory cf = new CidadeFactory();
		mapCidades = cf.retornaDuasCidadesMaisDistantes(listaCidades);

		model.addAttribute("mapCidades", mapCidades);

		return "cidade/cidadesMaisDistantes";
	}

	@RequestMapping("cidadesDoEstado/{uf}")
	public String getCidadesDoEstado(@PathVariable("uf") String uf, Model model) {

		List<Cidade> listaCidadesDoEstado = new ArrayList<Cidade>();
		uf = uf.toUpperCase();

		listaCidadesDoEstado = cidadeRepositorio.listaCidadesPeloEstado(uf);

		model.addAttribute("listaCidadesDoEstado", listaCidadesDoEstado);
		model.addAttribute("uf", uf);

		return "cidade/cidadesDoEstado";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarCidade(@Valid @ModelAttribute Cidade cidade,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {

		} else {
			cidadeRepositorio.save(cidade);
		}

		List<Cidade> listaCidades = new ArrayList<Cidade>();
		listaCidades = (List<Cidade>) cidadeRepositorio.findAll();

		Integer qtdRegistros = listaCidades.size();
		model.addAttribute("qtdRegistros", qtdRegistros);
		model.addAttribute("listaCidades", listaCidades);

		return "cidade/listaCidades";

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{idCidade}")
	public ResponseEntity<String> deletarCidade(
			@PathVariable("idCidade") Long idCidade) {

		try {
			cidadeRepositorio.delete(idCidade);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

}
