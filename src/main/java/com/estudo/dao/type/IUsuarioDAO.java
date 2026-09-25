package com.estudo.dao.type;

import com.estudo.model.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    boolean inserir(Usuario usuario);     // C: Create
    List<Usuario> buscarTodos();          // R: Read
    boolean atualizar(String nome, String matricula, String setor);   // U: Update
    boolean deletar(int id);              // D: Delete
}
