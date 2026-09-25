package com.pizzaria.dao.user;

import com.pizzaria.dao.ConexaoDAO;
import com.pizzaria.dao.type.IUsuarioDAO;
import com.pizzaria.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {
    @Override
    public boolean inserir(Usuario usuario){
        String sql = "INSERT INTO usuarios (id, nome, matricula, setor) VALUES (?, ?,?,?)";

        try(Connection conexao = ConexaoDAO.getConexao();
            PreparedStatement declarao = conexao.prepareStatement(sql)){

            declarao.setString(1, usuario.getNome());
            declarao.setString(2, usuario.getMatricula());
            declarao.setString(3, usuario.getSetor());

            int linhasAfetadas = declarao.executeUpdate();

            return linhasAfetadas > 0;

        } catch (Exception e) {
            System.err.println("❌ Erro ao salvar usuário no DAO: " + e.getMessage());
            return false;

        }
    }

    @Override
    public List<Usuario> buscarTodos(){return null;}

    @Override
    public boolean atualizar(Usuario usuario){
        return false;
    }

    @Override
    public boolean deletar(int id){
        return false;
    }
}
