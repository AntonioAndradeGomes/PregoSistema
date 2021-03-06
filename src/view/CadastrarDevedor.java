package view;

import controller.ControleDevedores;
import controller.ControleLogin;
import controller.IControleDevedores;
import controller.IControleLogin;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.bean.Devedor;
import model.bean.Usuario;

public class CadastrarDevedor extends javax.swing.JInternalFrame {
    private IControleDevedores controle = new ControleDevedores();
    private String user;
    private JDesktopPane d;
    private Devedor devedorAtualizar;
    
    public CadastrarDevedor(String user, JDesktopPane d) {
        this.user = user;
        this.d = d;
        initComponents();
    }

    public JDesktopPane getD() {
        return d;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public IControleDevedores getControle() {
        return controle;
    }
    
    private boolean verficarNome(String nome){
        if (nome.equals("")){
            return false;
        }else{
            return true;
        }
    }

    public Devedor getDevedorAtualizar() {
        return devedorAtualizar;
    }

    public void setDevedorAtualizar(Devedor devedorAtualizar) {
        this.devedorAtualizar = devedorAtualizar;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        devedorNome = new javax.swing.JTextField();
        devedorCidade = new javax.swing.JTextField();
        devedorBairro = new javax.swing.JTextField();
        devedorRua = new javax.swing.JTextField();
        devedorCompl = new javax.swing.JTextField();
        devedorTelef1 = new javax.swing.JTextField();
        devedorTelf2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastrar Devedor");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(771, 562));
        setMinimumSize(new java.awt.Dimension(771, 562));
        setPreferredSize(new java.awt.Dimension(771, 562));

        jLabel1.setText("Nome do Devedor*");

        jLabel2.setText("Cidade");

        jLabel3.setText("Bairro");

        jLabel4.setText("Rua");

        jLabel5.setText("Complemento");

        jLabel6.setText("Telefone1");

        jLabel7.setText("Telefone2");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel9.setText("Observações:");

        jLabel10.setText("As informações com * são essenciais");

        jLabel11.setText("Devedores não devem ter nomes iguais");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(devedorTelef1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(devedorTelf2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCadastrar)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(devedorNome, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                                    .addComponent(devedorCidade)
                                    .addComponent(devedorRua)
                                    .addComponent(devedorBairro)
                                    .addComponent(devedorCompl)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(devedorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(devedorCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(devedorBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(devedorRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(devedorCompl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(devedorTelef1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(devedorTelf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Quer cadastrar esse devedor?",
                                                    "Confiarmar", JOptionPane.YES_NO_OPTION);
        IControleLogin cont = new ControleLogin();
        if (confirma == JOptionPane.YES_OPTION && this.verficarNome(this.devedorNome.getText())
                && this.getControle().existeDevedor(this.devedorNome.getText(), this.getUser())){
            Usuario user = cont.buscaUser(this.getUser());
            Devedor devedor = new Devedor (user,  this.devedorNome.getText(), this.devedorCidade.getText(),
                    this.devedorBairro.getText(), this.devedorRua.getText(), this.devedorCompl.getText(),
                    this.devedorTelef1.getText(), this.devedorTelf2.getText());
            
            if(this.getControle().cadastrarDevedor(devedor)){
                int confirma2 = JOptionPane.showConfirmDialog(null, "Quer cadastrar a primeira divida do devedor " + this.devedorNome.getText(),
                                                    "Confiarmar", JOptionPane.YES_NO_OPTION);
                
                if(confirma2 == JOptionPane.YES_OPTION){
                    //cria a tela de cadastro de divida, que recebe esse devedor novo
                    CadastrarDividaDevedor tela = new CadastrarDividaDevedor(this.getD(),devedor, user); //melhorar, não tem id
                    tela.setVisible(true);
                    this.getD().add(tela);
                    this.dispose();
                }else{
                    this.setarCampos();
                }
            }else{
                //nada
            }
        }else if(this.getControle().existeDevedor(this.devedorNome.getText(), this.getUser()) == false){
             JOptionPane.showMessageDialog(null, "Já existe devedor com esse nome!");
        }else if(this.verficarNome(this.devedorNome.getText()) == false){
            JOptionPane.showMessageDialog(null, "Campo NOME DO DEVEDOR não foi preenchido CORRETAMENTE!");
        }else{
                JOptionPane.showMessageDialog(null, "Campos não foram preenchidos CORRETAMENTE!");
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed
    
    private void setarCampos(){
        this.devedorNome.setText(""); this.devedorBairro.setText(""); this.devedorCidade.setText("");
        this.devedorRua.setText(""); this.devedorCompl.setText("");this.devedorTelef1.setText("");
        this.devedorTelf2.setText("");
    }

    private Usuario buscaUser(String user){
        IControleLogin cont = new ControleLogin();
        return cont.buscaUser(user);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JTextField devedorBairro;
    private javax.swing.JTextField devedorCidade;
    private javax.swing.JTextField devedorCompl;
    private javax.swing.JTextField devedorNome;
    private javax.swing.JTextField devedorRua;
    private javax.swing.JTextField devedorTelef1;
    private javax.swing.JTextField devedorTelf2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
