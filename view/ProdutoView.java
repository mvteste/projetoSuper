package view;

import controller.ProdutoController;
import model.Categoria;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoView extends JFrame {
    // Componentes da interface
    private JTextField txtNome;
    private JTextField txtPreco;
    private JComboBox<Categoria> cbCategoria;
    private JButton btnSalvar;
    
    // Referência para o Controller
    private final ProdutoController controller;

    public ProdutoView() {
        controller = new ProdutoController();
        configurarJanela();
        inicializarComponentes();
        preencherComboCategorias();
    }

    private void configurarJanela() {
        setTitle("Cadastro de Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setLocationRelativeTo(null); // Centraliza na tela
        setLayout(new GridLayout(4, 2, 10, 10)); // Layout em grade
    }

    private void inicializarComponentes() {
        txtNome = new JTextField();
        txtPreco = new JTextField();
        cbCategoria = new JComboBox<>();
        btnSalvar = new JButton("Salvar Produto");

        // Adicionando os componentes ao JFrame
        add(new JLabel("  Nome do Produto:"));
        add(txtNome);
        add(new JLabel("  Preço:"));
        add(txtPreco);
        add(new JLabel("  Categoria:"));
        add(cbCategoria);
        add(new JLabel("")); // Espaçador
        add(btnSalvar);

        // Evento do botão Salvar
        btnSalvar.addActionListener((ActionEvent e) -> {
            acaoSalvar();
        });
    }

    private void preencherComboCategorias() {
        // O Controller busca a lista de objetos Categoria do DAO
        for (Categoria cat : controller.obterCategorias()) {
            cbCategoria.addItem(cat); 
            // O JComboBox usará o método toString() da classe Categoria para exibir o nome
        }
    }

    private void acaoSalvar() {
        try {
            String nome = txtNome.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            
            // Recuperamos o OBJETO Categoria inteiro que está selecionado
            Categoria selecionada = (Categoria) cbCategoria.getSelectedItem();

            // Enviamos para o Controller processar
            controller.salvarProduto(nome, preco, selecionada);
            
            JOptionPane.showMessageDialog(this, "Produto '" + nome + "' cadastrado com sucesso!");
            limparCampos();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro: O preço deve ser um número válido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtPreco.setText("");
        cbCategoria.setSelectedIndex(0);
        txtNome.requestFocus();
    }
}