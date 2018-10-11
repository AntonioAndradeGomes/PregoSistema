package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import model.bean.Devedor;
import model.bean.Divida;
import model.bean.Usuario;
import model.dao.DividaDao;
import model.dao.UsuarioDao;

public class ControleDivida extends AbstractClass implements IControleDivida {

    public void cadastrarDivida(Devedor devedor, double valor, String especificacao, Date dataFechamento) {
        Divida divida = new Divida(devedor, valor, especificacao);
        divida.setDataAberturaAtual();
        divida.setData_fechamento(dataFechamento);
        divida.setStatus("Aberta");
        DividaDao.create(divida);
    }

    public ArrayList<Divida> listarDividasDevedor(Devedor devedor) {
        return DividaDao.readDividas(devedor);
    }

    public ArrayList<Divida> listarDividasTodas(Usuario user) {
        return DividaDao.readDividas(user);
    }

    public boolean dividaPaga(Divida divida, Date data) {
        return DividaDao.modificarStatus(divida, "Paga", data);
    }

    public Divida buscarDivida(int codigo, Usuario user) {
        return DividaDao.buscarDivida(codigo, user);
    }

    public void excluirDivida(Divida divida) {
        DividaDao.remove(divida);
    }

    public void modificarStatusDivida(Divida d, String status, Date date) {
       DividaDao.modificarStatus(d, status, date);
    }

    public void mostrarTexto(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    public void verificarAtrasoInterface(String user) {
        this.modificarStatus(user);
    }
   
}
