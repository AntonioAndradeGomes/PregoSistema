
package view;

import controller.ControleDevedores;
import controller.ControleLogin;
import controller.IControleDevedores;
import controller.IControleLogin;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Devedor;
import model.bean.Usuario;

public class ListarDevedores extends javax.swing.JInternalFrame {
    
    private String user;
    private IControleDevedores controle = new ControleDevedores();
    private JDesktopPane d;
    private String nomeDevedor;
    
    public ListarDevedores(String user, JDesktopPane d) {
        initComponents();
        this.user = user;
        this.d = d;
        this.read();
        this.destivarBotoes();
    }

    private String getUser() {
        return user;
    }

    private IControleDevedores getControle() {
        return controle;
    }

    public JDesktopPane getD() {
        return d;
    }

    private String getNomeDevedor() {
        return nomeDevedor;
    }

    private void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    private void read(){
        
        //falta tocar o id pelo numero de dividas, em resumo pegar todas as dividas de determinado devedor
         DefaultTableModel modelo = (DefaultTableModel) this.tabelaDevedores.getModel();
         modelo.setNumRows(0); //eliminar duplicadas do java 
         
         for (Devedor d: this.getControle().listarDevedores(this.getUser())){
             //terminar
             modelo.addRow(new Object[]{
                 d.getNome(),
                 d.getCidade(),
                 d.getTelefone1(),
                 //d.getId()
                 d.getDividas().size() //pegar a quantidade de dividas do devedor
                                       //lembrar de preencher esse array no momento da criação do objeto
             });
         } 
    }
    
    private void ativarBotoes(){
        this.btnAtualizarDevedor.setEnabled(true); 
        this.btnCriarDivida.setEnabled(true);
        this.btnDeletarDevedor.setEnabled(true); 
        this.btninformacoesDevedor.setEnabled(true);
        this.btnverDividasDevedor.setEnabled(true);
    }
    private void destivarBotoes(){
        this.btnAtualizarDevedor.setEnabled(false); //desativar botão atualizar devedor
        this.btnCriarDivida.setEnabled(false); //desativa botao de criar divida
        this.btnDeletarDevedor.setEnabled(false); //destaiva botao de deletarDevedor
        this.btninformacoesDevedor.setEnabled(false);
        this.btnverDividasDevedor.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDevedores = new javax.swing.JTable();
        btnDeletarDevedor = new javax.swing.JButton();
        btnAtualizarDevedor = new javax.swing.JButton();
        btninformacoesDevedor = new javax.swing.JButton();
        btnverDividasDevedor = new javax.swing.JButton();
        btnCriarDivida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Lista de Devedores");
        setMaximumSize(new java.awt.Dimension(771, 562));
        setMinimumSize(new java.awt.Dimension(771, 562));
        setPreferredSize(new java.awt.Dimension(771, 562));

        tabelaDevedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cidade", "Telefone", "Numero de dividas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaDevedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDevedoresMouseClicked(evt);
            }
        });
        tabelaDevedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaDevedoresKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaDevedores);

        btnDeletarDevedor.setText("Deletar Devedor");
        btnDeletarDevedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarDevedorActionPerformed(evt);
            }
        });

        btnAtualizarDevedor.setText("Atualizar Devedor");
        btnAtualizarDevedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarDevedorActionPerformed(evt);
            }
        });

        btninformacoesDevedor.setText("Informações completas");
        btninformacoesDevedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninformacoesDevedorActionPerformed(evt);
            }
        });

        btnverDividasDevedor.setText("Ver Dividas");

        btnCriarDivida.setText("Criar Divida");
        btnCriarDivida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarDividaActionPerformed(evt);
            }
        });

        jLabel1.setText("Dê dois cliques sobre uma linha da tabela e poderas usar os botões abiaxo corretamente.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel1)
                .addContainerGap(189, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDeletarDevedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizarDevedor)
                .addGap(45, 45, 45)
                .addComponent(btninformacoesDevedor)
                .addGap(46, 46, 46)
                .addComponent(btnverDividasDevedor)
                .addGap(44, 44, 44)
                .addComponent(btnCriarDivida)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletarDevedor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizarDevedor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btninformacoesDevedor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnverDividasDevedor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCriarDivida, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaDevedoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaDevedoresKeyPressed
        this.ativarBotoes();
        if (this.tabelaDevedores.getSelectedRow() != -1) {
            this.setNomeDevedor(this.tabelaDevedores.getValueAt(this.tabelaDevedores.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tabelaDevedoresKeyPressed

    private void tabelaDevedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDevedoresMouseClicked
        this.ativarBotoes();
        if (this.tabelaDevedores.getSelectedRow() != -1) {
            this.setNomeDevedor(this.tabelaDevedores.getValueAt(this.tabelaDevedores.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tabelaDevedoresMouseClicked
    
    private void btnDeletarDevedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarDevedorActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir esse devedor? \n"
                + "Saiba que todos seus dados e dividas serão perdidos!!", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION){
            IControleLogin contr1 = new ControleLogin();
            Usuario user = contr1.buscaUser(this.getUser());
            IControleDevedores contr2 = new ControleDevedores();
            Devedor selecionado = contr2.buscaDedevor(user, this.getNomeDevedor());
            contr2.excluirDevedor(user, selecionado);
            this.destivarBotoes();
            this.read();
            
        }
    }//GEN-LAST:event_btnDeletarDevedorActionPerformed

    private void btninformacoesDevedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninformacoesDevedorActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja ver todos os dados desse devedor?"
                , "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION){
            IControleLogin contr1 = new ControleLogin();
            Usuario user = contr1.buscaUser(this.getUser());
            IControleDevedores contr2 = new ControleDevedores();
            Devedor selecionado = contr2.buscaDedevor(user, this.getNomeDevedor());
            JOptionPane.showMessageDialog(null, "Nome: " + selecionado.getNome() + "\n"
                    + "Cidade: " + selecionado.getCidade() + "\n"
                    + "Bairro: " + selecionado.getBairro() +  "\n"
                    + "Rua: " + selecionado.getRua() +  "\n"
                    + "Complemento: " + selecionado.getComplemento() + "\n"
                    + "Telefone 1: " + selecionado.getTelefone1() + "\n" +
                    "Telefone 2: " + selecionado.getTelefone2());
        }
    }//GEN-LAST:event_btninformacoesDevedorActionPerformed

    private void btnAtualizarDevedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarDevedorActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja atualizar os dados desse devedor?"
                , "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION){
            IControleLogin contr1 = new ControleLogin();
            Usuario user = contr1.buscaUser(this.getUser());
            Devedor dev = this.getControle().buscaDedevor(user, this.getNomeDevedor());
            AtualizarDevedor tela = new AtualizarDevedor(user, dev, this.getD());
            tela.setarcampos();
            this.getD().add(tela);
            tela.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnAtualizarDevedorActionPerformed

    private void btnCriarDividaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarDividaActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Desejas cadastrar um divida para esse devedor?", "Confirmar",
        JOptionPane.YES_NO_OPTION);
        
        if (confirma == JOptionPane.YES_OPTION){
            IControleLogin contr1 = new ControleLogin();
            Usuario user = contr1.buscaUser(this.getUser());
            Devedor dev = this.getControle().buscaDedevor(user, this.getNomeDevedor());
            CadastrarDividaDevedor tela = new CadastrarDividaDevedor(this.getD(), dev, user);
            this.getD().add(tela);
            tela.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCriarDividaActionPerformed
    
    private Usuario buscaUser(String user){
        IControleLogin cont = new ControleLogin();
        return cont.buscaUser(user);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarDevedor;
    private javax.swing.JButton btnCriarDivida;
    private javax.swing.JButton btnDeletarDevedor;
    private javax.swing.JButton btninformacoesDevedor;
    private javax.swing.JButton btnverDividasDevedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaDevedores;
    // End of variables declaration//GEN-END:variables
}
