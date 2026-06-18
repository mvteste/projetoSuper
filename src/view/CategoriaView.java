package view;

import controller.CategoriaController;
import java.awt.HeadlessException;
import javax.swing.*;

public class CategoriaView extends JPanel {

    public CategoriaView() {
        initComponents();
        controller = new CategoriaController();
    }
         
    // Referência para o Controller
    private CategoriaController controller;
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cadastro de Categorias");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel2.setText("Nome:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 43, -1, -1));
        add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 40, 306, -1));

        jButton1.setText("Limpar");

        jButton2.setText("Salvar");
        jButton2.addActionListener(this::btnSalvar);

        jButton3.setText("Cancelar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jButton3)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 93, 388, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvar
        // Evento do botão Salvar
        acaoSalvar();
        };

        private void acaoSalvar() {
            try {
                String nome = txtNome.getText();               

                // Enviamos para o Controller processar
                controller.salvarCategoria(nome);

                JOptionPane.showMessageDialog(this, "Categoria '" + nome + "' cadastrado com sucesso!");
                limparCampos();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erro: O preço deve ser um número válido.");
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
            }
        }

        private void limparCampos() {
            txtNome.setText("");
            txtNome.requestFocus();

    }//GEN-LAST:event_btnSalvar


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
