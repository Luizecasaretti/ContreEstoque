package com.controle.estoque.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public String definirAutenticacao(String nome, int senha) throws Exception {

		if (senha == 1234) {
			//boolean gerente = true;
			return "parametros/gerente";
		} else if (nome != null && senha > 0) {
			return "parametros/cliente";
		} else
			return "parametros/loginInvalido";
		}
}
