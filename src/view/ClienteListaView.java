package view;

import controller.ClienteController;
import model.Cliente;
import dao.ClienteDAO;
import java.util.List;
import javax.swing.*;
//import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
    
public final class ClienteListaView extends JPanel {
       
    // Referência para o Controller
    private final ClienteDAO clienteDao = new ClienteDAO();
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter;
    private ClienteDAO clienteDAO;  // ← ADICIONE ESTA LINHA
    
    public ClienteListaView() {
       initComponents(); 
     // ADICIONE AQUI o que falta
        inicializarComponentes();      
        clienteDAO = new ClienteDAO();  // ✅ Agora funciona
       // carregarDados();
          preencherTabela();   // Sua lógica de carregamento automático
        
}
      
       // Método NOVO que você cria manualmente
    private void inicializarComponentes() {
        // Aqui você inicializa o que o Design não criou
        clienteDAO = new ClienteDAO();
        Object tableModel = null;
        
        // Se o tableModel não foi criado pelo Design, crie aqui
        if (tableModel == null) {
            String[] colunas = {"ID", "Nome", "Email", "Telefone", "Endereço"};
            tableModel = new DefaultTableModel(colunas, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            
   
        }
    }
    


      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Clientes Cadastrados");

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "CPF", "E-mail", "Telefone", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaClientes.setName("tabelaClientes"); // NOI18N
        tabelaClientes.setOpaque(false);
        jScrollPane2.setViewportView(tabelaClientes);

        jButton1.setText("jButton1");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(146, 146, 146))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        
        //  carregarDados();
    }//GEN-LAST:event_jButton1ActionPerformed

   /* ==================== LÓGICA ==================== */
    
    
  /**
 * Busca os dados no banco de dados e popula o JTable.
 */
private void preencherTabela() {
    // 1. Instancia o Controller (que por sua vez chama o DAO)
    ClienteController controller = new ClienteController();
    List<Cliente> lista = controller.listarTodos();

    // 2. Obtém o modelo da tabela. 
    // Certifique-se que o nome da variável no Design é 'tblClientes'
    DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();

    // 3. Limpa a tabela para evitar duplicidade ao recarregar
    modelo.setNumRows(0);

    // 4. Itera sobre a lista de clientes e adiciona as linhas
    for (Cliente c : lista) {
        modelo.addRow(new Object[]{
            c.getId(),
            c.getNome(),
            c.getCpf(),
            c.getEmail(),            
            c.getTelefone(), // Adicione conforme os atributos do seu Model
            c.getEndereco()
        });
    }
}
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables

  
}
