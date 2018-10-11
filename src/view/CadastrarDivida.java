package view;

import controller.ControleDevedores;
import controller.ControleDivida;
import controller.IControleDevedores;
import controller.IControleDivida;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Devedor;
import model.bean.Usuario;

public class CadastrarDivida extends javax.swing.JInternalFrame {
    private Usuario user;
    private JDesktopPane desktop;
    private String nomeDevedor;
    
    public CadastrarDivida(Usuario user, JDesktopPane desktop) {
        initComponents();
        this.user = user;
        this.desktop = desktop;
        this.read();
        this.desativarCampos();
    }

    private Usuario getUser() {
        return user;
    }

    private JDesktopPane getDesktop(){
        return this.desktop;
    }

    private String getNomeDevedor() {
        return nomeDevedor;
    }

    private void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDevedores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnListar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEspecificacao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(771, 562));
        setMinimumSize(new java.awt.Dimension(771, 562));

        tabelaDevedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Devedor", "Quantidade de Dividas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

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

        jLabel1.setText("* Selecidione Devedor na tabela abaixo e após complete os campos.");

        jLabel2.setText("Ou vá para a tela de listagem de devedores e veja as informações de cada devedor");

        btnListar.setText("Listar Devedores");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jLabel3.setText("*Valor da Divida:");

        jLabel4.setText("Especificação:");

        jLabel5.setText("Data de fechamento:");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnSalvar.setText("Salvar Nova Divida");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair da Tela");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel6.setText("Para selecionar um devedor dê dois cliques sobre algum na tabela abaixo.");

        jLabel7.setText("Obs.: Para cadastrar o valor com os centavos use ponto(.) no lugar de vírgula(,)");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("R$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(64, 64, 64)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSair)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalvar))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEspecificacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel6))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEspecificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnSair))
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
       ListarDevedores tela = new ListarDevedores(this.getUser().getNome(), this.getDesktop());
       this.getDesktop().add(tela);
       tela.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que quer cadastrar uma divida para o devedor " + this.getNomeDevedor() + 
                                                    " com esses dados?",
                                                    "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            if (this.verficaValor(this.txtValor.getText()) >= 0){
                IControleDivida controle = new ControleDivida();
                double valor = Double.parseDouble(this.txtValor.getText());
                if (this.txtData.getText().equals("  /  /    ")){
                    controle.cadastrarDivida(this.buscaDevedor(this.getNomeDevedor(), this.getUser()), valor, this.txtEspecificacao.getText(), null);
                    this.limparCampos();
                }else{
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date data;
                    try {
                        data = formato.parse(this.txtData.getText());
                        controle.cadastrarDivida(this.buscaDevedor(this.getNomeDevedor(), this.getUser()), valor, this.txtEspecificacao.getText(), data);
                        this.limparCampos();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro de digitação de data \n" + e);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Campo de valor obrigatorio \n"
                    + "Campo de valor deve ser preenchido corretamente");
            }
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

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
        this.read();
    }
    
    private void tabelaDevedoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaDevedoresKeyPressed
        this.ativarCampos();
        if (this.tabelaDevedores.getSelectedRow() != -1) {
            this.setNomeDevedor(this.tabelaDevedores.getValueAt(this.tabelaDevedores.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tabelaDevedoresKeyPressed

    private void tabelaDevedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDevedoresMouseClicked
        this.ativarCampos();
        if (this.tabelaDevedores.getSelectedRow() != -1) {
            this.setNomeDevedor(this.tabelaDevedores.getValueAt(this.tabelaDevedores.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_tabelaDevedoresMouseClicked
    
    private Devedor buscaDevedor(String nomeDevedor, Usuario user){
        IControleDevedores controle = new ControleDevedores();
        Devedor devedor = controle.buscaDedevor(user, nomeDevedor);
        return devedor;
    }
    private void desativarCampos(){
        //this.txtData.setEditable(false);
        this.txtData.setEnabled(false);
        this.txtValor.setEnabled(false);
        this.txtEspecificacao.setEnabled(false);
//        this.txtValor.setEditable(false);
//        this.txtEspecificacao.setEditable(false);
        this.btnSalvar.setEnabled(false);
    }
    
    private void ativarCampos(){
        this.txtData.setEnabled(true);
        this.txtEspecificacao.setEnabled(true);
        this.txtValor.setEnabled(true);
        this.btnSalvar.setEnabled(true);
    }
    
    private void read(){
        IControleDevedores controle = new ControleDevedores();
        
        DefaultTableModel modelo = (DefaultTableModel) this.tabelaDevedores.getModel();
        modelo.setNumRows(0); //eliminar duplicadas do java 
        for (Devedor d: controle.listarDevedores(this.getUser().getNome())){
             //terminar
             modelo.addRow(new Object[]{
                 d.getNome(),
                 d.getDividas().size() //pegar a quantidade de dividas do devedor
                                       //lembrar de preencher esse array no momento da criação do objeto
            });
        } 
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaDevedores;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEspecificacao;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
