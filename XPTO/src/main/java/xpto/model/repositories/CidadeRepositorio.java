/**
 * 
 */
package xpto.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import xpto.model.entity.Cidade;

/**
 * @author Tiago Ferezin Data: 01/09/2018
 */
@Repository
public interface CidadeRepositorio extends CrudRepository<Cidade, Long> {

	@Query("SELECT t FROM Cidade t WHERE t.capital  = 'TRUE' ORDER BY t.nome ASC")
	public List<Cidade> capitaisOrdenadadasPorNome();
	
	@Query("SELECT t FROM Cidade t WHERE t.idIBGE = ?")
	public Cidade getCidadePorIdIBGE(Long idIBGE);
	
	@Query("SELECT t FROM Cidade t WHERE t.uf = ?")
	public List<Cidade> listaCidadesPeloEstado(String uf);

}
