package model.dao;

import conection.ConnectionFactory;
import java.sql.*;
import javax.swing.JOptionPane;
import model.bean.Devedor;

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
}
