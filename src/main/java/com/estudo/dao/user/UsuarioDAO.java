package com.estudo.dao.user;

import com.estudo.dao.ConexaoDAO;
import com.estudo.dao.type.IUsuarioDAO;
import com.estudo.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {
    @Override
    public boolean inserir(Usuario usuario){
        String sql = "INSERT INTO usuarios (nome, matricula, setor) VALUES (?,?,?)";

        try(Connection conexao = ConexaoDAO.getConexao();
            PreparedStatement declarao = conexao.prepareStatement(sql)){

            declarao.setString(1, usuario.getNome());
            declarao.setString(2, usuario.getMatricula());
            declarao.setString(3, usuario.getSetor());

            int linhasAfetadas = declarao.executeUpdate();

            declarao.close();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("❌ Erro ao salvar usuário no DAO: " + e.getMessage());

            return false;
        }


    }

    @Override
    public List<Usuario> buscarTodos(){
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try(Connection conexao = ConexaoDAO.getConexao();
            PreparedStatement comando = conexao.prepareStatement(sql); ResultSet resultado = comando.executeQuery()){

           while (resultado.next()){
               Usuario usuario = new Usuario();

               usuario.setId(resultado.getInt("id"));
               usuario.setNome(resultado.getString("nome"));
               usuario.setMatricula(resultado.getString("matricula"));
               usuario.setSetor(resultado.getString("setor"));

               usuarios.add(usuario);
           }



        } catch (SQLException e) {
            System.out.println("Error ao tentar listar usuarios" + e.getMessage());
            throw new RuntimeException(e);
        }

        return usuarios;
    }

    @Override
    public boolean atualizar(String nome, String matricula, String setor){
        String sql = "UPDATE usuarios SET nome = ?, matricula = ?, setor = ? WHERE id = ?";

        try(Connection conexao = ConexaoDAO.getConexao(); PreparedStatement comando = conexao.prepareStatement(sql)){
            comando.setString(1, nome);
            comando.setString(2, matricula);
            comando.setString(3, setor);

           return comando.executeUpdate() > 0;

        }
        catch (Exception e){

            System.out.println("Erro ao listar os usuarios " + e.getMessage());

            return false;
        }
    }

    @Override
    public boolean deletar(int id){
        return false;
    }
}
