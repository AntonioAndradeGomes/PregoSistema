package controller;

import conection.ConnectionFactory;
import java.sql.*;
import javax.swing.JOptionPane;
import model.dao.UsuarioDao;
import model.bean.Usuario;
import view.NovoUsuario;
import view.TelaPrincipal;

public class ControleLogin implements IControleLogin {

    private Connection conexao = null;
    private PreparedStatement stmt = null; //conjunto de bibliotecas para manipular as instruções sql
    private ResultSet rs = null; //exibe o resultado das instruções sql feitos no java

    public boolean controleLogin(String UserName, String senha) {
        this.conexao = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM `PregoSistema`.`Usuario` WHERE UserNome=? and Senha=?";
        try {
            stmt = conexao.prepareStatement(sql);//preparam a string para a ser executada no bd
            stmt.setString(1, UserName);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if (rs.next()) {
                TelaPrincipal tela = new TelaPrincipal();
                tela.setUserName(UserName); //Salvar o nome do usauraio

                tela.setVisible(true);
                ConnectionFactory.closeConnection(conexao, stmt, rs);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Não foi encontrado essa entidade no BD");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        } finally {
            ConnectionFactory.closeConnection(conexao, stmt, rs);
        }
    }

    public void controleNovoUsuario() {
        NovoUsuario tela = new NovoUsuario();
        tela.setVisible(true);
    }

    public boolean cadastarUsuario(String nome, String senha) {
        Usuario user = new Usuario(nome, senha);
        if (UsuarioDao.create(user)) {
            this.controleLogin(nome, senha);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletarUsuario(String UserName) {
        int confirma = JOptionPane.showConfirmDialog(null, "Quer deletar este usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            Usuario user = UsuarioDao.readUsuario(UserName);
            UsuarioDao.remove(user);
            return true;
        } else {
            return false;
        }
    }

    public Usuario buscaUser(String UserName) {
        return UsuarioDao.readUsuario(UserName);
    }

    public boolean atualizarUser(Usuario antigo, Usuario novo) {
        int confirma = JOptionPane.showConfirmDialog(null, "Quer atualizar este usuario com esses dados?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            UsuarioDao.update(antigo, novo);
            return true;
        } else {
            return false;
        }
    }

}
