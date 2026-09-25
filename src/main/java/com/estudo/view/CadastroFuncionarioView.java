package com.estudo.view;

import com.estudo.controller.UsuarioController;
import com.estudo.model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CadastroFuncionarioView {
    private JPanel painelPrincipal;
    private JTabbedPane tabbedPane1;
    private JPanel Informações;
    private JPanel Relatorio;
    private JLabel Nome;
    private JLabel Matricula;
    private JLabel Setor;
    private JTextField textNome;
    private JTextField textMatricula;
    private JTextField textSetor;
    private JButton salvarButton;
    private JTable tableUsuarios;



    public CadastroFuncionarioView() {

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String matricula = textMatricula.getText();
                String setor = textSetor.getText();

                UsuarioController controller = new UsuarioController();

                boolean salvou = controller.salvarUsuario(nome, matricula, setor);

                if (salvou){
                    JOptionPane.showMessageDialog(null, "✅ Usuário cadastrado com sucesso!");
                    atualizarTabela();
                    textNome.setText("");
                    textMatricula.setText("");
                    textSetor.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null,  "❌ Erro ao salvar no banco de dados.");
                }

            }
        });

        String[] colunas = { "ID", "Nome", "Matricula", "Setor"};

        DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);

        tableUsuarios.setModel(modeloTabela);
        atualizarTabela();


    }

public void atualizarTabela(){
        DefaultTableModel modelo = (DefaultTableModel) tableUsuarios.getModel();

        modelo.setRowCount(0);
        UsuarioController controller = new UsuarioController();
        List<Usuario> lista = controller.listarUsuarios();

        for (Usuario usuario: lista){
            modelo.addRow(new Object[]{
                    usuario.getId(),
                    usuario.getNome(),
                    usuario.getMatricula(),
                    usuario.getSetor()
            });
        }
}

    public JPanel getPainelPrincipal(){
        return painelPrincipal;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
