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

public class ControleDivida implements IControleDivida {

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

    public void verificarAtraso(String user) {
        Usuario usuario = UsuarioDao.readUsuario(user);
        ArrayList<Divida> dividasA = DividaDao.dividasAbertasFech(usuario);
        Date dataSO = new Date();
        Calendar dataAtualSO = Calendar.getInstance();
        dataAtualSO.setTime(dataSO);

        for (Divida d : dividasA) {
            Calendar data_fecha = Calendar.getInstance();
            data_fecha.setTime(d.getData_fechamento());
            if (dataAtualSO.get(Calendar.YEAR) > data_fecha.get(Calendar.YEAR)) {
                DividaDao.modificarStatus(d, "Em atraso", null);
                JOptionPane.showMessageDialog(null, d.getDevedor().getNome() + " " + d.getValor() + " Divida atrasada");
                //melhorar essa notificação acima
            } else if ((dataAtualSO.get(Calendar.MONTH) > data_fecha.get(Calendar.MONTH))
                    && (dataAtualSO.get(Calendar.YEAR) == data_fecha.get(Calendar.YEAR))) {
                //divida atrasada
                //melhorar essa notificação 
                DividaDao.modificarStatus(d, "Em atraso", null);
                JOptionPane.showMessageDialog(null, d.getDevedor().getNome() + " " + d.getValor() + " Divida atrasada");
            } else if ((dataAtualSO.get(Calendar.DATE) > data_fecha.get(Calendar.DATE))
                    && (dataAtualSO.get(Calendar.MONTH) == data_fecha.get(Calendar.MONTH))
                    && (dataAtualSO.get(Calendar.YEAR) == data_fecha.get(Calendar.YEAR))) {
                DividaDao.modificarStatus(d, "Em atraso", null);
                //melhorar essa notificação
                JOptionPane.showMessageDialog(null, d.getDevedor().getNome() + " " + d.getValor() + " Divida atrasada");
                //divida atradada
            }
        }

    }

}
