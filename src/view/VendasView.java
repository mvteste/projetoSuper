/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.VendaDAO;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Venda;

/**
 * Tela de consulta das vendas registradas no banco.
 *
 * A interface é montada após o initComponents para manter compatibilidade com
 * o projeto criado no NetBeans e, ao mesmo tempo, deixar a tela funcional.
 *
 * @author GUSTAVOSCALEIMORAES
 */
public class VendasView extends javax.swing.JInternalFrame {

    private final VendaDAO vendaDAO = new VendaDAO();
    private final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    private JTable tabelaVendas;
    private JTextField campoPesquisa;
    private JLabel labelResumo;

    /**
     * Creates new form VendasView
     */
    public VendasView() {
        initComponents();
        configurarTela();
        carregarTodasAsVendas();
    }

    private void configurarTela() {
        setTitle("Vendas");
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout(8, 8));

        JPanel painelPesquisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelPesquisa.add(new JLabel("Cliente:"));

        campoPesquisa = new JTextField(20);
        painelPesquisa.add(campoPesquisa);

        JButton botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.addActionListener(evt -> pesquisarVendas());
        painelPesquisa.add(botaoPesquisar);

        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(evt -> {
            campoPesquisa.setText("");
            carregarTodasAsVendas();
        });
        painelPesquisa.add(botaoLimpar);

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Cliente", "Data", "Valor total"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaVendas = new JTable(modelo);
        tabelaVendas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        labelResumo = new JLabel(" ");

        getContentPane().add(painelPesquisa, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(tabelaVendas), BorderLayout.CENTER);
        getContentPane().add(labelResumo, BorderLayout.SOUTH);

        setSize(650, 400);
        revalidate();
        repaint();
    }

    private void carregarTodasAsVendas() {
        try {
            preencherTabela(vendaDAO.listarTodos());
        } catch (RuntimeException e) {
            mostrarErro(e);
        }
    }

    private void pesquisarVendas() {
        String pesquisa = campoPesquisa.getText().trim();

        try {
            if (pesquisa.isEmpty()) {
                preencherTabela(vendaDAO.listarTodos());
            } else {
                preencherTabela(vendaDAO.buscarPorCliente(pesquisa));
            }
        } catch (RuntimeException e) {
            mostrarErro(e);
        }
    }

    private void preencherTabela(List<Venda> vendas) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaVendas.getModel();
        modelo.setNumRows(0);

        double valorSomado = 0.0;

        for (Venda venda : vendas) {
            String cliente = venda.getCliente() != null
                    ? venda.getCliente().getNome()
                    : "Cliente não informado";

            String data = venda.getDataVenda() != null
                    ? venda.getDataVenda().format(formatoData)
                    : "";

            modelo.addRow(new Object[]{
                venda.getId(),
                cliente,
                data,
                formatoMoeda.format(venda.getValorTotal())
            });

            valorSomado += venda.getValorTotal();
        }

        labelResumo.setText(
                "Vendas encontradas: " + vendas.size()
                + "   |   Valor total: " + formatoMoeda.format(valorSomado)
        );
    }

    private void mostrarErro(RuntimeException e) {
        Throwable causa = e.getCause() != null ? e.getCause() : e;

        JOptionPane.showMessageDialog(
                this,
                "Não foi possível carregar as vendas.\nDetalhes: " + causa.getMessage(),
                "Erro ao consultar vendas",
                JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
