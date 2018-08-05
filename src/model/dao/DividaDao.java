package model.dao;

import conection.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.*;

public class DividaDao {

    public static void create(Divida divida) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            if (divida.getData_fechamento() != null){
                stmt = con.prepareStatement("INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, "
                    + "`Status`, `Datadeabertura`, `Datadefechamento`) VALUES (?, ?, ?, ?, ?, ?)");
                stmt.setInt(1, divida.getDevedor().getId());
                stmt.setDouble(2, divida.getValor());
                stmt.setString(3,divida.getEspecificacao());
                stmt.setString(4, divida.getStatus());
                stmt.setDate(5, new Date(divida.getData_abertura().getTime()));
                stmt.setDate(6, new Date(divida.getData_fechamento().getTime()));
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Nova divida cadastrada com sucesso!!"); 
            }else{
                stmt = con.prepareStatement("INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, "
                    + "`Status`, `Datadeabertura`) VALUES (?, ?, ?, ?, ?)");
                stmt.setInt(1, divida.getDevedor().getId());
                stmt.setDouble(2, divida.getValor());
                stmt.setString(3,divida.getEspecificacao());
                stmt.setString(4, divida.getStatus());
                stmt.setDate(5, new Date(divida.getData_abertura().getTime()));
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Nova divida cadastrada com sucesso!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar nova divida \n"
                    + e);
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    //Retorna todas as dividas dado um devedor selecionado
    /*para todas essas pesquisas falta fazer um algoritmo (Observer) em que quando se fizer essas buscas 
    *Se houver alguma divida em que a data atual seja pos data de fechamento altere no banco de dados o status para 
    *em atraso, claro tem que se verificar se o status atual da divida não esta pago
     */
    public static ArrayList<Divida> readDividas(Devedor devedor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Divida> dividas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from `PregoSistema`.`Divida` where `Divida`.`idDevedor` = ?");
            stmt.setInt(1, devedor.getId());
            rs = stmt.executeQuery();
            while (rs.next()){
                Divida divida = new Divida(devedor, rs.getDouble(3), rs.getString(4));
                divida.setId(rs.getLong(1));
                divida.setStatus(rs.getString(5));
                divida.setData_abertura(rs.getDate(6));
                divida.setData_fechamento(rs.getDate(7));
                divida.setData_pagamento(rs.getDate(8));
                dividas.add(divida);
            }
        } catch (Exception e) {
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dividas;
    }
    
    public static ArrayList<Divida> readDividas(Usuario usuario){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Divida> dividas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT  `PregoSistema`.`divida`.`idDivida`, "
                    + "`PregoSistema`.`divida`.`idDevedor`, "
                    + "`PregoSistema`.`divida`.`Valor`, "
                    + "`PregoSistema`.`divida`.`Especificacao`, `PregoSistema`.`divida`.`Status`, "
                    + "`PregoSistema`.`divida`.`Datadeabertura`, `PregoSistema`.`divida`.`Datadefechamento`, "
                    + "`PregoSistema`.`divida`.`DatadePagamento` FROM `PregoSistema`.`divida`, "
                    + "`PregoSistema`.`devedor` Where `devedor`.`Usuario_UserNome` = ? AND "
                    + "`devedor`.`idDevedor` = `divida`.`idDevedor`");
            stmt.setString(1, usuario.getNome());
            rs = stmt.executeQuery();
            while(rs.next()){
                Devedor devedor = DevedorDao.buscarDevedorId(rs.getLong(2), usuario);
                Divida divida = new Divida(devedor, rs.getDouble(3), rs.getString(4));
                divida.setId(rs.getLong(1));
                divida.setStatus(rs.getString(5));
                divida.setData_abertura(rs.getDate(6));
                divida.setData_fechamento(rs.getDate(7));
                divida.setData_pagamento(rs.getDate(8));
                dividas.add(divida);
            }
            
        } catch (Exception e) {
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return dividas;
    }

    public static void remove (Divida divida, Devedor devedor){
        //DELETE FROM `PregoSistema`.`Divida` WHERE `idDivida`='9' and `idDevedor` = ;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM `PregoSistema`.`Divida` WHERE `idDivida`= ? and `idDevedor` = ?");
            stmt.setLong(1, divida.getId());
            stmt.setInt(2, devedor.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Divida deletada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "erro! " + e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public static boolean modificarStatus(Divida divida, String status, java.util.Date data){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        try {
            if (status.equals("Paga")){
                stmt = con.prepareStatement("UPDATE `PregoSistema`.`Divida` SET `Status`= ?, `DatadePagamento` = ?"
                        + " WHERE `idDivida`= ?");
                stmt.setString(1, status);
                stmt.setDate(2, new Date(data.getTime()));
                stmt.setLong(3, divida.getId());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,
                    "Status da divida alterada para " + status + " com sucesso!");
                return true;
            }else{
                stmt = con.prepareStatement("UPDATE `PregoSistema`.`Divida` SET `Status`= ? WHERE `idDivida`= ?");
                stmt.setString(1, status);
                stmt.setLong(2, divida.getId());
                stmt.executeUpdate();
                return true; 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "erro! " + e);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
   
    public static boolean update(Divida antigaDivida, Divida novaDivida){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        //UPDATE `PregoSistema`.`Divida` SET `Valor`='450', `Especificacao`='SSD\'s',
        //`Datadeabertura`='2018-07-22', `Datadefechamento`='2018-10-10', `DatadePagamento`='2018-10-09' 
        //WHERE `idDivida`='1';
        try {
            stmt = con.prepareStatement("UPDATE `PregoSistema`.`Divida` SET `Valor`= ?, `Especificacao`= ?,"
                    + " `Datadefechamento`= ? WHERE `idDivida`= ?");
            stmt.setDouble(1, novaDivida.getValor());
            stmt.setString(2, novaDivida.getEspecificacao());
            stmt.setDate(3,new Date(novaDivida.getData_fechamento().getTime()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "Divida alterada editada com sucesso!");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro!"
                    + "\n" + e);
            return false;
        }
    }
    

}