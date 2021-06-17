
package com.controle.estoque.exceptions;

public class CamposInvalidosException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CamposInvalidosException() {
		super("Nome e senha devem ser preenchidos");
	}

}
