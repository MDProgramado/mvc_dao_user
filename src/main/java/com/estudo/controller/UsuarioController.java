package com.estudo.controller;

import com.estudo.dao.user.UsuarioDAO;
import com.estudo.model.Usuario;

import javax.swing.*;
import java.util.List;

public class UsuarioController {
    private UsuarioDAO dao  = new UsuarioDAO();

    public boolean salvarUsuario(String nome, String matricula, String setor){

        if ((nome != null && !nome.isEmpty()) && (matricula != null && !matricula.isEmpty()) && (setor != null && !setor.isEmpty())){
            Usuario NovoUsuario = new Usuario(nome, matricula, setor);

             dao = new UsuarioDAO();


            return dao.inserir(NovoUsuario);
        } else {
            JOptionPane.showMessageDialog(null, "Digite os dados corretamente!");
            return false;
        }

    }
    public List<Usuario> listarUsuarios(){ return dao.buscarTodos();
    }

}
