package com.pizzaria.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUsuarioView {
    private JPanel painelPrincipal;
    private JLabel Nome;
    private JLabel Matricula;
    private JLabel Setor;
    private JTextField txtNome;
    private JTextField textMatricula;
    private JTextField textSetor;
    private JButton btnSalvar;

    public CadastroUsuarioView() {
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
