package model.dao;

import conection.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Devedor;
import model.bean.Divida;
import model.bean.Usuario;

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

}