package view;

import controller.ControleDivida;
import controller.IControleDivida;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Divida;
import model.bean.Usuario;

public class ListarDividasUsuario extends javax.swing.JInternalFrame {
    
    private Usuario user;
    private JDesktopPane desktop;
    private IControleDivida controle = new ControleDivida();
    private Divida dividaSelecionada = null;
    
    public ListarDividasUsuario(Usuario user, JDesktopPane desktop) {
        initComponents();
        this.user = user;
        this.desktop = desktop;
        this.read();
        this.cancelarBotoes();
    }

    public Usuario getUser() {
        return user;
    }

    public JDesktopPane getDesktop() {
        return desktop;
    }

    public IControleDivida getControle() {
        return controle;
    }

    public Divida getDividaSelecionada() {
        return dividaSelecionada;
    }

    public void setDividaSelecionada(Divida dividaSelecionada) {
        this.dividaSelecionada = dividaSelecionada;
    }
   
    private void read(){
    //falta tocar o id pelo numero de dividas, em resumo pegar todas as dividas de determinado devedor
         DefaultTableModel modelo = (DefaultTableModel) this.tabelaDividas.getModel();
         modelo.setNumRows(0); //eliminar duplicadas do java 
         
         for (Divida d: this.getControle().listarDividasTodas(this.getUser())){
            modelo.addRow(new Object[]{
               d.getId(),
               d.getDevedor().getNome(),
               d.getValor(),
               d.getStatus(),
               d.getEspecificacao()
            });
         }
    }
    
    private void cancelarBotoes(){
        this.btnSetarPaga.setEnabled(false);
        this.btnEditar.setEnabled(false);
        this.btnInfo.setEnabled(false);
        this.btnExcluir.setEnabled(false);
    }
    
    private void ativarBotoes(){
        this.btnSetarPaga.setEnabled(true);
        this.btnEditar.setEnabled(true);
        this.btnInfo.setEnabled(true);
        this.btnExcluir.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDividas = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSetarPaga = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Listar Todas as Dividas");
        setMaximumSize(new java.awt.Dimension(771, 562));
        setMinimumSize(new java.awt.Dimension(771, 562));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(771, 562));

        tabelaDividas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Devedor", "Valor", "Status", "Especificação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaDividas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDividasMouseClicked(evt);
            }
        });
        tabelaDividas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaDividasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaDividas);
        if (tabelaDividas.getColumnModel().getColumnCount() > 0) {
            tabelaDividas.getColumnModel().getColumn(0).setMinWidth(0);
            tabelaDividas.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabelaDividas.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir Dívida");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSetarPaga.setText("Alterar Dívida Para Paga");
        btnSetarPaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetarPagaActionPerformed(evt);
            }
        });

        btnInfo.setText("Mais informações da Dívida");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar Dívida");

        jLabel2.setText("Para ativar os botões abaixo e para segurança dê dois cliques numa dívida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditar)
                        .addGap(37, 37, 37)
                        .addComponent(btnInfo)
                        .addGap(45, 45, 45)
                        .addComponent(btnSetarPaga)
                        .addGap(46, 46, 46)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnExcluir)
                    .addComponent(btnSetarPaga)
                    .addComponent(btnInfo)
                    .addComponent(btnEditar))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tabelaDividasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaDividasKeyPressed
        if(this.tabelaDividas.getSelectedRow() != -1){
            this.ativarBotoes();
            try {
                String num = this.tabelaDividas.getValueAt(this.tabelaDividas.getSelectedRow(), 0).toString();
                int n = Integer.parseInt(num);
                Divida d = this.getControle().buscarDivida(n, this.getUser());
                this.setDividaSelecionada(d);
            } catch (Exception e) {
                this.cancelarBotoes();
            }
        }
    }//GEN-LAST:event_tabelaDividasKeyPressed

    private void tabelaDividasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDividasMouseClicked
        if(this.tabelaDividas.getSelectedRow() != -1){
            this.ativarBotoes();
            try {
                String num = this.tabelaDividas.getValueAt(this.tabelaDividas.getSelectedRow(), 0).toString();
                int n = Integer.parseInt(num);
                Divida d = this.getControle().buscarDivida(n, this.getUser());
                this.setDividaSelecionada(d);
            } catch (Exception e) {
                this.cancelarBotoes();
            }
        }
    }//GEN-LAST:event_tabelaDividasMouseClicked

    private void btnSetarPagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetarPagaActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja alterar o status dessa dívida para pago?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION){
            Date data = new Date();
            this.getControle().dividaPaga(this.getDividaSelecionada(), data);
            this.read();
        }
    }//GEN-LAST:event_btnSetarPagaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         int confirma = JOptionPane.showConfirmDialog(null, "Deseja alterar excluir essa dívida?", "Confirmar", JOptionPane.YES_NO_OPTION);
         if(confirma == JOptionPane.YES_OPTION){
             this.getControle().excluirDivida(this.getDividaSelecionada());
             this.cancelarBotoes();
             this.read();
         }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja saber informações completas sobre essa dívida?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            if(this.getDividaSelecionada().getStatus().equals("Paga")){
                JOptionPane.showMessageDialog(null, "Devedor: " + getDividaSelecionada().getDevedor().getNome() + "\n" +
                                                     "Valor: R$" + getDividaSelecionada().getValor() + "\n" +
                                                      "Especificação: " + getDividaSelecionada().getEspecificacao() + "\n"+
                                                      "Status: " + getDividaSelecionada().getStatus() + "\n"+
                                                      "Data de aberuta: " + getDividaSelecionada().getData_abertura()+ "\n" +
                                                      "Data em que o usúario acredita(va) que será(ou seria) pago: " + getDividaSelecionada().getData_fechamento() + "\n" +
                                                       "Data de pagamento: " + getDividaSelecionada().getData_pagamento());
            }else{
                JOptionPane.showMessageDialog(null, "Devedor: " + getDividaSelecionada().getDevedor().getNome() + "\n" +
                                                     "Valor: R$" + getDividaSelecionada().getValor() + "\n" +
                                                      "Especificação: " + getDividaSelecionada().getEspecificacao() + "\n"+
                                                      "Status: " + getDividaSelecionada().getStatus() + "\n"+
                                                      "Data de aberuta: " + getDividaSelecionada().getData_abertura()+ "\n" +
                                                      "Data em que o usúario acredita(va) que será pago: " + getDividaSelecionada().getData_fechamento() + "\n" +
                                                       "Devedor ainda não efetuou o pagamento!!");
            }
        }
    }//GEN-LAST:event_btnInfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSetarPaga;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaDividas;
    // End of variables declaration//GEN-END:variables

}
