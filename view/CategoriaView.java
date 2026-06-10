package view;

import controller.CategoriaController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoriaView extends JPanel{
    // Componentes da interface
    private JTextField txtNome;
    private JButton btnSalvar;
    
    // Referência para o Controller
    private CategoriaController controller;

    public CategoriaView() {
        controller = new CategoriaController();
      // configurarJanela();
        inicializarComponentes();       
    }
/*
    private void configurarJanela() {
        setTitle("Cadastro de Categoria");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setLocationRelativeTo(null); // Centraliza na tela
        setLayout(new GridLayout(4, 2, 10, 10)); // Layout em grade
    }*/

    private void inicializarComponentes() {
        txtNome = new JTextField();       
        btnSalvar = new JButton("Salvar Categoria");

        // Adicionando os componentes ao JFrame
        add(new JLabel("  Nome da Categoria:"));
        add(txtNome);        
        add(new JLabel("")); // Espaçador
        add(btnSalvar);

        // Evento do botão Salvar
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoSalvar();
            }
        });
    }

    private void acaoSalvar() {
        try {
            String nome = txtNome.getText();                      
         
            // Enviamos para o Controller processar
            controller.salvarCategoria(nome);
            
            JOptionPane.showMessageDialog(this, "Categoria '" + nome + "' cadastrado com sucesso!");
            limparCampos();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro: O preço deve ser um número válido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtNome.requestFocus();
    }
}