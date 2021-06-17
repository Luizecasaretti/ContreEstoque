package com.controle.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.controle.estoque.models.LoginModel;
import com.controle.estoque.services.LoginService;

//import com.controle.estoque.models.LoginModel;
//import com.controle.estoque.services.LoginService;

@Controller
public class EstoqueController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/login" )
	public String inicio() throws Exception{
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/validarLogin" )
	public String inserirLogin(String nome, int senha, Model model) throws Exception{	
		String resultado = " ";
		try {
			LoginModel login = new LoginModel();
			login.setNome(nome);
			login.setSenha(senha);
			resultado = loginService.definirAutenticacao(login.getNome(), login.getSenha());
		} catch(Exception e) {
			model.addAttribute("erroLogin", e.getMessage());
		}
		return resultado;
	}

}
