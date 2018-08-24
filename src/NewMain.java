
import java.util.ArrayList;
import java.util.Date;
import model.bean.Devedor;
import model.bean.Divida;
import model.bean.Usuario;
import model.dao.DevedorDao;
import model.dao.DividaDao;
import model.dao.UsuarioDao;



public class NewMain {

    public static void main(String[] args) {
        Usuario user = UsuarioDao.readUsuario("Antonio");
        ArrayList<Divida> dividas = DividaDao.readDividas(user);
        for(Divida d: dividas){
            System.out.println(d.getId());
        }
    }
}
