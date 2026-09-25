package com.pizzaria.dao.type;

import com.pizzaria.model.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    boolean inserir(Usuario usuario);     // C: Create
    List<Usuario> buscarTodos();          // R: Read
    boolean atualizar(Usuario usuario);   // U: Update
    boolean deletar(int id);              // D: Delete
}
