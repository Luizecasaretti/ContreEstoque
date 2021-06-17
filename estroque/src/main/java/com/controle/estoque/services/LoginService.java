package com.controle.estoque.services;

import org.springframework.stereotype.Service;

import com.controle.estoque.exceptions.CamposInvalidosException;

@Service
public class LoginService {
	
	
	public String definirAutenticacao(String nome, int senha) throws Exception {

			if (nome == "gerente" && senha == 1234) {
				return "gerenteValido";
			}else if  (nome != null && senha > 0){
				return "clienteValido";
			}else {
				throw new CamposInvalidosException();
			}
	}
	
}
