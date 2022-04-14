package com.crud.ProjetoCrudApi.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionDAO {

    Logger logger = Logger.getLogger("Log");


    private String connectionUrl = "jdbc:mysql://localhost:3306/projeto_crud?serverTimezone=UTC";
    private String username = "username";
    private String password= "password";

    public ConnectionDAO() {
    }

    public Connection criarConexao() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(connectionUrl, username, password);

            logger.info("Conexão com o banco de dados feita com sucesso");
        } catch (SQLException | ClassNotFoundException e) {
            logger.severe(e.getLocalizedMessage());
        }

        return connection;
    }
}
