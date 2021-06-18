package com.controle.estoque.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.controle.estoque.config.ConnectionConfig;
import com.controle.estoque.models.ProdutoModel;

@Repository
public class ProdutoRepository {
	
	public void insertProduto(ProdutoModel produtoNovo) {
		
		String sql = "INSERT INTO PRODUTOS VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			Connection conn = null;
			PreparedStatement pstm = null;
		
			conn = ConnectionConfig.createConnectionToMariaDB();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, produtoNovo.getCodigo());
			pstm.setString(2, produtoNovo.getNome());
			pstm.setString(3, produtoNovo.getValidade());
			pstm.setString(4, produtoNovo.getMarca());
			pstm.setString(5, produtoNovo.getPreco());
			pstm.setString(6, produtoNovo.getDescricao());
			
			pstm.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateProduto(ProdutoModel produtoAlterado) {
		
//		String sql = "UPDATE PRODUTOS SET NOME = ?, DATA_VALIDADE = ?, MARCA = ?, "
//				   + "PRECO = ?, DESCRICAO = ? WHERE CODIGO = ?";
	
		try {
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			conn = ConnectionConfig.createConnectionToMariaDB();
				
			
			if (!produtoAlterado.getNome().isEmpty()) {	
				String sql = "UPDATE PRODUTOS SET NOME = ? WHERE CODIGO = ?";
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, produtoAlterado.getNome());
				pstm.setInt(2, produtoAlterado.getCodigo());
				pstm.execute();
			}
					
			if (!produtoAlterado.getValidade().isEmpty())	{
				String sql = "UPDATE PRODUTOS SET DATA_VALIDADE = ? WHERE CODIGO = ?";
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, produtoAlterado.getValidade());
				pstm.setInt(2, produtoAlterado.getCodigo());
				pstm.execute();
			}
			if (!produtoAlterado.getMarca().isEmpty())	{
				String sql = "UPDATE PRODUTOS SET MARCA = ? WHERE CODIGO = ?";
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, produtoAlterado.getMarca());
				pstm.setInt(2, produtoAlterado.getCodigo());
				pstm.execute();
			}
			if (!produtoAlterado.getPreco().isEmpty())	{
				String sql = "UPDATE PRODUTOS SET PRECO = ? WHERE CODIGO = ?";
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, produtoAlterado.getPreco());
				pstm.setInt(2, produtoAlterado.getCodigo());
				pstm.execute();
			}
			if (!produtoAlterado.getDescricao().isEmpty())	{
				String sql = "UPDATE PRODUTOS SET DESCRICAO = ? WHERE CODIGO = ?";
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, produtoAlterado.getDescricao());
				pstm.setInt(2, produtoAlterado.getCodigo());
				pstm.execute();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteProduto(ProdutoModel produtoExcluido) {
		
		String sql = "DELETE FROM PRODUTOS WHERE CODIGO = ? AND NOME = ?";
		
		try {
			Connection conn = null;
			PreparedStatement pstm = null;
		
			conn = ConnectionConfig.createConnectionToMariaDB();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, produtoExcluido.getCodigo());
			pstm.setString(2, produtoExcluido.getNome());
			
			pstm.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet countProduto() {
		
		String sql = "SELECT COUNT(*) FROM produtos";
		
		ResultSet rset = null;
		 
		try {
			Connection conn = null;
			PreparedStatement pstm = null;
		
			conn = ConnectionConfig.createConnectionToMariaDB();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
						
			rset = pstm.executeQuery();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(rset);
		return rset;
		
	}
	

	public ArrayList<ProdutoModel> selectProduto() {
			
		String sql = "SELECT * FROM PRODUTOS";
		
		ArrayList<ProdutoModel> tabelaProdutos = new ArrayList<ProdutoModel>();
		//Classe que vai recuperar os dados do sql
		ResultSet rset = null;
		
		try {
			Connection conn = null;
			PreparedStatement pstm = null;
	
			conn = ConnectionConfig.createConnectionToMariaDB();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
		while(rset.next()) {
			
			ProdutoModel produto = new ProdutoModel();
			produto.setCodigo(rset.getInt("CODIGO"));
			produto.setNome(rset.getString("NOME"));
			produto.setValidade(rset.getString("DATA_VALIDADE"));
			produto.setMarca(rset.getString("MARCA"));
			produto.setPreco(rset.getString("PRECO"));
			produto.setDescricao(rset.getString("DESCRICAO"));
			
			tabelaProdutos.add(produto);
			}			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
//		for (int i = 0; i < tabelaProdutos.size(); i++) {
//			System.out.println(tabelaProdutos.get(i));
//
//		}
		//System.out.println(rset);
		return tabelaProdutos;
	}
	
	
}

