package model.dao;

import conection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Devedor;
import model.bean.Usuario;

public class DevedorDao {
    public static void create(Devedor devedor){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into `PregoSistema`.`Devedor`(Nome, Cidade, Bairro, "
                    + "Rua, Complemento, Telefone1, Telefone2, Usuario_UserNome) values (?,?,?,?,?,?,?,?)");
            stmt.setString(1, devedor.getNome());
            stmt.setString(2, devedor.getCidade());
            stmt.setString(3, devedor.getBairro());
            stmt.setString(4, devedor.getRua());
            stmt.setString(5, devedor.getComplemento());
            stmt.setString(6, devedor.getTelefone1());
            stmt.setString(7, devedor.getTelefone2());
            stmt.setString(8, devedor.getUsuario().getNome());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Salvo com sucesso o novo usuario no BD!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar novo Devedor!" + e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    //fiz uma busca por um usuario para ser passado como paramentro para criação de um objeto na funação abaixo
    public static Usuario buscaUsuario(String userName){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario user = null;
        
        try {
            stmt = con.prepareStatement("select * from `PregoSistema`.`Usuario` "
                    + "where `PregoSistema`.`Usuario`.`UserNome` = ?");
            stmt.setString(1, userName);
            rs = stmt.executeQuery();
            while(rs.next()){
                user = new Usuario(rs.getString(1),
                                   rs.getString(2));
            }
        } catch (Exception e) {
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return user;
    }
    
    public static ArrayList<Devedor> readDevedor(String userName){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Devedor> devedores = new ArrayList<>();
         
         try{
             stmt = con.prepareStatement("select * from `PregoSistema`.`Devedor` where"
                    + " `PregoSistema`.`Devedor`.`Usuario_UserNome` = ?");
             stmt.setString(1, userName);
             rs = stmt.executeQuery();
             while(rs.next()){
                 Devedor devedor = new Devedor(DevedorDao.buscaUsuario(userName), rs.getString(1), 
                 rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                 devedores.add(devedor);
             }
         }catch(Exception e){
         }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
         }
         return devedores;
    }
    
    
    
    
}
