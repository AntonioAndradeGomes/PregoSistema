package model.dao;

import conection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Devedor;
import model.bean.Usuario;

public class DevedorDao {
    
    public static boolean create(Devedor devedor){
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
                    "Salvo com sucesso o novo Devedor no BD!");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar novo Devedor!"
                            + "\n" + e);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
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
                 Devedor devedor = new Devedor(UsuarioDao.readUsuario(userName), rs.getString(2), 
                 rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                // devedor.setDividas(DividaDao.readDividas(devedor));
                 devedor.setId(rs.getInt(1));
                 devedores.add(devedor);
             }
         }catch(Exception e){
         }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
         }
         return devedores;
    }
    
    public static boolean nomeIgual(String nome, String user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean vdd = false;
        try{
            stmt = con.prepareStatement("select * from `PregoSistema`.`Devedor` where "
                    + "`Devedor`.`nome` = ? and `Devedor`.`Usuario_UserNome` = ?");
            stmt.setString(1, nome);
            stmt.setString(2, user);
            rs = stmt.executeQuery();
            while(rs.next()){
                vdd = true;
                break;
            }
        }catch(Exception e){
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return vdd;
    }
    
    public static void removeDevedor(Usuario user, Devedor devedor){
        
    }
    
    public static Devedor buscarDevedorEspeci(Usuario user, String nomeDevedor){
        //Sera utilizado na tela de listar devedores
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Devedor devedor = null;
        try{
            stmt = con.prepareStatement("select * from `PregoSistema`.`Devedor` where "
                    + "`Devedor`.`nome` = ? and `Devedor`.`Usuario_UserNome` = ?");
            stmt.setString(1, nomeDevedor);
            stmt.setString(2, user.getNome());
            rs = stmt.executeQuery();
            while(rs.next()){
                devedor = new Devedor(user, rs.getString(2), 
                 rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                devedor.setId(rs.getInt(1));
            }
        }catch(Exception e){
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return devedor;
    }
}
