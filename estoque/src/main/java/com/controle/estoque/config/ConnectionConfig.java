package com.controle.estoque.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {

	public static Connection createConnectionToMariaDB() {
		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/db_controle_estoque";
		String user = "root";
		String pwd = "123456";

		try {

			connection = DriverManager.getConnection(url, user, pwd);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("CONECTADO");
		return connection;
	}

}
