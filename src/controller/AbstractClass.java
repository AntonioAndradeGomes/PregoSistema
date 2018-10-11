package controller;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.bean.Divida;
import model.bean.Usuario;
import model.dao.DividaDao;
import model.dao.UsuarioDao;

public abstract class AbstractClass {
    //Classe que terá o Template Method
    public void modificarStatus(String user){ //templateMethod
        Usuario usuario = UsuarioDao.readUsuario(user);
        ArrayList<Divida> dividasA = DividaDao.dividasAbertasFech(usuario);
        Date dataSO = new Date();
        Calendar dataAtualSO = Calendar.getInstance();
        dataAtualSO.setTime(dataSO);
        int cont = 0;
        for (Divida d : dividasA) {
            Calendar data_fecha = Calendar.getInstance();
            data_fecha.setTime(d.getData_fechamento());
            if (dataAtualSO.get(Calendar.YEAR) > data_fecha.get(Calendar.YEAR)) {
                //DividaDao.modificarStatus(d, "Em atraso", null);
                cont++;
                this.modificarStatusDivida(d, "Em atraso", null);
//                JOptionPane.showMessageDialog(null, d.getDevedor().getNome() + " " + d.getValor() + " Divida atrasada");
                //melhorar essa notificação acima
            } else if ((dataAtualSO.get(Calendar.MONTH) > data_fecha.get(Calendar.MONTH))
                    && (dataAtualSO.get(Calendar.YEAR) == data_fecha.get(Calendar.YEAR))) {
                //divida atrasada
                //melhorar essa notificação 
                //DividaDao.modificarStatus(d, "Em atraso", null);
                cont++;
                this.modificarStatusDivida(d, "Em atraso", null);
//                JOptionPane.showMessageDialog(null, d.getDevedor().getNome() + " " + d.getValor() + " Divida atrasada");
            } else if ((dataAtualSO.get(Calendar.DATE) > data_fecha.get(Calendar.DATE))
                    && (dataAtualSO.get(Calendar.MONTH) == data_fecha.get(Calendar.MONTH))
                    && (dataAtualSO.get(Calendar.YEAR) == data_fecha.get(Calendar.YEAR))) {
                //DividaDao.modificarStatus(d, "Em atraso", null);
                cont++;
                this.modificarStatusDivida(d, "Em atraso", null);
                //melhorar essa notificação
//                JOptionPane.showMessageDialog(null, d.getDevedor().getNome() + " " + d.getValor() + " Divida atrasada");
                //divida atradada
            }
        }
        if (cont > 0) {
            this.mostrarTexto("Existe uma nova Divida atrasada \n"
                    + "Vá em listar dividas para observar!!");
        }
    }
    public abstract void modificarStatusDivida(Divida d, String status, Date date);
    public abstract void mostrarTexto(String texto);
}
