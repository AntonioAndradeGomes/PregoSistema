package view;

import java.sql.*;
import conection.ConnectionFactory;
import controller.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
public class TelaLogin extends javax.swing.JFrame {
    
    private Connection con = null;
    private IControleLogin controle = new ControleLogin();
    private boolean conec = false;
    public TelaLogin() {
        initComponents();
        con = ConnectionFactory.getConnection();
        //lembrar que em disposes acabar com essa conexao
        if (this.con != null){
            this.status_conexao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/bancoConectado.png")));
            this.conec = true;
        }else{
            this.status_conexao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/bancoDesconectado.png")));
        }
        this.saudar();
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

        jLabel1 = new javax.swing.JLabel();
        User = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        btnlogar = new javax.swing.JButton();
        btnCriarUsu = new javax.swing.JButton();
        status_conexao = new javax.swing.JLabel();
        saudacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        setBackground(new java.awt.Color(38, 240, 242));
        setResizable(false);

        jLabel1.setText("UserName: ");

        jLabel2.setText("Senha:");

        btnlogar.setText("Entrar");
        btnlogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogarActionPerformed(evt);
            }
        });

        btnCriarUsu.setText("Novo Usuario");
        btnCriarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarUsuActionPerformed(evt);
            }
        });

        status_conexao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/bancoConectado.png"))); // NOI18N

        saudacao.setText("Saudacao");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCriarUsu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addComponent(btnlogar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(status_conexao)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(senha)
                            .addComponent(User)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(saudacao)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status_conexao)
                    .addComponent(saudacao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlogar)
                    .addComponent(btnCriarUsu))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogarActionPerformed
        if(controle.controleLogin(this.User.getText(), this.senha.getText())){
            ConnectionFactory.closeConnection(con);
            this.dispose();
        }
    }//GEN-LAST:event_btnlogarActionPerformed

    private void btnCriarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarUsuActionPerformed
        if(conec){
            controle.controleNovoUsuario();
            ConnectionFactory.closeConnection(con);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Banco de Dados desconectado!!");
        }
        
    }//GEN-LAST:event_btnCriarUsuActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField User;
    private javax.swing.JButton btnCriarUsu;
    private javax.swing.JButton btnlogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel saudacao;
    private javax.swing.JPasswordField senha;
    private javax.swing.JLabel status_conexao;
    // End of variables declaration//GEN-END:variables
}
