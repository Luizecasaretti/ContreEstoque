package com.controle.estoque.exception;

public class LoginInvalidoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public LoginInvalidoException() {
		super("Verificar se todos os campos de login foram preenchidos!");
	}

}


