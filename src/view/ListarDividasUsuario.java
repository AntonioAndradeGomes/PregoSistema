package view;

import controller.ControleDivida;
import controller.IControleDivida;
import javax.swing.JDesktopPane;
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDividas = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bntSetarPaga = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

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

        jButton2.setText("Excluir Dívida");

        bntSetarPaga.setText("Alterar Dívida Para Paga");

        jButton4.setText("Mais informações da Dívida");

        jButton5.setText("Editar Dívida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(37, 37, 37)
                        .addComponent(jButton4)
                        .addGap(45, 45, 45)
                        .addComponent(bntSetarPaga)
                        .addGap(37, 37, 37)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(jButton2)
                    .addComponent(bntSetarPaga)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSetarPaga;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaDividas;
    // End of variables declaration//GEN-END:variables

}
