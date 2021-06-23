package com.controle.estoque.services;

import org.springframework.stereotype.Service;
import com.controle.estoque.exception.LoginInvalidoException;

@Service 
public class LoginService {
	public String definirAutenticacao(String nome, int senha) throws Exception {

		if (!nome.isEmpty() && senha == 1234) {
			return "parametros/gerente";
		} else if (!nome.isEmpty() && senha > 0) {
			return "parametros/cliente";
		} else {
			throw new LoginInvalidoException();
		}
	}
}
