package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
// Importações sugeridas para as demais views:
import view.CategoriaView;
import view.ClienteView;
//import view.ProdutoView;
// import view.FuncionarioView;

/**
 * Classe principal da interface Desktop.
 * Utiliza um JPanel central (painelCorpo) para carregar as diferentes telas do sistema.
 */
public class TelaInicial extends JFrame {

    private JPanel painelCorpo; // Container principal para troca de telas

    public TelaInicial() {
        configurarJanela();
        inicializarComponentes();
    }

    private void configurarJanela() {
        setTitle("Sistema de Gestão de Supermercado");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {
        JMenuBar menuBar = new JMenuBar();

        // 1. Menu Cadastro
        JMenu menuCadastro = new JMenu("Cadastro");
        menuCadastro.add(criarItemMenu("Categoria", e -> carregarTela(new CategoriaView()))); // Substituir por CategoriaView
        menuCadastro.add(criarItemMenu("Cliente", e -> carregarTela(new ClienteView())));
        menuCadastro.add(criarItemMenu("Funcionário", e -> carregarTela(new JPanel()))); 
        menuCadastro.add(criarItemMenu("Tipo Funcionário", e -> carregarTela(new JPanel())));
        menuCadastro.add(criarItemMenu("Produto", e -> carregarTela(new JPanel())));

        // 2. Menu Visualizar
        JMenu menuVisualizar = new JMenu("Visualizar");
        menuVisualizar.add(criarItemMenu("Categoria", e -> System.out.println("Visualizar Categoria")));
        menuVisualizar.add(criarItemMenu("Cliente", e -> System.out.println("Visualizar Cliente")));
        menuVisualizar.add(criarItemMenu("Funcionário", e -> System.out.println("Visualizar Funcionário")));
        menuVisualizar.add(criarItemMenu("Tipo Funcionário", e -> System.out.println("Visualizar Tipo")));
        menuVisualizar.add(criarItemMenu("Produto", e -> System.out.println("Visualizar Produto")));

        // 3. Menu Vendas
        JMenu menuVendas = new JMenu("Vendas");
        menuVendas.add(criarItemMenu("Pedido", e -> System.out.println("Abrir Pedido")));

        // 4. Menu Compras
        JMenu menuCompras = new JMenu("Compras");
        menuCompras.add(criarItemMenu("Pedido Compra", e -> System.out.println("Abrir Pedido Compra")));

        // Adicionando menus à barra
        menuBar.add(menuCadastro);
        menuBar.add(menuVisualizar);
        menuBar.add(menuVendas);
        menuBar.add(menuCompras);
        setJMenuBar(menuBar);

        // Painel Central que receberá as Views (JPanels)
        painelCorpo = new JPanel(new BorderLayout());
        painelCorpo.setBorder(BorderFactory.createEtchedBorder());
        add(painelCorpo, BorderLayout.CENTER);
    }

    /**
     * Helper para criar itens de menu com eventos de clique.
     */
    private JMenuItem criarItemMenu(String rotulo, java.awt.event.ActionListener acao) {
        JMenuItem item = new JMenuItem(rotulo);
        item.addActionListener(acao);
        return item;
    }

    /**
     * Método responsável por realizar a troca de telas no painel central.
     * @param novaTela O JPanel da View a ser carregada.
     */
    private void carregarTela(JPanel novaTela) {
        painelCorpo.removeAll();
        painelCorpo.add(novaTela, BorderLayout.CENTER);
        painelCorpo.revalidate();
        painelCorpo.repaint();
    }

    public static void main(String[] args) {
        // Garante a execução na Thread de Eventos do Swing
        SwingUtilities.invokeLater(() -> {
            new TelaInicial().setVisible(true);
        });
    }
}