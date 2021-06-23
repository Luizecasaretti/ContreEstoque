package com.controle.estoque.services;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.estoque.models.ProdutoModel;
import com.controle.estoque.repositories.ProdutoRepository;


@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository; 

	public String verificacaoProduto(ProdutoModel produtoNovo) {
		produtoRepository.insertProduto(produtoNovo);	
		return "parametros/gerente";
	}
	
	public String alteracaoProduto(ProdutoModel produtoAlterado) {
		produtoRepository.updateProduto(produtoAlterado);
		return "parametros/gerente";		
	}
	
	public String exclusaoProduto(ProdutoModel produtoExcluido) {
		produtoRepository.deleteProduto(produtoExcluido);	
		return "parametros/gerente"; 	
	}
	
	public List<ProdutoModel> consultaProduto() {	
		return produtoRepository.selectProduto();
	}
	
	public ResultSet contaProduto() {
		return produtoRepository.countProduto();
	}
}
