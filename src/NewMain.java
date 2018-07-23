//execuções enquanto não há uma interface grafica e por eu não gostar de ficar codificando testes
import java.util.ArrayList;
import model.bean.*;
import model.dao.*;

public class NewMain {

    public static void main(String[] args) {
        Usuario user = UsuarioDao.readUsuario("Antonio");
        Devedor dev = DevedorDao.buscarDevedorEspeci(user, "Antonio");
        Divida d = new Divida(dev, 800, "Hardware");
        d.setDataAberturaAtual();
        DividaDao.create(d);
    }
    
}
