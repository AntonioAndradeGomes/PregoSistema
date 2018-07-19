//execuções enquanto não há uma interface grafica e por eu não gostar de ficar codificando testes
import java.util.ArrayList;
import model.bean.Devedor;
import model.bean.Divida;
import model.bean.Usuario;
import model.dao.DevedorDao;
import model.dao.DividaDao;
import model.dao.UsuarioDao;


public class NewMain {

    public static void main(String[] args) {
        System.out.println(DevedorDao.nomeIgual("Rafael S"));
//        Devedor d = DividaDao.buscaDevedor("Rafael");
//        ArrayList<Divida> dividas = DividaDao.readDividas();
//        System.out.println(dividas.isEmpty());
//        ArrayList<Divida> dividas = DividaDao.readDividas(d);
//        System.out.println(dividas.isEmpty());
        
    }
    
}
