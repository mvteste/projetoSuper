/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import model.Categoria;
import model.Produto;

/**
 *
 * @author GUSTAVOSCALEIMORAES
 */
public class ProdutoView extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProdutoView
     */
    public ProdutoView() {
        initComponents();
        carregarCategorias(); // Adicione esta linha aqui!
    }

    // --- CRIE ESTE MÉTODO AQUI ---
    private void carregarCategorias() {
        dao.CategoriaDAO dao = new dao.CategoriaDAO();
        java.util.List<model.Categoria> lista = dao.listarTodos();

        // 1. Limpa aqueles "Item 1, Item 2" padrões do NetBeans
        jComboBox1.removeAllItems(); 

        // 2. Coloca as categorias que vieram do banco dentro da caixinha
        for (model.Categoria c : lista) {
    // Engana o Java forçando o componente a agir de forma genérica
    ((javax.swing.JComboBox) jComboBox1).addItem(c); 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        jLabel1.setText("Nome");

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Descrição");

        jLabel3.setText("Categoria");

        jLabel4.setText("Preço");

        try {
            jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Validade");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(142, 142, 142))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(41, 41, 41)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton1))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // 1. Pegar os textos da tela
        String nome = jTextField1.getText(); // Campo Nome
        String descricao = jTextField2.getText(); // Campo Descrição
        String dataValidadeTexto = jFormattedTextField2.getText(); // Campo Validade
        String precoTexto = jFormattedTextField1.getText(); // Campo Preço
        
        model.Categoria categoriaSelecionada = (model.Categoria) jComboBox1.getSelectedItem();

        // 2. Validações simples
        if(nome.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "O Nome do produto é obrigatório!");
            return;
        }
        if (categoriaSelecionada == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecione uma Categoria!");
            return;
        }

        // --- TRATANDO O PREÇO E TORNANDO OBRIGATÓRIO ---
        double precoConvertido = 0.0;
        // Limpa o R$, pontos e espaços
        String precoLimpo = precoTexto.replace("R$", "").replace(".", "").replace(",", ".").trim();
        
        // 1ª Validação: Verifica se o campo está vazio
        if (precoLimpo.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "O Preço do produto é obrigatório!");
            return; // Trava o cadastro aqui
        }

        try {
            precoConvertido = Double.parseDouble(precoLimpo);
            
            // 2ª Validação: Verifica se o preço é zero ou negativo
            if (precoConvertido <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "O Preço do produto deve ser maior que zero!");
                return; // Trava o cadastro aqui
            }
            
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, digite um preço numérico válido!");
            return; // Trava o cadastro aqui
        }
        // -----------------------------------------------

        // --- TRATANDO A DATA DE VALIDADE ---
        java.util.Date dataConvertida = null; // Criamos a variável fora do try para ela não "morrer"
        String dataLimpa = dataValidadeTexto.replace(" ", "");
        if(!dataLimpa.equals("//") && !dataLimpa.isEmpty()){
            try {
                java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd/MM/yyyy");
                formato.setLenient(false);
                dataConvertida = formato.parse(dataLimpa);
            } catch (java.text.ParseException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Data de validade inválida! Use o formato DD/MM/AAAA.");
                return; 
            }
        }
        // -----------------------------------

        // 3. Mandar para o Controller salvar no Banco de Dados!
        // Olha como fica limpo usar o Controller que você criou:
        controller.ProdutoController controller = new controller.ProdutoController();
        controller.salvarProduto(nome, precoConvertido, descricao, categoriaSelecionada, dataConvertida); 

        javax.swing.JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");

        // 4. Limpar a tela para o próximo cadastro
        jTextField1.setText("");
        jTextField2.setText("");
        jFormattedTextField1.setText(""); // Limpa o preço
        jFormattedTextField2.setText(""); // Limpa a data
        if (jComboBox1.getItemCount() > 0) {
            jComboBox1.setSelectedIndex(0); // Volta a categoria para o primeiro item
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables


}
