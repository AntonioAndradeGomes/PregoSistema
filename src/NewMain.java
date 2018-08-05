//execuÃ§Ãµes enquanto nÃ£o hÃ¡ uma interface grafica e por eu nÃ£o gostar de ficar codificando testes
import controller.ControleDivida;
import controller.IControleDivida;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.bean.*;
import model.dao.*;

public class NewMain {

    public static void main(String[] args) {
        IControleDivida contr = new ControleDivida();
        Usuario user = UsuarioDao.readUsuario("Antonio");
        Date data = new Date();
        ArrayList<Divida> dividas = DividaDao.readDividas(user);
        System.out.println(dividas.get(0).getStatus());
        contr.dividaPaga(dividas.get(0), data);
        
    }  
}
