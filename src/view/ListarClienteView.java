/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

/**
 *
 * @author GUSTAVOSCALEIMORAES
 */
public class ListarClienteView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListarClienteView
     */
    public ListarClienteView() {
        initComponents();
    }

    private void preencherTabela(java.util.List<model.Cliente> lista) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        modelo.setNumRows(0); 
        
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

        for (model.Cliente c : lista) {
            String dataFormatada = "";
            if (c.getData_Nascimento() != null) {
                dataFormatada = sdf.format(c.getData_Nascimento());
            }

            // --- INÍCIO DA FORMATAÇÃO DO CPF ---
            String cpfFormatado = c.getCpf();
            
            // Só tenta formatar se o CPF não for vazio e tiver exatamente 11 números
            if (cpfFormatado != null && cpfFormatado.length() == 11) {
                cpfFormatado = cpfFormatado.substring(0, 3) + "." + 
                               cpfFormatado.substring(3, 6) + "." + 
                               cpfFormatado.substring(6, 9) + "-" + 
                               cpfFormatado.substring(9, 11);
            }
            // -----------------------------------

            modelo.addRow(new Object[]{
                c.getId(), 
                c.getNome(),
                dataFormatada,
                cpfFormatado // <-- Trocamos c.getCpf() pela variável formatada aqui!
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "D. NASC.", "CPF"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("Excluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pesquisar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int linhaSelecionada = jTable1.getSelectedRow();
        
        if (linhaSelecionada == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente na tabela para excluir!");
            return;
        }
        
        int confirmacao = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Tem certeza que deseja excluir este cliente do banco de dados?",
            "Confirmar exclusão",
            javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirmacao == javax.swing.JOptionPane.YES_OPTION) {
            // Pega o ID do cliente que está na primeira coluna (índice 0) da linha selecionada
            int idCliente = (int) jTable1.getValueAt(linhaSelecionada, 0);
            
            // Chama o DAO para excluir de verdade do MySQL
            dao.ClienteDAO dao = new dao.ClienteDAO();
            dao.excluir(idCliente); // ATENÇÃO: Você precisa criar esse método no DAO!
            
            // Atualiza a tabela mostrando que o cliente sumiu
            preencherTabela(dao.listarTodos());
            
            javax.swing.JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String textoPesquisa = jTextField1.getText();
        
        // Agora quem faz a busca inteligente é o Banco de Dados, não mais o 'for' do Java!
        dao.ClienteDAO dao = new dao.ClienteDAO();
        java.util.List<model.Cliente> lista = dao.buscarPorNome(textoPesquisa);
        
        preencherTabela(lista);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField1.setText(""); // Limpa a caixa de texto
        
        // Busca todos do banco novamente
        dao.ClienteDAO dao = new dao.ClienteDAO();
        preencherTabela(dao.listarTodos());
                                                

  
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables


}
