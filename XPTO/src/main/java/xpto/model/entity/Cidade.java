/**
 * 
 */
package xpto.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tiago Ferezin Data: 01/09/2018
 */
@Entity
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCidade;

	private Long idIBGE;

	private String uf;

	private String nome;

	private Boolean capital;

	private String longitude;

	private String latitude;

	private String nomeSemAcentos;

	private String nomeAlternativo;

	private String microRegiao;

	private String mesoRegiao;

	public Cidade() {

	}

	/**
	 * @return the idCidade
	 */
	public Long getIdCidade() {
		return idCidade;
	}

	/**
	 * @param idCidade
	 *            the idCidade to set
	 */
	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	/**
	 * @return the idIBGE
	 */
	public Long getIdIBGE() {
		return idIBGE;
	}

	/**
	 * @param idIBGE
	 *            the idIBGE to set
	 */
	public void setIdIBGE(Long idIBGE) {
		this.idIBGE = idIBGE;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf
	 *            the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the capital
	 */
	public Boolean getCapital() {
		return capital;
	}

	/**
	 * @param capital
	 *            the capital to set
	 */
	public void setCapital(Boolean capital) {
		this.capital = capital;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the nomeSemAcentos
	 */
	public String getNomeSemAcentos() {
		return nomeSemAcentos;
	}

	/**
	 * @param nomeSemAcentos
	 *            the nomeSemAcentos to set
	 */
	public void setNomeSemAcentos(String nomeSemAcentos) {
		this.nomeSemAcentos = nomeSemAcentos;
	}

	/**
	 * @return the nomeAlternativo
	 */
	public String getNomeAlternativo() {
		return nomeAlternativo;
	}

	/**
	 * @param nomeAlternativo
	 *            the nomeAlternativo to set
	 */
	public void setNomeAlternativo(String nomeAlternativo) {
		this.nomeAlternativo = nomeAlternativo;
	}

	/**
	 * @return the microRegiao
	 */
	public String getMicroRegiao() {
		return microRegiao;
	}

	/**
	 * @param microRegiao
	 *            the microRegiao to set
	 */
	public void setMicroRegiao(String microRegiao) {
		this.microRegiao = microRegiao;
	}

	/**
	 * @return the mesoRegiao
	 */
	public String getMesoRegiao() {
		return mesoRegiao;
	}

	/**
	 * @param mesoRegiao
	 *            the mesoRegiao to set
	 */
	public void setMesoRegiao(String mesoRegiao) {
		this.mesoRegiao = mesoRegiao;
	}

}
