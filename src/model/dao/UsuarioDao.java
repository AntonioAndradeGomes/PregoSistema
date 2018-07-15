package model.dao;

import conection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Usuario;

public class UsuarioDao {
    public static boolean create(Usuario usuario){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into `PregoSistema`.`Usuario`(UserNome, Senha) values (?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Salvo com sucesso o novo usuario no BD!");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar o novo Usuario! \n"
                            + e);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public static ArrayList<Usuario> readUsuario(){
//        //pensar em receber tambem as dividas por usaurio somente nesse metodo 
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            stmt = con.prepareCall("SELECT * FROM `PregoSistema`.`Usuario`");
            rs = stmt.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario(rs.getString(1),
                                              rs.getString(2));
                usuarios.add(usuario);
            }
        }catch (Exception e) {
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }
    
    public static void remove(Usuario usuario){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM `PregoSistema`.`Usuario` WHERE `PregoSistema`.`Usuario`.`UserNome`=? "
                    + "and `PregoSistema`.`Usuario`.`Senha` = ?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Usuario deletado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "erro! " +  e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public static void update(Usuario usuario, String userName_antigo){
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE `PregoSistema`.`Usuario` SET `UserNome`=?, `Senha`=? WHERE `UserNome`=?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, userName_antigo);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Dados do Usuario atualizados com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "erro! " +  e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt); 
        }
    }
}
