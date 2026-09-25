package com.estudo.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDAO {
    private static final String URL = "jdbc:derby:db_usuarios;create=true";
    private static final String USUARIO = "app";
    private static final String SENHA = "app";

    private ConexaoDAO(){}

    public static Connection getConexao(){
        try {
            return DriverManager.getConnection(URL,USUARIO, SENHA);

        } catch (SQLException e) {
            System.out.println("❌ Erro catastrófico ao conectar no banco!");
            throw new RuntimeException("Falha na conexão: " + e.getMessage());
        }
    }
    public static void criarTabelaSeNaoExistir(){

        String sql = """
                CREATE TABLE usuarios(
                id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1),
                nome VARCHAR(100) NOT NULL,
                matricula VARCHAR(100) NOT NULL,
                setor VARCHAR(50) NOT NULL
                )
                """;

        try(Connection conexao = getConexao()){
            Statement statement = conexao.createStatement();

            statement.execute(sql);
            System.out.println("✅ Tabela 'usuarios' criada com sucesso no Derby!");
        } catch (SQLException e){
            if (e.getSQLState().equals("X0Y32")) {
                System.out.println("ℹ️ A tabela 'usuarios' já existe. Nenhuma ação necessária.");
            } else {

                System.err.println("❌ Erro ao tentar criar a tabela: " + e.getMessage());
            }

        }
    }
}
