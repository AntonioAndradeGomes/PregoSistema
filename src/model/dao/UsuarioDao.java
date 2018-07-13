package model.dao;

import conection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Usuario;

public class UsuarioDao {
    public void create(Usuario usuario){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into `PregoSistema`.`Usuario`(Nome) values (?)");
            stmt.setString(1, usuario.getNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Salvo com sucesso o novo usuario no BD!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar o novo cliente! \n"
                            + e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
//    public ArrayList<Usuario> readUsuario(){
//        //pensar em receber tambem as dividas por usaurio somente nesse metodo 
//        Connection con = ConnectionFactory.getConnection();
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        ArrayList<Usuario> usuario = new ArrayList<>();
//        try {
//            
//        } catch (Exception e) {
//        }
//    }
}
