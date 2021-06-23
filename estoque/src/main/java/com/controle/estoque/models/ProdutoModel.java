package com.controle.estoque.models;

import io.swagger.annotations.ApiModelProperty;

public class ProdutoModel {

	@ApiModelProperty
	private int codigo;
	
	@ApiModelProperty
	private String nome;

	@ApiModelProperty
	private String validade;
	
	@ApiModelProperty
	private String marca;
	
	@ApiModelProperty
	private String preco;
	
	@ApiModelProperty
	private String descricao;
	
	public ProdutoModel(int codigo, String nome, String validade,
						String marca, String preco, String descricao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.validade = validade;
		this.marca =  marca;
		this.preco = preco;
		this.descricao = descricao;
	}
	public ProdutoModel() {
		super();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Codigo: " + this.codigo + ", Nome: " + this.nome + ", Validade: " + this.validade + ", Marca: " + this.marca +  ", Preco: " + this.preco + ", Descricao: " + this.descricao + System.lineSeparator();
	}
}
