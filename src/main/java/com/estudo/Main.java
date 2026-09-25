package com.estudo;

import com.estudo.dao.ConexaoDAO;
import com.estudo.view.CadastroFuncionarioView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //ConexaoDAO.criarTabelaSeNaoExistir();

        JFrame janela = new JFrame("Sistema de Cadastro - MVC");
        janela.setContentPane(new CadastroFuncionarioView().getPainelPrincipal());


        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setLocationRelativeTo(null);

        janela.setVisible(true);
    }
}