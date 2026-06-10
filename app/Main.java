package app;
import view.ProdutoView;
import view.CategoriaView;
import view.ClienteView;
import javax.swing.*;
import java.awt.*;
public class Main extends JFrame {
    public Main() {
        setTitle("Sistema de Gerenciamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        
        JButton btnAbrir = new JButton("Abrir Cadastro de Produtos");
        btnAbrir.addActionListener(e -> {ProdutoView produtoView = new ProdutoView();
        produtoView.setVisible(true);});
        add(btnAbrir);
       
        JButton btnAbrirCategoria = new JButton("Abrir Cadastro de Categorias");
        btnAbrirCategoria.addActionListener(e -> {CategoriaView categoriaView = new CategoriaView();
        categoriaView.setVisible(true);});
        add(btnAbrirCategoria);
        
        JButton btnAbrirCliente = new JButton("Cadastro de Clientes");
        btnAbrirCliente.addActionListener(e -> {ClienteView clienteView = new ClienteView();
        clienteView.setVisible(true);});
        add(btnAbrirCliente);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);});
    }
}