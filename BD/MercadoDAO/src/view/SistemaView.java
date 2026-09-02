package view;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class SistemaView extends JFrame {
    public SistemaView() {
        super("MercadoDAO System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1050, 700));
        setLocationByPlatform(true);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Clientes", new ClienteView());
        tabs.addTab("Fornecedores", new FornecedorView());
        tabs.addTab("Funcionários", new FuncionarioView());
        tabs.addTab("Cargos", new CargoFuncionarioView());
        tabs.addTab("Caixas", new CaixaView());
        tabs.addTab("Categorias", new CategoriaProdutoView());
        tabs.addTab("Produtos", new ProdutoView());
        tabs.addTab("Estoque", new EstoqueView());
        tabs.addTab("Pedidos", new PedidoCompraView());
        tabs.addTab("Itens de pedido", new PedidoCompraProdutoView());
        tabs.addTab("Contratos", new ContratoView());
        tabs.addTab("Vendas", new VendaView());
        tabs.addTab("Itens de venda", new CarrinhoView());
        tabs.addTab("Contas a pagar", new ContaPagarView());
        tabs.addTab("Contas a receber", new ContaReceberView());
        tabs.addChangeListener(event -> reloadSelected(tabs));
        setContentPane(tabs);
        pack();
        setLocationRelativeTo(null);
        SwingUtilities.invokeLater(() -> reloadSelected(tabs));
    }

    private static void reloadSelected(JTabbedPane tabs) {
        if (tabs.getSelectedComponent() instanceof AbstractEntityView<?> view) view.reload();
    }
}
