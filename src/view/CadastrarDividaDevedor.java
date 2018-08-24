package view;


import controller.ControleDivida;
import controller.IControleDivida;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.bean.Devedor;
import model.bean.Usuario;

public class CadastrarDividaDevedor extends javax.swing.JInternalFrame {
    
    private JDesktopPane desktop;
    private Devedor devedor;
    private Usuario user;
    
    public CadastrarDividaDevedor(JDesktopPane desktop, Devedor devedor, Usuario user) {
        initComponents();
        this.desktop = desktop;
        this.devedor = devedor;
        this.user = user;
        this.setarCampos();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public JDesktopPane getDesktop() {
        return desktop;
    }

    public Devedor getDevedor() {
        return devedor;
    }
    
    private void setarCampos(){
        this.nomeDevedor.setText(this.getDevedor().getNome());
        this.numeroDevidas.setText("" + this.getDevedor().getDividas().size());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nomeDevedor = new javax.swing.JLabel();
        numeroDevidas = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtEspecificacao = new javax.swing.JTextField();
        Salvar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();

        setClosable(true);
        setResizable(true);
        setTitle("Cadastrar dívida para um devedor");
        setMaximumSize(new java.awt.Dimension(771, 562));
        setMinimumSize(new java.awt.Dimension(771, 562));
        setPreferredSize(new java.awt.Dimension(771, 562));

        jLabel1.setText("*Valor da Divida:");

        jLabel2.setText("Especificação:");

        jLabel3.setText("Data de fechamento:");

        jLabel4.setText("Devedor:");

        nomeDevedor.setText("nomeDevedor");

        numeroDevidas.setText("numero de dividas");

        Salvar.setText("Salvar");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("itens com * são obrigatorios");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeroDevidas)
                            .addComponent(nomeDevedor))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(434, 434, 434)
                        .addComponent(Salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEspecificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(15, 15, 15)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEspecificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nomeDevedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numeroDevidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        ListarDevedores tela = new ListarDevedores(this.getUser().getNome(), this.getDesktop());
        this.getDesktop().add(tela);
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed
    private double verficaValor(String valor){
        double valorf = -1;
        try {
            valorf = Double.parseDouble(valor);
        } catch (Exception e) {
        }
        return valorf;
    }
    private void limparCampos(){
        this.txtValor.setText("");
        this.txtEspecificacao.setText("");
        this.txtData.setText("");
    }
    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed

        if (this.verficaValor(this.txtValor.getText()) >= 0){
            IControleDivida controle = new ControleDivida();
            double valor = Double.parseDouble(this.txtValor.getText());
            if (this.txtData.getText().equals("  /  /    ")){
                controle.cadastrarDivida(this.getDevedor(), valor, this.txtEspecificacao.getText(), null);
                this.limparCampos();
            }else{
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date data;
                try {
                    data = formato.parse(this.txtData.getText());
                    controle.cadastrarDivida(this.getDevedor(), valor, this.txtEspecificacao.getText(), data);
                    this.limparCampos();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro de digitação de data \n" + e);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Campo de valor obrigatorio \n"
                    + "Campo de valor deve ser preenchido corretamente");
        }

    }//GEN-LAST:event_SalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Salvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel nomeDevedor;
    private javax.swing.JLabel numeroDevidas;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEspecificacao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
