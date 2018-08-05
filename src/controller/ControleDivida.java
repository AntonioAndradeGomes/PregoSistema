
package controller;

import java.util.ArrayList;
import java.util.Date;
import model.bean.Devedor;
import model.bean.Divida;
import model.bean.Usuario;
import model.dao.DividaDao;

public class ControleDivida implements IControleDivida {

    public void cadastrarDivida(Devedor devedor, double valor, String especificacao, Date dataFechamento) {
        Divida divida = new Divida(devedor, valor, especificacao);
        divida.setDataAberturaAtual();
        divida.setData_fechamento(dataFechamento);
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
    

}
