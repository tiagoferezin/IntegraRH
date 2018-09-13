/**
 * 
 */
package xpto.factory;

/**
 * @author Tiago Ferezin Data: 13/09/2018
 */
public class CalculoDistanciaFactory {

	private static Double degParaRaio(Double deg) {
		return (deg * Math.PI / 180D);
	}

	private static Double raioParaDeg(Double raio) {
		return (raio * 180 / Math.PI);
	}

	public Double calculaDistancia(Double lat1, Double long1, Double lat2,
			Double long2, String unidadeDistancia) {
		Double retorno = 0D;

		Double theta = long1 - long2;
		Double distancia = Math.sin(degParaRaio(lat1))
				* Math.sin(degParaRaio(lat2)) + Math.cos(degParaRaio(lat1))
				* Math.cos(degParaRaio(lat2)) * Math.cos(degParaRaio(theta));
		distancia = Math.acos(distancia);
		distancia = raioParaDeg(distancia);

		distancia = distancia * 60 * 1.1515;

		if (unidadeDistancia == "K") {
			distancia = distancia * 1.609344;
		} else if (unidadeDistancia == "N") {
			distancia = distancia * 0.8684;
		}

		retorno = distancia;

		return retorno;
	}
	
	public Double distanciaEmKM(String latitude1, String longitude1, String latitude2,
			String longitude2){
		Double lat1 = Double.parseDouble(latitude1);
		Double lat2 = Double.parseDouble(latitude2);
		Double long1 = Double.parseDouble(longitude1);
		Double long2 = Double.parseDouble(longitude2);
		
		return calculaDistancia(lat1, long1, lat2, long2, "K");
	}

}
