package view;

import controller.ControleLogin;
import controller.IControleLogin;
import java.util.Calendar;
import model.bean.Usuario;

public class TelaPrincipal extends javax.swing.JFrame {
    
    
    private String userName;

    public TelaPrincipal() {
        initComponents();
        this.saudar();
    }

    private String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    private void saudar(){
        Calendar c1 = Calendar.getInstance();
        int hora =  c1.get(Calendar.HOUR_OF_DAY);
        if(hora > 5 && hora < 12){
            this.saudacao.setText("Bom Dia");
        }else if (hora > 12 && hora < 18){
            this.saudacao.setText("Boa Tarde");
        }else{
            this.saudacao.setText("Boa noite");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        btnListarDevedores = new javax.swing.JButton();
        btnCadastrarDivida = new javax.swing.JButton();
        CriarDevedor = new javax.swing.JButton();
        Sair = new javax.swing.JButton();
        excluirUsuario = new javax.swing.JButton();
        usuario = new javax.swing.JLabel();
        btnListarDividas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        saudacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        setMaximumSize(new java.awt.Dimension(986, 573));
        setMinimumSize(new java.awt.Dimension(986, 573));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        desktop.setMaximumSize(new java.awt.Dimension(771, 562));
        desktop.setMinimumSize(new java.awt.Dimension(771, 562));

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 771, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnListarDevedores.setText("Listar Devedores");
        btnListarDevedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarDevedoresActionPerformed(evt);
            }
        });

        btnCadastrarDivida.setText("Criar Divida");
        btnCadastrarDivida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarDividaActionPerformed(evt);
            }
        });

        CriarDevedor.setText("Criar Devedor");
        CriarDevedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarDevedorActionPerformed(evt);
            }
        });

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        excluirUsuario.setText("Excluir usuario");
        excluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirUsuarioActionPerformed(evt);
            }
        });

        usuario.setText("Usuario");

        btnListarDividas.setText("Listar Dividas");
        btnListarDividas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarDividasActionPerformed(evt);
            }
        });

        jButton1.setText("Atualizar Usuario");
        jButton1.setToolTipText("Atualizar dados do Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        saudacao.setText("saudacao");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnListarDevedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListarDividas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadastrarDivida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CriarDevedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(excluirUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saudacao)
                            .addComponent(usuario))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnListarDividas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarDevedores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrarDivida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CriarDevedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                        .addComponent(saudacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuario)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(excluirUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sair)
                        .addGap(49, 49, 49))
                    .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.usuario.setText(this.getUserName());
    }//GEN-LAST:event_formWindowActivated

    private void btnListarDevedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarDevedoresActionPerformed
        ListarDevedores tela = new ListarDevedores(this.getUserName(), this.desktop);
        tela.setVisible(true);
        this.desktop.add(tela);
    }//GEN-LAST:event_btnListarDevedoresActionPerformed

    private void CriarDevedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarDevedorActionPerformed
        CadastrarDevedor tela = new CadastrarDevedor(this.getUserName(), this.desktop);
        tela.setVisible(true);
        this.desktop.add(tela);
    }//GEN-LAST:event_CriarDevedorActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void excluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirUsuarioActionPerformed
        IControleLogin cont = new ControleLogin();
        if(cont.deletarUsuario(this.getUserName())){
            TelaLogin tela = new TelaLogin();
            tela.setVisible(true);
            this.dispose();
        };
        
    }//GEN-LAST:event_excluirUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        IControleLogin cont = new ControleLogin();
        AtualizarUsuario tela = new AtualizarUsuario();
        tela.setUser(cont.buscaUser(this.getUserName()));
        tela.setarCampos();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnListarDividasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarDividasActionPerformed
        IControleLogin cont = new ControleLogin();
        ListarDividasUsuario tela = new ListarDividasUsuario(cont.buscaUser(this.getUserName()), this.desktop);
        this.desktop.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_btnListarDividasActionPerformed

    private void btnCadastrarDividaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarDividaActionPerformed
        IControleLogin cont = new ControleLogin();
        Usuario user = cont.buscaUser(this.getUserName());
        CadastrarDivida tela = new CadastrarDivida(user, this.desktop);
        tela.setVisible(true);
        this.desktop.add(tela);
    }//GEN-LAST:event_btnCadastrarDividaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CriarDevedor;
    private javax.swing.JButton Sair;
    private javax.swing.JButton btnCadastrarDivida;
    private javax.swing.JButton btnListarDevedores;
    private javax.swing.JButton btnListarDividas;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JButton excluirUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel saudacao;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
