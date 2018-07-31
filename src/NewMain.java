//execuÃ§Ãµes enquanto nÃ£o hÃ¡ uma interface grafica e por eu nÃ£o gostar de ficar codificando testes
import java.util.ArrayList;
import java.util.Calendar;
import model.bean.*;
import model.dao.*;

public class NewMain {

    public static void main(String[] args) {
        Usuario user = UsuarioDao.readUsuario("Antonio");
        Devedor dev = DevedorDao.buscarDevedorEspeci(user, "Rafael");
        dev.setDividas(DividaDao.readDividas(dev));
        for(Divida d: dev.getDividas()){
            System.out.println(d.getId() + " "+ d.getEspecificacao() + " " + d.getValor() + " "
                    + d.getStatus() + " " + d.getData_abertura() + " " + d.getData_fechamento() + " " + d.getData_pagamento());
        }
    }  
}
