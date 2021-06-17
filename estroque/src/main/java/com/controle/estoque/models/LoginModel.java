package com.controle.estoque.models;

import io.swagger.annotations.ApiModelProperty;

public class LoginModel {

	@ApiModelProperty
	private String nome;

	@ApiModelProperty
	private int senha;
	
	public LoginModel(String nome, int senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}
	public LoginModel() {
		super();
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}

}
