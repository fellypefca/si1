package lab1;

public class NumberSystem {

	private String unidade[] = { "zero", "um", "dois", "três", "quatro",
			"cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze",
			"treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito",
			"dezenove" };

	private String dezena[] = { "vinte", "trinta", "quarenta",
			"cinquenta", "sessenta", "setenta", "oitenta", "noventa" };

	private String centena[] = { "cem", "duzentos", "trezentos",
			"quatrocentos", "quinhentos", "seiscentos", "setecentos",
			"oitocentos", "novecentos" };

	private final int DEZEN = 10;
	private final int CENTEN = 100;

	public String getResposta(int num) throws Invalid {
		if (num < 0 || num > 1000000000) {
			throw new Invalid();
		}

		if (num < 100) {
			return getUnidade(num);
		} 
		else if (num < 1000) {
			return getCentenaResposta(num);
		} 
		else if (num < 1000000) {
			return getMil(num);
		} 
		else if (num < 1000000000) {
			return getMilhao(num);
		}
		return "um bilhão";
	}

	private String getUnidade(int number) {
		if (number < 20) {
			return unidade[number];
		} 
		else if (number < 100) {
			return dezena[number / DEZEN - 2]
					+ ((number % DEZEN > 0 ? " e "
							+ getUnidade(number % DEZEN) : ""));
		}
		return "";
	}

	private String getCentena(int num) {
		if (num != 100 && num < 200) {
			return "cento";
		}
		return centena[num / CENTEN - 1];
	}

	private String getMil(int num) throws Invalid {
		if (num == 1000) {
			return "um mil";
		} 
		else {
			String resposta = "";
			int subNum = Integer.valueOf(String.valueOf(num).substring(getNumeroDeDigitos(num) - 3, getNumeroDeDigitos(num)));
			String milhar = getResposta((getNumeroSeparado(num, 0, -3)));
			resposta += (milhar.equals("um") ? "mil" : milhar + " mil");
			resposta += ((subNum != 0) ? " e " + getCentenaResposta(subNum): "");
			return resposta;
		}
	}

	private String getMilhao(int num) throws Invalid {
		String resposta = "";
		if (num < 2000000) {
			resposta += "um milhão";
		} 
		else {
			resposta += getResposta(getNumeroSeparado(num, 0, -6)) + " milhões";
		}
		String tmp = getResposta(getNumeroSeparado(num, getNumeroDeDigitos(num) - 6, 0));
		resposta += (!tmp.equals("zero") ? " e " + tmp : "");
		return resposta;
	}

	private String getCentenaResposta(int num) {
		String resposta = "";
		resposta = getCentena(num);
		num = num % CENTEN;
		resposta += ((num != 0) ? " e " + getUnidade(num) : "");
		return resposta;
	}

	private int getNumeroDeDigitos(int num) {
		return String.valueOf(num).length();
	}

	private int getNumeroSeparado(int num, int addBegin, int addLast) {
		return Integer.valueOf(String.valueOf(num).substring(0 + addBegin,
				getNumeroDeDigitos(num) + addLast));
	}
}