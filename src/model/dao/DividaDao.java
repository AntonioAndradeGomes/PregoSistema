
package model.dao;

import conection.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Devedor;
import model.bean.Divida;

public class DividaDao {
    
    public static void create(Divida divida){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO `PregoSistema`.`Divida` (`idDevedor`, `Valor`, `Especificacao`, "
                    + "`Status`, `Datadeabertura`, `Datadefechamento`) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, divida.getDevedor().getId());
            stmt.setDouble(2, divida.getValor());
            stmt.setString(3,divida.getEspecificacao());
            stmt.setString(4, divida.getStatus());
            stmt.setDate(5, new java.sql.Date(divida.getData_abertura().getTime()));
            stmt.setDate(6, new java.sql.Date(divida.getData_fechamento().getTime()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nova divida cadastrada com sucesso!!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar nova divida \n"
                    + e);
            System.out.println(e);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
