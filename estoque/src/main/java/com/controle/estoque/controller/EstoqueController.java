package com.controle.estoque.controller;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.controle.estoque.exception.LoginInvalidoException;
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

	private ResultSet contagem;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/login" )
	public String inicio() throws Exception{
		return "parametros/login";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/validarLogin" )
	public String inserirLogin(@RequestParam(required = true) String nome, 
			                   @RequestParam(required = true) int senha, 
			                   Model model) throws Exception {	
	
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
	
	@RequestMapping(method = RequestMethod.POST, value = "/gerenteAlterar" )
	public String alterarProduto(int codigo, String nome, String validade, 
								 String marca, String preco, String descricao) throws Exception{	
		ProdutoModel produtoAlterado = new ProdutoModel();
		produtoAlterado.setCodigo(codigo);
		produtoAlterado.setNome(nome);
		produtoAlterado.setValidade(validade);
		produtoAlterado.setMarca(marca);
		produtoAlterado.setPreco(preco);
		produtoAlterado.setDescricao(descricao);	
		
		produtoService.alteracaoProduto(produtoAlterado);
		
		return "parametros/gerente";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/gerenteExcluir" )
	public String gerenteExcluirProduto(int codigo, String nome) throws Exception{	
		ProdutoModel produtoExcluido = new ProdutoModel();
		produtoExcluido.setCodigo(codigo);
		produtoExcluido.setNome(nome);
		
		produtoService.exclusaoProduto(produtoExcluido);
		
		return "parametros/gerente";
		
	} 
	
	@RequestMapping(method = RequestMethod.POST, value = "/clienteExcluir" )
	public String clienteExcluirProduto(int codigo, String nome, Model model) throws Exception{	
		ProdutoModel produtoExcluido = new ProdutoModel();
		produtoExcluido.setCodigo(codigo);
		produtoExcluido.setNome(nome);
		
		try {
			produtoService.exclusaoProduto(produtoExcluido);
		}
		catch(Exception e) {
			throw new LoginInvalidoException();
			//model.addAttribute("erroDeleteProduto", e.getMessage());
		}
		return "parametros/cliente";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/consultarProduto" )
	public String consultarProduto(Model model) throws Exception{	
			
		ArrayList<ProdutoModel> resultadoTabela = new ArrayList<ProdutoModel>();
		//String resultadoTabela = "";
		resultadoTabela = produtoService.consultaProduto();
		//resultadoTabela = produtoService.consultaProduto();
		model.addAttribute("consulta", resultadoTabela);
		
		//model.addAttribute("produtos", produtoService.consultaProduto());
	    
		
		return "parametros/gerente";
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/contarProdutos" )
	public String contarTotalProduto(Model model) throws Exception{	
			
		contagem = produtoService.contaProduto();
		model.addAttribute("contagem", contagem);
		
		return "parametros/gerente"; 
		
	}

}
