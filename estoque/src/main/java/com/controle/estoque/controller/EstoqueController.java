package com.controle.estoque.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.controle.estoque.models.LoginModel;
import com.controle.estoque.models.ProdutoModel;
import com.controle.estoque.services.LoginService;
import com.controle.estoque.services.ProdutoService;



@Controller
public class EstoqueController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	ProdutoService produtoService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/login" )
	public String inicio() throws Exception{
		return "parametros/login";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/validarLogin" )
	public String inserirLogin(String nome, int senha) throws Exception {	
	
			LoginModel login  = new LoginModel(nome, senha);
			login.setNome(nome);
			login.setSenha(senha);
			
			return loginService.definirAutenticacao(login.getNome(), login.getSenha());	
	
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/gerente" )
	public String inserirProduto(int codigo, String nome, String validade, 
								 String marca, String preco, String descricao) throws Exception{	
		ProdutoModel produtoNovo = new ProdutoModel();
		produtoNovo.setCodigo(codigo);
		produtoNovo.setNome(nome);
		produtoNovo.setValidade(validade);
		produtoNovo.setMarca(marca);
		produtoNovo.setPreco(preco);
		produtoNovo.setDescricao(descricao);	
		
		produtoService.verificacaoProduto(produtoNovo);
		
		return "parametros/gerente";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/produtoExcluir" )
	public String excluirProduto(int codigo, String nome) throws Exception{	
		ProdutoModel produtoExcluido = new ProdutoModel();
		produtoExcluido.setCodigo(codigo);
		produtoExcluido.setNome(nome);
		
		produtoService.exclusaoProduto(produtoExcluido);
		
		return "parametros/gerente";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/consultarProduto" )
	public String consultarProduto(Model model) throws Exception{	
			
		ArrayList<ProdutoModel> resultadoTabela = new ArrayList<ProdutoModel>();
		resultadoTabela = produtoService.consultaProduto();
		model.addAttribute("resultadoTabela");
		
		return "parametros/gerente";
		
	}

}
