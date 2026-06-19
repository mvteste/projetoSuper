/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import model.Produto;
import model.Estoque;
import dao.ProdutoDAO;
import dao.EstoqueDAO;

/**
 *
 * @author GUSTAVOSCALEIMORAES
 */
public class EstoqueView extends javax.swing.JInternalFrame {

    public EstoqueView() {
        initComponents(); // Desenha a tela
        
        // Agora só chamamos o preencherTabela()
        preencherTabela(); 
        
        this.pack();
        this.revalidate();
        this.repaint();
    }

    // Método para buscar os produtos e colocar na Caixa de Seleção
    

    // Método para listar o estoque atual na tabela
    private void preencherTabela() {
        // 1. Pega a estrutura da tabela visual e limpa as linhas antigas
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0); 
        
        // 2. Chama os DAOs para buscar as informações no banco
        dao.ProdutoDAO daoProduto = new dao.ProdutoDAO(); 
        dao.EstoqueDAO daoEstoque = new dao.EstoqueDAO();
        
        // 3. Pega TUDO do banco de dados e guarda em listas
        java.util.List<model.Produto> listaProdutos = daoProduto.listarTodos();
        java.util.List<model.Estoque> listaEstoque = daoEstoque.listarTodos();
        
        // 4. A mágica acontece aqui: Vamos passar por TODOS os produtos (um por um)
        for (model.Produto p : listaProdutos) {
            
            // Assumimos que o produto está zerado no começo
            int quantidadeAtual = 0; 
            
            // Procuramos se esse produto específico tem algum registro na lista de Estoque
            for (model.Estoque e : listaEstoque) {
                // Se o ID do produto bater com o ID que está salvo no estoque...
                if (e.getProduto().getId() == p.getId()) {
                    quantidadeAtual = e.getQuantidade(); // Atualizamos a quantidade com o valor real
                    break; // Achou o que precisava, para de procurar esse produto
                }
            }
            
            // 5. Adiciona a linha na tabela visual (ID do Produto, Nome do Produto, Quantidade)
            modelo.addRow(new Object[]{ p.getId(), p.getNome(), quantidadeAtual });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel3.setText("Pesquisar");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Preço", "Categoria", "Quantidade"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jButton3.setText("Pesquisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Limpar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String busca = jTextField1.getText();
        
        // Buscamos os produtos filtrados pelo nome
        dao.ProdutoDAO daoProduto = new dao.ProdutoDAO();
        java.util.List<model.Produto> listaFiltrada = daoProduto.buscarPorNome(busca);
        
        // Como o preencherTabela() atual precisa saber dos estoques, 
        // vamos atualizar a lógica para filtrar também no estoque ou recarregar tudo.
        // Se quiser apenas filtrar a tabela, o mais simples é:
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0);
        
        dao.EstoqueDAO daoEstoque = new dao.EstoqueDAO();
        java.util.List<model.Estoque> listaEstoque = daoEstoque.listarTodos();

        for (model.Produto p : listaFiltrada) {
            int qtd = 0;
            for (model.Estoque e : listaEstoque) {
                if (e.getProduto().getId() == p.getId()) {
                    qtd = e.getQuantidade();
                    break;
                }
            }
            modelo.addRow(new Object[]{ p.getId(), p.getNome(), qtd });
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTextField1.setText("");
        // Chama o método que já criamos anteriormente e que faz tudo certo
        preencherTabela();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
